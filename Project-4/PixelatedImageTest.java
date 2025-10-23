import org.junit.*;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

/**
 * Unit tests for PixelatedImage - Project 4.
 * 
 * @author  Qi Ye
 */

public class PixelatedImageTest {
   private PixelatedImage runner = null;
   /**
    * setup() method, runs before each of your test methods.
    * Use this method to recreate the objects needed for
    * testing your class.
    */
   @Before
   public void setup() {
      runner = new PixelatedImage(5);
   }

   /**
    * tests the initialization of pixelated image
    */
   @Test
   public void testDefaults() {
      assertEquals(5, runner.getWidth());
      assertEquals(5, runner.getHeight());
      for (int r = 0; r < runner.getHeight(); r++)
         for (int c = 0; c < runner.getWidth(); c++)
            assertEquals(0, runner.getPixel(r,c));
   }
}
