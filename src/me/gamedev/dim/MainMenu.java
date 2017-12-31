/**
 * 
 */
package me.gamedev.dim;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * @author Ronnie
 *
 */
public class MainMenu extends GameState{
	private Texture		mainMenuBG;
	private char[] 		title = {'D', 'M'};
	private Font 		menuFont = new Font("GL Scratchy", Font.PLAIN, 400);	
	private double		maxOscillation = 20, rotation = maxOscillation;
	private float 		radius = 150;
	private Random 		rand;
	
	private AudioPlayer	audioPlayer;

	public MainMenu() {
		super();
	}
	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#init()
	 */
	@Override
	public void init() {
		System.out.println("initializing Main Menu...");
		rand = new Random();
		mainMenuBG = new Texture("main_menu");
		audioPlayer = new AudioPlayer("Journey_to_Anok");
		audioPlayer.play();
	}

	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#tick()
	 */
	@Override
	public void tick() {
		rotation = maxOscillation * Math.cos((2 * Math.PI / 2500) * System.currentTimeMillis());
		float pulse = rand.nextFloat() * 20 - 10;
		//System.out.printf("pulse: %f\n", pulse);
		if(radius + pulse < 0)
			pulse = 0;
		radius += pulse;
	}

	/* (non-Javadoc)
	 * @see me.gamedev.dim.GameState#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {		
		Graphics2D g2d = (Graphics2D) g;
		mainMenuBG.render(g, 100, 20);
		g2d.setFont(menuFont);
		g2d.setColor(Color.white);
		g2d.drawChars(title, 0, 1, 100, 410);
		g2d.setColor(new Color(255, 255, 255, 250));
		g2d.setFont(menuFont);
		AffineTransform at = new AffineTransform();
		AffineTransform oldTransform = g2d.getTransform();
		at.setToRotation(Math.toRadians(rotation), 710, 300);
		g2d.setTransform(at);
		g2d.drawChars(title, 1, 1, 600, 650);
		g2d.setTransform(oldTransform);
		Point2D lightOrb = new Point2D.Float(510, 270);
		float[] dist = {0.0f, 1.0f};
		Color[] colors = {new Color(0.0f, 0.0f, 0.25f, 0.0f), Color.black};
		RadialGradientPaint paint = new RadialGradientPaint(lightOrb, radius, dist, colors);
		g2d.setPaint(paint);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.98f));
		g2d.fillRect(0, 0, Dim.WIDTH, Dim.HEIGHT);
		g2d.dispose();
	}
	

}
