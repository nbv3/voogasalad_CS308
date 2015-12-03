package authoring.fluidmotion;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeTransitionWizard {
	public static Animation fadeOut(Node node,int timeDuration,  
			int initVal, int endVal, int cycleNo, EventHandler<ActionEvent> onFinished){
		FadeTransition ft = initFadeTransitionObject(node, timeDuration, onFinished);
		 ft.setFromValue(1);
	     ft.setToValue(0);
	     ft.play();
		return ft;
	}
	
	public static Animation fadeIn(Node node,int timeDuration,  
			int initVal, int endVal, int cycleNo, EventHandler<ActionEvent> onFinished){
		FadeTransition ft = initFadeTransitionObject(node, timeDuration, onFinished);
		 ft.setFromValue(0);
	     ft.setToValue(1);
	     ft.play();
		return ft;
	}

	private static FadeTransition initFadeTransitionObject(Node node, int timeDuration,
			EventHandler<ActionEvent> onFinished) {
		FadeTransition ft = new FadeTransition(Duration.millis(timeDuration),node);
	     ft.setCycleCount(1);
	     ft.setOnFinished(onFinished);
		return ft;
	}
}
