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
		HashMap map = createSeeds(img);
	}
	/*
	 * createSeeds takes a buffered image as input
	 * and returns a HashMap containing all of the seeds in the source image
	 */
	public static HashMap createSeeds(BufferedImage img){
		HashMap<Seed, String> seedMap = new HashMap<Seed, String>();
		for(int i = 0; i < img.getHeight() - 5; i++){
			for(int n = 0; n < img.getWidth() - 5; n++){
				Seed seed = new Seed(n, i, n+5, i+5);
				for(int j = i; j < i+5; j++){
					for(int k = n; k < n+5; k++){
						seed.setPixelAt(j-i, k-n, new Color(img.getRGB(k,j)).getRed());
					}
				}
				seedMap.put(seed, seed.toString());
			}
		}
		return seedMap;
	}
	
	public static boolean compareSeeds(){
		return false;
		
	}
}
