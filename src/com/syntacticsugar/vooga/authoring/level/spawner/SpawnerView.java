package com.syntacticsugar.vooga.authoring.level.spawner;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import com.syntacticsugar.vooga.authoring.fluidmotion.FadeTransitionWizard;
import com.syntacticsugar.vooga.authoring.fluidmotion.FluidGlassBall;
import com.syntacticsugar.vooga.authoring.icon.IDataSelector;
import com.syntacticsugar.vooga.authoring.level.map.MapManager;
import com.syntacticsugar.vooga.authoring.level.map.MapView;
import com.syntacticsugar.vooga.authoring.library.IRefresher;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.authoring.tooltips.ObjectTooltip;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.animation.Animation;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;

public class SpawnerView implements IDataSelector<ObjectData>, IVisualElement, IRefresher, Observer {

	private ListView<Node> myQueuePane;
	private Queue<ObjectData> myQueue;
	private ObservableList<Node> myWave;
	private Node selectedItem;
	private HashMap<Node, ObjectData> myObjects;
	private MapManager myMapManager;

	public SpawnerView(MapManager mapManager) {
		myMapManager = mapManager;
		myObjects = new HashMap<Node, ObjectData>();
		myQueuePane = new ListView<Node>();
		myQueue = new LinkedList<ObjectData>();
		myWave = FXCollections.observableArrayList();
		myQueuePane.setItems(myWave);
		myQueuePane.setOrientation(Orientation.HORIZONTAL);
	}

	@Override
	public void addData(ObjectData dataToAdd, Node dataView) { 
		myQueue.add(dataToAdd);
		addToSpawnerView(dataToAdd, dataView);
	}

	private void addToSpawnerView(ObjectData obj, Node dataView) {
		myWave.add(dataView);
		dataView.setOnMousePressed(e -> highlightSpawnTile(obj));
		dataView.setOnMouseReleased(e -> deHighlightSpawnTile(obj));
		dataView.setOnMouseClicked(e -> setSelectItem(dataView));
		myObjects.put(dataView, obj);
		Tooltip.install(dataView, new ObjectTooltip(obj));
	}

	private void highlightSpawnTile(ObjectData obj) {
		double x = obj.getSpawnPoint().getX();
		double y = obj.getSpawnPoint().getY();
		int colIndex = (int) Math.round(myMapManager.getMapSize() * x / 1000);
		int rowIndex = (int) Math.round(myMapManager.getMapSize() * y / 1000);
		myMapManager.getTileIconMap().get(myMapManager.getMapData().getTileData(colIndex, rowIndex))
				.setEffect(MapView.TILE_EFFECT);
	}

	private void deHighlightSpawnTile(ObjectData obj) {
		double x = obj.getSpawnPoint().getX();
		double y = obj.getSpawnPoint().getY();
		int colIndex = (int) Math.round(myMapManager.getMapSize() * x / 1000);
		int rowIndex = (int) Math.round(myMapManager.getMapSize() * y / 1000);
		myMapManager.getTileIconMap().get(myMapManager.getMapData().getTileData(colIndex, rowIndex)).setEffect(null);
	}

	private void setSelectItem(Node temp) {
		selectedItem = temp;

	}

	@Override
	public void removeSelectedData() {
		if (selectedItem != null) {
			Animation fade = FadeTransitionWizard.fadeOut(selectedItem, FluidGlassBall.getFadeDuration(),
					FluidGlassBall.getFadeOutOpacityStart(), FluidGlassBall.getFadeOutOpacityEnd(),
					FluidGlassBall.getFadeCycleCount());
			fade.setOnFinished(toExecuteOnFinished -> removeSelectedData_BAREBONE());
			fade.play();
		}
	}

	private void removeSelectedData_BAREBONE() {
		myQueue.remove(myObjects.get(selectedItem));
		myObjects.remove(selectedItem);
		myWave.remove(selectedItem);
	}

	@Override
	public ObjectData getSelectedData() {
		if (selectedItem != null) {
			return myObjects.get(selectedItem);
		}
		return null;

	}

	@Override
	public Node getView() {
		return myQueuePane;
	}

	@Override
	public void clearData() {

	}

	@Override
	public Collection<ObjectData> getAllData() {
		return myObjects.values();
	}

	public Collection<ObjectData> getObjectQueue() {
		return myQueue;
	}

	@Override
	public void refresh() {
		myQueuePane.refresh();
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();

	}

	@Override
	public void addSelectionListener(ChangeListener<Node> listener) {
		// TODO Auto-generated method stub
		
	}

}
