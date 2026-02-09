import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel.*;
//import javax.swing.JTabbedPane.*;
//import javax.swing.JComponent.*;
import java.awt.event.*;
import java.awt.BorderLayout;

class dashBoard1 extends JFrame implements ActionListener
{
	JPanel left,hdng,cntr;
	
	empOption emp_obj=new empOption();
	deptOption dept_obj=new deptOption();
	leaveOption lv_obj=new leaveOption();
	salaryOption sal_obj=new salaryOption();
	generationOption gen_obj=new generationOption();
	distOption dist_obj =new distOption();
	revReport rev_obj=new revReport();
	aboutUs abt_obj=new aboutUs();
	reportOption rep_obj=new reportOption();
	

	JButton btnHome,btnEmp,btnDept,btnLeave,btnAttend,btnSalary,btnGen,btnDis,btnRev,btnReprt,btnCreate,btnAbout,btnOut;
	JLabel lblhdng,lblhomepic,lblWel; 
	//JLabel lblEmpAdd;
	//JPanel cntrAdd,cntrUpdate;
	Dimension screenSize;
    dashBoard1()
	{
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		Color c= new Color(0,150,255);
		
		cntr=new JPanel();   //centre cardlayout
		left=new JPanel(new GridLayout(15,1));
		hdng=new JPanel();
		
		Image sone=new ImageIcon("fotos//sone.jpeg").getImage().getScaledInstance(screenSize.width-250,screenSize.height-150,Image.SCALE_SMOOTH);
        
		Image emp=new ImageIcon("fotos//username.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image dep=new ImageIcon("fotos//dep.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image lv=new ImageIcon("fotos//holi.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image atten=new ImageIcon("fotos//attend.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image sal=new ImageIcon("fotos//money.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image gen=new ImageIcon("fotos//hy.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image dist=new ImageIcon("fotos//dist_2.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image rev=new ImageIcon("fotos//rev.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image out=new ImageIcon("fotos//logout.jpeg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image about=new ImageIcon("fotos//about.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image rep=new ImageIcon("fotos//rprt.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		Image cuser=new ImageIcon("fotos//cuser.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		
		
		
		
		
		
		
		
		
		
		lblWel=new JLabel("Welcome Admin");
		lblhdng=new JLabel();
		lblhomepic=new JLabel(new ImageIcon(sone));
		btnHome=new JButton("Home");
		btnEmp=new JButton("Employee Details",new ImageIcon(emp));
		btnDept=new JButton("Department Details",new ImageIcon(dep));
		btnLeave=new JButton("Leave Details",new ImageIcon(lv));
		btnGen=new JButton("Generation",new ImageIcon(gen));
		btnAttend=new JButton("Make your Attendence",new ImageIcon(atten));
		btnSalary=new JButton("Salary",new ImageIcon(sal));
		btnDis=new JButton("Distribution",new ImageIcon(dist));
		btnRev=new JButton("Revenue",new ImageIcon(rev));
		btnReprt=new JButton("Reports",new ImageIcon(rep));
		btnCreate=new JButton("Create User",new ImageIcon(cuser));
		btnAbout=new JButton("About Us",new ImageIcon(about));
		btnOut=new JButton("Logout",new ImageIcon(out));
		
		
		
		setLayout(null);
		add(left);
		add(hdng);
		left.setBounds(0,150,250,screenSize.height-150);
		hdng.setBounds(0,0,screenSize.width,150);
		cntr.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		lblhomepic.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		lblWel.setBounds(300,50,400,50);
		btnAttend.setBounds(800,10,300,100);
		dept_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		emp_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		abt_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		lv_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		sal_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		dist_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		gen_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		rev_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		rep_obj.setBounds(250,150,screenSize.width-250,screenSize.height-150);
		add(dept_obj);
		add(emp_obj);
		add(abt_obj);
		add(lv_obj);
		add(sal_obj);
		add(gen_obj);
		add(dist_obj);
		add(rev_obj);
		add(rep_obj);
		add(cntr);
		cntr.setBackground(Color.gray);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		abt_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		dept_obj.setVisible(false);
		gen_obj.setVisible(false);
		rev_obj.setVisible(false);
		dist_obj.setVisible(false);
		rep_obj.setVisible(false);
		
 
 
 hdng.add(lblhdng);
 left.add(btnHome);
 left.add(btnEmp);   left.add(btnDept);  left.add(btnLeave);    left.add(btnSalary); left.add(btnGen);
 left.add(btnDis); left.add(btnRev); left.add(btnCreate);  left.add(btnReprt);
 left.add(btnAbout); left.add(btnOut);
 cntr.add(lblhomepic);
 
lblhomepic.add(lblWel);
lblhomepic.add(btnAttend);
 
 

 
 hdng.setPreferredSize(new Dimension(screenSize.width,150));
 left.setBackground(c);
 left.setPreferredSize(new Dimension(250,screenSize.height-150));
 lblhdng.setSize(new Dimension(screenSize.width,500));
 lblhdng.setIcon(new ImageIcon("fotos\\hd.jpg"));
 
 
 lblWel.setForeground(new Color(136,14,79));
 lblWel.setFont(new Font( "Vladimir Script",Font.BOLD,50));
 
  btnHome.setBackground(new Color(0,150,255));
 btnHome.setForeground(new Color(255,255,255));
 btnHome.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnHome.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnEmp.setBackground(new Color(0,150,255));
 btnEmp.setForeground(new Color(255,255,255));
 btnEmp.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnEmp.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnDept.setBackground(new Color(0,150,255));
 btnDept.setForeground(new Color(255,255,255));
 btnDept.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnDept.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnLeave.setBackground(new Color(0,150,255));
 btnLeave.setForeground(new Color(255,255,255));
 btnLeave.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnLeave.setHorizontalAlignment(SwingConstants.LEFT);
 
 //btnAttend.setBackground(new Color(0,150,255));
 //btnAttend.setForeground(new Color(255,255,255));
 btnAttend.setFont(new Font( "Tahoma",Font.PLAIN,18));
btnAttend.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnSalary.setBackground(new Color(0,150,255));
 btnSalary.setForeground(new Color(255,255,255));
 btnSalary.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnSalary.setHorizontalAlignment(SwingConstants.LEFT);
 
  btnGen.setBackground(new Color(0,150,255));
 btnGen.setForeground(new Color(255,255,255));
 btnGen.setFont(new Font( "Tahoma",Font.PLAIN,18));
  btnGen.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnDis.setBackground(new Color(0,150,255));
 btnDis.setForeground(new Color(255,255,255));
 btnDis.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnDis.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnRev.setBackground(new Color(0,150,255));
 btnRev.setForeground(new Color(255,255,255));
 btnRev.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnRev.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnCreate.setBackground(new Color(0,150,255));
 btnCreate.setForeground(new Color(255,255,255));
 btnCreate.setFont(new Font( "Tahoma",Font.PLAIN,18));
 btnCreate.setHorizontalAlignment(SwingConstants.LEFT);
 
 
  btnReprt.setBackground(new Color(0,150,255));
 btnReprt.setForeground(new Color(255,255,255));
 btnReprt.setFont(new Font( "Tahoma",Font.PLAIN,18));
  btnReprt.setHorizontalAlignment(SwingConstants.LEFT);
 
  btnAbout.setBackground(new Color(0,150,255));
 btnAbout.setForeground(new Color(255,255,255));
 btnAbout.setFont(new Font( "Tahoma",Font.PLAIN,18));
  btnAbout.setHorizontalAlignment(SwingConstants.LEFT);
  
  btnOut.setBackground(new Color(0,150,255));
 btnOut.setForeground(new Color(255,255,255));
 btnOut.setFont(new Font( "Tahoma",Font.PLAIN,18));
  btnOut.setHorizontalAlignment(SwingConstants.LEFT);
 
 btnEmp.setContentAreaFilled(false);
 btnEmp.setBorderPainted(false);
  btnLeave.setBorderPainted(false);
btnLeave.setContentAreaFilled(false);
 btnDept.setBorderPainted(false);
 btnDept.setContentAreaFilled(false);
 btnSalary.setContentAreaFilled(false);
 btnAttend.setContentAreaFilled(false);
 btnAttend.setBorderPainted(false);
 btnSalary.setBorderPainted(false);
 btnRev.setBorderPainted(false);
 btnRev.setContentAreaFilled(false);
 btnDis.setContentAreaFilled(false);
 btnDis.setBorderPainted(false);
  btnGen.setBorderPainted(false);
 btnAbout.setContentAreaFilled(false);
 btnAbout.setBorderPainted(false);
 btnReprt.setBorderPainted(false);
 btnCreate.setContentAreaFilled(false);
  btnCreate.setBorderPainted(false);
   btnOut.setContentAreaFilled(false);
  btnOut.setBorderPainted(false);
  btnHome.setContentAreaFilled(false);
  btnHome.setBorderPainted(false);
   
 
 //cntr.add(lblEmpAdd);
 
 //lblEmp.addActionListener(this);
 btnHome.addActionListener(this);
 btnEmp.addActionListener(this);
 btnDept.addActionListener(this);
 btnLeave.addActionListener(this);
 //btnAttend.addActionListener(this);
 btnSalary.addActionListener(this);
 btnDis.addActionListener(this);
 btnRev.addActionListener(this);
 btnCreate.addActionListener(this);
 btnGen.addActionListener(this);
 btnAbout.addActionListener(this);
 btnOut.addActionListener(this);
 btnReprt.addActionListener(this);
 setVisible(true);


}

public void actionPerformed(ActionEvent e)
{
	/*if(e.getSource()==lblEmp)
	{
		entry1 obj=new entry1();
		obj.setPreferredSize(new Dimension(screenSize.width-250,screenSize.height));
		JScrollPane jsp=new JScrollPane(obj);
		jsp.setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
		add(jsp);
		//JOptionPane.showMessageDialog(null,"Entry1Execute");
		cntr.setVisible(false);
		
	}*/
	if (e.getSource()==btnHome)
	{  
		cntr.setVisible(true);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
	}
	if (e.getSource()==btnCreate)
	{
		signUp sign_obj=new signUp();
		sign_obj.setPreferredSize(new Dimension(screenSize.width-250,screenSize.height));
		
		cntr.setVisible(true);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
	
	}
	if (e.getSource()==btnEmp)
	{
		cntr.setVisible(false);
		emp_obj.setVisible(true);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
		//obj.setVisible(false);
	}
	
	if (e.getSource()==btnDept)
	{
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(true);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
		//obj.setVisible(false);
	}
	
	if (e.getSource()==btnLeave)
	{
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(true);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
		//obj.setVisible(false);
	}
	if (e.getSource()==btnAbout)
	{  
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(true);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
		//obj.setVisible(false);
	}
	if (e.getSource()==btnSalary)
	{  
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(true);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
	}
	if (e.getSource()==btnDis)
	{
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(true);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
		//obj.setVisible(false);
	}
	if (e.getSource()==btnGen)
	{  
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(true);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(false);
	}
	if (e.getSource()==btnRev)
	{  
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(true);
		rep_obj.setVisible(false);
		/*JScrollPane jsp=new JScrollPane(rev_obj);
		jsp.setPreferredSize(new Dimension(screenSize.width-250,screenSize.height-150));
		add(jsp);*/
	}
	
	
	
	
	if(e.getSource()==btnReprt)
	{
		cntr.setVisible(false);
		emp_obj.setVisible(false);
		dept_obj.setVisible(false);
		lv_obj.setVisible(false);
		sal_obj.setVisible(false);
		gen_obj.setVisible(false);
		dist_obj.setVisible(false);
		abt_obj.setVisible(false);
		rev_obj.setVisible(false);
		rep_obj.setVisible(true);
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
 new dashBoard1(); 
}
}