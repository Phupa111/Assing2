import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
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
	MyThred t[] = new MyThred[numOfM];

	public MyPanel() {
	
		M1 =new Image[numOfM];
		for (int j = 0; j < numOfM; j++) {
			 pointX[j] = (int)(Math.random()*700);
			 pointY[j] =(int)(Math.random()*650);
			 int type =(int)(Math.random()*11);
			 M1[j] =Toolkit.getDefaultToolkit().createImage(
						System.getProperty("user.dir")+File.separator+(type+".png")
						);
			 t[j] = new MyThred(M1[j], j, this); 
			 t[j].start();
		}
			
		setBackground(Color.BLACK);
		setSize(600,800);
	}
		@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		for (int i = 0; i < numOfM; i++) {
		   g.drawImage(M1[i],pointX[i],pointY[i],50,50,this);	
		}
		
	}
}
class MyThred extends Thread
{
	Image m;
	int i;
	MyPanel panel;
	MyThred(Image m, int i,MyPanel panel)
	{
		this.m = m;
		this.i  = i;
		this.panel = panel;
	}
	@Override
	public void run() {
		panel.pointX[i] +=1;
		panel.pointY[i] +=1;
		panel.repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}













