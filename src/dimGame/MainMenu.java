/**
 * 
 */
package dimGame;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Ronnie
 *
 */
public class MainMenu extends GameState{

	/* (non-Javadoc)
	 * @see dimGame.GameState#init()
	 */
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dimGame.GameState#tick()
	 */
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dimGame.GameState#render(java.awt.Graphics)
	 */
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}

}
