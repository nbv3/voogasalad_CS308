package junit;

import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

/**
 * The class <code>ReflectionExceptionTest</code> contains tests for the class <code>{@link ReflectionException}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ReflectionExceptionTest {
	/**
	 * Run the ReflectionException(Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReflectionException_1()
		throws Exception {
		Throwable exception = new Throwable();

		ReflectionException result = new ReflectionException(exception);

		// add additional test code here
		assertNotNull(result);
		assertEquals("com.syntacticsugar.vooga.util.reflection.ReflectionException: java.lang.Throwable", result.toString());
		assertEquals("java.lang.Throwable", result.getLocalizedMessage());
		assertEquals("java.lang.Throwable", result.getMessage());
	}

	/**
	 * Run the ReflectionException(String,Object[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReflectionException_2()
		throws Exception {
		String message = "";

		ReflectionException result = new ReflectionException(message);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("com.syntacticsugar.vooga.util.reflection.ReflectionException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the ReflectionException(Throwable,String,Object[]) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReflectionException_3()
		throws Exception {
		Throwable cause = new Throwable();
		String message = "";

		ReflectionException result = new ReflectionException(cause, message);

		// add additional test code here
		assertNotNull(result);
		assertEquals("com.syntacticsugar.vooga.util.reflection.ReflectionException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
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
		new org.junit.runner.JUnitCore().run(ReflectionExceptionTest.class);
	}
}