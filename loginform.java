import java.sql.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
public class loginform extends JFrame implements ActionListener
{
  public static String nm=null;
  public static String usr=null;
  JLabel lblu,lblp, lbllogin,lbluser,lblpass,lblTitle, lblUtype;
  JComboBox cbUtype;
  JLabel lblpic=new JLabel()
  {
	  public void paintComponent(Graphics g)
	  {
		g.drawImage(new ImageIcon("fotos//zigzag.png").getImage(),0,0,615,330,null);
		g.drawRect(50,60,515,210);
	  }
  };
  JButton btnLogin, btnCan, btnchange;
   static JTextField txtuser;
  JPasswordField txtpass;
  Dimension screensize;
  loginform()
   {
	   lblTitle=new JLabel("SIGN IN");
	   lblTitle.setBounds(101,0,150,80);
	   lblTitle.setFont(new Font("Tahoma",Font.PLAIN,32));
	   lblu=new JLabel("Enter Username");
	   lblp=new JLabel("Enter Password");
	   lblu.setBounds(150,120,100,30);
	   lblp.setBounds(150,160,100,30);
     
	 Image img2=new ImageIcon("fotos//hy.png").getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
     lbllogin = new JLabel(new ImageIcon(img2));
	 Image img3=new ImageIcon("fotos//tuser.jpg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	 Image img4=new ImageIcon("fotos//tpass.jpeg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
     lbluser = new JLabel(new ImageIcon(img3));
     lblpass = new JLabel(new ImageIcon(img4));
     lblpic.setBounds(0,0,615,430);
     
	 
	 lblUtype=new JLabel("User type");
	  String type[]={"Admin","User"};
	 cbUtype=new JComboBox(type);
     txtuser = new JTextField();
     txtpass = new JPasswordField();                   

     btnchange = new JButton("FORGOT PASSWORD?");
     btnLogin = new JButton("LOGIN");
     btnCan = new JButton("CANCEL");
	 btnLogin.setBackground(new Color(0,51,153));
	  btnCan.setBackground(new Color(0,51,153));
	  
     btnLogin.setForeground(Color.white);
     btnchange.setForeground(Color.white);
     
     btnCan.setForeground(Color.white);
	 
	 
     lbllogin.setBounds(0,0,100,100);
	 lblUtype.setBounds(150,80,100,30);
     lbluser.setBounds(278,120,30,30);
     lblpass.setBounds(278,160,30,30);
     btnLogin.setBounds(200,230,100,30);
     btnCan.setBounds(350,230,100,30);
     btnchange.setBounds(200,300,250,20);
	 btnchange.setBorderPainted(false);
	 btnchange.setContentAreaFilled(false);
     txtuser.setBounds(308,120,200,30);
     txtpass.setBounds(308,160,200,30);
	 cbUtype.setBounds(278,80,230,30);
     btnLogin.addActionListener(this);
     btnCan.addActionListener(this);
     btnchange.addActionListener(this);
     
	 add(lbllogin);add(lbluser);add(lblpass);
     add(btnLogin);add(btnchange);add(lblu); add(lblp);  add(lblTitle);   add(lblUtype);  add(cbUtype);
	
	 add(btnCan);add(txtuser);add(txtpass);add(lblpic);
     screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-615)/2,(screensize.height-330)/2,615,330);
		lbllogin.setFont(new Font("Tahoma",Font.PLAIN,50));
        
        setResizable(false);
        setSize(615,330);
        setLayout(null);
		setUndecorated(true);
        setVisible(true);
        setTitle("LOGIN FORM");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent e)
  {
    if(e.getSource() == btnLogin)
    {
		
          try
          {
			   if(txtuser.getText().equals(""))
			   {
				JOptionPane.showMessageDialog(this," enter userid....");
				return;
			   }
			    if(txtpass.getText().equals(""))
			   {
				JOptionPane.showMessageDialog(this," enter password....");
				return;
			   }
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="Select EID from login where userId='"+txtuser.getText()+"' and psswd='"+txtpass.getText()+"' and userType='"+cbUtype.getSelectedItem().toString()+"'";
				ResultSet rs=st.executeQuery(sql);
				 if(rs.next())
				 {
					 if(cbUtype.getSelectedItem().toString().equals("Admin"))
					 {
						
						dashBoard1 obj=new dashBoard1();
						dispose();
				     }
					 else
					 {
						 usr=rs.getString("EID");
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con2=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st2=con2.createStatement();
				
				String sql2="select eName from employee  where eid='"+usr+"' ";
				ResultSet rs2=st2.executeQuery(sql2);
				 if (rs2.next())
				 {
					nm=rs2.getString("eName");
					empDashboard obj=new empDashboard();	  
						 dispose(); 
				 }	
				
						
					 }
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(this,"Invalid UserId or Password");
				 } 
				rs.close();
				st.close();
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
     
    }

	if(e.getSource() == btnCan)
    {
      dispose();
    }
	
	if(e.getSource() == btnchange)          //if someone forgets password
    {
      
	   forget f=new forget();
	   f.setVisible(true);
	   setVisible(false);
    }
  }

  public static void main(String args[])
  {
    new loginform();
  }
}
