package com.syntacticsugar.vooga.authoring.fluidmotion;

import java.util.List;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransitionWizard {
	
	public static Animation fadeOut(Node node, int timeDuration, int cycleNo){
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(FluidGlassBall.getFadeOutOpacityStart());
		ft.setToValue(FluidGlassBall.getFadeOutOpacityEnd());
		return ft;
	}

	public static Animation fadeOut(Node node, int timeDuration, int initVal, int endVal, int cycleNo) {
		FadeTransition ft = fade(node, timeDuration, initVal, endVal);
		return ft;
	}

	public static Animation fadeIn(Node node, int timeDuration, int cycleNo) {
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(FluidGlassBall.getFadeInOpacityStart());
		ft.setToValue(FluidGlassBall.getFadeInOpacityEnd());
		return ft;
	}
	
	public static Animation fadeIn(Node node, int timeDuration, int initVal, int endVal, int cycleNo) {
		FadeTransition ft = fade(node, timeDuration, initVal, endVal);
		return ft;
	}

	private static FadeTransition fade(Node node, int timeDuration, int initVal, int endVal) {
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(initVal);
		ft.setToValue(endVal);
		return ft;
	}

	private static FadeTransition initFadeTransitionObject(Node node, int timeDuration) {
		FadeTransition ft = new FadeTransition(Duration.millis(timeDuration), node);
		ft.setCycleCount(1);
		return ft;
	}


}
