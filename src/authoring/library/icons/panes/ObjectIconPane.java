package authoring.library.icons.panes;

/* ObjectIconPane is an implementation of IconPane that displays graphical 
 * representations of ObjectData instances (ie. different Game Objects)
 */

import java.util.Collection;

import authoring.library.icons.implementations.AbstractIcon;
import authoring.library.icons.implementations.ObjectIcon;
import authoring.objectediting.ObjectData;

public class ObjectIconPane extends AbstractIconPane {

	private final double DEFAULT_ICON_DIMENSION = 50;
	
	public ObjectIconPane(){
		super();
	}
	
	public void showIcons(Collection<ObjectData> dataList) {
		clearIconPane();
		for (ObjectData data : dataList){
			AbstractIcon icon = makeObjectIcon(data);
			icon.getImageView().setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon);
			addIconImageToMap(icon, data.getImagePath());
		}
		setSelectedIcon(null);
		addIconToPane(getAddIcon());
	}
	
	private AbstractIcon makeObjectIcon(ObjectData data){
		return new ObjectIcon(data, DEFAULT_ICON_DIMENSION);
	}
	
	@Override
	protected void createNewIcon() {
		
	}
	
	
}
