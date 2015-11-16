package objects.attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.geometry.Point2D;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import view.BoundingBox;

public class SolidAttribute extends AbstractAttribute {
	
	private List<IEvent> onHitSolidLocalEvents;
	private List<IEvent> onHitSolidGlobalEvents;

	public SolidAttribute(IGameObject parent) {
		super(parent);
		onHitSolidLocalEvents = new ArrayList<>();
		onHitSolidGlobalEvents = new ArrayList<>();
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getType().equals(EEventType.HitSolidObjectEvent)) {
			//Move the object outside of the thing it collided with
			Vector<Double> vel = getParent().getVelocity();
			BoundingBox box = getParent().getBoundingBox();
			Point2D point = box.getPoint();
			double x = point.getX() - vel.get(0);
			double y = point.getY() - vel.get(1);
			getParent().setLocation(new Point2D(x, y));
			getParent().setVelocity(0.0, 0.0);
			
			for (IEvent event: onHitSolidLocalEvents) {
				getParent().sendEventToChildren(event);
			}
			
			for (IEvent event: onHitSolidGlobalEvents) {
				getPoster().postEvent(event);
			}
		}

	}
	
	public void addHitSolidLocalEvent(IEvent e) {
		onHitSolidLocalEvents.add(e);
	}
	
	public void addHitSolidGlobalEvent(IEvent e) {
		onHitSolidGlobalEvents.add(e);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
