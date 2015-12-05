package com.syntacticsugar.vooga.gameplayer.view;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class DirectionArrows extends BorderPane{
	
	public DirectionArrows(double size, TileView tile){
		ImageView left = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrLeft.png")));
		left.setOnMouseClicked(e -> tile.informTowerControl(Direction.LEFT, this));
		ImageView right = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrRight.png")));
		right.setOnMouseClicked(e -> tile.informTowerControl(Direction.RIGHT, this));
		ImageView up = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrUp.png")));
		up.setOnMouseClicked(e -> tile.informTowerControl(Direction.UP, this));
		ImageView down = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrDown.png")));
		down.setOnMouseClicked(e -> tile.informTowerControl(Direction.DOWN, this));
		BorderPane.setAlignment(up, Pos.CENTER);
		BorderPane.setAlignment(down, Pos.CENTER);
		List<ImageView> myImgs = new ArrayList<ImageView>();
		myImgs.add(left); myImgs.add(right); myImgs.add(up); myImgs.add(down);
		for(ImageView img: myImgs){
			img.setFitHeight(size);
			img.setFitWidth(size);
		}
		Canvas center = new Canvas(size, size);
		this.setTop(up);
		this.setLeft(left);
		this.setRight(right);
		this.setBottom(down);
		this.setCenter(center);
	}
	
}
