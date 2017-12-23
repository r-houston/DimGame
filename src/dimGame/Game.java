package dimGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

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
public class Game extends Canvas implements Runnable {
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "D I M (alpha)", this);
	}
	/*
	 * Initializes and executes game loop.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta>= 1) {
				tick();
				delta--;
			}
			
			if(running) {
				render();
			}
			
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		kill();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();		
		running = true;
	}
	
	public synchronized void kill() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
		
	}
	
	public void render() {
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufferStrategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		GameStateHandler.getInstance().render(g);
		
		g.dispose();
		bufferStrategy.show();
		
	}
	
	
	public static void main(String[] args) {
		new Game();
	}

}
