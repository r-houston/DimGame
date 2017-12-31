/**
 * 
 */
package me.gamedev.dim;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Ronnie
 *
 */
public class AdventureGuide extends GameState{

	public AdventureGuide() {
		super();
	}
	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#init()
	 */
	@Override
	public void init() {
		System.out.println("Initializing Adventure Guide...");
	}

	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(0, 0, Dim.WIDTH, Dim.HEIGHT);
		
	}
	

}
