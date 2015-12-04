package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import authoring.fluidmotion.FadeTransitionWizard;
import authoring.fluidmotion.FluidGlassBall;
import authoring.fluidmotion.ParallelTransitionWizard;
import javafx.animation.Animation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemyQueueTabManager {
	private TabPane myTabPane;
	private EnemyQueuePane currentEnemyPane;

	public EnemyQueueTabManager() {
		myTabPane = new TabPane();
		myTabPane.setPrefWidth(600);

		Tab tab1 = new Tab("Wave 1");
		currentEnemyPane = new EnemyQueuePane();
		tab1.setContent(currentEnemyPane.getContent());
		myTabPane.getTabs().addAll(tab1);
		myTabPane.getSelectionModel().select(tab1);
	}

	public void addNewWave() {
		EnemyQueuePane newWave;
		try {
			newWave = new EnemyQueuePane();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		currentEnemyPane = newWave;
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory("Choose Wave Number");

		Tab newWaveTab = new Tab(String.format("%s %d", "Wave", (int) msgBox.getValue()));
		newWaveTab.setContent(newWave.getContent());

		myTabPane.getTabs().add(newWaveTab);
		myTabPane.getSelectionModel().select(newWaveTab);

	}

	public void clearWave() {
		ListView<VBox> wave = (ListView<VBox>) myTabPane.getSelectionModel().getSelectedItem().getContent();
		Animation parallel = ParallelTransitionWizard.parallelize(convertNodeListToAnimList(wave));
		parallel.setOnFinished(toExecuteOnFinished->clearWave_BAREBONE(wave));
		parallel.play();
	}

	private void clearWave_BAREBONE(ListView<VBox> wave) {
		System.out.println("The wave before clearing is: "+wave);
		wave.getItems().clear();
	}
	
	private List<Animation> convertNodeListToAnimList(ListView<VBox> wave) {
		List<Animation> animationList = new ArrayList<Animation>();
		for(Node node:wave.getItems()){
			Animation nodeAnim = FadeTransitionWizard.fadeOut(node, 
									FluidGlassBall.getFadeDuration(),
									FluidGlassBall.getFadeOpacityStart(),
									FluidGlassBall.getFadeOpacityEnd(),
									FluidGlassBall.getFadeCycleCount());
			animationList.add(nodeAnim);
		}
		return animationList;
	}
	

	private void updateLevelNumbers() {
		int i = 1;
		for (Tab t : myTabPane.getTabs()) {
			if (!t.getText().equals("+")) {
				t.setText(String.format("%s %s", "Wave", i));
				i++;
			}
		}
	}

	public Node getView() {
		return myTabPane;
	}
	
	public void removeItem()
	{
		currentEnemyPane.removeObjectFromQueue();
	}
	
	public ObjectData getSelectedItem()
	{
		return currentEnemyPane.getSelectedItem();
	}


}
