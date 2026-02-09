import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Image.*;
class aboutUs extends JPanel implements Runnable
{
	JPanel j;
 JLabel lbla;
JLabel lbl=new JLabel();
	Image img[];
	public void run()
	{
		int i=0;
		while(true)
		{
			lbl.setIcon(new ImageIcon(img[i]));
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e){}
			i++;
			if(i==5)
				i=0;
		}
	}	
   aboutUs()
   {    setLayout(null);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
		img=new Image[]{new ImageIcon("fotos/pp1.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH),new ImageIcon("fotos/pp2.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH),new ImageIcon("fotos/1.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH),new ImageIcon("fotos/2.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH),new ImageIcon("fotos/6.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH),new ImageIcon("fotos/7.jpg").getImage().getScaledInstance(screenSize.width-350,500,Image.SCALE_SMOOTH)};
   Thread th=new Thread(this);
		th.start();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
       lbla=new JLabel("<html> Bihar State Hydel Power Corporation Limited(BHPC) is a company of government of Bihar registered under Companies Act 1956.The Company is responsible for exploring all possibilities of Hydel potential and its development in Bihar state.The Bhpc endeavours to associate with public and private sectors companies for accelerated development of hydro power potential in the state.<br> The bihar State Hydro Electric Power Corporation(BHPC) is an Undertaking of Government of Bihar,company no.1627 of 1981-82 which has been working since 1982.</html>");
	lbla.setFont(new Font( "Tahoma",Font.PLAIN,18));
	  j=new JPanel();
	  j.setBounds(0,0,screenSize.width-250,screenSize.height-150);
	   j.setBorder(loweredbevel);
	   lbla.setBounds(50,10,screenSize.width-350,150);
	   lbl.setBounds(50,170,screenSize.width-350,400);
	  j.add(lbla); j.add(lbl);
	  j.setLayout(null);
	   add(j);
   }
   public static void main(String args[])
{
 new aboutUs(); 
}
}