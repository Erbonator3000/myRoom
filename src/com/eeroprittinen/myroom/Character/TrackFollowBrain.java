package com.eeroprittinen.myroom.Character;


import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.eeroprittinen.myroom.Map;

public class TrackFollowBrain extends DestinationBrain{
	
	ArrayList<Vector2> track;
	int destIndex=0;
	
	public TrackFollowBrain(GenericCharacter u, Map m){
		super(u, m);
		track = new ArrayList<Vector2>();
	}
	
	public void addPoint(Vector2 p){
		track.add(p);
	}
	
	public void removePoint(int index){
		track.remove(index);
	}
	
	/**sets the new destination from track*/
	@Override
	protected void landAction(){
		destIndex++;
		if(destIndex>=track.size())
			destIndex=0;
		destination=track.get(destIndex);
		
	}
	
}
