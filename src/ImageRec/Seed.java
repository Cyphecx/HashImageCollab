package ImageRec;


public class Seed {
	
	private int[][] pixels;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	/*
	 * This constructor takes the coordinates of the top left and bottom right points
	 * and sets the width and height of the pixel array accordingly.
	 */
	public Seed(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		pixels = new int[endX-startX][endY-startY];
	}

	public int[][] getPixels() {
		return pixels;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}
	
	//Gets the color of a pixel at a certain point.
	public int getPixelAt(int x, int y){
		return pixels[x][y];
	}
	
	//Sets the color of a pixel at a determined point. 
	public void setPixelAt(int x, int y, int color){
		pixels[x][y] = color;
	}
		
	public int size(){
		return pixels.length;
	}
	
	public String toString(){
		return "x1: "+startX+", y1: "+startY+"| x2:"+endX+", y2:"+endY;
	}
}
