package junit;

import java.util.Collection;
import java.util.Map;
import javafx.geometry.Point2D;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>GameObjectTest</code> contains tests for the class <code>{@link GameObject}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameObjectTest {
	/**
	 * Run the GameObject(ObjectData,Point2D,double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameObject_1()
		throws Exception {
		ObjectData data = new ObjectData();
		data.setImagePath("");
		data.setType(GameObjectType.ENEMY);
		Point2D startingPoint = new Point2D(1.0, 1.0);
		double width = 1.0;
		double height = 1.0;

		GameObject result = new GameObject(data, startingPoint, width, height);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPath());
	}

	/**
	 * Run the GameObject(ObjectData,Point2D,double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameObject_2()
		throws Exception {
		ObjectData data = new ObjectData();
		data.setImagePath("");
		data.setType(GameObjectType.ENEMY);
		Point2D startingPoint = new Point2D(1.0, 1.0);
		double width = 1.0;
		double height = 1.0;

		GameObject result = new GameObject(data, startingPoint, width, height);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPath());
	}

	/**
	 * Run the GameObject(GameObjectType,Point2D,double,double,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameObject_3()
		throws Exception {
		GameObjectType type = GameObjectType.ENEMY;
		Point2D point = new Point2D(1.0, 1.0);
		double width = 1.0;
		double height = 1.0;
		String path = "";

		GameObject result = new GameObject(type, point, width, height, path);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPath());
	}

	/**
	 * Run the void addAttribute(IAttribute) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddAttribute_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		IAttribute attribute = EasyMock.createMock(IAttribute.class);
		// add mock object expectations here

		EasyMock.replay(attribute);

		fixture.addAttribute(attribute);

		// add additional test code here
		EasyMock.verify(attribute);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key $Proxy42
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.ResourceManager.getString(ResourceManager.java:15)
		//       at com.syntacticsugar.vooga.gameplayer.objects.GameObject.addAttribute(GameObject.java:85)
	}

	/**
	 * Run the void addCollisionBinding(GameObjectType,IGameEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddCollisionBinding_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		GameObjectType type = GameObjectType.ENEMY;
		IGameEvent event = EasyMock.createMock(IGameEvent.class);
		// add mock object expectations here

		EasyMock.replay(event);

		fixture.addCollisionBinding(type, event);

		// add additional test code here
		EasyMock.verify(event);
	}

	/**
	 * Run the void addCollisionBinding(GameObjectType,IGameEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddCollisionBinding_2()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		GameObjectType type = GameObjectType.ENEMY;
		IGameEvent event = EasyMock.createMock(IGameEvent.class);
		// add mock object expectations here

		EasyMock.replay(event);

		fixture.addCollisionBinding(type, event);

		// add additional test code here
		EasyMock.verify(event);
	}

	/**
	 * Run the Map<String, IAttribute> getAttributes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetAttributes_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");

		Map<String, IAttribute> result = fixture.getAttributes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Collection<IGameEvent> getEventsFromCollision(GameObjectType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetEventsFromCollision_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		GameObjectType type = GameObjectType.ENEMY;

		Collection<IGameEvent> result = fixture.getEventsFromCollision(type);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the GameObjectType getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");

		GameObjectType result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ENEMY", result.name());
		assertEquals("ENEMY", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateSelf_1()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateSelf_2()
		throws Exception {
		GameObject fixture = new GameObject(GameObjectType.ENEMY, new Point2D(1.0, 1.0), 1.0, 1.0, "");
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameObjectTest.class);
	}
}