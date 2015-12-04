package authoring.fluidmotion;

public class FluidGlassBall {	
	// All durations are in milliseconds. 
	
	private static final int FADE_DURATION = 150; 
	private static final int FADE_OPACITY_START = 1;
	private static final int FADE_OPACITY_END = 0;
	private static final int FADE_CYCLE_COUNT = 1;
	public static int getFadeDuration() {
		return FADE_DURATION;
	}
	public static int getFadeOpacityStart() {
		return FADE_OPACITY_START;
	}
	public static int getFadeOpacityEnd() {
		return FADE_OPACITY_END;
	}
	public static int getFadeCycleCount() {
		return FADE_CYCLE_COUNT;
	}

}
