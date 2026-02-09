import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;

class reportOption extends JPanel implements ActionListener
{ 

	
JLabel lblTitle;
JButton btnEmp,btnAttend,btnLeave,btnDist,btnSal,btnDep;

Dimension screenSize;


reportOption()
{ 
setLayout(null);
setBackground(new Color(255,204,204));
screenSize=Toolkit.getDefaultToolkit().getScreenSize();
setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
  
Image ins=new ImageIcon("fotos/line-chart.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image emp=new ImageIcon("fotos/employee.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image leave=new ImageIcon("fotos/labor-day.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image salary=new ImageIcon("fotos/sal.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
Image loan=new ImageIcon("fotos/loan.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);


 lblTitle=new JLabel(" REPORT",new ImageIcon(ins),SwingConstants.HORIZONTAL);
 btnEmp=new JButton("Employee Report ",new ImageIcon(emp));
 btnAttend=new JButton("Attendence Report",new ImageIcon());
  btnLeave=new JButton("Leave Report ",new ImageIcon(leave));
  btnSal=new JButton("Salary Report",new ImageIcon(salary));
  btnDist=new JButton("Distribution Report",new ImageIcon(loan));
btnDep=new JButton("Department Report",new ImageIcon());
  
  lblTitle.setBounds(0,0,screenSize.width-250,50);
  lblTitle.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblTitle.setOpaque(true);
  lblTitle.setBackground(new Color(255,153,153));
  lblTitle.setForeground(new Color(255,255,255)); 
     
 
  
 btnEmp.setBounds(150,250,250,50);
 
 btnAttend.setBounds(550,250,270,50);
  btnLeave.setBounds(150,350,250,50);
  btnSal.setBounds(150,450,270,50);
  btnDist.setBounds(550,350,270,50);
  btnDep.setBounds(550,450,270,50);
  
 btnEmp.addActionListener(this);
 btnAttend.addActionListener(this);
  btnLeave.addActionListener(this);
  btnDist.addActionListener(this);
 btnSal.addActionListener(this);
 btnDep.addActionListener(this);
 btnEmp.setFont(new Font("Britannic",Font.BOLD,15));
 btnAttend.setFont(new Font("Britannic",Font.BOLD,15));
 btnLeave.setFont(new Font("Britannic",Font.BOLD,15));
 btnDist.setFont(new Font("Britannic",Font.BOLD,15));
 btnSal.setFont(new Font("Britannic",Font.BOLD,15));
 btnDep.setFont(new Font("Britannic",Font.BOLD,15));
 
 btnEmp.setBackground(new Color(204,255,51));
 btnAttend.setBackground(new Color(204,255,51));
 btnLeave.setBackground(new Color(204,255,51));
 btnSal.setBackground(new Color(204,255,51));
 btnDist.setBackground(new Color(204,255,51));
 btnDep.setBackground(new Color(204,255,51));
 
 btnEmp.setForeground(new Color(255,153,51));
 btnAttend.setForeground(new Color(255,153,51));
 btnDist.setForeground(new Color(255,153,51));
 btnLeave.setForeground(new Color(255,153,51));
 btnSal.setForeground(new Color(255,153,51));
 btnDep.setForeground(new Color(255,153,51));
  
 btnEmp.setBorderPainted(false);
 btnAttend.setBorderPainted(false);
 btnLeave.setBorderPainted(false);
 btnDist.setBorderPainted(false);
 btnSal.setBorderPainted(false);
 btnDep.setBorderPainted(false);
  
  add(btnEmp); add(btnAttend);    add(btnLeave); add(btnDist); add(lblTitle);  add(btnSal);  add(btnDep);
 
  //setVisible(false);
  //setSize(800,800);
}
  
  public void actionPerformed(ActionEvent e)
  {
	  if(e.getSource()==btnEmp)
	  { 
		new employeeRep();
       
	  }
	 
  if(e.getSource()==btnSal)
  {
	 new salaryRep();
	  
  }
if(e.getSource()==btnLeave)
  {
	 new leaveRep();
	 
  } 
if(e.getSource()==btnDist)
  {
	 new distRep();
	 
  } 
if(e.getSource()==btnAttend)
  {
	 new attendRep();
	 
  }
if(e.getSource()==btnDep)
  {
	 new departmentReport();
	 
  }  
}
  
  
  
  
   // public static void main(String arg[])
    // {reportOption oo=new reportOption();}

}
  
 
 
