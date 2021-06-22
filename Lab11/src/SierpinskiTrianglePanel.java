import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.RenderingHints;

public class SierpinskiTrianglePanel extends Panel {
	private static int maxRecursion = 9;
	private static int operationCouner=0;
	private static Color[] colors = {Color.BLACK, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.RED, Color.GREEN,  Color.ORANGE, Color.GRAY, Color.LIGHT_GRAY};// new Color(0x0E12F2), new Color(0xF2F20E), new Color(0x800EF2), new Color(0x19f904)};
	
	private void drawTriangle(Graphics g, Point2D pointA, Point2D pointB, Point2D pointC, int level) {
		Graphics2D g2D= (Graphics2D) g.create();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//drawing with GeneralPath instead of Polygon, bc of double Points
		GeneralPath path = new GeneralPath();
		path.moveTo(pointA.getX(), pointA.getY());
		path.lineTo(pointB.getX(), pointB.getY());
		path.lineTo(pointC.getX(), pointC.getY());
        g2D.setColor(Color.BLACK);
        //g2D.draw(path);
        g2D.setColor(colors[level-1%colors.length]);
        g2D.fill(path);
	}
	
	private void drawRecursively(Graphics g, Point2D pointA, Point2D pointB, Point2D pointC, int level) {
		drawTriangle(g, pointA, pointB, pointC, level);
		if(level==1) return;
		Point2D pointAB = middlePoint(pointA, pointB);
	    Point2D pointBC = middlePoint(pointB, pointC);
	    Point2D pointAC = middlePoint(pointA, pointC);
	    drawRecursively(g, pointA, pointAB, pointAC, level - 1);
	    drawRecursively(g, pointAB, pointB, pointBC, level - 1);
	    drawRecursively(g, pointAC, pointBC, pointC, level - 1);
	}
	
	private Point2D middlePoint(Point2D pointA, Point2D pointB){
		return new Point2D.Double((pointA.getX() + pointB.getX()) / 2, (pointA.getY() + pointB.getY()) / 2);
	 }
	
	public void paint(Graphics g) {
		//Background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Fomula for equilateral triangle a, h
		int width = (int) ((this.getHeight()*2)/Math.sqrt(3));
		int height = (int) ((Math.sqrt(3)/2)*this.getWidth());
		
		if(this.getHeight()<this.getWidth()&&width<this.getWidth()) height = this.getHeight();
		else width = this.getWidth();
		
		//first Triangle
		Point2D pointA = new Point2D.Double(0+(this.getWidth()-width)/2, height);
		Point2D pointB = new Point2D.Double(this.getWidth()/2, 0);
		Point2D pointC = new Point2D.Double(this.getWidth()-(this.getWidth()-width)/2, height);
		drawRecursively(g, pointA, pointB, pointC, maxRecursion);
		
//		System.out.println("width "+this.getWidth()+" height "+this.getHeight()+"w "+width+" h "+height);
	}
}
