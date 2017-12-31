/**
 * 
 */
package me.gamedev.dim;

import java.awt.Graphics;
import java.util.Stack;

/**
 * @author Ronnie
 *
 */
public class GameStateHandler {
	Stack<GameState> states;
	
	public GameStateHandler() {
		states = new Stack<GameState>();
	}
	
	public void addState(GameState state) {
		states.push(state);
	}
	
	public void removeState() {
		states.pop();
	}
	
	public void tick() {
		states.peek().tick();
	}
	
	public void render(Graphics g) {
		states.peek().render(g);
	}

}
