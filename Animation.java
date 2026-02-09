import java.awt.*;
import javax.swing.*;
class Animation extends JFrame implements Runnable
{
	String str[]={"fotos/pp1.jpg","fotos/pp2.jpg"};
	public void run()
	{
		int i=0;
		while(true)
		{
			lbl.setIcon(new ImageIcon(str[i]));
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e){}
			i++;
			if(i==2)
				i=0;
		}
	}
	JLabel lbl=new JLabel();
	Animation()
	{
		Thread th=new Thread(this);
		th.start();
		add(lbl);
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[]args)
	{
		new Animation();
	}
}