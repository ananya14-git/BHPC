import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.lang.StringBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class empDetAdd extends JFrame implements ActionListener
{   int eCode;
	Dimension screenSize;  File f;
	String img_path=null; String image_path = null;
	static JTable show;  static String panRegrex;
	JScrollPane jsp;
    DefaultTableModel model ;
	JLabel lblEmpCode, lblName, lblDeptId, lblDesg,lblDepName,  lblDob, lblFname, lblDoj,lblLogo;
	JLabel lblPh, lblAddress,lblPan,lblEmail,lblEtype,lblBgrp,lblCtgry,lblGen,lblMstatus;
	JLabel lblempUp;
	JTextField txtEmpCode,txtName, txtDepName, txtDesg, txtDob, txtFname, txtDoj, txtPh, txtAddress,txtPan,txtEmail;
	JLabel lblPic,lblphoto;
	JComboBox cbGen,cbMstatus,cbAppoint ,cbBldGrp,cbReserve,cbDeptId,cbDesg;
	JButton btnClear,btnClose,btnAdd,btnUpload,btnJcal,btnBcal;
	empDetAdd()
    {
		setLayout(null);
	 	screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		String col[]={"Emp Id","Emp Name","Dept Id","Type","Desig","DOJ","Father's Name","Gender","Marriage Status","Category","Email","PAN"};
		model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
	    show=new JTable();
	    int x=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int y=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	    jsp=new JScrollPane(show,x,y);
	    show.setModel(model);
		jsp.setBounds(50,460,815,100);
        lblphoto=new JLabel();
		lblphoto.setBounds(750,80,115,110);
		Image logo=new ImageIcon("fotos\\pro_icon.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		Image upload=new ImageIcon("fotos\\upload.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
		Image save=new ImageIcon("fotos\\sav.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	    Image clear=new ImageIcon("fotos\\clear.jpeg").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	    lblLogo=new JLabel(new ImageIcon(logo));
		lblLogo.setBounds(0,0,50,50);
		String desg[]={"","Multi-tasking Staff","Clerical","Manager","Worker","Engineers"};
        cbDesg=new JComboBox(desg);  
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
	lblDeptId=new JLabel("Department Id");          cbDeptId=new JComboBox();
	lblDeptId.setBounds(50,120,150,20);             cbDeptId.setBounds(200,120,150,20);
	lblDeptId.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	lblDepName=new JLabel("Department name");         txtDepName=new JTextField();
	lblDepName.setBounds(400,120,150,20);             txtDepName.setBounds(550,120,150,20);
	lblDepName.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	txtDepName.setEditable(false);
	lblDesg=new JLabel("Designation");               
	lblDesg.setBounds(50,160,150,20);                cbDesg.setBounds(200,160,150,20);
	lblDesg.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	lblEtype=new JLabel("Employee Type");
	lblEtype.setBounds(400,160,150,20);
	lblEtype.setFont(new Font("Segoe UI Symbol",Font.PLAIN,15));
	String Appoint[] = {"Regular" , "Deputational" , "Contract" , "Agency" };
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
    btnUpload=new JButton("Browse",new ImageIcon(upload));
    btnUpload.setBounds(750,190,115,20);
    btnAdd=new JButton("Add",new ImageIcon(save));
	btnAdd.setBounds(750,320,100,20);
	btnClear=new JButton("Clear",new ImageIcon(clear));
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
	 txtEmpCode.setEditable(false);
	 
	 //adding 
	 btnAdd.addActionListener(this);
	btnClear.addActionListener(this);
	btnClose.addActionListener(this);
	btnUpload.addActionListener(this);
	btnJcal.addActionListener(this);
	btnBcal.addActionListener(this);
	
	
cbDeptId.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select dName from department where dId = '"+cbDeptId.getSelectedItem().toString()+"'";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtDepName.setText(rs.getString("dName"));
                      }
                     else
                     {
				      System.out.println("txtDepName.setText");
                      // JOptionPane.showMessageDialog("no such department");
                     }
                     rs.close();
                     con.close();
                     }
          catch(Exception a)
                    {  System.out.println(a.getMessage());  }
			 }
		}
	}
	
);
//validations
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
/*txtEmail.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		
		char ch=e.getKeyChar();
		if( ch=='@'  && ch=='g' )
		{
			StringBuffer a=new StringBuffer(txtEmail.getText());
			a.append("mail.com");
			txtEmail.setText("");
			txtEmail.setText(a.toString());}
	
	}
});*/

