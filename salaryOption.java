import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;

class salaryOption extends JPanel implements ActionListener
{ 	
JLabel lblTitle;
JButton btnSal,btnAdv,btnPaySlip,btnScale;
Dimension screenSize;
salaryOption()
{ 
setLayout(null);
setBackground(new Color(255,204,204));
screenSize=Toolkit.getDefaultToolkit().getScreenSize();
setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
 Image ins=new ImageIcon("fotos/money.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image up=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image Adv=new ImageIcon("fotos/tuser.jpg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  Image PaySlip=new ImageIcon("fotos/update.jpeg").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
  lblTitle=new JLabel("SALARY");
  btnSal=new JButton("Salary Master ",new ImageIcon(ins));
  btnScale=new JButton("Scale Master",new ImageIcon(up));
  btnPaySlip=new JButton("PaySlip Master ",new ImageIcon(PaySlip));
  btnAdv=new JButton("Advance/Loan Master",new ImageIcon(Adv));
  lblTitle.setBounds(0,0,screenSize.width-250,50);
  lblTitle.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblTitle.setOpaque(true);
  lblTitle.setBackground(new Color(255,153,153));
  lblTitle.setForeground(new Color(255,255,255)); 
  btnScale.setBounds(150,250,250,50);
  btnAdv.setBounds(550,250,250,50);
  btnSal.setBounds(150,350,250,50);
  btnPaySlip.setBounds(550,350,250,50);
  btnSal.addActionListener(this);
  btnScale.addActionListener(this);
  btnAdv.addActionListener(this);
  btnPaySlip.addActionListener(this);
  btnSal.setFont(new Font("Britannic",Font.BOLD,15));
  btnScale.setFont(new Font("Britannic",Font.BOLD,15));
  btnSal.setBackground(new Color(204,255,51));
  btnScale.setBackground(new Color(204,255,51));
  btnSal.setForeground(new Color(255,153,51));
  btnScale.setForeground(new Color(255,153,51));
  btnAdv.setFont(new Font("Britannic",Font.BOLD,15));
  btnPaySlip.setFont(new Font("Britannic",Font.BOLD,15));
  btnAdv.setBackground(new Color(204,255,51));
  btnPaySlip.setBackground(new Color(204,255,51));
  btnAdv.setForeground(new Color(255,153,51));
  btnPaySlip.setForeground(new Color(255,153,51));
  btnSal.setBorderPainted(false);
   btnScale.setBorderPainted(false);
   btnAdv.setBorderPainted(false);
   btnPaySlip.setBorderPainted(false);
  add(btnSal); add(btnScale);    add(btnAdv); add(btnPaySlip); add(lblTitle);
}
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==btnSal)
	  { 
        new salMaster();
	  }
  if(e.getSource()==btnScale)
  {
	  new scale(); 
  }
if(e.getSource()==btnAdv)
  {
	  new advance(); 
  } 
if(e.getSource()==btnPaySlip)
  {
	  new payslip(); 
  }   
}
    /*public static void main(String arg[])
     {leaveOption oo=new leaveOption();}*/
}
  
 
 
