package simple.attribute;

import simple.obj.ISimpleObject;
import simple.universe.ISimpleUniverse;
import simple.universe.fxns.SimpleObjectRemover;

public class SimpleHealthAttribute extends SimpleAbstractAttribute {

	private double myHealth;
	
	/**
	 * Construct a health attribute with default 100 starting health 
	 * and the specified parent object.
	 * @param parent
	 */
	public SimpleHealthAttribute(ISimpleObject parent) {
		this(100, parent);
	}
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and parent object.
	 * @param startingHealth
	 * @param parent
	 */
	public SimpleHealthAttribute(double startingHealth, ISimpleObject parent) {
		super(parent);
		this.myHealth = startingHealth;
	}
	
	@Override
	public void updateSelf(ISimpleUniverse universe) {
		checkForDeath(new SimpleObjectRemover(universe));
	}
	
	/**
	 * Change the value of this attribute's internal health.
	 * @param healthChange
	 */
	public void changeHealth(double healthChange) {
		this.myHealth += healthChange;
	}
	
	private void checkForDeath(SimpleObjectRemover remover) {
		if (isDead()) {
			remover.removeFromEnvironment(getParent());
		}
	}
	
	private boolean isDead() {
		return this.myHealth <= 0;
	}

}
