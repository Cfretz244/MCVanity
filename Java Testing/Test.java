import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Test {

	private static final int newWidth = 300;

	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("pic.jpg"));
		img = resizeImage(img);
		ImageIO.write(img, "jpg", new File("picresized.jpg"));
	}

	public static BufferedImage resizeImage(BufferedImage img) {
		int height = img.getHeight(), width = img.getWidth(), type = img.getType();
		double ratio = height / (double)width;
		int newHeight = (int)(newWidth * ratio);
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(img, 0, 0, newWidth, newHeight, null);
		g.dispose();
	 
		return resizedImage;
	}

}