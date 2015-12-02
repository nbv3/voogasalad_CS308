package authoring.icons.panes;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import authoring.icons.ImageFileFilter;
import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ImageIcon;
import javafx.scene.image.ImageView;
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
			AbstractIcon icon = new ImageIcon(path);
			icon.setOnDragDetected((MouseEvent e) -> createDragClipBoards(icon.getImage(), path, e));
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon, path);
		}
		setSelectedIcon(null);
	}
	
}
