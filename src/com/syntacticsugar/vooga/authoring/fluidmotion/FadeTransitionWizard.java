package com.syntacticsugar.vooga.authoring.fluidmotion;

import java.util.List;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransitionWizard {

	// public static Animation fadeOut(List<Node> nodes,int timeDuration,
	// int initVal, int endVal, int cycleNo, EventHandler<ActionEvent>
	// onFinished){
	//
	// }

	public static Animation fadeOut(Node node, int timeDuration, int initVal, int endVal, int cycleNo) {
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(1);
		ft.setToValue(0);
		return ft;
	}

	public static Animation fadeIn(Node node, int timeDuration, int initVal, int endVal, int cycleNo) {
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(0);
		ft.setToValue(1);
		return ft;
	}

	private static FadeTransition initFadeTransitionObject(Node node, int timeDuration) {
		FadeTransition ft = new FadeTransition(Duration.millis(timeDuration), node);
		ft.setCycleCount(1);
		return ft;
	}


}
