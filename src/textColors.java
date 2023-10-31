/**
 * From this website: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 */
public interface textColors {
   /**
    * Resets the color of the font of the println to the standard.
    */
   public static final String RESET = "\033[0m";

   // Regular Colors
   //public static final String BLACK = "\033[0;30m";   // BLACK
   /**
    * Changes the font to red.
    */
   public static final String RED = "\033[0;31m";
   /**
    * Changes the font to green.
    */
   public static final String GREEN = "\033[0;32m";
   //public static final String YELLOW = "\033[0;33m";  // YELLOW

   // Bold
   //public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
   /**
    * Changes the font to red and bold.
    */
   public static final String RED_BOLD = "\033[1;31m";
   /**
    * Changes the font to green and bold.
    */
   public static final String GREEN_BOLD = "\033[1;32m";
   //public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW

   // Underline
   /**
    * Changes the font to red and underlined.
    */
   public static final String RED_UNDERLINED = "\033[4;31m";
   /**
    * Changes the font to green and underlined.
    */
   public static final String GREEN_UNDERLINED = "\033[4;32m";
   //public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW

   // High Intensity
   //public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
   /**
    * Changes the font to bright red.
    */
   public static final String RED_BRIGHT = "\033[0;91m";
   /**
    * Changes the font to bright green.
    */
   public static final String GREEN_BRIGHT = "\033[0;92m";
   //public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW

   // Bold High Intensity
   /**
    * Changes the font to bright red and bold.
    */
   public static final String RED_BOLD_BRIGHT = "\033[1;91m";
   /**
    * Changes the font to bright green and bold
    */
   public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
   //public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
}
