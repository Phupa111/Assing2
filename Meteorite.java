import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;

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
	int numOfM =15;
	int pointX[] = new int[numOfM];
	int pointY[] = new int[numOfM];
	ImageIcon mc;
    JLabel label[] = new JLabel[numOfM];
    MyThread thread[] = new MyThread[numOfM];
    Exopled exopled[] = new Exopled[numOfM];
	public MyPanel() {
	    setBackground(Color.BLACK);
		setSize(900,800);
		setLayout(null);
		M1 =new Image[numOfM];
		for (int j = 0; j < numOfM; j++) {
			 pointX[j] = (int)(Math.random()*785);
			 pointY[j] =(int)(Math.random()*660);
			 int type =(int)(Math.random()*10)+1;
			 final Integer J = new Integer(j); 
			 mc = new ImageIcon(getClass().getClassLoader().getResource(""+type+".png"));
			 label[j] = new JLabel(mc);
			 label[j].setBounds(pointX[j],pointY[j], 100, 100);
			 thread[j]= new MyThread(label[j],j, this);
			 thread[j].start();
			 label[j].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(e.getClickCount() == 2&& !e.isConsumed())
				{
					e.consume();
					
//					 mc = new ImageIcon(getClass().getClassLoader().getResource("bomb.gif"));
//					 label[J].setIcon(mc);
//					 label[J].setBounds(pointX[J], pointY[J], 150, 150);
				    thread[J].isExpoled = !thread[J].isExpoled;
					exopled[J] = new Exopled(mc, label[J]);
					exopled[J].start();
					 
				}
			}
			});
			 add(label[j]);
			 System.out.println(pointX[j]+"  "+pointY[j]);
			 
		}
		//label[0].setBounds(0,660, 100,100);
			
		
	}
	
}
class MyThread extends Thread
{
	JLabel label;
	int i;
	MyPanel panel;
	int ranX;
	int ranY;
	int speed;
	public boolean isExpoled = true;
	public MyThread(JLabel label,int i,	MyPanel panel) 
	{
		this.i = i;
		this.label= label;
		this.panel = panel;
		speed = (int)(Math.random()*50)+1;
		ranX = (new Random().nextInt(3)-1);
		ranY = (new Random().nextInt(3)-1);
	    whileRandow();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		super.run();
		while(true)
		{
	
		int x= panel.pointX[i]+=ranX;
		int y= panel.pointY[i]+=ranY;
		
	    if(isExpoled)
	    {
		//farm
		if(label.getX()+label.getWidth() > panel.getWidth())
		{
			
			ranX = (new Random().nextInt(2)-1);
			ranY = (new Random().nextInt(3)-1);
			whileRandow();
			x= panel.pointX[i]+=ranX;
			y= panel.pointY[i]+=ranY;
			speed = (int)(Math.random()*50)+1;
	   
		}
		else if(label.getY()+label.getHeight() >panel.getHeight())
		{
			
			
			ranX = (new Random().nextInt(3)-1);
			ranY = (new Random().nextInt(2)-1);
			whileRandow();
			x= panel.pointX[i]+=ranX;
			y= panel.pointY[i]+=ranY;
			speed = (int)(Math.random()*50)+1;
		}
		else if(label.getX()<=0)
		{
			
			ranX = (new Random().nextInt(2));
			ranY = (new Random().nextInt(3)-1);
			whileRandow();
			x= panel.pointX[i]+=ranX;
			y= panel.pointY[i]+=ranY;
			speed = (int)(Math.random()*50)+1;
		  
		}
		else if(label.getY()<=0)
		{
			
			ranX = (new Random().nextInt(3)-1);
			ranY = (new Random().nextInt(2));
			whileRandow();
			x= panel.pointX[i]+=ranX;
			y= panel.pointY[i]+=ranY;
			speed = (int)(Math.random()*50)+1;
		}	
		label.setLocation(x,y);
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		}
	}
    void whileRandow()
    {
    	while(ranX == 0 && ranY == 0) {
			ranX = (new Random().nextInt(3)-1);
			ranY = (new Random().nextInt(3)-1);
		}
    }
}
 class Exopled extends Thread
 {
	 ImageIcon mc;
	 JLabel label;
	 public Exopled(ImageIcon mc,JLabel label) {
		 this.mc = mc;
		 this.label = label;
		
	}
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		 mc = new ImageIcon(getClass().getClassLoader().getResource("bomb.gif"));
		 label.setIcon(mc);
		 label.setBounds(label.getX(),label.getY(), 150, 150);
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 label.setVisible(false);
	}
 }












