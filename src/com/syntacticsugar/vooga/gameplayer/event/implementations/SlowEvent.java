package com.syntacticsugar.vooga.gameplayer.event.implementations;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.SlowAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.StatusEffectAttribute;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEventType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
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
	public void executeEvent(IGameObject obj) {
		Map<String, IAttribute> targetAttributes = obj.getAttributes();
		String key = ResourceManager.getString(SlowAttribute.class.getSimpleName());
		SlowAttribute slow = new SlowAttribute(myTime, mySlow);
		if (targetAttributes.get(key) != null) {
			StatusEffectAttribute attr = (StatusEffectAttribute) targetAttributes.get(key);
			attr.kill();
		}
		targetAttributes.put(key, slow);
		slow.setParent(obj);
	}

}
