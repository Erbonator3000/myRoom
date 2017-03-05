package com.eeroprittinen.myroom.Character;

import com.badlogic.gdx.math.Vector2;
import com.eeroprittinen.myroom.Map;

public class DestinationBrain extends Brain{

	Map map;
	
	protected float speed = 0.1f;
	protected Vector2 destination;
	protected float close=0.1f;
	
	public DestinationBrain(GenericCharacter u, Map m){
		super(u);
		map = m;
		setDestination(user.position);
	}
	
	//testing purposes only
	DestinationBrain(GenericCharacter u){
		super(u);
		setDestination(user.position);
	}
	
	
	public void setDestination(Vector2 d){
		destination=d.cpy();
	}
	
	public void goTo(Vector2 d){
		destination=d.cpy();
	}
	
	public void setSpeed(float s){
		speed=s;
		close=s;
	}
	
	@Override
	public void performStep(){
		//TODO check if move is legal
		
		//check if in destination
		if(inDestination()){
			landAction();
		}else{
			Vector2 delta=destination.cpy().sub(user.position);
			delta.setLength(speed);
			user.move(delta);
		}
	}
	
	/**returns true if we are close enough to the destination*/
	public boolean inDestination(){
		return (Math.abs(dist())<=close);
	}
	
	/**distance to destination*/
	float dist(){
		return user.position.dst(destination);
	}
	
	/**action to perform when the destination has been reached*/
	protected void landAction(){
		//this is mostly for subclasses so perform step doesn't have to be rewritten
		//TODO a better name for this, damn!
	}

}
