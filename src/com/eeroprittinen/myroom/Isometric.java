package com.eeroprittinen.myroom;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**provides functions to transform from map coordinates to isometric coordinates
 * when the origins are in the same position and isometric x:y ratio is 2
**/
public class Isometric {

	/**method to transfer coordinates to isometric view coordinates*/
	public static Vector2 toIso(Vector2 pos){		
		return new Vector2(toIsoX(pos), toIsoY(pos));
	}
	/**method to transfer coordinates to isometric view coordinates*/
	public static float toIsoX(Vector2 pos){	
		return toIsoX(pos.x, pos.y);
	}
	/**method to transfer coordinates to isometric view coordinates*/
	public static float toIsoY(Vector2 pos){
		return toIsoY(pos.x, pos.y);
	}
	/**method to transfer coordinates to isometric view coordinates*/
	public static float toIsoX(float x, float y){
		return 2*x/(float)Math.sqrt(5)+2*y/(float)Math.sqrt(5);	
	}
	/**method to transfer coordinates to isometric view coordinates*/
	public static float toIsoY(float x, float y){
		return y/(float)Math.sqrt(5)-x/(float)Math.sqrt(5);
	}
	
	
	//TODO see the z-coordinate work in action
	/**method to transfer coordinates to isometric view coordinates
	 * still testing, use with caution*/
	public static Vector2 toIso(Vector3 pos){		
		return new Vector2(toIsoX(pos), toIsoY(pos));
	}
	/**method to transfer coordinates to isometric view coordinates
	 * still testing, use with caution*/
	public static float toIsoX(Vector3 pos){	
		return toIsoX(pos.x, pos.y, pos.z);
	}
	/**method to transfer coordinates to isometric view coordinates
	 * still testing, use with caution*/
	public static float toIsoY(Vector3 pos){
		return toIsoY(pos.x, pos.y, pos.z);
	}
	/**method to transfer coordinates to isometric view coordinates
	 * still testing, use with caution*/
	public static float toIsoX(float x, float y, float z){
		return 2*x/(float)Math.sqrt(5)+2*y/(float)Math.sqrt(5);	
	}
	/**method to transfer coordinates to isometric view coordinates
	 * still testing, use with caution*/
	public static float toIsoY(float x, float y, float z){
		return y/(float)Math.sqrt(5)-x/(float)Math.sqrt(5)+z;
	}

	
	
	/**transfers coordinates from isometric view to world coordinates*/
	public static Vector2 fromIso(Vector2 pos){		
		return new Vector2(fromIsoX(pos), fromIsoY(pos));
	}
	/**transfers coordinates from isometric view to world coordinates*/
	public static float fromIsoX(Vector2 pos){	
		return fromIsoX(pos.x, pos.y);
	}
	/**transfers coordinates from isometric view to world coordinates*/
	public static float fromIsoY(Vector2 pos){
		return fromIsoY(pos.x, pos.y);
	}
	/**transfers coordinates from isometric view to world coordinates*/
	public static float fromIsoX(float x, float y){
		return  (float) Math.sqrt(5)*x/4-(float)Math.sqrt(5)*y/2;
	}
	/**transfers coordinates from isometric view to world coordinates*/
	public static float fromIsoY(float x, float y){
		return (float) Math.sqrt(5)*x/4+(float)Math.sqrt(5)*y/2;
	}
	
}
