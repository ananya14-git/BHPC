import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
class leaveOption extends JPanel implements ActionListener
{ 	
JLabel lblTitle;
JButton btnMins,btnMup,btnTins,btnTup;
Dimension screenSize;
leaveOption()
{ 
setLayout(null);
setBackground(new Color(255,204,204));
screenSize=Toolkit.getDefaultToolkit().getScreenSize();
setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
 Image ins=new ImageIcon("fotos/tuser.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image up=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image Tins=new ImageIcon("fotos/tuser.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image Tup=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  lblTitle=new JLabel("LEAVE");
  btnMins=new JButton("Leave Master ",new ImageIcon(ins));
  btnMup=new JButton("Edit Leave Master",new ImageIcon(up));
  btnTins=new JButton("Leave Transaction ",new ImageIcon(Tins));
  btnTup=new JButton("Edit Leave Transaction",new ImageIcon(Tup));
  lblTitle.setBounds(0,0,screenSize.width-250,50);
  lblTitle.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblTitle.setOpaque(true);
  lblTitle.setBackground(new Color(255,153,153));
  lblTitle.setForeground(new Color(255,255,255)); 
  btnMins.setBounds(150,250,250,50);
  btnMup.setBounds(550,250,270,50);
  btnTins.setBounds(150,350,250,50);
  btnTup.setBounds(550,350,270,50);
  btnMins.addActionListener(this);
  btnMup.addActionListener(this);
  btnTins.addActionListener(this);
  btnTup.addActionListener(this);
  btnMins.setFont(new Font("Britannic",Font.BOLD,15));
  btnMup.setFont(new Font("Britannic",Font.BOLD,15));
  btnMins.setBackground(new Color(204,255,51));
  btnMup.setBackground(new Color(204,255,51));
  btnMins.setForeground(new Color(255,153,51));
  btnMup.setForeground(new Color(255,153,51));
  btnTins.setFont(new Font("Britannic",Font.BOLD,15));
  btnTup.setFont(new Font("Britannic",Font.BOLD,15));
  btnTins.setBackground(new Color(204,255,51));
  btnTup.setBackground(new Color(204,255,51));
  btnTins.setForeground(new Color(255,153,51));
  btnTup.setForeground(new Color(255,153,51));
  btnMins.setBorderPainted(false);
   btnMup.setBorderPainted(false);
   btnTins.setBorderPainted(false);
   btnTup.setBorderPainted(false);
  add(btnMins); add(btnMup);    add(btnTins); add(btnTup); add(lblTitle);
}
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==btnMins)
	  { 
        new entryleavedet(); 
	  }
  if(e.getSource()==btnMup)
  {
	  new entryleaveUp();
  }
if(e.getSource()==btnTins)
  {
	   new leave();
  } 
if(e.getSource()==btnTup)
  {
	   new mleave();
  }   
}
    /*public static void main(String arg[])
     {leaveOption oo=new leaveOption();}*/
}
  
 
 
