package engine.environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import engine.IGameEngine;
import engine.objectives.IObjectiveAction;
import javafx.geometry.Point2D;
import tiles.DecoratorTile;
import view.ViewController;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.EObjectType;
import objects.IGameEventListener;
import objects.IGameObject;
import objects.Spawner;
import objects.attributes.HealthAttribute;
import objects.attributes.SolidAttribute;
import objects.events.DamageEvent;
import objects.events.EEventType;
import objects.events.GoalScoreEvent;
import objects.events.HitSolidObjectEvent;
import objects.events.IEvent;
import objects.events.ObjectSpawnEvent;
import objects.events.PlayerControlEvent;
import objects.player.Player;
import tiles.DecoratorTile;
import view.GameView;
import view.ViewController;

public class GameEnvironment implements IEnvironment, IGameEventListener, IHandleObjective {

	private IGameEngine myEngine;

	private int currentViewID;
	private IGameMap myGameMap;
	private List<IGameObject> environmentObjects;
	private List<KeyCode> currentInput;

	public GameEnvironment(IGameEngine engine) {
		this(20, 20, engine);
	}

	public GameEnvironment(int numCellsWide, int numCellsHigh, IGameEngine engine) {
		myEngine = engine;
		myEngine.addListener(this);
		currentViewID = 0;
		myGameMap = buildGameMap(numCellsWide, numCellsHigh);
		environmentObjects = new ArrayList<IGameObject>();

		currentInput = new ArrayList<KeyCode>();

		// TEMP CODE
		// TODO: REMOVE THIS
		IGameObject obj = new Player(new Point2D(100, 100), 10, 10, myEngine);
		obj.setObjectType(EObjectType.PLAYER);
		obj.getChildren().add(new SolidAttribute(obj));
		DamageEvent dmg = new DamageEvent();
		dmg.setDamage(10);
		obj.addCollisionEvent(EObjectType.ENEMY, dmg);
		addToEnvironment(obj, null);

		IGameObject obj2 = new Spawner(new Point2D(200, 200), 40, 40, myEngine, null);
		obj2.setObjectType(EObjectType.ENEMY);
		obj2.addCollisionEvent(EObjectType.PLAYER, new HitSolidObjectEvent(obj));
		HealthAttribute health = new HealthAttribute(obj2);
		health.addZeroGlobalEvent(new GoalScoreEvent());
		obj2.getChildren().add(health);
		addToEnvironment(obj2, null);
	}

	// Maybe move this into own class?
	private IGameMap buildGameMap(int w, int h) {
		IGameMap map = new GameMap(w, h);
		double tileWidth = 1000.0 / ((double) w);
		double tileHeight = 1000.0 / ((double) h);

		for (int i=0; i<w; i++) {
			for (int j=0;j<h; j++) {
				Point2D p = new Point2D(tileWidth*i, tileHeight*j);
				DecoratorTile dt = new DecoratorTile(currentViewID++, p, tileWidth, tileHeight);
				myEngine.getViewController().addViewObject(dt.getID(), dt, "path_brick_2.png");
				map.setTile(p, dt);
			}
		}

		return map;
	}

	@Override
	public void addToEnvironment(IGameObject g, String path) {
		environmentObjects.add(g);
		myEngine.addListener(g);
		myEngine.getViewController().addViewObject(g.getID(), g, "path_brick_1.png");
	}

	@Override
	public void removeFromEnvironment(IGameObject g) {
		environmentObjects.remove(g);
		myEngine.removeListener(g);

	}

	@Override
	public void updateObjects() {
		for (IGameObject g : environmentObjects) {
			g.update();
		}


	}

	@Override
	public List<IGameObject> getEnvironmentObjects() {
		return environmentObjects;
	}

	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		if (!currentInput.contains(e.getCode())) {
			currentInput.add(e.getCode());
			PlayerControlEvent event = new PlayerControlEvent(currentInput);
			myEngine.postEvent(event);
		}
	}

	@Override
	public void handleKeyReleased(KeyEvent e) {
		if (currentInput.contains(e.getCode())) {
			currentInput.remove(e.getCode());
			PlayerControlEvent event = new PlayerControlEvent(currentInput);
			myEngine.postEvent(event);
		}
	}

	@Override
	public void handleMouseInput(double x, double y) {
		// TODO Auto-generated method stub

	}

	public GameView getGameView() {
		return myEngine.getViewController().getGameView();
	}


	@Override
	public void onEvent(IEvent e) {
		if (e.getType().equals(EEventType.ObjectDespawnEvent)) {
			removeFromEnvironment(e.getSource());
		}

		if (e.getType().equals(EEventType.ObjectSpawnEvent)) {
			ObjectSpawnEvent event = (ObjectSpawnEvent) e;
			addToEnvironment(event.getSource(), event.getPath());
		}
	}

	@Override
	public void executeObjective(IObjectiveAction act) {
		act.objectiveTakeAction(this);

	}

}