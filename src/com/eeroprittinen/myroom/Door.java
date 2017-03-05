package com.eeroprittinen.myroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Door {

	float width=0.7f;
	float position;
	
	float imgWidth;
	float imgHeight;
	
	Sprite sprite;
	
	Door(float p, String f){
		sprite = new Sprite(new Texture(Gdx.files.internal(f)));
		position=p;
		imgWidth=width*2/(float)Math.sqrt(5);
		imgHeight=imgWidth*sprite.getHeight()/sprite.getWidth();
		sprite.setSize(imgWidth, imgHeight);
	}
	
	
}
