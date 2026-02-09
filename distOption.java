import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
class distOption extends JPanel implements ActionListener
{ 
JLabel lblTitle;
JButton btnIns,btnUp,btnShow,btnClear;
Dimension screenSize;
distOption()
{ 
  setLayout(null);
	setBackground(new Color(255,204,204));
  screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
 Image ins=new ImageIcon("fotos/tuser.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image up=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
   lblTitle=new JLabel("DISTRIBUTION");
  btnIns=new JButton("Distribution Master",new ImageIcon(ins));
  btnUp=new JButton("Distribution Update",new ImageIcon(up));
  btnShow=new JButton("Company Master",new ImageIcon(ins));
  btnClear=new JButton("Company Update",new ImageIcon(up));
  lblTitle.setBounds(0,0,screenSize.width-250,50);
  lblTitle.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblTitle.setOpaque(true);
  lblTitle.setBackground(new Color(255,153,153));
  lblTitle.setForeground(new Color(255,255,255)); 
  btnIns.setBounds(150,270,250,50);
  btnUp.setBounds(500,270,250,50);
  btnShow.setBounds(150,400,250,50);
  btnClear.setBounds(500,400,250,50);
  btnIns.addActionListener(this);
  btnUp.addActionListener(this);
  btnShow.addActionListener(this);
  btnClear.addActionListener(this);
  btnIns.setFont(new Font("Britannic",Font.BOLD,15));
  btnUp.setFont(new Font("Britannic",Font.BOLD,15));
  btnClear.setFont(new Font("Britannic",Font.BOLD,15));
  btnShow.setFont(new Font("Britannic",Font.BOLD,15));
  btnIns.setBackground(new Color(204,255,51));
  btnUp.setBackground(new Color(204,255,51));
  btnIns.setForeground(new Color(255,153,51));
  btnUp.setForeground(new Color(255,153,51));
   btnShow.setForeground(new Color(255,153,51));
  btnClear.setForeground(new Color(255,153,51)); 
   btnShow.setBackground(new Color(204,255,51));
  btnClear.setBackground(new Color(204,255,51));
  btnIns.setBorderPainted(false);
   btnUp.setBorderPainted(false);
    btnClear.setBorderPainted(false);
  btnShow.setBorderPainted(false);
  add(btnIns); add(btnUp); add(lblTitle); add(btnShow);  add(btnClear);
}
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==btnIns)
	  { 
        new distInsert();
	  }
  if(e.getSource()==btnUp)
  {
	 new distUpdate(); 
  }
  if(e.getSource()==btnShow)
  {
	 new distCompInsert(); 
  }
  if(e.getSource()==btnClear)
  {
	 new distCompUpdate(); 
  }
     
}
   /* public static void main(String arg[])
     {distOption oo=new distOption();}*/
}