package com.syntacticsugar.vooga.authoring.icon;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.dirview.IFileConverter;
import com.syntacticsugar.vooga.util.dirview.IDirectoryViewer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.layout.TilePane;

/**
 * Generates visual representations of the Files in a target directory.
 * Stores the data objects generated from the Files in said directory. 
 * Allows the user to click on JavaFX Nodes to select between the data objects they represent.
 * 
 * @author Brody Kellish
 *
 * @param <T> : The data type backing this display
 */
public class DataSelectionPane<T> implements IVisualElement, 
											 IDirectoryViewer<T>, 
											 IDataSelector<T> {

	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 3;
	private final int NUM_COLS = 3;
	
	private final ScrollPane myScrollPane;
	private final TilePane myNodePane;
	private final Map<Node, T> myNodeToDataMap;
	private final ObjectProperty<Node> mySelectedNode;

	/**
	 * Construct a new DataSelectionPane
	 */
	public DataSelectionPane() {
		myNodeToDataMap = new HashMap<>();
		mySelectedNode = initSelectedNode();
		myScrollPane = initScrollPane();
		myNodePane = initTilePane();
		myScrollPane.setContent(myNodePane);
	}
	
	@Override
	public void addSelectionListener(ChangeListener<Node> listener) {
		mySelectedNode.addListener(listener);
	}

	@Override
	public Collection<T> getAllData() {
		return Collections.unmodifiableCollection(myNodeToDataMap.values());
	}

	@Override
	public T getSelectedData() {
		return myNodeToDataMap.get(mySelectedNode.get());
	}

	@Override
	public void removeSelectedData() {
		Node toRemove = mySelectedNode.getValue();
		myNodePane.getChildren().remove(toRemove);
		myNodeToDataMap.remove(toRemove);
		mySelectedNode.set(null);
	}

	@Override
	public void addData(T dataToAdd, Node dataView) {
		dataView.setOnMouseClicked(e -> toggleSelectedImage(dataView));
		myNodeToDataMap.put(dataView, dataToAdd);
		myNodePane.getChildren().add(dataView);
	}

	@Override
	public void clearData() {
		myNodePane.getChildren().clear();
		myNodeToDataMap.clear();
		mySelectedNode.set(null);
	}

	@Override
	public void showDirectoryContents(File fileDirectory, IFileConverter<T> fileConverter, INodeCreator<T> nodeCreator) {
		Collection<T> convertedData = fileConverter.convertFiles(fileDirectory);
		for (T data: convertedData) {
			addData(data, nodeCreator.createNode(data));
		}
	}

	@Override
	public Node getView() {
		return this.myScrollPane;
	}
	

	// ********* Private methods *****************
	
	/**
	 *  Initialize the Node property that stores the currently selected Node
	 * @return selectedNode : The constructed ObjectProperty<ImageView>
	 */
	private ObjectProperty<Node> initSelectedNode() {
		ObjectProperty<Node> selectedNode = new SimpleObjectProperty<>();
		selectedNode.addListener((o, s1, s2) -> setSelectedEffect(s1, s2));
		return selectedNode;
	}

	/**
	 *  Initialize the ScrollPane used to organize the TilePane
	 * @return sp : The constructed ScrollPane 
	 */
	private ScrollPane initScrollPane() {
		ScrollPane sp = new ScrollPane();
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setFitToWidth(true);
		sp.setPadding(new Insets(INSET_VALUE));
		sp.setFitToHeight(true);
		return sp;
	}

	/**
	 * Initialize the TilePane used to organize Nodes in this Pane
	 * @return tp : The constructed TilePane (bound to the size of the ScrollPane)
	 */
	private TilePane initTilePane() {
		TilePane tp = new TilePane();
		tp.setPrefColumns(NUM_COLS);
		tp.setAlignment(Pos.CENTER);
		tp.setHgap(INSET_VALUE);
		tp.setVgap(INSET_VALUE);
		tp.maxWidthProperty().set(
				myScrollPane.viewportBoundsProperty().get().getWidth() - 2 * INSET_VALUE);
		return tp;
	}
	
	/**
	 * Toggle the current selection in this pane
	 * @param node : The Node clicked by the user
	 */
	private void toggleSelectedImage(Node node) {
		if (mySelectedNode.get() != null) {
			if (mySelectedNode.get().equals(node)) {
				mySelectedNode.set(null);
				return;
			}
		}
		mySelectedNode.set(node);
	}
	
	/**
	 * Update the Glow effect that we use to show the current selection
	 * @param oldSelection : The previously selected Node
	 * @param newSelection : The newly selected Node
	 */
	private void setSelectedEffect(Node oldSelection, Node newSelection) {
		if (oldSelection == null) {
			newSelection.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		if (newSelection == null) {
			oldSelection.setEffect(null);
			return;
		}
		oldSelection.setEffect(null);
		newSelection.setEffect(new Glow(GLOW_PERCENTAGE));
	}


}
