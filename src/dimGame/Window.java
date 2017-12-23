/**
 * 
 */
package dimGame;

import javax.swing.JFrame;

/**
 * @author Ronnie
 * 
 * Handles window setup.
 */
public class Window {
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
		game.start();
	}

}
