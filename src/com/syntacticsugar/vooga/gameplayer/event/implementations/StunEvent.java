package com.syntacticsugar.vooga.gameplayer.event.implementations;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.StatusEffectAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.StunAttribute;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEventType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.util.ResourceManager;

public class StunEvent extends CollisionEvent {
	
	int myTime;
	
	public StunEvent(int time) {
		super(CollisionEventType.Stun);
		myTime = time;
	}

	@Override
	public void executeEvent(IGameObject obj) {
		Map<String, IAttribute> targetAttributes = obj.getAttributes();
		String key = ResourceManager.getString(StunAttribute.class.getSimpleName());
		StunAttribute slow = new StunAttribute(myTime);
		if (targetAttributes.get(key) != null) {
			StatusEffectAttribute attr = (StatusEffectAttribute) targetAttributes.get(key);
			attr.kill();
		}
		targetAttributes.put(key, slow);
		slow.setParent(obj);
	}

}
