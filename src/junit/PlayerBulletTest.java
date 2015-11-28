package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.AbstractMovementType;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.MoveDownCardinal;
import com.syntacticsugar.vooga.gameplayer.objects.implementations.PlayerBullet;

/**
 * The class <code>PlayerBulletTest</code> contains tests for the class <code>{@link PlayerBullet}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PlayerBulletTest {
	/**
	 * Run the PlayerBullet(AbstractMovementType,Point2D,String,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testPlayerBullet_1()
		throws Exception {
		AbstractMovementType move = new MoveDownCardinal();
		Point2D startPoint = new Point2D(1.0, 1.0);
		String imagePath = "";
		double damage = 1.0;

		PlayerBullet result = new PlayerBullet(move, startPoint, imagePath, damage);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPath());
	}

	/**
	 * Run the PlayerBullet(AbstractMovementType,Point2D,String,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testPlayerBullet_2()
		throws Exception {
		AbstractMovementType move = new MoveDownCardinal();
		Point2D startPoint = new Point2D(1.0, 1.0);
		String imagePath = "";
		double damage = 1.0;

		PlayerBullet result = new PlayerBullet(move, startPoint, imagePath, damage);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getPath());
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
		new org.junit.runner.JUnitCore().run(PlayerBulletTest.class);
	}
}