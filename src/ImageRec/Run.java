package ImageRec;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Run {
	HashMap seedMap = new HashMap();
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("Resources/picsForHash/marble.jpg"));
		System.out.println(new Color(img.getRGB(0, 0)));
		System.out.println(img.getWidth()+"x"+img.getHeight());
		System.out.println(img.getWidth()/((double) img.getHeight()));
	}

	public HashMap createSeeds(BufferedImage img){
		for(int i = 0; i < img.getHeight() - 5; i++){
			for(int n = 0; n < img.getWidth() - 5; n++){
				//Seed seed = new Seed(i, n, i+5, n+5);
				
			}
		}
		return null;
	}
	
	public static boolean compareSeeds(){
		return false;
		
	}
}