/*txtEmail.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		
		char ch=e.getKeyChar();
		if( ch.isDigit() || ch=='.' )
		{
			StringBuffer a=new StringBuffer(txtEmail.getText());
			a.append("mail.com");
			txtEmail.setText("");
			txtEmail.setText(a.toString());}
	
	}
});
 panRegrex="[A-Z]{5}[0-9]{4}[A-Z]{1}";
Pattern pattern=Pattern.compile(panRegrex);
String panNo=txtPan.getText();
Matcher matcher =pattern.matches(panNo);
if(matcher.matches()){}
else 
  {JOptionPane.showMessageDialog(null,"Wrong pan format");}
	


String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();*/
	
		
     add(lblEmpCode); add(txtEmpCode); add(lblName); add(txtName);     add(lblDeptId); add(cbDeptId);  add(jsp);
	 add(lblDepName); add(txtDepName);
	 add(lblDesg); add(cbDesg);   add(lblDob);add(txtDob);     add(lblDoj);add(txtDoj); add(lblMstatus);
     add(lblPh); add(txtPh);  add(lblAddress);  add(txtAddress);   add(lblBgrp); add(lblCtgry); add(lblEtype); add(lblGen);
	 add(lblFname); add(txtFname); add(cbReserve);
     add(lblEmail);  add(txtEmail);	add(txtPan); add(lblPan);
	 add(lblphoto); add(btnUpload); add(lblLogo);  add(jsp);
     add(cbAppoint); add(cbBldGrp); add(cbGen); add(cbMstatus);	 add(lblempUp); ; add(btnAdd); add(btnClose); add(btnClear);
	 add(btnBcal); add(btnUpload); add(btnJcal);
	  //add(lblPic);
	  
	  try
	  {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select max(srNo)+1 as srNo from employee";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					//System.out.println(rs.getInt("srNo"));
					 eCode=rs.getInt("srNo");
					String eId="EMP-"+String.valueOf(eCode);
					txtEmpCode.setText(eId);
				}
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
	  
	  try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select did from department order by did";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbDeptId.addItem(rs.getString("did"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
       //setLocationRelativeTo(null);
	  setBounds((screenSize.width-910)/2,(screenSize.height-300)/2,910,screenSize.height-200);
	 setSize(910,screenSize.height-200);
	 
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent e)
 {   
	  
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
			
			
			
			
		  if (e.getSource()==btnAdd)
		  { //validations
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
			  try
			  {
				   if(txtName.getText()=="")
	           {JOptionPane.showMessageDialog(this,"Enter name");
				return;
			   }
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="insert into employee(eId,eName,eDesg,eDid,eDob,eFatherName,ePhoneNo,eAppntmt,eCtgry,eGen,eMstatus,eBgrp,eDoj,ePan,eAdd,email,srNo,image) values ('"+txtEmpCode.getText()+"','"+txtName.getText()+"','"+cbDesg.getSelectedItem().toString()+"','"+cbDeptId.getSelectedItem().toString()+"','"+txtDob.getText()+"','"+txtFname.getText()+"','"+txtPh.getText()+"','"+cbAppoint.getSelectedItem().toString()+"','"+cbReserve.getSelectedItem().toString()+"','"+cbGen.getSelectedItem().toString()+"','"+cbMstatus.getSelectedItem().toString()+"','"+cbBldGrp.getSelectedItem().toString()+"','"+txtDoj.getText()+"','"+txtPan.getText()+"','"+txtAddress.getText()+"','"+txtEmail.getText()+"',EmpSeq.nextVal,'"+img_path+"')";
				
				st.executeUpdate(sql);
				sql="select * from employee";
				 ResultSet rs = st.executeQuery(sql);
		   int i=0;
		   while(rs.next())
		   {
			    String eid="";
     String ename="";
      String desg="";
         String did="";
		 String depName="";
		 
		 String dob="";
        String fname="";
      String ph="";
      String appnt="";
      String ctgry="";
      String gen="";
      String mstatus="";
       String bgrp="";
      String doj="";
	  String email="";
	  
      String pan="";
      String add="";
			   
			     eid= rs.getString("eId");
           ename = rs.getString("eName");
           desg = rs.getString("eDesg");
           did = rs.getString("eDid");
           fname=rs.getString("eFatherName");
           ph=rs.getString("ePhoneNo");
           appnt=rs.getString("eAppntmt");
           ctgry=rs.getString("eCtgry");
           gen=rs.getString("eGen");
          mstatus=rs.getString("eMstatus");
           bgrp=rs.getString("eBgrp");
           doj=rs.getString("eDoj");    
		   //dob=rs.getInt("eDob");    
           pan=rs.getString("ePan");
		   email=rs.getString("email");
          // add=rs.getString("eAdd");
		   model.addRow(new Object[]{eid,ename,did,appnt,desg,doj,fname,gen,mstatus,ctgry,email,pan});
		   i++;
		   }
		   rs.close();
				
				
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"records inserted");
			
			  }
			 catch(Exception  a)
			  {
				JOptionPane.showMessageDialog(this,a.getMessage());
			  }
		  }
		  if(e.getSource()==btnClear)
		  {
				
			    txtName.setText("");
				txtDepName.setText("");
				cbBldGrp.setSelectedIndex(0);
				cbAppoint.setSelectedIndex(0);
				cbDeptId.setSelectedIndex(0);
				cbDesg.setSelectedIndex(0);
				cbGen.setSelectedIndex(0);
				cbMstatus.setSelectedIndex(0);
				cbReserve.setSelectedIndex(0);
				txtDob.setText("");
				txtDoj.setText("");
				txtFname.setText("");
				txtPan.setText("");
				txtPh.setText("");
				txtEmail.setText("");
				txtAddress.setText("");
				
				//lblphoto.setIcon(new ImageIcon());
			    lblphoto.setIcon(new ImageIcon(new ImageIcon("fotos\\tuser.jpg").getImage().getScaledInstance(115,110,Image.SCALE_SMOOTH)));
			  	  try
	  {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select max(srNo)+1 as srNo from employee";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					//System.out.println(rs.getInt("srNo"));
					 eCode=rs.getInt("srNo");
					String eId="EMP-"+String.valueOf(eCode);
					txtEmpCode.setText(eId);
				}
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
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
		System.out.println(img_path);
       image_path=img_path;
      lblphoto.setIcon(new ImageIcon(img_path));
//int result =f1.showSaveDialog(null);`
		 }
		  }
		  if(e.getSource()==btnClose)
		  {
			  dispose();
		  }
			  
			  
	  }
	
	public static void main(String arg[])
	{
		new empDetAdd();
	}
	
}