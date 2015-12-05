package com.syntacticsugar.vooga.gameplayer.event.implementations;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.SlowAttribute;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEventType;
import com.syntacticsugar.vooga.util.ResourceManager;

public class SlowEvent extends CollisionEvent {
	
	double mySlow;
	int myTime;
	
	public SlowEvent(double slow, int time) {
		super(CollisionEventType.Slow);
		mySlow = slow;
		myTime = time;
	}

	@Override
	public void executeEvent(Map<String, IAttribute> targetAttributes) {
		String key = ResourceManager.getString(SlowAttribute.class.getSimpleName());
		SlowAttribute slow = new SlowAttribute(myTime, mySlow);
		targetAttributes.put(key, slow);
	}

}
