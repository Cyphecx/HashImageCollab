package ImageRec;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Run {
	private static LinkedList seedList = new LinkedList();
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("Resources/picsForHash/marble.jpg"));
		BufferedImage img2 = ImageIO.read(new File("Resources/picsForHash/marlbe1.jpg"));
		HashMap map = createSeeds(img);
		Rectangle hitbox = new Rectangle();
		double percentMatch = (hitbox.getHeight()*hitbox.getWidth())/(img.getHeight()*img.getWidth());
		System.out.println("There is a "+percentMatch+"% match at ("+hitbox.getMinX()+
				", "+hitbox.getMinY()+"), ("+hitbox.getMaxX()+", "+hitbox.getMaxY()+")");
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
	public static Rectangle createHitbox(Vector<Seed> hits){
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
	public static Vector findHits(BufferedImage whole,BufferedImage partial){
		HashMap wholeSeeds= createSeeds(whole);
		HashMap partialSeeds= createSeeds(partial);
		Vector containVector= new Vector();
		for(int x=0;x<partialSeeds.getList().size();x+=(partialSeeds.getList().size()/100)){
			if(wholeSeeds.containsKey(partialSeeds.getList().get(x))==true){

			}
		}
		return containVector;
	}
}
