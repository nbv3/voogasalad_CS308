package objects.events;

import objects.IGameObject;

public class ScoreChangeEvent extends AbstractEvent {
	
	private double amount;

	public ScoreChangeEvent(IGameObject source) {
		super(EEventType.ScoreChangeEvent, source);
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amt) {
		amount = amt;
	}

}
