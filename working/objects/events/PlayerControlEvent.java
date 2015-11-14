package objects.events;

import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.input.KeyCode;

public class PlayerControlEvent extends AbstractEvent {
	
	private Collection<KeyCode> myKeyCodes;
	
	public PlayerControlEvent(Collection<KeyCode> codes){
		super(EEventType.PlayerControlEvent);
		myKeyCodes = new ArrayList<KeyCode>();
		for (KeyCode kc : codes) {
			myKeyCodes.add(kc);
		}
	}
	
	public Collection<KeyCode> getKeyCodes() {
		Collection<KeyCode> retCodes = new ArrayList<KeyCode>();
		for (KeyCode kc: myKeyCodes) {
			retCodes.add(kc);
		}
		return retCodes;
	}

}
