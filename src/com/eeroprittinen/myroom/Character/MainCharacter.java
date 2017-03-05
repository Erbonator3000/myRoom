package com.eeroprittinen.myroom.Character;


public class MainCharacter extends GenericCharacter{

	
	
	public DestinationBrain brain;
	
	public MainCharacter(){
		super();
	}
	
	public MainCharacter(String f, int frameRows, int frameCols){
		super(f, frameRows, frameCols);
	}
	
	public void addBrain(DestinationBrain b){
		brain = b;
	}
	
}
