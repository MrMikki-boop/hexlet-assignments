package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        int originalRows = image.length;
        int originalCols = image[0].length;

        String[][] enlargedImage = new String[originalRows * 2][originalCols * 2];

        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                String pixel = image[i][j];
                enlargedImage[i * 2][j * 2] = pixel;
                enlargedImage[i * 2][j * 2 + 1] = pixel;
                enlargedImage[i * 2 + 1][j * 2] = pixel;
                enlargedImage[i * 2 + 1][j * 2 + 1] = pixel;
            }
        }

        return enlargedImage;
    }
}
// END
