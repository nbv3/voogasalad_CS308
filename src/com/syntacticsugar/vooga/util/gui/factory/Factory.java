package com.syntacticsugar.vooga.util.gui.factory;

import java.lang.reflect.Method;
import javafx.scene.Node;

public abstract class Factory {
		public abstract Node createObject(String id);
		protected Method createMethodObject(String className, String id, Class[] params){
			try {
				Class<?> cls = Class.forName(className);
				return this.getClass().getDeclaredMethod(id, params);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			return null;
		}
}
