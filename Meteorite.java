import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Meteorite extends JFrame{
	
  MyPanel panel =new MyPanel();
	public Meteorite()
	{
		setSize(900,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		add(panel);
		
		
	}
	
   public static void main(String[] args) {
	new Meteorite().setVisible(true);
}
}
class MyPanel extends JPanel
{
	Image M1[];
	int numOfM =10;
	int pointX[] = new int[numOfM];
	int pointY[] = new int[numOfM];
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		for (int i = 0; i < numOfM; i++) {
		   g.drawImage(M1[i],pointX[i],pointY[i],50,50,this);	
		}
		
	}
	public MyPanel() {
	
		M1 =new Image[numOfM];
		for (int j = 0; j < numOfM; j++) {
			 pointX[j] = (int)(Math.random()*700);
			 pointY[j] =(int)(Math.random()*650);
			 int type =(int)(Math.random()*11);
			 M1[j] =Toolkit.getDefaultToolkit().createImage(
						System.getProperty("user.dir")+File.separator+(type+".png")
						);
			 
		}
			
		setBackground(Color.BLACK);
		setSize(600,800);
	}
	
}
class MyThred extends Thread
{
	MyThred()
	{}
}













