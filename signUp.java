import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class signUp extends JFrame implements ActionListener
{
  JLabel lblLogo,lblHead,lblUsrtype,lblUser,lblPass,lblCnfr,picUser,picPass,picCnfr;
  JLabel lblEid,lblDob,lblSques,lblSans,lblCaps,lblWpass,lblWcnfr;
  JTextField txtUser,txtDob,txtSans;
   JButton btnSign, btnCan,btnClear;
  JPasswordField txtPass,txtCnfr;
  JComboBox cbUtype,cbSques,cbEid;
 JLabel lblpic=new JLabel();
  Dimension screensize;
  signUp()
   {
	   setLayout(null);
	   lblUsrtype=new JLabel("Sign up as");
	   lblHead=new JLabel("Create user");
	   lblUser=new JLabel("Username");
	   lblPass=new JLabel("Password");
	   lblCnfr=new JLabel("Confirm PassWord");
	   lblUsrtype=new JLabel("User Type");
	   lblEid=new JLabel("Employee Id");
	   lblDob=new JLabel("Date Of Birth");
	   lblSques=new JLabel("Security Question");
	   lblSans=new JLabel("Security Answer");
	   lblWcnfr=new JLabel();
	   lblWpass=new JLabel();
	  Image img=new ImageIcon("fotos\\zigzag.png").getImage().getScaledInstance(515,600,Image.SCALE_SMOOTH);
     lblpic = new JLabel(new ImageIcon(img));
	 Image img2=new ImageIcon("fotos\\hy.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
     Image img3=new ImageIcon("fotos\\tuser.jpg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	 Image img4=new ImageIcon("fotos\\tpass.jpeg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	 Image img5=new ImageIcon("fotos\\cnfrm.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	 lblLogo = new JLabel(new ImageIcon(img2));
     picUser = new JLabel(new ImageIcon(img3));
     picPass = new JLabel(new ImageIcon(img4));
	 picCnfr=new JLabel(new ImageIcon(img5));
     txtUser = new JTextField();
     txtPass = new JPasswordField();
	 txtCnfr=new JPasswordField();
	 cbEid=new JComboBox();
	 txtDob=new JTextField();
	 txtSans=new JTextField();
	 String type[]={"User","Admin"};
	 cbUtype=new JComboBox(type);
	 String ques[]={"Which school you went to as a child?","Which is your favourite color?","Who was your favourite teacher in school?","Which was your favourite cartoon in childhood?","Which lane you lived in childhood?"};
	 cbSques=new JComboBox(ques);
     btnSign = new JButton("SIGN UP");
     btnCan = new JButton("CANCEL");
	 btnClear=new JButton("CLEAR");
	lblpic.setBounds(0,0,515,600);
     lblLogo.setBounds(0,0,100,100);
	 lblHead.setBounds(100,0,430,100);
	 lblUser.setBounds(50,120,150,30);
	 picUser.setBounds(200,120,30,30);
     txtUser.setBounds(230,120,150,30);
     lblPass.setBounds(50,170,150,30);
	 picPass.setBounds(200,170,30,30);
	 txtPass.setBounds(230,170,150,30);
	 lblCnfr.setBounds(50,220,150,30);
	 picCnfr.setBounds(200,220,30,30);
	 txtCnfr.setBounds(230,220,150,30);
	 lblUsrtype.setBounds(50,270,150,30);
	 cbUtype.setBounds(200,270,180,30);
	 lblEid.setBounds(50,320,150,30);
	 cbEid.setBounds(200,320,180,30);
	 lblDob.setBounds(50,370,150,30);
	 txtDob.setBounds(200,370,180,30);
	 lblSques.setBounds(50,420,150,30);
	 cbSques.setBounds(200,420,300,30);
	 lblSans.setBounds(50,470,150,30);
	 txtSans.setBounds(200,470,180,30);
	 btnSign.setBounds(80,510,100,30);
	 btnCan.setBounds(360,510,100,30);
	 btnClear.setBounds(220,510,100,30);
	 lblWpass.setBounds(390,170,100,30);
	 lblWcnfr.setBounds(390,220,100,30);
     btnSign.addActionListener(this);
     btnCan.addActionListener(this);
     btnClear.addActionListener(this);
	 btnCan.setBackground(new Color(51,51,51));
     btnSign.setBackground(new Color(51,51,51)); btnClear.setBackground(new Color(51,51,51));
	 btnCan.setForeground(new Color(0,255,0));
     btnSign.setForeground(new Color(0,255,0)); btnClear.setForeground(new Color(0,255,0));
	 add(lblLogo); add(lblHead); add(lblUser);  add(picUser); add(txtUser); add(lblPass);  add(picPass); 
	 add(txtPass); add(lblCnfr); add(picCnfr);  add(txtCnfr); add(lblUsrtype); add(cbUtype);  add(lblEid); add(cbEid);
	 add(lblDob); add(txtDob); 
	 add(lblSques); add(cbSques); add(lblSans);  add(txtSans); add(btnSign);  add(btnCan); add(btnCan); add(lblWpass);  add(btnClear);
	 add(lblWcnfr); 
	 add(lblpic);
	 try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select eId from employee order by eId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbEid.addItem(rs.getString("eId"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
     screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(550,180,515,570);
		lblHead.setFont(new Font("Tahoma",Font.PLAIN,50));
        setSize(515,570);
		setUndecorated(true);
        setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {  if (txtUser.getText()=="") 
	   {
	    JOptionPane.showMessageDialog(this,"Enter user name");
		return;
	   }
	   if (txtPass.getText()=="") 
	   {
		    JOptionPane.showMessageDialog(this,"Enter password");
			return;
	   }
	   if (txtCnfr.getText()=="") 
	   {
			    JOptionPane.showMessageDialog(this,"Confirm your password");
				return;
	   }
	   if(txtDob.getText()=="") 
	   {
		         JOptionPane.showMessageDialog(this,"Enter your date of birth");
				 return;
	   }
	   if(txtSans.getText()=="")
	   {
		     JOptionPane.showMessageDialog(this,"Enter answer");
			 return;
	   }
   
	   if(e.getSource()==btnSign)
	   {    lblWpass.setText("");
            lblWcnfr.setText("");
		   if(txtPass.getText().length()<8)
		   {   
				txtPass.setText("");
				txtCnfr.setText("");
			   lblWpass.setText("<html>minimum <br>8 characters</html>");
				lblWpass.setForeground(new Color(0,0,0));
				return;
		   }
		   if(!txtPass.getText().equals(txtCnfr.getText()))
		   {
			   txtCnfr.setText("");
			   lblWcnfr.setText("<html>password<br> mismatch");
			   lblWcnfr.setForeground(new Color(0,0,0));
			   return;
		   }
		       try
			   {
				   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="Select * from login where userId='"+txtUser.getText()+"'";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					JOptionPane.showMessageDialog(this,"User already exists");
					return;
				}
				 sql="insert into login (userId,psswd,userType,eId,uDob,secQue,ans) values ('"+txtUser.getText()+"','"+txtPass.getText()+"','"+cbUtype.getSelectedItem()+"','"+cbEid.getSelectedItem().toString()+"','"+txtDob.getText()+"','"+cbSques.getSelectedItem()+"','"+txtSans.getText()+"')";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"User Created");
			   }
			   catch(Exception ex)
			   {
				   JOptionPane.showMessageDialog(this,ex.getMessage());
			   }
	   }
	   
	   if(e.getSource()==btnCan)
	   {
		   dispose();
	   }
	   if(e.getSource()==btnClear)
	   {
		        txtUser.setText("");
				txtPass.setText("");
				txtCnfr.setText("");
				txtSans.setText("");
				txtDob.setText("");
	   }
   }
  /*public static void main(String args[])
  {
    new signUp();
  }*/
}