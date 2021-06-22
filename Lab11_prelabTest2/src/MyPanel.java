import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
	private final int size = 1000;
	public int panelHeight;
	public int panelWidth;
	private int height;// = (int) Math.sqrt(Math.pow(panelWidth,2)-Math.pow(panelWidth/2,2));
	public int recursionLevel;
	private final int stopValue = 1;
//	public Point pointA;
//	public Point pointB;
//	public Point pointC;
	private final Color foregroundColor = Color.WHITE;
	private final Color backgroundColor = Color.DARK_GRAY;
	private Color c0, c1, c2, c3, c4, c5, c6, c7, c8, c9;
	public Graphics2D g2D;
	public Graphics2D g2D2;
	private boolean first = true;
 //Image image;
 
 MyPanel(){
  
	 //image = new ImageIcon("sky.png").getImage();
	 panelHeight = 1000-89;
	 panelWidth = 1000-14;
	 //this.height = (int) Math.sqrt(Math.pow(panelWidth,2)-Math.pow(panelHeight/2,2));
	 //this.height = panelHeight;
	 this.setPreferredSize(new Dimension(panelWidth,panelHeight));
	 recursionLevel = 10;
 	}

// MyPanel(int height, int width, int recursionLevel){
//	  
//	  //image = new ImageIcon("sky.png").getImage();
//	 panelHeight = height;
//	 panelWidth = width;
//	  System.out.println("#"+panelWidth+" H "+ panelHeight+" height "+height+ " re "+recursionLevel);
//
//	 //this.height = (int) Math.sqrt(Math.pow(panelWidth,2)-Math.pow(panelHeight/2,2));
//	 //this.height = panelHeight;
//	 this.setPreferredSize(new Dimension(panelWidth,panelHeight));
//	 this.recursionLevel = recursionLevel;
//	 //repaint();
//	 paint(g2D);
//	 //startAgain();
//	 
//	 }
 
 public void paint(Graphics g) {
  
  g2D = (Graphics2D) g;
  
  //g2D.drawImage(image, 0, 0, null);
  if(first) {
  g2D.setPaint(backgroundColor);
  g2D.fillRect(0, 0, panelWidth, panelHeight);
  g2D.setPaint(foregroundColor);
  first=false;
  }
  System.out.println(panelWidth+" H "+ panelHeight+" height "+height+ " re "+recursionLevel);
  Point pointA = new Point(0, panelHeight);
  Point pointB = new Point(panelWidth/2, 0);
  Point pointC = new Point(panelWidth, panelHeight);
  drawTriangle(pointA, pointB, pointC, recursionLevel);
  //  g2D.setStroke(new BasicStroke(5));
  //  g2D.drawLine(0, 0, 500, 500);
  
  //g2D.setPaint(Color.pink);
  //g2D.drawRect(0, 0, 100, 200);
  //g2D.fillRect(0, 0, 100, 200);
  
  //g2D.setPaint(Color.orange);
  //g2D.drawOval(0, 0, 100, 100);
  //g2D.fillOval(0, 0, 100, 100);
  
  //g2D.setPaint(Color.red);
  //g2D.drawArc(0, 0, 100, 100, 0, 180);
  //g2D.fillArc(0, 0, 100, 100, 0, 180);
  //g2D.setPaint(Color.white);
  //g2D.fillArc(0, 0, 100, 100, 180, 180);
  
  //int[] xPoints = {150,250,350};
  //int[] yPoints = {300,150,300};
  //g2D.setPaint(Color.yellow);
  //g2D.drawPolygon(xPoints, yPoints, 3);
  //g2D.fillPolygon(xPoints, yPoints, 3);
  
  //g2D.setPaint(Color.magenta);
  //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
  //g2D.drawString("U R A WINNER! :D", 50, 50); 
  
  
 }
 
 private void startAgain() {
	 //height = (int) Math.sqrt(Math.pow(panelWidth,2)-Math.pow(panelHeight/2,2));
//	 paint(Graphics g) {
//		  
//		  g2D = (Graphics2D) g;
//		  
//		  g2D.setPaint(backgroundColor);
//		  g2D.fillRect(0, 0, panelWidth, panelHeight);
//		  g2D.setPaint(foregroundColor);
//	 }
	 Point pointA = new Point(0, panelHeight);
	 Point pointB = new Point(panelWidth/2, 0);
	 Point pointC = new Point(panelWidth, panelHeight);
	 drawTriangle(pointA, pointB, pointC, recursionLevel);
 }
 
