package com.syntacticsugar.vooga.authoring.fluidmotion;

public class FluidGlassBall {	
	// All durations are in milliseconds. 
	
	private static final int FADE_DURATION = 150; 
	private static final int FADE_IN_OPACITY_START = 1;
	private static final int FADE_IN_OPACITY_END = 0;
	private static final int FADE_OUT_OPACITY_START = FADE_IN_OPACITY_END;
	private static final int FADE_OUT_OPACITY_END = FADE_IN_OPACITY_START;
	private static final int FADE_CYCLE_COUNT = 1;

	public static int getFadeDuration() {
		return FADE_DURATION;
	}
	public static int getFadeInOpacityStart() {
		return FADE_IN_OPACITY_START;
	}
	public static int getFadeInOpacityEnd() {
		return FADE_IN_OPACITY_END;
	}
	public static int getFadeOutOpacityStart() {
		return FADE_OUT_OPACITY_START;
	}
	public static int getFadeOutOpacityEnd() {
		return FADE_OUT_OPACITY_END;
	}
	public static int getFadeCycleCount() {
		return FADE_CYCLE_COUNT;
	}

}
