package authoring.icons.implementations;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ImageIcon extends AbstractIcon {

	public ImageIcon(String imagePath, double dimension) {
		super(imagePath, dimension);
		this.setBorder(new Border(new BorderStroke(
				Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
	}
	
}
