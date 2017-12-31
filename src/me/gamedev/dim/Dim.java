package me.gamedev.dim;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.File;

import javax.swing.JFrame;

/**
 * 
 * @author Ronnie
 * 
 * <h1>Welcome to DIM!<h1>
 * This is a top-down adventure-defense game. 
 * Game.java handles game initialization and game loop.
 *
 */
@SuppressWarnings("serial")
public class Dim extends Canvas implements Runnable {
	public static final String 	TITLE = "D I M";
	public static final int 	WIDTH = 1080;
	public static final int 	HEIGHT = WIDTH / 4 * 3;
	
	private boolean				running;
	private GameStateHandler	gameStateHandler;
	private GameState			currentState;
	
	public Dim() {
		loadFonts();
		gameStateHandler = new GameStateHandler();
		gameStateHandler.addState(new MainMenu());
	}
	
	private void loadFonts() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./res/GL_Scratchy.ttf")));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void tick() {
		gameStateHandler.tick();
	}
	
	private void render() {
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bufferStrategy.getDrawGraphics();
		g.setColor(new Color(0, 0, 0, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);		
		gameStateHandler.render(g);
		g.dispose();
		bufferStrategy.show();
	}
	
	private void start() {
		if(running)
			return;
		running = true;
		new Thread(this, "DimMain-Thread").start();
	}
	
	private void kill() {
		if(!running)
			return;
		running = false;
		System.out.println("Exiting game...");
	}
	/*
	 * Initializes and executes game loop.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Game running...");
		double target = 60.0;
		double ns = 1000000000.0 / target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double lag = 0.0;
		int fps = 0;
		int tps = 0;
		while(running) {
			long now = System.nanoTime();
			lag += (now - lastTime) / ns;
			lastTime = now;			
			if(lag >= 1.0) {
				tick();
				lag--;
				tps++;
				render();
				fps++;
			}
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.printf("fps: %d || tps: %d\n", fps, tps);
				fps = 0;
				tps = 0;
			}
		}
		System.exit(0);
	}
	
	
	
	
	public static void main(String[] args) {
		final Dim game = new Dim();
		
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.addWindowListener(new WindowAdapter() {
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				game.kill();
			}
		});
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		game.start();
		
	}

}
