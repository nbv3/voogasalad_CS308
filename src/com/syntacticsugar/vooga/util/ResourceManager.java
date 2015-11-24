package com.syntacticsugar.vooga.util;

import java.util.ResourceBundle;

public class ResourceManager {

	private static final ResourceBundle myResources = addBundle();
	
	private static ResourceBundle addBundle() {
		return ResourceBundle.getBundle("com/syntacticsugar/vooga/resources/Resources");
	}
	
	public static String getString(String key) {
		return myResources.getString(key);
	}
	
}
