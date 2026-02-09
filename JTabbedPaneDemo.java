import java.awt.*;
import javax.swing.*;
class JTabbedPaneDemo extends JFrame
{
	JTabbedPane obj=new JTabbedPane();
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JTabbedPaneDemo()
	{
		obj.add(p);
		obj.add(p1);obj.add(p2);
		add(obj);
		setSize(400,500);
		setVisible(true);
	}
	public static void main(String[]args)
	{
		new JTabbedPaneDemo();
	}
}