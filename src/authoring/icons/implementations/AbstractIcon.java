package authoring.icons.implementations;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class AbstractIcon extends Pane {
	
	private static final double BORDER_WIDTH = 1.0;
	private static final Border BORDER = new Border(new BorderStroke(
			Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(BORDER_WIDTH)));

	private ImageView myImageView;
	private String myPath;
	private String fileName;
	
	public AbstractIcon(String imagePath, double dimension){
		setFileName(imagePath);
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
		myPath = imagePath;
		myImageView = new ImageView(img);
		setIconDimensions(dimension);
		this.getChildren().add(myImageView);
		this.setBorder(BORDER);
	}
	
	private void setFileName(String path)
	{
		Path p = Paths.get(path);
		String file = p.getFileName().toString();
		fileName = file;
	}
	
	public String getFileName()
	{
		return fileName;
	}
	
	private void setIconDimensions(double size){
		myImageView.fitWidthProperty().bind(this.widthProperty().subtract(BORDER_WIDTH));
		myImageView.fitHeightProperty().bind(this.heightProperty().subtract(BORDER_WIDTH));
		this.setSize(size);
	}
	
	public String getPath()
	{
		return myPath;
	}
	
	public void setImage(Image image) {
		myImageView.setImage(image);
	}
	
	public void setImagePath(String newPath)
	{
		File a = new File(myPath);
		String fullPath = newPath + "/" + a.getName();
		a.renameTo(new File(fullPath));
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(a.getName()));
		myImageView = new ImageView(img);
		a.delete();
	}
	
	public ImageView getImage()
	{
		return myImageView;
	}
	
	public void setSize(double size) {
		this.setWidth(size);
		this.setHeight(size);
	}
	
}
