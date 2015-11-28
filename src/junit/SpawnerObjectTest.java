package junit;

import javafx.scene.image.ImageView;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.editor.SpawnerObject;

/**
 * The class <code>SpawnerObjectTest</code> contains tests for the class <code>{@link SpawnerObject}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class SpawnerObjectTest {
	/**
	 * Run the int getDamage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetDamage_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);

		int result = fixture.getDamage();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
		assertEquals(0, result);
	}

	/**
	 * Run the ImageView getImage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetImage_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);

		ImageView result = fixture.getImage();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		assertNotNull(result);
	}

	/**
	 * Run the int getMaxHealth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetMaxHealth_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);

		int result = fixture.getMaxHealth();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
		assertEquals(0, result);
	}

	/**
	 * Run the int getSpawnNum() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSpawnNum_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);

		int result = fixture.getSpawnNum();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
		assertEquals(0, result);
	}

	/**
	 * Run the void setDamage(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetDamage_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);
		int damage = 1;

		fixture.setDamage(damage);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
	}

	/**
	 * Run the void setImage(ImageView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetImage_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);
		ImageView image = new ImageView();

		fixture.setImage(image);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
	}

	/**
	 * Run the void setMaxHealth(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetMaxHealth_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);
		int maxHealth = 1;

		fixture.setMaxHealth(maxHealth);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
	}

	/**
	 * Run the void setSpawnNum(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetSpawnNum_1()
		throws Exception {
		SpawnerObject fixture = new SpawnerObject();
		fixture.setMaxHealth(1);
		fixture.setSpawnNum(1);
		fixture.setImage(new ImageView());
		fixture.setDamage(1);
		int spawnNum = 1;

		fixture.setSpawnNum(spawnNum);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.image.ImageView
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
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
	 * @generatedBy CodePro at 11/28/15 12:56 AM
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
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SpawnerObjectTest.class);
	}
}