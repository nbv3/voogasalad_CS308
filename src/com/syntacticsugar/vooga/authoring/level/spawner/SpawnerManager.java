package com.syntacticsugar.vooga.authoring.level.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.fluidmotion.FadeTransitionWizard;
import com.syntacticsugar.vooga.authoring.fluidmotion.FluidGlassBall;
import com.syntacticsugar.vooga.authoring.fluidmotion.ParallelTransitionWizard;
import com.syntacticsugar.vooga.authoring.level.IDataSelector;
import com.syntacticsugar.vooga.authoring.level.ITabbedManager;
import com.syntacticsugar.vooga.authoring.level.map.MapManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.WaveData;

import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class SpawnerManager implements ITabbedManager<ObjectData> {

	private TabPane myTabPane;
	private Map<Tab, SpawnerView> mySpawnerViewMap;
	private SpawnerControls mySpawnerController;
	private MapManager myMapManager;

	public SpawnerManager(MapManager mapManager) {
		myMapManager = mapManager;
		myTabPane = new TabPane();
		mySpawnerViewMap = new HashMap<>();
		mySpawnerController = new SpawnerControls(this);
		append();
	}

	@Override
	public void append() {
		SpawnerView newSpawnerView = new SpawnerView(myMapManager);

		Tab newWaveTab = new Tab();
		newWaveTab.setContent(newSpawnerView.getView());
		newWaveTab.setOnCloseRequest(e -> remove());
		newWaveTab.setOnClosed(e -> updateWaveNumbers());

		mySpawnerViewMap.put(newWaveTab, newSpawnerView);

		myTabPane.getTabs().add(newWaveTab);
		myTabPane.getSelectionModel().select(newWaveTab);
		updateWaveNumbers();
	}

	@Override
	public void remove() {
		@SuppressWarnings("unchecked")
		ListView<VBox> wave = (ListView<VBox>) myTabPane.getSelectionModel().getSelectedItem().getContent();
		Animation parallel = ParallelTransitionWizard.parallelize(convertNodeListToAnimList(wave));
		parallel.setOnFinished(toExecuteOnFinished -> clearWave_BAREBONE(wave));
		parallel.play();
	}

	@Override
	public SpawnerView getCurrentView() {
		return mySpawnerViewMap.get(myTabPane.getSelectionModel().getSelectedItem());
	}

	public void addDataToCurrentView(ObjectData data) {
		mySpawnerViewMap.get(myTabPane.getSelectionModel().getSelectedItem()).addData(data);
	}

	@Override
	public Observable getObservableController() {
		return mySpawnerController;
	}

	@Override
	public Node getControlNode() {
		return mySpawnerController.getView();
	}

	@Override
	public Node getViewNode() {
		return GUIFactory.buildTitledPane("Spawner Display", myTabPane);
	}

	public SpawnerData getSpawnerData() {
		Collection<WaveData> map = new ArrayList<WaveData>();
		for (Tab t : myTabPane.getTabs()) {
			WaveData queue = mySpawnerViewMap.get(t).getWaveData();
			map.add(queue);
		}
		return new SpawnerData(map);
	}

	private void clearWave_BAREBONE(ListView<VBox> wave) {
		wave.getItems().clear();
	}

	private List<Animation> convertNodeListToAnimList(ListView<VBox> wave) {
		List<Animation> animationList = new ArrayList<Animation>();
		for (Node node : wave.getItems()) {
			Animation nodeAnim = FadeTransitionWizard.fadeOut(node, FluidGlassBall.getFadeDuration(),
					FluidGlassBall.getFadeOutOpacityStart(), FluidGlassBall.getFadeOutOpacityEnd(),
					FluidGlassBall.getFadeCycleCount());
			animationList.add(nodeAnim);
		}
		return animationList;
	}

	private void updateWaveNumbers() {
		for (int i = 0; i < myTabPane.getTabs().size(); i++) {
			Tab t = myTabPane.getTabs().get(i);
			t.setText(String.format("%s %s", "Wave", i + 1));
		}
	}

}
