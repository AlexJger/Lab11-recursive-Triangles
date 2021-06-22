import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SierpinskiTriangle {
	static JFrame frame;
	
	public static void main(String[] args) {
		makeFrame();
		makeTriangles();
	}

	private static void makeFrame() {
		frame = new JFrame("Sierpisnki Triangle");
		JFrame.setDefaultLookAndFeelDecorated(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(434, 400)); //Symmetrical
		
//		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//		frame.setSize(screensize.width, screensize.height);		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setUndecorated(true);
	}

	private static void makeTriangles() {
		frame.add(new SierpinskiTrianglePanel());
		frame.setVisible(true);
	}
}
