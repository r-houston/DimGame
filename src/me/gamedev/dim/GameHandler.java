/**
 * 
 */
package me.gamedev.dim;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Ronnie
 *
 */
public class GameHandler {
	private ArrayList<Object> objects;	//change to array of GameStates when created
	private GameStateHandler gameStateHandler;

	private GameHandler() {
		objects = new ArrayList<Object>();
		gameStateHandler = new GameStateHandler();
	}
	
	public void addObject(Object obj) {
		objects.add(obj);
	}
	
	public void removeObject(Object obj) {
		objects.remove(obj);
	}
	
	public Object getObjectById(ID id) {
		for(Object obj : objects) {
			//if obj id matches id param
				//return obj
		}
		return null;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		gameStateHandler.render(g);
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