//added code snippet
 private void drawTriangle(Point pointA, Point pointB, Point pointC, int recursionLevel){
     if(recursionLevel == stopValue){
         Polygon polygon = new Polygon();
         polygon.addPoint(pointA.x, pointA.y);
         polygon.addPoint(pointB.x, pointB.y);
         polygon.addPoint(pointC.x, pointC.y);
         //g2D.setColor(new Color((int)(Math.random() * 0x1000000)));
         //g2D.setColor(new Color(255*(recursionLevel/10),255-255*(recursionLevel/10),255-255*(recursionLevel/10)));
         //g2D.setColor(initializeColors(recursionLevel));
         g2D.draw(polygon);
         return;
     }
     Point pointAB = middlePoint(pointA, pointB);
     Point pointBC = middlePoint(pointB, pointC);
     Point pointAC = middlePoint(pointA, pointC);
     drawTriangle(pointA, pointAB, pointAC, recursionLevel - 1);
     drawTriangle(pointAB, pointB, pointBC, recursionLevel - 1);
     drawTriangle(pointAC, pointBC, pointC, recursionLevel - 1);
     //return null;
 }
 private Point middlePoint(Point pointA, Point pointB){
     return new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2);
 }
 
// private Color initializeColors(int input) {
////	 c0=new Color((int)(Math.random() * 0x1000000));
////	 c1=new Color((int)(Math.random() * 0x1000000));
////	 c2=new Color((int)(Math.random() * 0x1000000));
////	 c3=new Color((int)(Math.random() * 0x1000000));
////	 c4=new Color((int)(Math.random() * 0x1000000));
////	 c5=new Color((int)(Math.random() * 0x1000000));
////	 c6=new Color((int)(Math.random() * 0x1000000));
////	 c7=new Color((int)(Math.random() * 0x1000000));
////	 c8=new Color((int)(Math.random() * 0x1000000));
////	 c9=new Color((int)(Math.random() * 0x1000000));
////	 
// c0 = Color.GRAY;
// c1 = Color.RED;
// c2 = Color.BLUE;
// c3 = Color.GREEN;
// c4 = Color.YELLOW;
// c5 = Color.ORANGE;
// c6 = Color.MAGENTA;
// c7 = Color.CYAN;
// c8 = Color.LIGHT_GRAY;
// c9 = Color.BLACK;
// 
//	 switch (input) {
//	 case 10 : return c0;
//	 case 1 : return c1;
//	 case 2 : return c2;
//	 case 3 : return c3;
//	 case 4 : return c4;
//	 case 5 : return c5;
//	 case 6 : return c6;
//	 case 7 : return c7;
//	 case 8 : return c8;
//	 case 9 : return c9;
//	 }
//	return c0;
// }
// 
// private Color getColor(int recursionLevel) {
//	 if(recursionLevel>10)return new Color((int)(Math.random() * 0x1000000));
//	 Color[] cAr = new Color[recursionLevel];
//	 cAr[0] = Color.GRAY;
//	 cAr[1] = Color.RED;
//	 cAr[2] = Color.BLUE;
//	 cAr[3] = Color.GREEN;
//	 cAr[4] = Color.YELLOW;
//	 cAr[5] = Color.ORANGE;
//	 cAr[6] = Color.MAGENTA;
//	 cAr[7] = Color.CYAN;
//	 cAr[8] = Color.LIGHT_GRAY;
//	 cAr[9] = Color.BLACK;
//	 return cAr[recursionLevel-1]; 
// }
 
}