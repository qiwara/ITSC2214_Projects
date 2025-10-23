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
    * Creates a size x size integer array and initializes it to 0.
    * @param s size of the initial grid
    */
   public PixelatedImage(int s)
   {
      size = s;
      grid = new int[size][size];
      for (int i=0;i<size;i++)
      {
         for (int j=0;j<size;j++)
         {
            grid[i][j] = 0;
         }
      }
   }

   /**
    * Initializes image with a csv file.
    * @param filename file with text to be used as the initial grid
    */
   public PixelatedImage(String filename)
   {
      try {
         loadFromFile(filename);
      } catch (FileNotFoundException e) {
         System.out.println("File not found.");
      }
   }

   /**
    * Loads the grid with random colors.
    */
   public void loadRandomly()
   {
      Random rand = new Random();
      if (grid == null) 
      {
        grid = new int[size][size];
      }

      for (int i = 0; i < getHeight(); i++) 
      {
        for (int j = 0; j < getWidth(); j++) 
        {
            grid[i][j] = rand.nextInt(16);
        }
    }
   }

   /**
    * Loads a csv file into the internal grid representation.
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
      return grid[0].length;
   }

   /**
    * Get height of the image.
    * @return height of the image
    */
   public int getHeight()
   {
      return grid.length;
   }

   /**
    * Returns the color value stored at row and col.
    * @param row row of target pixel
    * @param col column of target pixel
    * @return color of the pixel at position (row,col)
    */
   public int getPixel(int row, int col)
   {
      return grid[row][col];
   }

   /**
    * Stores the color value at position (row, col). 
    * @param row row of target pixel
    * @param col column of target pixel
    * @param color color of pixel, expected between 0 and 15
    */
   public void setPixel(int row, int col, int color)
   {
      if ((color >= 0) && (color <= 15))
         grid[row][col] = color;
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
    * Recursion of checking (row,col) and if the color 
    * stored there is origColor, then replace it and 
    * recursively call it with the four adjacent neighbors.
    
    * @param row row of the grid to visit
    * @param col col of the grid to visit
    * @param origColor color to be replaced
    * @param fillColor color to use for replacing
    */
   protected void floodFill(int row, int col, int origColor, int fillColor)
   {
      // Base case
      if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth())
        return;

      // Already visited
      if (visited[row][col])
         return;

      // Fill if the current color = original
      if (grid[row][col] != origColor)
        return;

      // Fill the pixel and mark as visited
      grid[row][col] = fillColor;
      visited[row][col] = true;

      // Recursive case: call floodFill, down up right left
      floodFill(row + 1, col, origColor, fillColor);
      floodFill(row - 1, col, origColor, fillColor);
      floodFill(row, col + 1, origColor, fillColor);
      floodFill(row, col - 1, origColor, fillColor);
   }

}
