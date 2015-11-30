package com.syntacticsugar.vooga.gameplayer.utilities;

public abstract class Stat implements IGameStat {
	
	private String description;
	private Double value;
	
	public Stat(){
		description = new String();
		value = new Double(0);
	}
//	
//	public void setDescription(String des){
//		description = des;
//	}
//	
//	public void setValue(Double val){
//		value = val;
//	}
//	
//	public String getDescription(){
//		return description;
//	}
//	
//	public Double getValue(){
//		return value;
//	}
	
}
