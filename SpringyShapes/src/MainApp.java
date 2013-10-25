import processing.core.*;
import pbox2d.*;
import org.jbox2d.common.*;
 
public class MainApp extends PApplet {
 
	private static final long serialVersionUID = 7561908389779951086L;
	

	PBox2D box2d;
	SpringyTriangle triangle;
	
    @Override
	public void setup() {
        size(640, 480);
        noStroke();
        smooth(6);
        frameRate(40);
        
        box2d = new PBox2D(this);
        box2d.createWorld();
        box2d.setGravity(0, 20);
        
        // Triangle (ALIZARIN)  
        triangle = new SpringyTriangle(
          this,
          box2d,
          new PVector(width/4, 200),
          new PVector(width/2, 60),
          new PVector(3*width/4, 200),
          0xFFE74C3C,
          new Vec2(-150, -150)
        );

    }
 
    @Override
	public void draw() {
    	
    	background(0xffffff);
	    pushMatrix();
//		    translate(width/2, 0);
		    triangle.update(); 
		    if (frameCount%90 == 0) {
		    	triangle.impulse();
		    } 
	    popMatrix();
	  
	  // We must always step through time!
	  box2d.step();
    }
    
    public static void main(String args[]) {
		PApplet.main(new String[] { /*"--present",*/ "MainApp" }); /*"--present",*/
	}
}