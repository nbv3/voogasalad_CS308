package com.syntacticsugar.vooga.gameplayer.event.implementations;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.SlowAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.StunAttribute;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEventType;
import com.syntacticsugar.vooga.util.ResourceManager;

public class StunEvent extends CollisionEvent {
	
	int myTime;
	
	public StunEvent(int time) {
		super(CollisionEventType.Stun);
		myTime = time;
	}

	@Override
	public void executeEvent(Map<String, IAttribute> targetAttributes) {
		String key = ResourceManager.getString(StunAttribute.class.getSimpleName());
		StunAttribute slow = new StunAttribute(myTime);
		targetAttributes.put(key, slow);
	}

}
