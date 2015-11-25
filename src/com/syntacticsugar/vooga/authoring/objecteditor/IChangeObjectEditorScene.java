package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

public interface IChangeObjectEditorScene {
	
	public void initSelectionScene(GameObjectType type);
	public void resetToTypeScene();
	
}
