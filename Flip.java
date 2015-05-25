import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Flip {
	

    public BufferedImage flipVertical(BufferedImage src){
	    AffineTransform tx=AffineTransform.getScaleInstance(-1.0,1.0);  //scaling
	    tx.translate(-src.getWidth(),0);  //translating
	    AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
	   
	    return tr.filter(src, null);  //filtering
    }
    
    public BufferedImage flipHorizontal(BufferedImage src){
	    AffineTransform tx=AffineTransform.getScaleInstance(1.0,-1.0);  //scaling
	    tx.translate(0,-src.getHeight());  //translating
	    AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
	   
	    return tr.filter(src, null);  //filtering
    }
}