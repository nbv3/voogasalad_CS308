package authoring.library;

/* DataIconPane is an implementation of IconPane that gets its images from XML files
 * and displays the images with labels.
 */

import java.io.File;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.thoughtworks.xstream.XStream;
import javafx.scene.image.Image;

public class DataIconPane extends IconPane {

	private final String[] myAcceptableXMLTypes = {".XML", ".xml"};
	private final int DEFAULT_ICON_DIMENSION = 50;
	private XStream myXStream;
	
	public DataIconPane(){
		super();
		// myXStream = new XStream; or whatever object we need to parse data;
	}
	
	private LabeledIcon makeLabeledIconFromImage(Image image, String name){
		LabeledIcon labeledIcon = new LabeledIcon(name, image, DEFAULT_ICON_DIMENSION);
		registerMouseClickHandler(labeledIcon);
		return labeledIcon;
	}

	public void showImageOptionsFromXML(File XMLDirectory) {
		for (File file: XMLDirectory.listFiles()){
			if (file.getName().endsWith("xml")){
				ObjectData objectData = new ObjectData();
				//ObjectData objectData = (ObjectData) myXStream.fromXML(file);
				// ^ DOES THIS WORK ?
				Image iconImage = new Image(
						getClass().getClassLoader().getResourceAsStream(objectData.getImagePath()));
				LabeledIcon icon = makeLabeledIconFromImage(iconImage, objectData.getObjectName());
				myIconPane.getChildren().add(icon);
			}
			registerAddButtonMouseClickHandler(myAcceptableXMLTypes);
			myIconPane.getChildren().add(myAddButton);
		}
	}
	
	
}
