package objects.events;

public class DamageEvent extends AbstractEvent{
	
	private double myDamage;
	
	public DamageEvent() {
		super(EEventType.DamageEvent);
	}
		
	public double getDamage() {
		return myDamage;
	}
	
	//Maybe a component handles this, maybe the object directly fires this
	
}
