package authoring.icons.panes;

import java.io.File;
import java.util.Collection;

import authoring.icons.ImageFileFilter;
import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ImageIcon;

public class ImageIconPane extends AbstractIconPane {

	private final double DEFAULT_ICON_DIMENSION = 50;

	public ImageIconPane() {
		super();
	}

	@Override
	public void showIcons(File directory) {
		clearIconPane();
		Collection<String> imagePaths = getImagePaths(directory, new ImageFileFilter());
		for (String path : imagePaths) {
			AbstractIcon icon = makeImageIcon(path);
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon, path);
		}
		setSelectedIcon(null);
	}

	private AbstractIcon makeImageIcon(String imagePath) {
		return new ImageIcon(imagePath, DEFAULT_ICON_DIMENSION);
	}

}
