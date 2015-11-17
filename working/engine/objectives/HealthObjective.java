package engine.objectives;

import java.util.Observable;

import objects.attributes.HealthAttribute;

public class HealthObjective extends AbstractObjective{
	
	private HealthAttribute observedHealth;
	
	public HealthObjective(HealthAttribute health){
		observedHealth = health;
		observedHealth.addObserver(this);
	}

	@Override
	public boolean hasAchieved() {
		
		return false;
	}


	@Override
	public void update(Observable o, Object arg) {
		
		
	}

}
