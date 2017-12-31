/**
 * 
 */
package me.gamedev.dim;

import java.awt.image.BufferedImage;

/**
 * @author Ronnie
 *
 */
public class TextureHandler {
	private BufferedImage image;
	
	public TextureHandler(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

}
