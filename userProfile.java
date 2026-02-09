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


class userProfile extends JFrame
{   
   JLabel lblName,lblDeptId,lblDeptName,lblDesg,lblEmpType,lblFname,lblDob,lblDoj,lblGen,lblBgrp,lblMstatus,lblPan,lblEmail,lblPh,lblAdd, lblPro,lblphoto;
    JTextField txtName,txtDeptId,txtDeptName,txtDesg,txtEmpType,txtFname,txtDob,txtDoj,txtGen,txtBgrp,txtMstatus,txtPan,txtEmail,txtPh,txtAdd;
	JButton btnUpload;
	Dimension screenSize;
	
		String img_path=null; 
	userProfile()
	{   screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		lblPro=new JLabel("_____________MY PROFILE________________");
		        lblphoto=new JLabel("asdf");
		lblphoto.setBounds(900,80,115,110);
		Image upload=new ImageIcon("fotos\\upload.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
		
		lblPro.setBounds(0,0,screenSize.width-250,50);
		lblName=new JLabel("Name");
		lblName.setBounds(50,100,190,30);
		lblDesg=new JLabel("Designation");
		lblDesg.setBounds(50,140,190,30);
		lblDoj=new JLabel("Date of joining");
		lblDoj.setBounds(50,180,190,30);
		lblEmail=new JLabel("Email Id");
		lblEmail.setBounds(50,220,190,30);

		lblDeptId=new JLabel("Department Id");
		lblDeptId.setBounds(450,100,190,30);
		lblDeptName=new JLabel("Department Name");
		lblDeptName.setBounds(450,140,190,30);
		lblEmpType=new JLabel("Employee type");
		lblEmpType.setBounds(450,180,190,30);

		
		lblFname=new JLabel("Father's name");
		lblFname.setBounds(50,340,190,30);
		lblGen=new JLabel("Gender");
		lblGen.setBounds(50,380,190,30);
		lblMstatus=new JLabel("Marital Status");
		lblMstatus.setBounds(50,420,190,30);
		lblBgrp=new JLabel("Blood group");
		lblBgrp.setBounds(50,460,190,30);
		
		lblDob=new JLabel("Date of birth");
		lblDob.setBounds(450,340,190,30);
		lblPh=new JLabel("Phone number");
		lblPh.setBounds(450,380,190,30);
		lblPan=new JLabel("Pan number");
		lblPan.setBounds(450,420,190,30);
		lblAdd=new JLabel("Address");
		lblAdd.setBounds(450,460,190,30);

		
		//textFields
		txtName=new JTextField();
		txtName.setBounds(150,100,190,30);
		txtDesg=new JTextField();
		txtDesg.setBounds(150,140,190,30);
		txtDoj=new JTextField();
		txtDoj.setBounds(150,180,190,30);
		txtEmail=new JTextField();
		txtEmail.setBounds(150,220,190,30);
		
		txtDeptId=new JTextField();
		txtDeptId.setBounds(580,100,190,30);
		txtDeptName=new JTextField();
		txtDeptName.setBounds(580,140,190,30);
		txtEmpType=new JTextField();
		txtEmpType.setBounds(580,180,190,30);
		
		txtFname=new JTextField();
		txtFname.setBounds(150,340,190,30);
		txtGen=new JTextField();
		txtGen.setBounds(150,380,190,30);
		txtMstatus=new JTextField();
		txtMstatus.setBounds(150,420,190,30);
		txtBgrp=new JTextField();
		txtBgrp.setBounds(150,460,190,30);

		txtDob=new JTextField();
		txtDob.setBounds(580,340,190,30);
		txtPh=new JTextField();
		txtPh.setBounds(580,380,190,30);
		txtPan=new JTextField();
		txtPan.setBounds(580,420,190,30);
		txtAdd=new JTextField();
		txtAdd.setBounds(580,460,190,30);
		
		    btnUpload=new JButton("Browse",new ImageIcon(upload));
			btnUpload.setBounds(750,190,115,20);
		
		//editable
		txtName.setEditable(false);
		txtDeptId.setEditable(false);
		txtDeptName.setEditable(false);
		txtDesg.setEditable(false);
		txtEmpType.setEditable(false);
		txtFname.setEditable(false);
		txtDob.setEditable(false);
		txtDoj.setEditable(false);
		txtGen.setEditable(false);
		txtBgrp.setEditable(false);
		txtMstatus.setEditable(false);
		txtPan.setEditable(false);
		txtEmail.setEditable(false);
		txtPh.setEditable(false);
		txtAdd.setEditable(false);
		//btnUpload.addActionListener(this);
		
		
		try
		       {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		        String sql="select * from employee where eId='"+loginform.usr+"'";
		        Statement st=con.createStatement();
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
		        String var1=r.getString("ename");
		        txtName.setText(var1);
		        String var2=r.getString("eDid");
		        
				
				String var3=r.getString("eDesg");
				txtDesg.setText(var3);
				
				String var4=r.getString("eFatherName");
				txtFname.setText(var4);
			
				String var5=r.getString("ePhoneNo");
				txtPh.setText(var5);
				
				String var6=r.getString("email");
				
				txtEmail.setText(var6);
				String var7=r.getString("eAppntmt");
				txtEmpType.setText(var7);
				
				//String var8=r.getString("eCtgry");
				//txt.setText(var8);
				String var9=r.getString("eGen");
				txtGen.setText(var9);
			
				String var10=r.getString("eMstatus");
				txtMstatus.setText(var10);
			
				String var11=r.getString("eBgrp");
				txtBgrp.setText(var11);
				
				String var12=r.getString("eDoj");
				txtDoj.setText(var12);
			
				String var13=r.getString("ePan");
				txtPan.setText(var13);
				String var14=r.getString("eAdd");
				txtAdd.setText(var14);
			
				String var15=r.getString("eDob");
				txtDob.setText(var15);
				
				img_path=r.getString("image");
				
				lblphoto.setIcon(new ImageIcon(img_path));
		        }
			   
		   
		       r.close();
		       st.close();
		       con.close();
			   }
		      catch(Exception ex)
                  {JOptionPane.showMessageDialog(null,ex.getMessage());}
		   
				
				
				

		//adding
		add(lblName); add(lblDeptId); add(lblDeptName); add(lblDesg); add(lblEmpType); add(lblFname); add(lblDob); add(lblDoj); add(lblGen); add(lblBgrp); add(lblMstatus); add(lblPan); add(lblEmail);
		add(lblPh); add(lblAdd); add(lblphoto);// add(btnUpload);
		
		add(txtName); add(txtDeptId); add(txtDeptName); add(txtDesg); add(txtEmpType); add(txtFname); add(txtDob); add(txtDoj); add(txtGen); add(txtBgrp); add(txtMstatus); add(txtPan); add(txtEmail);
		add(txtPh); add(txtAdd);
		add(lblPro);
		
		//layout
		
		lblPro.setFont(new Font("Tahoma",Font.PLAIN,50));
		lblPro.setBackground(new Color(255,153,153));
		lblPro.setForeground(new Color(153,0,0));
		lblPro.setOpaque(true);
		setLayout(null);
		setSize(screenSize.width-250,screenSize.height-150);
		setVisible(true);
	}
	
	
	public static void main(String arg[])
	{new userProfile();}
}