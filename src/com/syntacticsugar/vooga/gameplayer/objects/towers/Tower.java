package com.syntacticsugar.vooga.gameplayer.objects.towers;

import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import authoring.data.ObjectData;
import javafx.geometry.Point2D;

public class Tower extends GameObject implements ITower {

	public Tower(ObjectData data, Point2D point, double width, double height) {
		super(data, width, height);
		getBoundingBox().setPoint(point);
	}

}
