import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class project extends JFrame
{
JPanel cntr;
JProgressBar jb;
JLabel lblpic,lbl1,lbl2,lbl3,ver; 
int i = 0, num = 0;
project()
{
Image img1=new ImageIcon("fotos/pro.jpg").getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	cntr=new JPanel();
Image img2=new ImageIcon("fotos/front.jpg").getImage().getScaledInstance(800,600,Image.SCALE_SMOOTH);
lblpic = new JLabel(new ImageIcon(img2));
lbl1=new JLabel("BHPC  ");
lbl2=new JLabel("AUTOMATION");
lbl3=new JLabel("SYSTEM ");
ver=new JLabel("Version  1.0");
jb = new JProgressBar(0,2000);
Dimension screensize;
screensize=Toolkit.getDefaultToolkit().getScreenSize();
setLayout(null);
lblpic.setBounds(0,0,800,600);
jb.setBounds(50,500,700,30);
cntr.setBounds(150,150,500,300);
lbl1.setBounds(350,150,500,300);
lbl1.setFont(new Font("Britannic",Font.BOLD,50));
lbl2.setBounds(150,570,500,300);
lbl2.setFont(new Font("Britannic",Font.BOLD,50));
lbl3.setBounds(150,890,500,300);
lbl3.setFont(new Font("Britannic",Font.BOLD,50));
ver.setBounds(150,920,500,300);
ver.setFont(new Font("Britannic",Font.BOLD,20));
cntr.setBackground(new Color(194, 24, 91,75));
jb.setBackground(new Color(230, 74, 25,10));              
jb.setForeground(new Color(230, 74, 25));
lbl1.setForeground(new Color(192,0,82));
lbl2.setForeground(new Color(192,0,82));
lbl3.setForeground(new Color(192,0,82));
ver.setForeground(new Color(192,0,82));
jb.setValue(0);
jb.setStringPainted(true);
add(jb); 
add(lblpic);
lblpic.add(cntr);
cntr.add(lbl1);
cntr.add(lbl2);
cntr.add(lbl3);
cntr.add(ver);
setBounds((screensize.width-800)/2,(screensize.height-600)/2,800,600);
setUndecorated(true);
setSize(800,600);
}
public void iterate()
{
while(i<=2000)
      {
jb.setValue(i);
i=i+50;
try{
      		 Thread.sleep(150);
if(jb.getValue()>=2000)
{
loginform obj = new loginform();
obj.setVisible(true);
dispose();
    		 }
}
catch(Exception e){}
    }
}
public static void main(String[] args)
{
project m = new project();
m.setVisible(true);
m.iterate();
}
}
