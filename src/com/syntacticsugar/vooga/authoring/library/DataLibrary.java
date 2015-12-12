package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.icon.DataSelectionPane;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;

/**
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Included to show my refactored DataSelectionPane in action!
 * Refactored for cleanliness and compatibility
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 * 
 * Class used to display visual representations of data files generated in
 * our authoring environment. The library is instantiated with a specific
 * Type of Game Object (Player, Enemy, Item, or Tower) and points a DataSelectionPane
 * to the corresponding data folder within our project setup. Allows the user to
 * update the library as new data files are generated and removed.
 * 
 * @author Elsie Ling,
 * @author Brody Kellish (Refactored for VoogaSalad Masterpiece)
 *
 */
public class DataLibrary extends Observable implements IVisualElement,
													   IRefresher {

	private final File myXMLDirectory;
	private DataSelectionPane<ObjectData> myDataSelectionPane;
	private TitledPane myViewPane;

	public DataLibrary(GameObjectType objectType) {
		// Build the title for this library
		String title = String.format("%s Library", objectType.toString());
		
		// Initialize the data selection pane used in this library
		myDataSelectionPane = new DataSelectionPane<>();
		
		// Build the pane used to contain this library
		myViewPane = GUIFactory.buildTitledPane(title, myDataSelectionPane.getView());
		myViewPane.setPadding(new Insets(10));
		
		// Get the target directory for ObjectData files of the specified GameObjectType
		String targetDirectory = ResourceManager.getString(
				String.format("%s_%s", objectType.toString().toLowerCase(), "data"));
		
		myXMLDirectory = new File(targetDirectory);
		
		// When we change the selection in our DataSelectionPane, then populate the 
		// ObjectEditor with the newly selected item. Uses the method defined in
		// the DataSelectionPane public API to define custom actions
		myDataSelectionPane.addSelectionListener((o, s1, s2) -> editItem());
		refresh();
	}

	/**
	 * Refresh this DataLibrary. Usually called after a new data file has been saved to 
	 * this library's target directory (for instance, after the user saves a new GameObject that
	 * they've built in the authoring environment). This method allows the pane to stay up-to-date
	 * with data generated during runtime.
	 */
	public void refresh() {
		myDataSelectionPane.showDirectoryContents(myXMLDirectory, e -> convertXMLFiles(myXMLDirectory));
	}
	
	@Override
	public Node getView() {
		return myViewPane;
	}

	/**
	 * This method is used as the IConverter<ObjectData> that we pass into the DataSelectionPane.
	 * Specifies which type of file we care about (XML files) and how to convert those
	 * files into ObjectData (via the XMLHandler<ObjectData> class)
	 * @param directory : The target directory (generated upon construction)
	 * @return dataCollection : A Collection of ObjectData with all the ObjectData stored as XML
	 * files in the target directory.
	 */
	private Collection<ObjectData> convertXMLFiles(File directory) {
		
		// List all the XML files in this directory
		File[] files = directory.listFiles(new XMLFileFilter());
		
		// Parse XML files as ObjectData
		XMLHandler<ObjectData> xml = new XMLHandler<>();
		Collection<ObjectData> dataCollection = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			ObjectData data = xml.read(files[i]);
			dataCollection.add(data);
		}
		
		// Return all the ObjectData instances contained in the XML files in this directory.
		return dataCollection;
	}

	/**
	 * Pass the currently selected item up to the top level manager so that it can
	 * populate the ObjectEditor (I didn't refactor the update chain for my masterpiece)
	 */
	private void editItem() {
		setChanged();
		notifyObservers(myDataSelectionPane.getSelectedData());
	}

	/**
	 * Get this library's currently selected data 
	 * @return
	 */
	public IData getCurrentData() {
		return myDataSelectionPane.getSelectedData();
	}

}
