package junit;

import java.io.File;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.manager.IGameManager;
import com.syntacticsugar.vooga.util.xml.LoaderSaver;
import com.syntacticsugar.vooga.util.xml.LoadingException;

/**
 * The class <code>LoaderSaverTest</code> contains tests for the class <code>{@link LoaderSaver}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:57 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class LoaderSaverTest {
	/**
	 * Run the LoaderSaver() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testLoaderSaver_1()
		throws Exception {

		LoaderSaver result = new LoaderSaver();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_1()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_2()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_3()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_4()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_5()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String formatXml(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testFormatXml_6()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		String result = fixture.formatXml(xml);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the IGameManager loadFromFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.xml.LoadingException.class)
	public void testLoadFromFile_1()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		File f = new File("");

		IGameManager result = fixture.loadFromFile(f);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the IGameManager loadFromFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.xml.LoadingException.class)
	public void testLoadFromFile_2()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		File f = new File("");

		IGameManager result = fixture.loadFromFile(f);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the IGameManager loadFromXML(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test(expected = com.syntacticsugar.vooga.util.xml.LoadingException.class)
	public void testLoadFromXML_1()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		String xml = "";

		IGameManager result = fixture.loadFromXML(xml);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String makeXML(IGameManager) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testMakeXML_1()
		throws Exception {
		LoaderSaver fixture = new LoaderSaver();
		IGameManager gm = EasyMock.createMock(IGameManager.class);
		// add mock object expectations here

		EasyMock.replay(gm);

		String result = fixture.makeXML(gm);

		// add additional test code here
		EasyMock.verify(gm);
		assertEquals("<?xml version=\"1.0\" ?><dynamic-proxy><interface>com.syntacticsugar.vooga.gameplayer.manager.IGameManager</interface><handler class=\"org.easymock.internal.ObjectMethodsFilter\" serialization=\"custom\"><org.easymock.internal.ObjectMethodsFilter><default><delegate><control><state class=\"org.easymock.internal.RecordState\"><lastInvocationUsed>true</lastInvocationUsed><behavior class=\"org.easymock.internal.MocksBehavior\"><behaviorLists></behaviorLists><stubResults></stubResults><nice>true</nice><checkOrder>false</checkOrder><isThreadSafe>true</isThreadSafe><shouldBeUsedInOneThread>false</shouldBeUsedInOneThread><position>0</position></behavior></state><behavior class=\"org.easymock.internal.MocksBehavior\" reference=\"../state/behavior\"></behavior><type>NICE</type></control></delegate></default><org.easymock.internal.MethodSerializationWrapper><className>java.lang.Object</className><methodName>toString</methodName><parameterTypeNames></parameterTypeNames></org.easymock.internal.MethodSerializationWrapper><org.easymock.internal.MethodSerializationWrapper><className>java.lang.Object</className><methodName>equals</methodName><parameterTypeNames><string>java.lang.Object</string></parameterTypeNames></org.easymock.internal.MethodSerializationWrapper><org.easymock.internal.MethodSerializationWrapper><className>java.lang.Object</className><methodName>hashCode</methodName><parameterTypeNames></parameterTypeNames></org.easymock.internal.MethodSerializationWrapper></org.easymock.internal.ObjectMethodsFilter></handler></dynamic-proxy>", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LoaderSaverTest.class);
	}
}