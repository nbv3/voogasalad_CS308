package authoring.icons.panes;

import java.io.File;
import java.util.Collection;

import authoring.icons.ImageFileFilter;
import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ImageIcon;

public class ImageIconPane extends AbstractIconPane {

	public ImageIconPane() {
		super();
	}

	@Override
	public void showIcons(File directory) {
		clearIconPane();
		Collection<String> imagePaths = getImagePaths(directory, new ImageFileFilter());
		for (String path : imagePaths) {
			AbstractIcon icon = new ImageIcon(path, true);
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon, path);
		}
		setSelectedIcon(null);
	}

}
