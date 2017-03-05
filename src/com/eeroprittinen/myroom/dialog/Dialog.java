package com.eeroprittinen.myroom.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.eeroprittinen.myroom.Isometric;

public class Dialog {

	Sprite background;
	
	long lifetime;
	
	boolean visible = false;
	long startTime;
	
	float width;
	float height;
	
	//TODO make more universal
	/**@param time: -1 for infinite*/
	public Dialog(long time, Vector3 pos){
		lifetime = time;
		background = new Sprite(new Texture(Gdx.files.internal("")));//some universal background
		background.setPosition(Isometric.toIsoX(pos), Isometric.toIsoY(pos));
		width=1;
		height=1;
		background.setSize(width, height);
	}
	
	public void spawn(){
		visible = true;
		startTime = TimeUtils.millis();
	}
	
	/**draws the dialog if it is visible*/
	public void draw(SpriteBatch batch){
		if(visible){
			background.draw(batch);
			if(lifetime!=-1 && TimeUtils.timeSinceMillis(startTime)>=lifetime)
				visible = false;
		}
	}
	
	public void hide(){
		visible = false;
	}
	
}
