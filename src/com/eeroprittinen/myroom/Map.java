package com.eeroprittinen.myroom;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.eeroprittinen.myroom.Character.GenericCharacter;
import com.eeroprittinen.myroom.Character.MainCharacter;
import com.eeroprittinen.myroom.Isometric;

/**Contains all the information about the world where our game is based on**/
public class Map {

	Room[][] rooms;
	float roomWidth;//assuming all the rooms are the same size
	float roomHeight;
	float width;
	float height;
	int sizeX;
	int sizeY;
	
	float roomSpriteWidth;
	float roomSpriteHeight;
	
	ArrayList<GenericCharacter> npcs;
	MainCharacter mainCharacter;
	
	float stateTime;
	
	
	Map(Room[][] r){
		rooms=r;

		sizeX=rooms.length;
		sizeY=rooms[0].length;
		
		roomWidth=rooms[0][0].width; //assuming all the rooms are the same size 
		roomHeight=rooms[0][0].height;
		
		width=sizeX*roomWidth;
		height=sizeY*roomHeight;
		
		roomSpriteWidth=rooms[0][0].imgWidth;
		roomSpriteHeight=rooms[0][0].imgHeight;
		
		setSprites();
		
		npcs = new ArrayList<GenericCharacter>();
		
	}
	
	/**set sprites of things(which things?) in the world in to their places in isometric coordinates**/
	private void setSprites(){
		for(int i=0; i<rooms.length; i++){
			for(int j=0; j<rooms[i].length; j++){
				//could be done with Isometric class but is it worth it here?
				rooms[i][j].floor.setPosition(roomSpriteWidth/2*(i+j),roomSpriteHeight/2*(j-i-1));
				rooms[i][j].wall1.sprite.setPosition(roomSpriteWidth/2*(i+j),roomSpriteHeight/2*(j-i));
				rooms[i][j].wall2.sprite.setPosition(roomSpriteWidth/2*(1+i+j),roomSpriteHeight/2*(j-i));
				rooms[i][j].wall1.updateSprites();
			}
		}
	}
	
	/**Draw floors of the map**/
	void drawFloors(SpriteBatch batch){
		//TODO maybe sorting out which floors need to be redrawn
		for(int i=0; i<rooms.length; i++){
			for(int j=0; j<rooms[i].length; j++){
				
				batch.begin();
				rooms[i][j].floor.draw(batch);
				batch.end();
			
			}
		}
	}
	
	/**draw walls of the map**/
	void drawWalls(SpriteBatch batch){
		//TODO maybe sorting out which walls need to be redrawn
		//TODO fading and transparent walls by player position
		for(int i=0; i<rooms.length; i++){
			for(int j=0; j<rooms[i].length; j++){
				
				batch.begin();
				
				if(rooms[i][j].wall1!=null){
					rooms[i][j].wall1.sprite.draw(batch);
					if(rooms[i][j].wall1.hasDoor())
						rooms[i][j].wall1.door.sprite.draw(batch);
				}
				
				if(rooms[i][j].wall2!=null){
					rooms[i][rooms[i].length-1-j].wall2.sprite.draw(batch);
					if(rooms[i][j].wall2.hasDoor())
						rooms[i][j].wall2.door.sprite.draw(batch);
				}
				
				batch.end();
			
			}
		}
	}
	
	
	/**draw characters on the map**/
	void drawCharacters(SpriteBatch batch){
		stateTime+=Gdx.graphics.getDeltaTime();
		
		
		//TODO quik and dirty
		//if (mainCharacter!=null)
		TextureRegion currentFrame = mainCharacter.walkDown.getKeyFrame(stateTime,true);
		Sprite frameSprite = new Sprite(currentFrame);
		frameSprite.setPosition( Isometric.toIsoX(mainCharacter.position), Isometric.toIsoY(mainCharacter.position));
		frameSprite.setSize(mainCharacter.width, mainCharacter.height);
		batch.begin();
			frameSprite.draw(batch);
		batch.end();
	}
}