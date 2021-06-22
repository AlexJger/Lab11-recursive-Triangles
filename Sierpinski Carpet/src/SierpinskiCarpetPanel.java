import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.RenderingHints;

public class SierpinskiCarpetPanel extends Panel {
	private static int maxRecursion = 9;
	private static double squareLenght = 200;
	private static Color[] colors = {Color.BLACK, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.RED, Color.GREEN,  Color.ORANGE, Color.GRAY, Color.LIGHT_GRAY};// new Color(0x0E12F2), new Color(0xF2F20E), new Color(0x800EF2), new Color(0x19f904)};
	
	private void drawSquare(Graphics g, Point2D pointA, int level, double lenght) {
		Graphics2D g2D= (Graphics2D) g.create();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//drawing with GeneralPath instead of Polygon, bc of double Points
		GeneralPath path = new GeneralPath();
		
		Point2D pointB=getB(pointA, lenght);
		Point2D pointC=getC(pointA, lenght);
		Point2D pointD=getD(pointA, lenght);
		
		path.moveTo(pointA.getX(), pointA.getY());
		path.lineTo(pointB.getX(), pointB.getY());
		path.lineTo(pointC.getX(), pointC.getY());
		path.lineTo(pointD.getX(), pointD.getY());
		path.lineTo(pointA.getX(), pointA.getY());
		
		g2D.setColor(Color.BLACK);
        g2D.draw(path);
		g2D.setColor(colors[level-1%colors.length]);
		g2D.fill(path);
	}
	
	private void drawRecursively(Graphics g, Point2D pointA, int level, double lenght) {

		drawSquare(g, pointA, level, lenght);
		if(level==1||lenght<1) { return;}
		
		Point2D pointA1 = new Point2D.Double(pointA.getX()-(2.0/3.0)*lenght, pointA.getY()-(2.0/3.0)*lenght);	//top-left
		Point2D pointA2 = new Point2D.Double(pointA.getX()+(1.0/3.0)*lenght, pointA.getY()-(2.0/3.0)*lenght);	//top-mid
		Point2D pointA3 = new Point2D.Double(pointA.getX()+(4.0/3.0)*lenght, pointA.getY()-(2.0/3.0)*lenght);	//top-right
		Point2D pointA4 = new Point2D.Double(pointA.getX()+(4.0/3.0)*lenght, pointA.getY()+(1.0/3.0)*lenght);	//mid-right
		Point2D pointA5 = new Point2D.Double(pointA.getX()+((4.0/3.0)*lenght), pointA.getY()+(4.0/3.0)*lenght);	//low-right
		Point2D pointA6 = new Point2D.Double(pointA.getX()+(1.0/3.0)*lenght, pointA.getY()+(4.0/3.0)*lenght);	//low-mid
		Point2D pointA7 = new Point2D.Double(pointA.getX()-(2.0/3.0)*lenght, pointA.getY()+(4.0/3.0)*lenght);	//low-left
		Point2D pointA8 = new Point2D.Double(pointA.getX()-(2.0/3.0)*lenght, pointA.getY()+(1.0/3.0)*lenght);	//mid-left
		
		drawRecursively(g, pointA1, level-1, lenght/3);
		drawRecursively(g, pointA2, level-1, lenght/3);
		drawRecursively(g, pointA3, level-1, lenght/3);
		drawRecursively(g, pointA4, level-1, lenght/3);
		drawRecursively(g, pointA5, level-1, lenght/3);
		drawRecursively(g, pointA6, level-1, lenght/3);
		drawRecursively(g, pointA7, level-1, lenght/3);
		drawRecursively(g, pointA8, level-1, lenght/3);
	}

	private Point2D getB(Point2D pointA, double lenght) {
		return new Point2D.Double(pointA.getX()+lenght, pointA.getY());
	}
	private Point2D getC(Point2D pointA, double lenght) {
		return new Point2D.Double(pointA.getX()+lenght, pointA.getY()+lenght);
	}
	private Point2D getD(Point2D pointA, double lenght) {
		return new Point2D.Double(pointA.getX(), pointA.getY()+lenght);
	}
	
	public void paint(Graphics g) {
		//Background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		
		//first Point
		Point2D pointA = new Point2D.Double(this.getWidth()/2-squareLenght/2 , this.getHeight()/2-squareLenght/2 );
		if(this.getHeight()<this.getWidth()) squareLenght=this.getHeight()/3;
		else squareLenght=this.getWidth()/3;
		drawRecursively(g, pointA, maxRecursion, squareLenght);
	}
}
