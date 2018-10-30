import java.io.IOException;
import java.io.FileWriter;

public class Image {

	/* 
	 * 1) A public byte array to store raw 24-bit RGB image data (3 bytes per pixel).
	 */
	public byte[] data;
	
	/*
	 * 2) A constructor Image( int width, int height ) 
	 * that creates an Image object with the specified width and height.
	 */
	private int width, height;
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		// Multiplying by 3 for the colors R G B
		data = new byte[width*height*3];
	}
	/*
	 * A method set( int x, int y, int val ) which sets a single pixel 
	 * at position (x,y) to the RGB value represented by val. 
	 * (Note: use zero-based indexing, i.e. the upper left corner pixel 
	 * has position (0,0). Note: only consider the lower 24 bits of val).
	 */
	public void set(int x, int y, int val) {
         // this is the formula to get location in the image buffer
         data[x*width*3 + y*3] = (byte)(val >> 16); // R bits
         data[x*width*3 + y*3 + 1] = (byte)((val >> 8 ) & 0xff); // G bits
         data[x*width*3 + y*3 + 2] = (byte)(val & 0xff); // B bits
     }
}
