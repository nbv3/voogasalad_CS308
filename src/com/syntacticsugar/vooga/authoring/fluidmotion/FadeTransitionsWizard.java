package com.syntacticsugar.vooga.authoring.fluidmotion;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransitionsWizard {
	public static Animation fadeOut(Node node,int timeDuration,  int initVal, int endVal, int cycleNo, EventHandler<ActionEvent> onFinished){
		FadeTransition ft = new FadeTransition(Duration.millis(timeDuration),node);
		 ft.setFromValue(1);;
	     ft.setToValue(0);;
	     ft.setCycleCount(1);
	     ft.play();
	     ft.setOnFinished(onFinished);
		return ft;
	}
}
