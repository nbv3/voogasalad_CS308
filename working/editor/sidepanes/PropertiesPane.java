package editor.sidepanes;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class PropertiesPane {

	private Pane myPane;
	
	
	public PropertiesPane()
	{
		myPane = new Pane();
	}
	
	public void addChildren(Node child)
	{
		myPane.getChildren().add(child);
	}
	
	public void removeChild(Node child)
	{
		if(myPane.getChildren().contains(child))
		{
			myPane.getChildren().remove(child);
		}
	}
	
	public Pane getPane()
	{
		return myPane;
	}

}
