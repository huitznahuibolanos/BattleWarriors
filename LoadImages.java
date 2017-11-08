import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class LoadImages {
	private final static String IMAGE_DIR = "Images/" ;
	
	private HashMap imagesMap; 
	
	private GraphicsConfiguration gc;

	
	
	 public LoadImages()
	  {  initLoader();  }
	 
	 private void initLoader()
	  {
	    imagesMap = new HashMap();
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
	  }
	 
	 public void loadImageFile(String fnm){
		 String imsFNm = IMAGE_DIR + fnm;
		 System.out.println("Reading file: " + imsFNm);
		 
		 try {
		      InputStream in = this.getClass().getResourceAsStream(imsFNm);
		      BufferedReader br = new BufferedReader(new FileReader(imsFNm));
		      // BufferedReader br = new BufferedReader( new FileReader(imsFNm));
		      String line;
		      char ch;
		      while((line = br.readLine()) != null) {
		        if (line.length() == 0)  // blank line
		          continue;
		        if (line.startsWith("//"))   // comment
		          continue;
		        ch = Character.toLowerCase( line.charAt(0) );
		        if (ch == 'o')  // a single image
		          getFileNameImage(line);
		        else
		        	System.out.println("Do not recognize line: " + line);
		      }
		      br.close();
		    } 
		    catch (IOException e) 
		    { System.out.println("Error reading file: " + imsFNm);
		      System.exit(1);
		    }
	 }
	 private void getFileNameImage(String line)
	  /* format:
	        o <fnm>
	  */
	  { StringTokenizer tokens = new StringTokenizer(line);

	    if (tokens.countTokens() != 2)
	      System.out.println("Wrong no. of arguments for " + line);
	    else {
	      tokens.nextToken();    // skip command label
	      System.out.print("o Line:");
	      //System.out.println(tokens.nextToken());
	      loadSingleImage( tokens.nextToken() );
	    }
	  }  // end of getFileNameImage()


	  public boolean loadSingleImage(String fnm)
	  // can be called directly
	  {
	    String name = getPrefix(fnm);

	    if (imagesMap.containsKey(name)) {
	      System.out.println( "Error: " + name + "already used");
	      return false;
	    }

	    BufferedImage bi = loadImage(fnm);
	    if (bi != null) {
	      ArrayList imsList = new ArrayList();
	      imsList.add(bi);
	      imagesMap.put(name, imsList);
	      System.out.println("  Stored " + name + "/" + fnm);
	      return true;
	    }
	    else
	      return false;
	  }  // end of loadSingleImage()


	  private String getPrefix(String fnm)
	  // extract name before '.' of filename
	  {
	    int posn;
	    if ((posn = fnm.lastIndexOf(".")) == -1) {
	      System.out.println("No prefix found for filename: " + fnm);
	      return fnm;
	    }
	    else
	      return fnm.substring(0, posn);
	  } // end of getPrefix()

	 
	  
	  public BufferedImage loadImage(String fnm) 
	   /* Load the image from <fnm>, returning it as a BufferedImage
	      which is compatible with the graphics device being used.
	      Uses ImageIO.
	   */
	   {
	     try {
	       //BufferedImage im =  ImageIO.read(getClass().getResource(IMAGE_DIR + fnm) );
	    	 BufferedImage im =  ImageIO.read(new File(IMAGE_DIR+fnm));
	       // An image returned from ImageIO in J2SE <= 1.4.2 is 
	       // _not_ a managed image, but is after copying!

	       int transparency = im.getColorModel().getTransparency();
	       BufferedImage copy =  gc.createCompatibleImage(
	                                im.getWidth(), im.getHeight(),
			                        transparency );
	       // create a graphics context
	       Graphics2D g2d = copy.createGraphics();
	       // g2d.setComposite(AlphaComposite.Src);

	       // reportTransparency(IMAGE_DIR + fnm, transparency);

	       // copy image
	       g2d.drawImage(im,0,0,null);
	       g2d.dispose();
	       return copy;
	     } 
	     catch(IOException e) {
	       System.out.println("Load Image error for " +
	                     IMAGE_DIR + "/" + fnm + ":\n" + e); 
	       return null;
	     }
	  } // end of loadImage() using ImageIO
	  
	  
	  public BufferedImage getImage(String name)
	  /* Get the image associated with <name>. If there are
	     several images stored under that name, return the 
	     first one in the list.
	  */
	  {
	    ArrayList imsList = (ArrayList) imagesMap.get(name);
	    if (imsList == null) {
	      System.out.println("No image(s) stored under " + name);  
	      return null;
	    }

	    // System.out.println("Returning image stored under " + name);  
	    return (BufferedImage) imsList.get(0);
	  }
	

	public static String getImageDir() {
		return IMAGE_DIR;
	}
}
