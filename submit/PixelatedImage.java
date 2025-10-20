import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Simulates an colored pixelated image using grids of integers.
 * 
 * @author  Qi Ye
 */
public class PixelatedImage {
   private int size;
   private int grid[][];
   private boolean visited[][];

   /**
    * Initializes image with the color corresponding to the number.
    * @param s color to be used for the initial grid
    */
   public PixelatedImage(int s)
   {

   }

   /**
    * Initializes image with a csv file.
    * @param filename file with text to be used as the initial grid
    */
   public PixelatedImage(String filename)
   {

   }

   /**
    * Loads the grid with random colors.
    */
   public void loadRandomly()
   {

   }

   /**
    * Loads grid from a file.
    * @param inFile file to be loaded from
    * @throws FileNotFoundException if file is not found
    */
   public void loadFromFile(String inFile) throws FileNotFoundException
   {
      File myObj = new File(inFile);
      Scanner scan = new Scanner(myObj);

      String line = scan.nextLine();
      size = Integer.parseInt(line);
      grid = new int[size][size];
      for (int i = 0; scan.hasNext() && i < getHeight(); i++) {
         line = scan.nextLine();
         String[] tokens = line.split(",");
         for (int j = 0; j < Math.min(tokens.length,size); j++) {
            grid[i][j] = Integer.parseInt(tokens[j]);
         }
      }
      scan.close();
   }

   /**
    * Get width of the image.
    * @return width of the image
    */
   public int getWidth()
   {
      return 0;
   }

   /**
    * Get height of the image.
    * @return height of the image
    */
   public int getHeight()
   {
      return 0;
   }

   /**
    * Gets position of a pixel.
    * @param row row of target pixel
    * @param col column of target pixel
    * @return position of target pixel
    */
   public int getPixel(int row, int col)
   {
      return 0;
   }

   /**
    * Sets the color of a pixel.
    * @param row row of target pixel
    * @param col column of target pixel
    * @param color color to set for the pixel
    */
   public void setPixel(int row, int col, int color)
   {

   }

   /**
    * Routine that starts the recursion by finding
    * the color at row,col and passing it to the recursive
    * version as origColor. Creates the visited array to
    * tag cells as they are visited.
    * 
    * @param row row of the grid to visit
    * @param col col of the grid to visit
    * @param fillColor color to use for replacing
    */
   public void floodFill(int row, int col, int fillColor)
   {
      int origColor = grid[row][col];
      visited = new boolean[getHeight()][getWidth()];
      floodFill(row, col, origColor, fillColor);
   }

   /**
    * 
    * @param row
    * @param col
    * @param origColor color to be replaced
    * @param fillColor color to replace with
    */
   protected void floodFill(int row, int col, int origColor, int fillColor)
   {

   }

}
