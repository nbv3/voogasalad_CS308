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
	
	public DirectionArrows(TileView tile, GameView myGameView){
		double size = tile.getViewPane().getWidth();
		ImageView left = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrLeft.png")));
		left.setOnMouseClicked(e -> tile.informTowerControl(Direction.LEFT, this, myGameView));
		ImageView right = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrRight.png")));
		right.setOnMouseClicked(e -> tile.informTowerControl(Direction.RIGHT, this, myGameView));
		ImageView up = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrUp.png")));
		up.setOnMouseClicked(e -> tile.informTowerControl(Direction.UP, this, myGameView));
		ImageView down = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("arrDown.png")));
		down.setOnMouseClicked(e -> tile.informTowerControl(Direction.DOWN, this, myGameView));
		BorderPane.setAlignment(up, Pos.CENTER);
		BorderPane.setAlignment(down, Pos.CENTER);
		List<ImageView> myImgs = new ArrayList<ImageView>();
		myImgs.add(left); myImgs.add(right); myImgs.add(up); myImgs.add(down);
		for(ImageView img: myImgs){
			img.setFitHeight(size);
			img.setFitWidth(size);
		}
		Canvas center = new Canvas(size, size);
		initializeBorderPane(left, right, up, down, center);
	}

	private void initializeBorderPane(ImageView left, ImageView right, ImageView up, ImageView down, Canvas center) {
		this.setTop(up);
		this.setLeft(left);
		this.setRight(right);
		this.setBottom(down);
		this.setCenter(center);
	}
	
}
