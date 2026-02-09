import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
class empOption extends JPanel implements ActionListener
{ 	
JLabel lblTitle;
JButton btnIns,btnUp,btnShow,btnClear;
Dimension screenSize;
empOption()
{ 
  setLayout(null);
  setBackground(new Color(255,204,204));
  screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
 Image ins=new ImageIcon("fotos/tuser.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image up=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
   lblTitle=new JLabel("EMPLOYEE ");
  btnIns=new JButton("Insert",new ImageIcon(ins));
  btnUp=new JButton("Modify",new ImageIcon(up));
  lblTitle.setBounds(0,0,screenSize.width-250,50);
  lblTitle.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblTitle.setOpaque(true);
  lblTitle.setBackground(new Color(255,153,153));
  lblTitle.setForeground(new Color(255,255,255)); 
  btnIns.setBounds(150,250,200,50);
  btnUp.setBounds(450,250,200,50);
  btnIns.addActionListener(this);
  btnUp.addActionListener(this);
  btnIns.setFont(new Font("Britannic",Font.BOLD,15));
  btnUp.setFont(new Font("Britannic",Font.BOLD,15));
  btnIns.setBackground(new Color(204,255,51));
  btnUp.setBackground(new Color(204,255,51));
  btnIns.setForeground(new Color(255,153,51));
  btnUp.setForeground(new Color(255,153,51));
  btnIns.setBorderPainted(false);
   btnUp.setBorderPainted(false);
  add(btnIns); add(btnUp); add(lblTitle);
}
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==btnIns)
	  { 
        new empDetAdd();
	  }	 
  if(e.getSource()==btnUp)
  {
	 new empDetUpdate(); 
  }  
}
    /*public static void main(String arg[])
     {empOption oo=new empOption();}*/
}