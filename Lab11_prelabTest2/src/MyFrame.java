import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class MyFrame extends JFrame{
 
 MyPanel panel;
 MyPanel panel2;
 private JTextField input;
 private JButton button;
 private JButton button2;
 private JButton button3;
 //Clicklistener click= new Clicklistener();
 //private int recursionLevel=10;
 
 MyFrame(){
  
  panel = new MyPanel();
  //panel = new MyPanel(1000, 1000, recursionLevel);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  
  //Button Panel
  JPanel buttonPanel = new JPanel(new GridLayout(2,2));
  //initializing
  input = new JTextField(""+panel.recursionLevel);
  button = new JButton("Enter");
  button2 = new JButton("<<<        Back");
  button3 = new JButton("Foreward        >>>");
  //adding
  buttonPanel.add(input);
  buttonPanel.add(button);
  //button.addActionListener(click);
  buttonPanel.add(button2);
  //button2.addActionListener(click);
  buttonPanel.add(button3);
  //button3.addActionListener(click);
  this.add(buttonPanel, BorderLayout.SOUTH);
  this.add(panel);
  this.pack();
  this.setLocationRelativeTo(null);
  this.setVisible(true);
  addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
		panel.panelHeight=getHeight()-89;
		panel.panelWidth=getWidth()-14;
		panel.recursionLevel=Integer.parseInt(input.getText().toString());
		}	}	);
  button.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		 	 panel.recursionLevel=Integer.parseInt(input.getText().toString());
	  }	});
  button2.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		  panel.recursionLevel--;
		  input.setText(""+panel.recursionLevel);
	  }	});
  button3.addActionListener(new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		  panel.recursionLevel++;
		  input.setText(""+panel.recursionLevel);
	  }	});
  this.pack();
//  addComponentListener(new ComponentAdapter() {
//	  public void actionPerformed(ActionEvent e)
//		 {
//		  if (e.getSource() == button)
//			 {
//				 panel.recursionLevel=Integer.parseInt(input.getText().toString());
//				 
//				 //panel = new MyPanel(panel.panelWidth, panel.panelHeight, panel.recursionLevel);
//			 }
//			if (e.getSource() == button2)
//			 {
//				 if(panel.recursionLevel>0)panel.recursionLevel--;
//			 }
//			if (e.getSource() == button3)
//			 {
//				panel.recursionLevel++;
//			 }
//			input.setText(""+panel.recursionLevel);
//		 }
//  });
  
  
 } 
 
// private class Clicklistener implements ActionListener
// {
//	public void actionPerformed(ActionEvent e)
//	 {
//		if (e.getSource() == button)
//		 {
//			 panel.recursionLevel=Integer.parseInt(input.getText().toString());
//			 System.out.println("rec "+panel.recursionLevel);
//			 
//			 //panel = new MyPanel(panel.panelWidth, panel.panelHeight, panel.recursionLevel);
//		 }
//		if (e.getSource() == button2)
//		 {
//			 if(panel.recursionLevel>0)panel.recursionLevel--;
//		 }
//		if (e.getSource() == button3)
//		 {
//			panel.recursionLevel++;
//		 }
//		input.setText(""+panel.recursionLevel);
//	 }
//	
//	
//	public void componentResized(ComponentEvent e) {
//		System.out.println("New width: " + getWidth() + " New height: " + getHeight());
//		}
// }
 
 
}