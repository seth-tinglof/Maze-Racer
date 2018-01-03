package mazeRunner;
/**
 * Allows object to store a position as a double.
 * useful for simulating angular momentum with more accuracy.
 * 
 * @author Seth Tinglof
 * @version 1.0
 */

public abstract class AngularMomentum 
extends Character{
	
	public AngularMomentum(int xPos, int yPos) {
		super(xPos, yPos);
		setTruePosition(xPos, yPos);
	}

	private double trueX;
	private double trueY;
	
	/**
	 * sets position as a double
	 * @param trueX xPosition of Character
	 * @param trueY yPosition of Character
	 */
	public void setTruePosition(double trueX, double trueY){
		this.trueX = trueX;
		this.trueY = trueY;
	}
	
	/**
	 * Change current true position by set amount.
	 * @param xIncrease amount Character moves right (negative moves left)
	 * @param yIncrease amount Character moves up (negative moves down)
	 */
	public void increaseTruePosition(double xIncrease, double yIncrease){
		trueX += xIncrease;
		trueY -= yIncrease;
	}
	
	/**
	 * Sets displayable position based on true position.
	 */
	public void setIntegerPosition(){
		setXPos((int) trueX);
		setYPos((int) trueY);
	}
}
