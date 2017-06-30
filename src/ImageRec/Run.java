package ImageRec;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Run {
	private static LinkedList seedList = new LinkedList();
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
	public static Rectangle createHitbox(LinkedList<Seed> hits){
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		
		for(Seed seed : hits){
			if(seed.getStartX() < minX){
				minX = seed.getStartX();
			}
			if(seed.getEndX() > maxX){
				maxX = seed.getEndX();
			}
			if(seed.getStartY() < minY){
				minY = seed.getStartY();
			}
			if(seed.getEndY() > maxY){
				maxY = seed.getEndY();
			}
		}
		Rectangle output = new Rectangle();
		output.setBounds(minX, minY, maxX-minX, maxY - minY);
		return output;
	}
	public static void findSquares(BufferedImage wholeImage,BufferedImage partialImage){
		HashMap wholeImageSeeds= createSeeds(wholeImage);
		HashMap partialImageSeeds= createSeeds(partialImage);
		
	}
	public static void findSquares(BufferedImage wholeImage,BufferedImage partialImage){
		HashMap wholeImageSeeds= createSeeds(wholeImage);
		HashMap partialImageSeeds= createSeeds(partialImage);
		for(int n=0;n<wholeImageSeeds.getList().size();n+=(wholeImageSeeds.getList().size()/100))
		partialImageSeeds.containsKey(wholeImageSeeds.getList().get(n));
		
	}
}
