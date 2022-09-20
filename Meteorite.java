import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

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

	int numOfM =10;
	int pointX[] = new int[numOfM];
	int pointY[] = new int[numOfM];
	Timer time[] =new Timer [numOfM];
	ImageIcon image[] = new ImageIcon[numOfM];  
	JLabel labelM[] = new  JLabel[numOfM]; 
	int x,y;

	public MyPanel() {
		setBackground(Color.BLACK);
		setSize(900,800);
		for (int j = 0; j < numOfM; j++) {
		
			 pointX[j] = (int)(Math.random()*850);
			 pointY[j] =(int)(Math.random()*750);
			 int type =(int)(Math.random()*11);
			 image[j] =new ImageIcon(getClass().getResource(""+j+"png"));
			 labelM[j] = new JLabel(image[j]);
			 labelM[j].setBounds(pointX[j], pointY[j], 100, 100);
			 add(labelM[j]);
		
	}

	  
			
		
	}
	
}












