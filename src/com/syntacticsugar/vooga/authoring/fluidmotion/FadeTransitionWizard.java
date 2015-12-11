// This entire file is part of my Masterpiece.
// Henry Yuen
package com.syntacticsugar.vooga.authoring.fluidmotion;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Applies a fade Transition effect to a JavaFX node. 
 * User can call applyEffect() with default values, or call individual
 * fadeIn or fadeOut methods with custom values.
 * @author Henry Yuen
 *
 */
public class FadeTransitionWizard {
	
	/**
	 * Applies effect determined by boolean fadeIn, with default values from FluidGlassBall. 
	 * True for FadeIn, false for FadeOut
	 * @param node
	 * @param timeDuration
	 * @param cycleNo
	 * @param fadeIn
	 * @return
	 */
	public static Animation applyEffect(Node node, Duration timeDuration, int cycleNo, boolean fadeIn){
		return (fadeIn) ? fadeIn(node, timeDuration,cycleNo): fadeOut(node, timeDuration,cycleNo);
	}
	
	/**
	 * Initialises the fadeTransition object.
	 * @param node
	 * @param timeDuration
	 * @return
	 */
	private static FadeTransition initFadeTransitionObject(Node node, Duration timeDuration) {
		FadeTransition ft = new FadeTransition(timeDuration, node);
		ft.setCycleCount(1);
		return ft;
	}
	
	/**
	 * Fade method that takes in node 
	 * @param node
	 * @param timeDuration
	 * @param initVal
	 * @param endVal
	 * @return
	 */
	private static FadeTransition fade(Node node, Duration timeDuration, double initVal, double endVal) {
		FadeTransition ft = initFadeTransitionObject(node, timeDuration);
		ft.setFromValue(initVal);
		ft.setToValue(endVal);
		return ft;
	}
	
	/**
	 * Applies the fadeOut animation with default values stated in FluidGlassBall.
	 * @param node
	 * @param timeDuration
	 * @param cycleNo
	 * @return
	 */
	public static Animation fadeOut(Node node, Duration timeDuration, int cycleNo){
		FadeTransition ft = fade(node,
								 timeDuration,
								 FluidGlassBall.getFadeOutOpacityStart(),
								 FluidGlassBall.getFadeOutOpacityEnd());
		return ft;
	}

	/**
	 * Applies the fadeOut animation with custom defined values.
	 * @param node
	 * @param timeDuration
	 * @param initVal
	 * @param endVal
	 * @param cycleNo
	 * @return
	 */
	public static Animation fadeOut(Node node, Duration timeDuration, double initVal, double endVal, int cycleNo) {
		FadeTransition ft = fade(node, 
								 timeDuration, 
								 initVal, 
								 endVal);
		ft.setCycleCount(cycleNo);
		return ft;
	}

	/**
	 * Applies the fadeIn animation with default values set in FluidGlassBall.
	 * @param node
	 * @param timeDuration
	 * @param cycleNo
	 * @return
	 */
	public static Animation fadeIn(Node node, Duration timeDuration, int cycleNo) {
		FadeTransition ft = fade(node,
								 timeDuration,
								 FluidGlassBall.getFadeInOpacityStart(),
								 FluidGlassBall.getFadeInOpacityEnd());
		return ft;
	}
	
	/**
	 * Applies the fadeIn animation with custom defined values. 
	 * @param node
	 * @param timeDuration
	 * @param initVal
	 * @param endVal
	 * @param cycleNo
	 * @return
	 */
	public static Animation fadeIn(Node node, Duration timeDuration, double initVal, double endVal, int cycleNo) {
		FadeTransition ft = fade(node, timeDuration, initVal, endVal);
		return ft;
	}
}
