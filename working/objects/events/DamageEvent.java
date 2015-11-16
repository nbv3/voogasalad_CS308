package objects.events;

public class DamageEvent extends AbstractEvent{
	
	private double myDamage;
	
	public DamageEvent() {
		super(EEventType.DamageEvent);
	}
		
	public double getDamage() {
		return myDamage;
	}
	
	public void setDamage(double dmg) {
		myDamage = dmg;
	}
	
	//Maybe a component handles this, maybe the object directly fires this
	
}
