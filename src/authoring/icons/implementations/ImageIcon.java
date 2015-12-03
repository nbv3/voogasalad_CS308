package authoring.icons.implementations;

public class ImageIcon extends AbstractIcon {

	public ImageIcon(String imagePath, boolean showBorder) {
		super(imagePath, showBorder);
	}
	
	public ImageIcon(String imagePath) {
		super(imagePath, false);
	}
	
}
