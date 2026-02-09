import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
 import java.lang.StringBuffer;
 //import java.util.regex.Matcher;
//import java.util.regex.Pattern;


class empDetUpdate extends JFrame implements ActionListener
{  
    File f;
	String img_path=null;
	String image_path = null;
	Dimension screenSize;
	JTable show;
	JLabel lblEmpCode, lblName, lblDeptId, lblDesg,lblDepName,  lblDob, lblFname, lblDoj,lblLogo;
	JLabel lblPh, lblAddress,  lblPan,lblEmail,lblEtype,lblBgrp,lblCtgry,lblGen,lblMstatus;
	JLabel lblempUp;
	JTextField txtName, txtDeptId,txtDepName, txtDob, txtFname, txtDoj, txtPh, txtAddress,txtPan,txtEmail;
	JLabel lblPic,txtphoto;
	JComboBox cbGen,cbMstatus,cbAppoint ,cbBldGrp,cbReserve,cbEmpCode,cbDesg;
	JButton btnClear,btnClose,btnUpdate,btnUpload,btnJcal,btnBcal,btnDelete;
	
	 
	 
	empDetUpdate()
    {
		
		
		setLayout(null);
	 	screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		String col[]={"Emp Id","Emp Name","Dept Id","Dept Name","Type","Desig","DOJ","Mobile","DOB","Father's Name","Gender","Marriage Status","Blood Group","Category","PAN","Email","Address"};
		String dta[][]={};
        show=new JTable(dta,col);
		show.setBounds(50,460,815,100);
         txtphoto=new JLabel();
		 txtphoto.setBounds(750,80,115,110);
		 
		 Image logo=new ImageIcon("fotos\\pro_icon.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		 lblLogo=new JLabel(new ImageIcon(logo));
		 lblLogo.setBounds(0,0,50,50);
		
		String desg[]={"","Multi-tasking Staff","Clerical","Manager","Worker","Engineers"};
  cbDesg=new JComboBox(desg); 
	  
		
	//label
	lblempUp=new JLabel("EMPLOYEE DETAILS UPDATION");
	lblempUp.setBounds(60,10,550,30);
	lblempUp.setFont(new Font("Segoe UI Symbol",Font.BOLD,30));
	
    lblEmpCode=new JLabel("Employee code");         cbEmpCode=new JComboBox();
	lblEmpCode.setBounds(50,80,150,20); 	cbEmpCode.setBounds(200,80,150,20);
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
	
	lblDesg=new JLabel("Designation");  
	lblDesg.setBounds(50,160,150,20);                cbDesg.setBounds(200,160,150,20);
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
	 lblAddress.setBounds(50,400,150,20);               txtAddress.setBounds(200,400,500,30);
	 lblAddress.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	 
	
	Image jcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image bcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	
	 //button
    
	btnUpload=new JButton("Upload");
    btnUpload.setBounds(750,190,115,20);
    btnUpdate=new JButton("Update");
	btnUpdate.setBounds(750,320,100,20);
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
	 btnDelete=new JButton("Delete");
	 btnDelete.setBounds(750,280,100,20);
	
	  try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select eId from employee order by eId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbEmpCode.addItem(rs.getString("eId"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
	
	cbEmpCode.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select eName,eDesg,eDid,TO_CHAR(eDob,'dd-Mon-yyyy')as  edob,eFatherName,ePhoneNo,email,eAppntmt,eCtgry,eGen,eMstatus,eBgrp,TO_CHAR(eDoj,'dd-Mon-yyyy') as edoj,ePan,eAdd,image,dname from employee,department where eId = '"+cbEmpCode.getSelectedItem().toString()+"' and did=edid";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtName.setText(rs.getString("eName"));
		   cbDesg.setSelectedItem(rs.getString("eDesg"));
		   txtDeptId.setText(rs.getString("eDid"));
		   txtDob.setText(rs.getString("eDob"));
		   txtFname.setText(rs.getString("eFatherName"));
		   txtDoj.setText(rs.getString("eDoj"));
		   txtPh.setText(rs.getString("ePhoneNo"));
		   txtEmail.setText(rs.getString("email"));
		   cbAppoint.setSelectedItem(rs.getString("eAppntmt"));
		   cbReserve.setSelectedItem(rs.getString("eCtgry"));
		   cbGen.setSelectedItem(rs.getString("eGen"));

		   cbMstatus.setSelectedItem(rs.getString("eMstatus"));
		   cbBldGrp.setSelectedItem(rs.getString("eBgrp"));
			txtPan.setText(rs.getString("ePan"));
			txtAddress.setText(rs.getString("eAdd"));
			String str=rs.getString("image");
			txtDepName.setText(rs.getString("dname"));
			txtphoto.setIcon(new ImageIcon(new ImageIcon(str).getImage().getScaledInstance(115,110,Image.SCALE_SMOOTH)));
                      }
                     else
                     {
				      
                       JOptionPane.showMessageDialog(null,"no such employee");
                     }
                     rs.close();
                     con.close();
                     }
          catch(Exception a)
                    {  JOptionPane.showMessageDialog (null,a.getMessage());  }
			 }
		}
	}
);	

