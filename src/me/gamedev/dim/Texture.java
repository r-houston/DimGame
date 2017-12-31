/**
 * 
 */
package me.gamedev.dim;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * @author Ronnie
 *
 */
public class Texture {
	private final static Map<String, TextureHandler> 	textureMap = new HashMap<String, TextureHandler>();
	private TextureHandler 								textureHandler;
	
	public Texture(String filename) {
		TextureHandler cachedImage = textureMap.get(filename);
		if(cachedImage != null) {
			textureHandler = cachedImage;
		}else {
			try {
				System.out.println("/res/" + filename + ".png");
				textureHandler = new TextureHandler(ImageIO.read(new File("./res/" + filename + ".png")));
				textureMap.put(filename, textureHandler);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(textureHandler.getImage(), x, y, null);
	}

}
