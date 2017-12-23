/**
 * 
 */
package dimGame;

import java.awt.Graphics;
import java.util.Stack;

/**
 * @author Ronnie
 *
 *Manages a stack of states and renders current game state.
 */
public class GameStateHandler {
	
	private static GameStateHandler instance;
	
	private Stack<GameState> states;

	private GameStateHandler() {
		states = new Stack<GameState>();
	}

	public static GameStateHandler getInstance() {
		if (instance == null) {
			instance = new GameStateHandler();
		}

		return instance;
	}
	
	public void tick() {
		states.peek().tick();
		
	}

	public void render(Graphics g) {
		states.peek().render(g);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
