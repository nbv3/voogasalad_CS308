package authoring.icons.panes;

import java.io.File;

/* ObjectIconPane is an implementation of IconPane that displays graphical 
 * representations of ObjectData instances (ie. different Game Objects)
 */

import java.util.Collection;

import authoring.icons.implementations.Icon;
import authoring.level.ObjectIconTooltip;
import javafx.scene.control.Tooltip;
import xml.data.ObjectData;

public class ObjectIconPane extends AbstractIconPane {

	public ObjectIconPane(){
		super();
	}
	
	public void showIcons(Collection<ObjectData> dataList) {
		clearIconPane();
		for (ObjectData data : dataList){
			Icon icon = makeObjectIcon(data);
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			Tooltip.install(icon, new ObjectIconTooltip(data));
			addIconToPane(icon, data.getImagePath());
		}
		setSelectedIcon(null);
	}
	
	private Icon makeObjectIcon(ObjectData data){
		return new Icon(data.getImagePath());
	}
	
	@Override
	public void showIcons(File directory) {
		// TODO Auto-generated method stub
		
	}
	
	
}
