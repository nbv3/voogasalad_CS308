package authoring.icons.panes;

import java.util.Collection;

import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ImageIcon;

public class ImageIconPane extends AbstractIconPane {

	private final double DEFAULT_ICON_DIMENSION = 50;

	public ImageIconPane() {
		super();
	}

	public void showIcons(Collection<String> imagePaths) {
		clearIconPane();
		for (String path : imagePaths) {
			AbstractIcon icon = makeImageIcon(path);
			icon.getImageView().setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon);
			addIconImageToMap(icon, path);
		}
		setSelectedIcon(null);
	}

	private AbstractIcon makeImageIcon(String imagePath) {
		return new ImageIcon(imagePath, DEFAULT_ICON_DIMENSION);
	}

	@Override
	protected void createNewIcon() {
		// TODO Auto-generated method stub

	}

}