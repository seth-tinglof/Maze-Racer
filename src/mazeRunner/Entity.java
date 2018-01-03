package mazeRunner;

import java.awt.geom.Line2D;

/**
 * a Displayable Character or Object with a position that can be shown or not shown.
 * 
 * @author Seth Tinglof
 * @version 1.0
 */
public abstract class Entity
implements Displayable
{
	private int xPos;
	private int yPos;

	Line2D[] hitBox;
	
	private boolean shown;
	private boolean active;
	
	public Entity(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;		
		active = true;
		shown = true;
	}
	
   /**
	* @return true if object is shown.
	*/
	public boolean getShown(){
		return shown;
	}
	
	/**
	 * Set whether an entity is to be shown
	 * @param true if this entity is to be shown, false if not.
	 */
	public void setShown(boolean shown){
		this.shown = shown;
	}
	
	/**
	 * @return true only if entity is active.
	 */
	public boolean getActive(){
		return active;
	}
	
	/**
	 * sets whether the entity is active or inactive.
	 * @param true for active or false for inactive.
	 */
	public void setActive(boolean active){
		this.active = active;
	}
	
   /**
	* @return x position for display in grid
	*/
	public int getXPos(){
		return xPos;
	}
	
	/**
	 * Sets value for xPosition of entity.
	 * @param xPosition for entity
	 */
	public void setXPos(int xPos){
		this.xPos = xPos;
	}
	
   /**
	* @return y position for display in grid
	*/
	public int getYPos(){
		return yPos;
	}
	
	/**
	 * Sets value for y Position
	 * @param y Position of entity
	 */
	public void setYPos(int yPos){
		this.yPos = yPos;
	}
	
	
	/**
	 * @return x and y position for Entity in an Integer array.
	 */
	public Integer[] getCoordinates(){
		return new Integer[]{new Integer(xPos), new Integer(yPos)};
	}
	
	/**
	 * @param entity whose location is being compared to this.
	 * @return true if this and the argument entity have overlapping hit boxes.
	 * also returns false if one entity has not set a hit box.
	 */
	public boolean entityHit(Entity entity){
		try{
			for(Line2D line: hitBox){
				for(Line2D otherLine: entity.hitBox)
					if(line.intersectsLine(otherLine))
						return true;
			}
		}catch(NullPointerException e) {}	//If one of the entity has not set a hit box, this method returns false.
		return false;
	}
	
	/**
	 * updates the entity's hit box.
	 */
	public abstract void updateHitBox();
	
	
	/**
	 * @return String with Entity's position
	 */
	public String toString(){
		return "X Position: " + xPos + "\nY Position: " + yPos + "\n";
	}
}