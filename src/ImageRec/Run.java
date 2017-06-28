package ImageRec;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Run {

	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("Resources/picsForHash/marble.jpg"));
		System.out.println(new Color(img.getRGB(0, 0)));
		System.out.println(img.getWidth()+"x"+img.getHeight());
		System.out.println(img.getWidth()/((double) img.getHeight()));
	}

	public static void iteratePixels(BufferedImage image){
		
	}
	
	public static boolean compareSeeds(){
		
	}
}
