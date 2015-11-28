package junit;

import java.util.Collection;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

/**
 * The class <code>ObjectDataTest</code> contains tests for the class <code>{@link ObjectData}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ObjectDataTest {
	/**
	 * Run the ObjectData() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testObjectData_1()
		throws Exception {

		authoring.objectediting.ObjectData result = new authoring.objectediting.ObjectData();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getType());
		assertEquals(null, result.getImagePath());
		assertEquals(null, result.getObjectName());
	}

	/**
	 * Run the Collection<IAttribute> getAttributes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetAttributes_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");

		Collection<IAttribute> result = fixture.getAttributes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Map<GameObjectType, Collection<IGameEvent>> getCollisionMap() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetCollisionMap_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");

		Map<GameObjectType, Collection<IGameEvent>> result = fixture.getCollisionMap();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getImagePath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetImagePath_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");

		String result = fixture.getImagePath();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getObjectName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetObjectName_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");

		String result = fixture.getObjectName();

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
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");

		GameObjectType result = fixture.getType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ENEMY", result.name());
		assertEquals("ENEMY", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the void setAttributes(Collection<IAttribute>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetAttributes_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");
		Collection<IAttribute> attributes = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(attributes);

		fixture.setAttributes(attributes);

		// add additional test code here
		EasyMock.verify(attributes);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at java.util.ArrayList.addAll(Unknown Source)
		//       at authoring.objectediting.ObjectData.setAttributes(ObjectData.java:55)
	}

	/**
	 * Run the void setCollisionMap(Map<GameObjectType,Collection<IGameEvent>>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetCollisionMap_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");
		Map<GameObjectType, Collection<IGameEvent>> collisionMap = EasyMock.createMock(Map.class);
		// add mock object expectations here

		EasyMock.replay(collisionMap);

		fixture.setCollisionMap(collisionMap);

		// add additional test code here
		EasyMock.verify(collisionMap);
	}

	/**
	 * Run the void setImagePath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetImagePath_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");
		String myImagePath = "";

		fixture.setImagePath(myImagePath);

		// add additional test code here
	}

	/**
	 * Run the void setType(GameObjectType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetType_1()
		throws Exception {
		authoring.objectediting.ObjectData fixture = new authoring.objectediting.ObjectData();
		fixture.setType(GameObjectType.ENEMY);
		fixture.setImagePath("");
		GameObjectType type = GameObjectType.ENEMY;

		fixture.setType(type);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(ObjectDataTest.class);
	}
}