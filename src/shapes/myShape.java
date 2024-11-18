package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class myShape extends Shape {
    private final double size;

    public myShape(double size) {
        this.size = size;
    }

    @Override
    public double getPerimiter() {
        // Approximation of a heart's perimeter
        return 5.1 * size;
    }

    @Override
    public double getArea() {
        // Approximation of a heart's area
        return 2.25 * size * size;
    }

    @Override
    public String getAuthor() {
        return "Saipriya";  
    } 

    @Override
    public void renderAsJpeg(File fileToJpeg) throws Exception {
        int width = 256;
        int height = 256;

        // Create a BufferedImage object
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the Graphics2D object
        Graphics2D g2d = image.createGraphics();

        // Set the background color (white)
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Set the heart color (pink)
        g2d.setColor(Color.PINK);

        // Create a more realistic heart shape
        GeneralPath heart = new GeneralPath();
        double scale = size / 100.0;
        double centerX = width / 2;
        double centerY = height / 2 + 20 * scale; 

        // Starting point at the bottom of the heart
        heart.moveTo(centerX, centerY + 40 * scale);

        // Left half of the heart (bottom to top-left curve)
        heart.curveTo(centerX - 80 * scale, centerY + 20 * scale, // control point 1
                      centerX - 70 * scale, centerY - 40 * scale, // control point 2
                      centerX, centerY - 0 * scale); // top-center point

        // Right half of the heart (top-right to bottom curve)
        heart.curveTo(centerX + 70 * scale, centerY - 40 * scale, // control point 3
                      centerX + 70 * scale, centerY + 20 * scale, // control point 4
                      centerX, centerY + 40 * scale); // bottom-center point

        // Fill the heart shape
        g2d.fill(heart);

        // Add the author's name in black
        addAuthorText(g2d, width, height);

        // Dispose the graphics object
        g2d.dispose();

        // Save the image as a JPEG file
        ImageIO.write(image, "jpg", fileToJpeg);
        System.out.println("Heart image saved as heart.jpg");
    }
}
