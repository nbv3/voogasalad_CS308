package authoring.fluidmotion;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class ParallelTransitionWizard {
	public static Animation parallelize(Animation... animationList){
		ParallelTransition pt = new ParallelTransition();
		pt.getChildren().addAll(animationList);
		return pt;
	}
	
	public static Animation parallelize(List<Animation> list){
		Animation[] animationList = new Animation[list.size()];
		for(int i=0; i<list.size(); i++){
			animationList[i] = list.get(i);
		}
		System.out.println("Animation List is :" + animationList);
		return parallelize(animationList);
	}	
}