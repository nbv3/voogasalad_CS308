package com.syntacticsugar.vooga.gameplayer.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.icons.implementations.Icon;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TowerBox extends Observable implements Observer{
	
	private final static double CONTENT_SPACING = 20.0;
	private VBox myContent;
	private boolean selected;
	private ObjectData currentSelection;
	private IGameUniverse myUniverse;
	private Collection<Icon> myTowerIcons;

	public TowerBox() {
		myContent = new VBox();
		selected = false;
		Label title = new Label("Tower Controls");
		//change to gridpane
		VBox content = new VBox(CONTENT_SPACING);
		myContent.getChildren().addAll(title, content);
	}


	public void initialize(Collection<ObjectData> availableTowers,IGameUniverse universe ) {
		testDragAndDrop(availableTowers);
		myUniverse = universe;
	}
	
	private void testDragAndDrop(Collection<ObjectData> availableTowers) {
		myTowerIcons = new ArrayList<>();
		for(ObjectData towerObject: availableTowers){
			Icon tower = new Icon(towerObject.getImagePath());
			tower.setOnMouseClicked(e -> selectedTower(tower, towerObject));
			myContent.getChildren().add(tower);
			myTowerIcons.add(tower);
		}
	}

	private void selectedTower(Icon tower, ObjectData towerObject) {
		if (towerObject.equals(currentSelection)){
			tower.setStyle("-fx-background-color: transparent");
			setChanged();
			notifyObservers(false);
			currentSelection = null;
		} else {
			for(Icon towerIcon: myTowerIcons){
				towerIcon.setStyle("-fx-background-color: transparent");
			}
			tower.setStyle("-fx-background-color: red");
			currentSelection = towerObject;
			setChanged();
			notifyObservers(true);
		}

	}
	
	public VBox getContent(){
		return myContent;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Point2D coordinates = (Point2D) arg1;
		currentSelection.setSpawnPoint(coordinates.getX(), coordinates.getY());
		myUniverse.addToSpawnYard(new GameObject(currentSelection));
	}
}
