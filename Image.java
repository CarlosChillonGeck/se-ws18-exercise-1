import java.io.IOException;
import java.io.*;

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
        /*
	 * Explains how the &0xff operand works to transform colors to special formats:
	 * https://oscarliang.com/what-s-the-use-of-and-0xff-in-programming-c-plus-p/
	 * Code taken and explained to me by Student of Digital Engineering Vaddi Vamshi Krishna.
	 */
         data[x*width*3 + y*3] = (byte)(val >> 16); 
         data[x*width*3 + y*3 + 1] = (byte)((val >> 8 ) & 0xff); 
         data[x*width*3 + y*3 + 2] = (byte)(val & 0xff); 
        }
	
	/*
	 * A method write( String filename ) which writes the 
	 * image data to a file represented by filename. 
	 * As image format, use the trivial PPM format with binary 
	 * encoding (see http://netpbm.sourceforge.net/doc/ppm.html for 
	 * the file structure).
	 * 
	 * Use Streams when you are dealing with raw data:
	 * https://www.journaldev.com/878/java-write-to-file
	 */
 		
 	public void write(String filename) throws IOException {
 	
		FileOutputStream os = null;
		try {
		    	os = new FileOutputStream(new File("./OutputImage.txt"));
			String header = ("P6\n" + width + "\n" + height + "\n255\n").getBytes();
			os.write(header);
			os.write(data);
		} catch (IOException e) {
		   	 e.printStackTrace();
		}finally{
		    try {
			os.close();
		    } catch (IOException e) {
			e.printStackTrace();
		  	}
 	}
 

}
