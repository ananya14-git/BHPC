import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFileChooser;

class empDetAdd1 extends JPanel implements ActionListener
{  
	Dimension screenSize;
	JFileChooser f1;
	JTable show;
	JLabel lblEmpCode, lblName, lblDeptId, lblDesg,lblDepName,  lblDob, lblFname, lblDoj,lblLogo;
	JLabel lblPh, lblAddress,  lblPan,lblEmail,lblEtype,lblBgrp,lblCtgry,lblGen,lblMstatus;
	JLabel lblempUp;
	JTextField txtEmpCode,txtName, txtDeptId,txtDepName, txtDesg, txtDob, txtFname, txtDoj, txtPh, txtAddress,txtPan,txtEmail,txtphoto;
	JLabel lblPic;
	JComboBox cbGen,cbMstatus,cbAppoint ,cbBldGrp,cbReserve;
	JButton btnClear,btnClose,btnAdd,btnUpload,btnJcal,btnBcal;
	
	 
	 
	empDetAdd1()
    {
		//lblPic =new JLabel(new ImageIcon("fotos\\zig.png"));
		//lblPic.setBounds(-100,-100,1000,700);
		
		setLayout(null);
	 	screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		String col[]={"Emp Id","Emp Name","Dept Id","Dept Name","Type","Desig","DOJ","Mobile","DOB","Father's Name","Gender","Marriage Status","Blood Group","Category","PAN","Email","Address"};
		String dta[][]={};
        show=new JTable(dta,col);
		show.setBounds(50,460,815,100);
         txtphoto=new JTextField();
		 txtphoto.setBounds(750,80,115,110);
		 
		 Image logo=new ImageIcon("fotos\\pro_icon.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		 lblLogo=new JLabel(new ImageIcon(logo));
		 lblLogo.setBounds(0,0,50,50);
		
	  
		
	//label
	lblempUp=new JLabel("EMPLOYEE DETAILS ENTRY");
	lblempUp.setBounds(60,10,550,30);
	lblempUp.setFont(new Font("Segoe UI Symbol",Font.BOLD,30));
	
    lblEmpCode=new JLabel("Employee code");         txtEmpCode=new JTextField();
	lblEmpCode.setBounds(50,80,150,20); 	txtEmpCode.setBounds(200,80,150,20);
	lblEmpCode.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	lblName=new JLabel("Name");                     txtName=new JTextField(); 
	lblName.setBounds(400,80,100,20);              txtName.setBounds(550,80,150,20);
	lblName.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
    lblDeptId=new JLabel("Department Id");           txtDeptId=new JTextField();
	lblDeptId.setBounds(50,120,150,20);             txtDeptId.setBounds(200,120,150,20);
	lblDeptId.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	lblDepName=new JLabel("Department name");         txtDepName=new JTextField();
	lblDepName.setBounds(400,120,150,20);             txtDepName.setBounds(550,120,150,20);
	lblDepName.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	lblDesg=new JLabel("Designation");                txtDesg=new JTextField(); 
	lblDesg.setBounds(50,160,150,20);                txtDesg.setBounds(200,160,150,20);
	lblDesg.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	lblEtype=new JLabel("Employee Type");
	lblEtype.setBounds(400,160,150,20);
	lblEtype.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	String Appoint[] = {"REGULAR" , "DEPUTATIONAL" , "CONTRACT" , "AGENCY" };
        cbAppoint = new JComboBox(Appoint);
		cbAppoint.setBounds(550,160,150,20); 
		
		lblDoj=new JLabel("Date of joining");              txtDoj=new JTextField();
	 lblDoj.setBounds(50,200,150,20);                      txtDoj.setBounds(200,200,150,20);
	 lblDoj.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	 
	  lblPh=new JLabel("Mobile no");                        txtPh=new JTextField();
     lblPh.setBounds(400,200,150,20);                      txtPh.setBounds(550,200,150,20);	 
	 lblPh.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	 
	
	
	 lblDob=new JLabel("Date of Birth");               txtDob=new JTextField();
	 lblDob.setBounds(50,240,150,20);                  txtDob.setBounds(200,240,150,20);
	  lblDob.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	  
	 lblFname=new JLabel("Father's Name");            txtFname=new JTextField();
	 lblFname.setBounds(400,240,150,20);              txtFname.setBounds(550,240,150,20);
	  lblFname.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	  
	  String gen[]={"Male","Female"};
	  lblGen=new JLabel("Gender");                      cbGen=new JComboBox(gen);
	  lblGen.setBounds(50,280,150,20);                  cbGen.setBounds(200,280,150,20);
	  lblGen.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	  
	  String m[]={"Married","Unmarried"};              
	  lblMstatus=new JLabel("Marriage Status");           cbMstatus=new JComboBox(m);
		lblMstatus.setBounds(400,280,150,20);             cbMstatus.setBounds(550,280,150,20);
		lblMstatus.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
		
		
		String blood[] = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
	    lblBgrp=new JLabel("Blood Group");                     cbBldGrp=new JComboBox(blood);
		lblBgrp.setBounds(50,320,150,20);          
		cbBldGrp.setBounds(200,320,150,20);  
		lblBgrp.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
		
		
		String reservation[] = {"RESERVED" ,"NOT RESERVED"};
         lblCtgry=new JLabel("Category");                             cbReserve = new JComboBox(reservation);
		  lblCtgry.setBounds(400,320,150,20);             
		  cbReserve.setBounds(550,320,150,20);
		 lblCtgry.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
		 
		  lblPan=new JLabel("PAN No");                          txtPan=new JTextField();
	 lblPan.setBounds(50,360,150,20);                           txtPan.setBounds(200,360,150,20);
	 lblPan.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	
	 lblEmail=new JLabel("Email");                           txtEmail=new JTextField();
	 lblEmail.setBounds(400,360,150,20);                     txtEmail.setBounds(550,360,150,20);
	 lblEmail.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	 
	 lblAddress=new JLabel("Address");                  txtAddress=new JTextField();
	 lblAddress.setBounds(50,400,150,20);               txtAddress.setBounds(200,400,150,30);
	 lblAddress.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	 
	
	Image jcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image bcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	
	 //button
    
	btnUpload=new JButton("Upload");
    btnUpload.setBounds(750,190,115,20);
    btnAdd=new JButton("Add");
	btnAdd.setBounds(750,320,100,20);
	btnClear=new JButton("Clear");
	btnClear.setBounds(750,360,100,20);
    btnClose=new JButton("Close");
	btnClose.setBounds(750,400,100,20);
	btnJcal=new JButton(new ImageIcon(jcal));
	btnJcal.setBounds(350,200,20,20);
	btnJcal.setContentAreaFilled(false);
	 btnJcal.setBorderPainted(false);
	btnBcal=new JButton(new ImageIcon(bcal));
	btnBcal.setBounds(350,240,20,20);
	btnBcal.setContentAreaFilled(false);
	 btnBcal.setBorderPainted(false);
	 
	 //adding 
	 btnAdd.addActionListener(this);
	btnClear.addActionListener(this);
	btnClose.addActionListener(this);
	btnUpload.addActionListener(this);
	btnJcal.addActionListener(this);
	btnBcal.addActionListener(this);
	
		
     add(lblEmpCode); add(txtEmpCode); add(lblName); add(txtName);     add(lblDeptId); add(txtDeptId); 
	 add(lblDepName); add(txtDepName);
	 add(lblDesg); add(txtDesg);   add(lblDob);add(txtDob);     add(lblDoj);add(txtDoj); add(lblMstatus);
     add(lblPh); add(txtPh);  add(lblAddress);  add(txtAddress);   add(lblBgrp); add(lblCtgry); add(lblEtype); add(lblGen);
	 add(lblFname); add(txtFname); add(cbReserve);
     add(lblEmail);  add(txtEmail);	add(txtPan); add(lblPan);
	 add(txtphoto); add(btnUpload); add(lblLogo); add(show);
     add(cbAppoint); add(cbBldGrp); add(cbGen); add(cbMstatus);	 add(lblempUp); ; add(btnAdd); add(btnClose); add(btnClear);
	 add(btnBcal); add(btnUpload); add(btnJcal);
	  //add(lblPic);
	 //setSize(910,screenSize.height-200);
		
		setLayout(null);
		//setUndecorated(true);
		//setVisible(true);
	}
	
	   public void actionPerformed(ActionEvent e)
	   {   
	      if(e.getSource()==btnBcal)
		  {
			  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtDob.setText(dt);
		  }
		  if(e.getSource()==btnJcal)
		  {
			  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtDoj.setText(dt);
		  }
		  if (e.getSource()==btnAdd)
		  {
			  try
			  {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="insert into employee(eId,eName,eDesg,eDid,eDob,eFatherName,ePhoneNo,eAppntmt,eCtgry,eGen,eMstatus,eBgrp,eDoj,ePan,eAdd,email) values ('"+txtEmpCode.getText()+"','"+txtName.getText()+"','"+txtDesg.getText()+"','"+txtDeptId.getText()+"','"+txtDob.getText()+"','"+txtFname.getText()+"','"+txtPh.getText()+"','"+cbAppoint.getSelectedItem().toString()+"','"+cbReserve.getSelectedItem().toString()+"','"+cbGen.getSelectedItem().toString()+"','"+cbMstatus.getSelectedItem().toString()+"','"+cbBldGrp.getSelectedItem().toString()+"','"+txtDoj.getText()+"','"+txtPan.getText()+"','"+txtAddress.getText()+"','"+txtEmail.getText()+"')";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"records inserted");
				txtEmpCode.setText("");
				txtName.setText("");
				txtDeptId.setText("");
				txtDepName.setText("");
				txtDesg.setText("");
				txtDob.setText("");
				txtDoj.setText("");
				txtFname.setText("");
				txtPan.setText("");
				txtPh.setText("");
				txtEmail.setText("");
				txtAddress.setText("");
			  }
			 catch(Exception  a)
			  {
				JOptionPane.showMessageDialog(this,a.getMessage());
			  }
		  }
		  if(e.getSource()==btnClear)
		  {
			  txtEmpCode.setText("");
				txtName.setText("");
				txtDeptId.setText("");
				txtDepName.setText("");
				txtDesg.setText("");
				txtDob.setText("");
				txtDoj.setText("");
				txtFname.setText("");
				txtPan.setText("");
				txtPh.setText("");
				txtEmail.setText("");
				txtAddress.setText("");
			  
		  }
		  if(e.getSource()==btnUpload)
		  {
			  f1=new JFileChooser();
			  
		  }
		  if(e.getSource()==btnClose)
		  {
			 // dispose();
		  }
			  
			  
	  }
	
	public static void main(String arg[])
	{
		new empDetAdd1();
	}
	
}