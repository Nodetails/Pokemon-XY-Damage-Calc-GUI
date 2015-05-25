import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageFlip extends JPanel {
	
	private String filename;
	
	public ImageFlip (String filename) {
		this.filename = filename;
	}

  public void paint(Graphics g) {
    Image myImage = new ImageIcon(filename).getImage();
    int x = 36;
    int y = 221;
     int width = 137;
     int height = 128;
    
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = (Graphics2D) g;

    Graphics gb = bufferedImage.getGraphics();
    gb.drawImage(myImage,x, y, null);
    gb.dispose();

    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
    tx.translate(-width, 0);
    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    bufferedImage = op.filter(bufferedImage, null);

    g2d.drawImage(myImage, x, y, null);
    g2d.drawImage(bufferedImage, null, x, y);
  }
}