txtPh.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed");}
	}
});

		
     add(lblEmpCode); add(cbEmpCode); add(lblName); add(txtName);     add(lblDeptId); add(txtDeptId); 
	 add(lblDepName); add(txtDepName);
	 add(lblDesg); add(cbDesg);   add(lblDob);add(txtDob);     add(lblDoj);add(txtDoj); add(lblMstatus);
     add(lblPh); add(txtPh);  add(lblAddress);  add(txtAddress);   add(lblBgrp); add(lblCtgry); add(lblEtype); add(lblGen);
	 add(lblFname); add(txtFname); add(cbReserve);
     add(lblEmail);  add(txtEmail);	add(txtPan); add(lblPan);
	 add(txtphoto); add(btnUpload); add(lblLogo); add(show);
     add(cbAppoint); add(cbBldGrp); add(cbGen); add(cbMstatus);	 add(lblempUp); ; add(btnUpdate); add(btnClose); add(btnClear);
	 add(btnBcal); add(btnUpload); add(btnJcal); add(btnDelete);
	  //add(lblPic);
	  setBounds((screenSize.width-910)/2,(screenSize.height-200)/2,910,screenSize.height-200);
	 setSize(910,screenSize.height-200);
	 
	 btnUpdate.addActionListener(this);
	btnClear.addActionListener(this);
	btnClose.addActionListener(this);
	btnUpload.addActionListener(this);
	btnJcal.addActionListener(this);
	btnBcal.addActionListener(this);
		 btnDelete.addActionListener(this);

		
		setLayout(null);
		
		setVisible(true);
	
	}

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnUpdate)
		{
			 if(txtFname.getText().equals(""))
			  {JOptionPane.showMessageDialog(this,"Enter Father's name");
			  return;}
		   
				
			  if(txtEmail.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter email");
				return; }
				
				if(txtDepName.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter Department name");
				return;}
			if(txtDob.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter date of birth");
				return;}
			if(txtDoj.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter date of joining");
				return;}
			if(txtPan.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter PAN NO");
				return;}
			if(txtPh.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter Phone no");
				return;}
			
			if(txtAddress.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"Enter address");
				return;}
			
				
		   
				if(txtPh.getText().length()!=10)
		   {   
				JOptionPane.showMessageDialog(this,"Recheck length of mobile no.");
				return;
		   }
		    if(txtPan.getText().length()!=10)
		   {   
				JOptionPane.showMessageDialog(this,"Recheck length of PAN No");
				return;
		   }
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="update employee set eName='"+txtName.getText()+"',eDid='"+txtDeptId.getText()+"',eDesg='"+cbDesg.getSelectedItem().toString()+"',eFatherName='"+txtFname.getText()+"',ePhoneNo='"+txtPh.getText()+"',eDoj='"+txtDoj.getText()+"',ePan='"+txtPan.getText()+"',eAdd='"+txtAddress.getText()+"',email='"+txtEmail.getText()+"',eDob='"+txtDob.getText()+"',image='"+img_path+"' where eId='"+cbEmpCode.getSelectedItem().toString()+"'";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"records updated");
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(this,a.getMessage());
			}
			
		}
		if(e.getSource()==btnDelete)
		{  
			int n= JOptionPane.showConfirmDialog(null,"Are You Sure","Enter Carefully",JOptionPane.WARNING_MESSAGE);
            if(n==JOptionPane.YES_OPTION)
			{   try{	
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
           String sql ="delete from employee where eId='"+cbEmpCode.getSelectedItem().toString()+"'";
		   st.executeUpdate(sql);
				st.close();
				con.close();
			JOptionPane.showMessageDialog(null,"Record deleted");
			 txtAddress.setText("");
			 txtDepName.setText("");
			 txtDeptId.setText("");
			 txtDob.setText("");
			 txtDoj.setText("");
			 txtEmail.setText("");
			 txtFname.setText("");
			 txtPan.setText("");
			 txtPh.setText("");
			 }
			catch(Exception ex)
			{JOptionPane.showMessageDialog(this,ex.getMessage());}
			}
			
		}
		 if(e.getSource()==btnBcal)
		  {
			  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtDob.setText(dt);
				try 
				{
					//first check that to is greater than from
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
					Statement st = con.createStatement();
					String sql = "select to_number(months_between('"+txtDoj.getText()+"','"+txtDob.getText()+"')) from dual";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next())
					{
						int nday=(int)(Math.ceil(rs.getDouble(1)*30));
						if(nday<(365*18))
						{   
							JOptionPane.showMessageDialog(null,"Joining date must be greater \n RESET DATE");
						txtDob.setText("");
						//	txtto.setText("");
						}
						else{
						//txtdays.setText(""+nday);
						}
					}
					con.close();
					
				}

				catch(Exception ex)
				{
				JOptionPane.showMessageDialog(this,ex.getMessage());
				}
		  }
		  if(e.getSource()==btnJcal)
		  {
			  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtDoj.setText(dt);
		  }
		   if(e.getSource()==btnClose)
		  {
			 dispose();
		  }
		  if(e.getSource()==btnClear)
		  {
			 txtAddress.setText("");
			 txtDepName.setText("");
			 txtDeptId.setText("");
			 txtDob.setText("");
			 txtDoj.setText("");
			 txtEmail.setText("");
			 txtFname.setText("");
			 txtPan.setText("");
			 txtPh.setText("");
			
		  }
		  if(e.getSource()==btnUpload)
		  {
			  
			 JFileChooser  f1=new JFileChooser();
			  FileNameExtensionFilter filter= new FileNameExtensionFilter("*.Images","jpg","png","jpeg");
              f1.addChoosableFileFilter(filter); 
			  Component modalToComponent = null;
         if (f1.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
        f = f1.getSelectedFile();

        img_path= f.getAbsolutePath();
       image_path=img_path;
      txtphoto.setIcon(new ImageIcon(img_path));
		  }
	}
	}
	
	
	/*class thehandler implements KeyListener
	{
		public void keyPressed(KeyEvent eve){}
		public void keyReleased(KeyEvent eve)
		{
			  try
		   {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		   String sql="select * from employee where eId='"+cbEmpCode.getSelectedItem().toString()+"' ";
		   Statement st=con.createStatement();
		   ResultSet r=st.executeQuery(sql);
		   if(r.next()){
		   String var1=r.getString("ename");
			String var2=r.getString("eDesg");
		   String var3=r.getString("eDid");
		   String var4=r.getString("eDob");
		   String var5=r.getString("eFatherName");
		   String var6=r.getString("eDoj");
		   String var7=r.getString("ePhoneNo");
		   String var8=r.getString("email");
		   String var9=r.getString("eAppntmt");
		   String var10=r.getString("ectgry");
		   String var11=r.getString("eGen");
		   String var12=r.getString("eMstatus");
		   String var13=r.getString("Bgrp");
		   String var14=r.getString("ePan");
		   String var15=r.getString("eAdd");
		   System.out.println(var1);
		  System.out.println(var2);
		  
		   txtName.setText(var1);
		   txtDesg.setText(var2);
		   txtDeptId.setText(var3);
		   txtDob.setText(var4);
		   txtFname.setText(var5);
		   txtDoj.setText(var6);
		   txtPh.setText(var7);
		   txtEmail.setText(var8);
		   cbAppoint.setSelectedItem(var9);
		   cbReserve.setSelectedItem(var10);
		   			cbGen.setSelectedItem(var11);

		   cbMstatus.setSelectedItem(var12);
		   cbBldGrp.setSelectedItem(var13);
			txtPan.setText(var14);
			txtAddress.setText(var15);
		   }
		   
		   r.close();
		   st.close();
		   con.close();
		   
		   }
		   catch(Exception ex)
            {JOptionPane.showMessageDialog(null,ex.getMessage());}
		}
		public void keyTyped(KeyEvent e){}
	}*/
	
	
	public static void main(String arg[])
	{
		new empDetUpdate();
	}
	
}