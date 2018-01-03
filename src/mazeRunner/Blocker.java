package mazeRunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Blocker 
extends Entity {
	
	static final int IMAGE_SIZE = 200;
	
	BufferedImage image;
	GeneralPath shape;
	
	/*X and Y coordinate points to witch the blocker displays */ 
	double[] xPoints;
	double[] yPoints;
	
	int size;
	double r;
	double angle;
	
	public Blocker(int xPos, int yPos, double r) {
		super(xPos, yPos);
		this.r = r;
		size = (int) (Math.random() * 5 + 3);
		xPoints = new double[size];
		yPoints = new double[size];
		angle = 2 * Math.PI /size;
		createBlockerShape();
		drawShape();
	}
	
	/**
	 * Creates the semi-random shape for the blocker.
	 */
	private void createBlockerShape(){
		double angle = this.angle;
		for(int i = 0; i < size; i++){
			angle = this.angle * i;
			xPoints[i] =  (IMAGE_SIZE / 2 + r * Math.sin(angle)) + (Math.random() * 20 - 10);
			yPoints[i] =  (IMAGE_SIZE / 2 - r * Math.cos(angle)) + (Math.random() * 20 - 10);
		}
	}
	
	/**
	 * Draws the image for the blocker.
	 */
	private void drawShape(){
		image = new BufferedImage(IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_ARGB);
		shape = new GeneralPath(GeneralPath.WIND_NON_ZERO, size);
		shape.moveTo(xPoints[0], yPoints[0]);
		for(int i = 1; i < size; i++)
			shape.lineTo(xPoints[i], yPoints[i]);
		shape.closePath();
		Graphics2D g = (Graphics2D) (image.getGraphics());
		g.setRenderingHints(ImageResources.AA);
		g.setColor(Color.BLUE);
		g.fill(shape);
		g.dispose();
		
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void updateHitBox() {
		hitBox = new Line2D[size];
		for(int i = 0; i < size - 1; i++)
			hitBox[i] = new Line2D.Double(getXPos() + xPoints[i], getYPos() + yPoints[i], getXPos() + xPoints[i + 1], getYPos() + yPoints[i + 1]);
		hitBox[size - 1] = new Line2D.Double(getXPos() + xPoints[size - 1], getYPos() + yPoints[size - 1], getXPos() + xPoints[0], getYPos() + yPoints[0]);	
	}
}
