package junit;

import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

/**
 * The class <code>ReflectionTest</code> contains tests for the class <code>{@link Reflection}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ReflectionTest {
	/**
	 * Run the Object callMethod(Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.reflection.ReflectionException.class)
	public void testCallMethod_1()
		throws Exception {
		Object target = new Object();
		String name = "";

		Object result = Reflection.callMethod(target, name);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object callMethod(Object,String,Object[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.reflection.ReflectionException.class)
	public void testCallMethod_2()
		throws Exception {
		Object target = new Object();
		String name = "";

		Object result = Reflection.callMethod(target, name);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object createInstance(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.reflection.ReflectionException.class)
	public void testCreateInstance_1()
		throws Exception {
		String className = "";

		Object result = Reflection.createInstance(className);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object createInstance(String,Object[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.reflection.ReflectionException.class)
	public void testCreateInstance_2()
		throws Exception {
		String name = "";

		Object result = Reflection.createInstance(name);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object getFieldValue(Object,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.reflection.ReflectionException.class)
	public void testGetFieldValue_1()
		throws Exception {
		Object target = new Object();
		String name = "";

		Object result = Reflection.getFieldValue(target, name);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Class<Object>[] toClasses(Object[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testToClasses_1()
		throws Exception {
		Object[] args = new Object[] {new Object()};

		Class<Object>[] result = Reflection.toClasses(args);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals("class java.lang.Object", result[0].toString());
		assertEquals(1, result[0].getModifiers());
		assertEquals(false, result[0].isInterface());
		assertEquals(false, result[0].isArray());
		assertEquals(false, result[0].isPrimitive());
		assertEquals(null, result[0].getSuperclass());
		assertEquals(null, result[0].getComponentType());
		assertEquals("java.lang.Object", result[0].getName());
		assertEquals(false, result[0].desiredAssertionStatus());
		assertEquals(null, result[0].getAnnotatedSuperclass());
		assertEquals("java.lang.Object", result[0].getCanonicalName());
		assertEquals(null, result[0].getClassLoader());
		assertEquals(null, result[0].getDeclaringClass());
		assertEquals(null, result[0].getEnclosingClass());
		assertEquals(null, result[0].getEnclosingConstructor());
		assertEquals(null, result[0].getEnclosingMethod());
		assertEquals(null, result[0].getEnumConstants());
		assertEquals(null, result[0].getGenericSuperclass());
		assertEquals(null, result[0].getSigners());
		assertEquals("Object", result[0].getSimpleName());
		assertEquals("java.lang.Object", result[0].getTypeName());
		assertEquals(false, result[0].isAnnotation());
		assertEquals(false, result[0].isAnonymousClass());
		assertEquals(false, result[0].isEnum());
		assertEquals(false, result[0].isLocalClass());
		assertEquals(false, result[0].isMemberClass());
		assertEquals(false, result[0].isSynthetic());
		assertEquals(new Object(), result[0].newInstance());
		assertEquals("public class java.lang.Object", result[0].toGenericString());
	}

	/**
	 * Run the Class<Object>[] toClasses(Object[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testToClasses_2()
		throws Exception {
		Object[] args = new Object[] {};

		Class<Object>[] result = Reflection.toClasses(args);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
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
		new org.junit.runner.JUnitCore().run(ReflectionTest.class);
	}
}