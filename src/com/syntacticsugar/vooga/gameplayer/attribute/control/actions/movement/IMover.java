package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement;

public interface IMover {

	/**
	 * Update the X and Y position of this ISimpleMover object based on 
	 * the current X and Y velocities.
	 */
	public void move();
	
	/**
	 * Returns the current speed (scalar) of this ISimpleMover object.
	 * @return
	 */
	public double getSpeed();
	
	/**
	 * Sets the current speed (scalar) of this ISimpleMover object.
	 * @param speed
	 */
	public void setSpeed(double speed);
	
	/**
	 * Sets the X velocity of this ISimpleMover object equal to the current
	 * speed of the object in the specified direction.
	 * @param xDir
	 */
	public void setXVelocity(HDirection xDir);
	
	/**
	 * Sets the Y velocity of this ISimpleMover object equal to the current
	 * speed of the object in the specified direction.
	 * @param yDir
	 */
	public void setYVelocity(VDirection yDir);

	/**
	 * Sets the rotation value of this object.
	 * @param rotate
	 */
	public void setRotate(double rotate);
	
	/**
	 * Set the direction of this object.
	 * @param dir
	 */
	public void setDirection(Direction dir);
	
	/**
	 * Sets the X and Y velocity of this ISimpleMover object equal to zero.
	 */
	void resetVelocity();
}
