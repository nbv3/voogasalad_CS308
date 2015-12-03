package authoring.icons.panes;

import java.io.File;
import java.util.Collection;

import authoring.dragdrop.DragDropManager;
import authoring.icons.ImageFileFilter;
import authoring.icons.implementations.Icon;
import javafx.scene.input.MouseEvent;

public class ImageIconPane extends AbstractIconPane {

	public ImageIconPane() {
		super();
	}

	@Override
	public void showIcons(File directory) {
		clearIconPane();
		Collection<String> imagePaths = getImagePaths(directory, new ImageFileFilter());
		for (String path : imagePaths) {
			Icon icon = new Icon(path);
			icon.setOnDragDetected((MouseEvent e) -> DragDropManager.createDragClipBoards(icon, e));
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon, path);
		}
		setSelectedIcon(null);
	}
	
}
