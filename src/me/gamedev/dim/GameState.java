/**
 * 
 */
package me.gamedev.dim;

import java.awt.Graphics;

/**
 * @author Ronnie
 *
 */
public abstract class GameState {
	
	public GameState() {
		init();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics g);

}
