// This entire file is part of my masterpiece.
// Brody Kellish

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

import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Included to show my refactored DataSelectionPane in action
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
		
		// Get the target directory for ObjectData files of the specified GameObjectType
		String targetDirectory = ResourceManager.getString(
				String.format("%s_%s", objectType.toString().toLowerCase(), "data"));
		
		myXMLDirectory = new File(targetDirectory);
		
		// When we change the selection in our DataSelectionPane, then populate the 
		// ObjectEditor with the newly selected item.
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
		myDataSelectionPane.showDirectoryContents(
				myXMLDirectory, 
				dir -> convertFilesToObjectData(dir),
				data -> generateNodeFromData(data));
	}
	
	/**
	 * INodeCreator method used to build a JavaFX ImageView from an instance of ObjectData
	 * @param data : The ObjectData to use
	 * @return node : A Node containing this ObjectData's Image
	 */
	private Node generateNodeFromData(ObjectData data) {
		String path = data.getImagePath();
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(path));
		return new ImageView(img);
	}

	/**
	 * IConverter method used to read XML files from a directory as ObjectData instances.
	 * @param directory : The directory containing the target XML
	 * @return data : The collection of ObjectData generated from this directory
	 */
	private Collection<ObjectData> convertFilesToObjectData(File directory) {
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<ObjectData> xml = new XMLHandler<>();
		Collection<ObjectData> dataCollection = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			ObjectData data = xml.read(files[i]);
			dataCollection.add(data);
		}
		return dataCollection;
	}
	
	@Override
	public Node getView() {
		return myViewPane;
	}

	/**
	 * Pass the currently selected item up to the top level manager so that it can
	 * populate the ObjectEditor.
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
