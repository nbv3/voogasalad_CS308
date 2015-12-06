package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.util.properties.PropertiesManager;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MoneyInfo extends HBox{
	
	private Label myMoney;
	private final String labelText;
	private PropertiesManager myPropertiesManager;
	
	public MoneyInfo(int initialCash, String style){
		this();
		this.getStyleClass().add(style);
		this.setAlignment(Pos.CENTER);
		myMoney = new Label(labelText + initialCash);
		ImageView coinImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("coin.png")));
		coinImage.setFitHeight(myPropertiesManager.getDoubleProperty("CoinSize"));
		coinImage.setFitWidth(myPropertiesManager.getDoubleProperty("CoinSize"));
		this.getChildren().addAll(myMoney, coinImage);
	}
	
	private MoneyInfo(){
		myPropertiesManager = new PropertiesManager("com/syntacticsugar/vooga/resources/View");
		labelText = myPropertiesManager.getProperty("Money");
	}
	
	public void changeMoney(int money){
		myMoney.setText(labelText+ " " + money);
	}

}
