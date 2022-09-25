import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	ImageIcon mc;
    JLabel label[] = new JLabel[numOfM];
	//MyThred t;

	public MyPanel() {
	
		M1 =new Image[numOfM];
		for (int j = 0; j < numOfM; j++) {
			 pointX[j] = (int)(Math.random()*700);
			 pointY[j] =(int)(Math.random()*600);
			 int type =(int)(Math.random()*11);
			//  M1[j] =Toolkit.getDefaultToolkit().createImage(
			// 			System.getProperty("user.dir")+File.separator+(type+".png")
			// 			);
			 mc = new ImageIcon(getClass().getResource(type+".png"));
			 label[j] = new JLabel(mc);
			 label[j].setBounds(pointX[j],pointY[j],100,100);
			 add(label[j]);
			 System.out.println(pointX[j]+"  "+pointY[j]);
		}
			
		setBackground(Color.BLACK);
		setSize(600,800);
	}
	// 	@Override
	// public void paint(Graphics g) {
		
	// 	super.paint(g);
	// 	for (int i = 0; i < numOfM; i++) {
	// 	   g.drawImage(M1[i],pointX[i],pointY[i],50,50,this);
	// 	//    t = new MyThred(M1[i], i, this,g); 
	// 		t.start();	
	// 	}
		
	// }
}
// class MyThred extends Thread
// {
// 	Image m;
// 	int i;
// 	MyPanel panel;
// 	Graphics g;
// 	MyThred(Image m, int i,MyPanel panel,Graphics g)
// 	{
// 		this.m = m;
// 		this.i  = i;
// 		this.panel = panel;
// 		this.g = g;
// 	}
// 	@Override
// 	public void run() {
// 		panel.pointX[i] +=1;
// 		panel.pointY[i] +=1;
// 		// g.drawImage(m, panel.pointX[i], panel.pointY[i], panel);
// 		panel.repaint();
// 		try {
// 			Thread.sleep(1);
// 		} catch (InterruptedException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 	}
// }













