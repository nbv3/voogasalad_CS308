package authoring.icons.panes;

import java.io.File;

/* ObjectIconPane is an implementation of IconPane that displays graphical 
 * representations of ObjectData instances (ie. different Game Objects)
 */

import java.util.Collection;

import authoring.data.ObjectData;
import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ObjectIcon;
import authoring.level.ObjectIconTooltip;
import javafx.scene.control.Tooltip;

public class ObjectIconPane extends AbstractIconPane {

	private final double DEFAULT_ICON_DIMENSION = 50;
	
	public ObjectIconPane(){
		super();
	}
	
	public void showIcons(Collection<ObjectData> dataList) {
		clearIconPane();
		for (ObjectData data : dataList){
			AbstractIcon icon = makeObjectIcon(data);
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			Tooltip.install(icon, new ObjectIconTooltip(data));
			addIconToPane(icon, data.getImagePath());
		}
		setSelectedIcon(null);
	}
	
	private AbstractIcon makeObjectIcon(ObjectData data){
		return new ObjectIcon(data, DEFAULT_ICON_DIMENSION);
	}
	
	@Override
	public void showIcons(File directory) {
		// TODO Auto-generated method stub
		
	}
	
	
}
