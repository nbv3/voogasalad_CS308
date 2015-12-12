package com.syntacticsugar.vooga.authoring.icon;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.dirview.IConverter;
import com.syntacticsugar.vooga.util.dirview.IDirectoryViewer;
import com.syntacticsugar.vooga.xml.data.IViewableData;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

/**
 * Generates visual representations of the Files in a target directory.
 * Stores the data objects generated from the Files in said directory. 
 * Allows the user to click on visual elements to select between data objects.
 * 
 * @author Brody Kellish
 *
 * @param <T> : The type of IViewableData to display
 */
public class DataSelectionPane<T extends IViewableData> implements IVisualElement, 
																   IDirectoryViewer<T>, 
																   IDataSelector<T> {

	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 3;
	private final int NUM_COLS = 3;
	
	private final ScrollPane myScrollPane;
	private final TilePane myIconPane;
	private final Map<ImageView, T> myImageToDataMap;
	private final ObjectProperty<ImageView> mySelectedImage;

	/**
	 * Construct a new DataSelectionPane
	 */
	public DataSelectionPane() {
		myImageToDataMap = new HashMap<>();
		mySelectedImage = initSelectedImage();
		myScrollPane = initScrollPane();
		myIconPane = initTilePane();
		myScrollPane.setContent(myIconPane);
	}
	
	/**
	 *  Initialize the ImageView property that stores the currently selected image
	 * @return selectedImage : The constructed ObjectProperty<ImageView>
	 */
	private ObjectProperty<ImageView> initSelectedImage() {
		ObjectProperty<ImageView> selectedImage = new SimpleObjectProperty<>();
		selectedImage.addListener((o, s1, s2) -> setSelectedEffect(s1, s2));
		return selectedImage;
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
	 *  Initialize the TilePane used to organize images in this Pane
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
	 *  Toggle the current selection in this pane
	 * @param iv : The ImageView clicked by the user
	 */
	private void toggleSelectedImage(ImageView iv) {
		if (mySelectedImage.get() != null) {
			if (mySelectedImage.get().equals(iv)) {
				mySelectedImage.set(null);
				return;
			}
		}
		mySelectedImage.set(iv);
	}
	
	/**
	 *  Update the Glow effect that we use to show the current selection
	 * @param oldIv : The previously selected image
	 * @param newIv : The newly selected image
	 */
	private void setSelectedEffect(ImageView oldIv, ImageView newIv) {
		if (oldIv == null) {
			newIv.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		if (newIv == null) {
			oldIv.setEffect(null);
			return;
		}
		oldIv.setEffect(null);
		newIv.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	/**
	 * Add a listener that updates whenever the current selection of this pane 
	 * changes. Allows the programmer to bind custom events to selection changes that occur in this pane.
	 * @param listener : the function to call whenever a selection change occurs on this pane.
	 */
	public void addSelectionListener(ChangeListener<ImageView> listener) {
		mySelectedImage.addListener(listener);
	}

	/**
	 * Returns a Collection of all the IViewableData currently backing this DataSelectionPane.
	 * @return backingData : a Collection of IViewableData.
	 */
	@Override
	public Collection<T> getAllData() {
		return Collections.unmodifiableCollection(myImageToDataMap.values());
	}

	/**
	 * Return the data backing the current selection in this DataSelectionPane.
	 */
	@Override
	public T getSelectedData() {
		return myImageToDataMap.get(mySelectedImage.get());
	}

	/**
	 * Remove the currently selected viewable data from this DataSelectionPane.
	 * 
	 * WARNING: This method does NOT remove the corresponding File from the target directory - 
	 * this method only removes the data from the current view. If the DataSelectionPane
	 * is pointed back at the current directory, the removed data will repopulate in the Pane.
	 */
	@Override
	public void removeSelectedData() {
		ImageView toRemove = mySelectedImage.getValue();
		myIconPane.getChildren().remove(toRemove);
		myImageToDataMap.remove(toRemove);
		mySelectedImage.set(null);
	}

	/**
	 * Add a new viewable data element to this SelectionPane.
	 * @param toAdd : the ViewableData object to add to this DataSelectionPane
	 */
	@Override
	public void addData(T toAdd) {
		String path = toAdd.getImagePath();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(path));
		ImageView iv = new ImageView(image);
		iv.setOnMouseClicked(e -> toggleSelectedImage(iv));
		myImageToDataMap.put(iv, toAdd);
		myIconPane.getChildren().add(iv);
	}

	/**
	 * Clear all data (and it's visual representation) from this DataSelectionPane.
	 */
	@Override
	public void clearData() {
		myIconPane.getChildren().clear();
		myImageToDataMap.clear();
		mySelectedImage.set(null);
	}

	/**
	 * Populate this DataSelectionPane with visual representations of the data files in 
	 * a specified directory. 
	 * @param fileDirectory : the System directory in which to search for files
	 * @param fileConverter : the functional interface used to extract data objects from the files in fileDirectory.
	 * 						  This method need only return a Collection of IViewableData objects.
	 */
	@Override
	public void showDirectoryContents(File directory, IConverter<T> fileConverter) {
		Collection<T> dataToDisplay = fileConverter.convertFiles(directory);
		for (T dataToAdd: dataToDisplay) {
			addData(dataToAdd);
		}
	}

	@Override
	public Node getView() {
		return this.myScrollPane;
	}

}
