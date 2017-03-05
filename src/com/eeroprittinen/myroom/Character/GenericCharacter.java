package com.eeroprittinen.myroom.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.eeroprittinen.myroom.Isometric;

public class GenericCharacter {
	
	public Vector2 position;
	
	//TODO some preset size for characters
	public float width=1;
	public float height=2;
	
	public Brain brain;
	
	/**some basic sprite for non animation sets**/
	public Sprite sprite;
	
	public Animation<TextureRegion> walkDown;
	public Animation<TextureRegion> walkUp;
	public Animation<TextureRegion> walkUpRight;
	public Animation<TextureRegion> walkRight;
	public Animation<TextureRegion> walkDownRight;
	
	Texture animationSheet;
	boolean animated=false;
	
	
	GenericCharacter(){
		this("assets/door_generic.png");
	}
	GenericCharacter(String f){
		sprite = new Sprite(new Texture(Gdx.files.internal(f)));
		sprite.setSize(width, height);//TODO better size settings
		position = new Vector2();
	}
	
	//animated constructor
	//TODO animation stuff
	GenericCharacter(String f, int frameRows, int frameCols){
		animationSheet = new Texture(Gdx.files.internal(f));
		TextureRegion[][] tmp = TextureRegion.split(animationSheet,
													animationSheet.getWidth()/frameRows,
													animationSheet.getHeight()/frameCols);
		//TODO fix quik and dirty
		walkDown = new Animation<TextureRegion>(0.2f, tmp[0]);
		
	}
	
	//constructor for testing purposes
	GenericCharacter(int i){
		sprite = new Sprite();
		position = new Vector2();
	}
	
	public void addBrain(Brain b){
		brain=b;
	}
	
	//TODO collision handling here or in the brain? maybe in the brain
	//more possibilities and makes moving more predictable and flawless
	public void moveTo(Vector2 pos){
		position=pos;
		updateSprite();
	}
	
	public void move(Vector2 dir){
		position.add(dir);
		updateSprite();
	}
	
	void updateSprite(){
		if (sprite!=null)
			sprite.setPosition(Isometric.toIsoX(position), Isometric.toIsoY(position));
	}
	
	
}
