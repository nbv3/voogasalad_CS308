package com.syntacticsugar.vooga.gameplayer.objects.towers;

import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.geometry.Point2D;
import xml.data.ObjectData;

public class Tower extends GameObject implements ITower {

	public Tower(ObjectData data) {
		super(data);
	}

}
