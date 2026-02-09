import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel.*;
//import javax.swing.JTabbedPane.*;
//import javax.swing.JComponent.*;
import java.awt.event.*;
import java.awt.BorderLayout;

class empDashboard extends JFrame implements ActionListener
{
	JPanel left,hdng,cntr;
  
 
	JButton btnEmp,btnMake,btnLeave,btnAttend,btnSalary,btnChange,btnOut;
	JLabel lblhdng; 
	JLabel lblWel;
    JLabel lblNm;
	
	Dimension screenSize;
    empDashboard()
	{
		Color c= new Color(0,150,255);

		cntr=new JPanel();   //centre cardlayout
		left=new JPanel(new GridLayout(15,1));
		hdng=new JPanel();
		
		
		Image out=new ImageIcon("fotos//logout.jpeg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	
		Image prof=new ImageIcon("fotos//tuser.jpg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image amake=new ImageIcon("fotos//attend1.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        Image atten=new ImageIcon("fotos//attend.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
         Image holi=new ImageIcon("fotos//holi.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		 Image sal=new ImageIcon("fotos//money.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		  Image pass=new ImageIcon("fotos//upss.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);



       lblhdng=new JLabel();
	   lblWel=new JLabel("Welcome");
	   lblNm=new JLabel(loginform.nm);
		btnEmp=new JButton("My Profile",new ImageIcon(prof));
		btnMake=new JButton("Make Attendance",new ImageIcon(amake));
		btnAttend=new JButton("My Attendance",new ImageIcon(atten));
		btnLeave=new JButton("My Leave",new ImageIcon(holi));
		btnSalary=new JButton("My Salary",new ImageIcon(sal));
		btnChange=new JButton("Change Password",new ImageIcon(pass));
		btnOut=new JButton("Logout",new ImageIcon(out));
		
		
		add(left,"West");
		add(hdng,"North");
		add(cntr,"Center");
 
 
 
 
 hdng.add(lblhdng);
 left.add(btnEmp);  left.add(btnLeave); left.add(btnMake) ; left.add(btnAttend); left.add(btnSalary); left.add(btnChange);
 cntr.add(lblWel);
 cntr.add(lblNm);
 lblWel.setBounds(300,50,250,100);
 lblNm.setBounds(600,50,250,100);
 lblWel.setFont(new Font( "Harrington",Font.PLAIN,50));
 lblNm.setFont(new Font( "Harrington",Font.PLAIN,50));
 lblWel.setForeground(new Color(128,0,64));
 lblNm.setForeground(new Color(128,0,64));
 screenSize=Toolkit.getDefaultToolkit().getScreenSize();
 setSize(screenSize.width,screenSize.height);

 cntr.setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
 cntr.setBackground(new Color(255,204,204));
 cntr.setLayout(null);
 hdng.setPreferredSize(new Dimension(screenSize.width,150));
 left.setBackground(c);
 left.setPreferredSize(new Dimension(250,screenSize.height-150));
 lblhdng.setSize(new Dimension(screenSize.width,500));
 lblhdng.setIcon(new ImageIcon("fotos\\hd.jpg"));
 
 btnEmp.setBackground(new Color(0,150,255));
 btnEmp.setForeground(new Color(255,255,255));
 btnEmp.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnEmp.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnMake.setBackground(new Color(0,150,255));
 btnMake.setForeground(new Color(255,255,255));
 btnMake.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnMake.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnLeave.setBackground(new Color(0,150,255));
 btnLeave.setForeground(new Color(255,255,255));
 btnLeave.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnLeave.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnAttend.setBackground(new Color(0,150,255));
 btnAttend.setForeground(new Color(255,255,255));
 btnAttend.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnAttend.setHorizontalAlignment(SwingConstants.LEFT);
 //btnAttend.setVerticalTextPosition(SwingConstants.CENTER);
 
 btnSalary.setBackground(new Color(0,150,255));
 btnSalary.setForeground(new Color(255,255,255));
 btnSalary.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnSalary.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnChange.setBackground(new Color(0,150,255));
 btnChange.setForeground(new Color(255,255,255));
 btnChange.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnChange.setHorizontalAlignment(SwingConstants.LEFT);
 
 
btnEmp.setContentAreaFilled(false);
 btnEmp.setBorderPainted(false);
  btnLeave.setBorderPainted(false);
btnLeave.setContentAreaFilled(false);
 btnMake.setBorderPainted(false);
 btnMake.setContentAreaFilled(false);
 btnSalary.setContentAreaFilled(false);
 btnAttend.setContentAreaFilled(false);
 btnAttend.setBorderPainted(false);
 btnSalary.setBorderPainted(false);
 btnChange.setBorderPainted(false);
 btnChange.setContentAreaFilled(false);
 
      /* try
		       {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		        String sql="select * from employee where eId='"+loginform.usr+"'";
		        Statement st=con.createStatement();
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
		        String var1=r.getString("ename");
		        lblNm.setText(var1);
				}
		       r.close();
		       st.close();
		       con.close();
			   }
		      catch(Exception ex)
                  {JOptionPane.showMessageDialog(null,ex.getMessage());}
		               
		        */ 
				  
			   
		   
		         
 
 //lblEmp.addActionListener(this);
 btnEmp.addActionListener(this);
 btnMake.addActionListener(this);

 btnLeave.addActionListener(this);
 btnAttend.addActionListener(this);
 btnSalary.addActionListener(this);
 btnChange.addActionListener(this);
 
 	
 
 setVisible(true);


}

public void actionPerformed(ActionEvent e)
{
	
	if (e.getSource()==btnEmp)
	{
		userProfile obj=new userProfile();
		
	}
	if (e.getSource()==btnLeave)
	{
		leaveRepEmp obj=new leaveRepEmp();
		
	}
	if (e.getSource()==btnSalary)
	{
		salaryRepEmp obj=new salaryRepEmp();
		
	}
	if (e.getSource()==btnMake)
	{
		attend obj=new attend();
		
	}
	if (e.getSource()==btnAttend)
	{
		attendRepEmp obj=new attendRepEmp();
		
	}
	if (e.getSource()==btnChange)
	{   
      
       changepswd ch_obj=new changepswd();
		
	}
	if(e.getSource()==btnOut)
	{
		int n= JOptionPane.showConfirmDialog(null,"Are You Sure Want To LOGOUT?","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(n==JOptionPane.YES_OPTION)
	   {
       dispose();
	   loginform obj=new loginform();
       }
	}
}
public static void main(String args[])
{
 new empDashboard(); 
}
}