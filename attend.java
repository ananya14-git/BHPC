import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
class attend extends JFrame  implements ActionListener
{
	JLabel lblpic,lblAttend,lblEmpCode, lblType;
	JTextField txtEmpCode;
	JComboBox cbType;
	JButton btnAttend,btnClose;
	Dimension screensize;
	
	attend()
	{
			setLayout(null);
	Image img=new ImageIcon("fotos\\attend1.png").getImage().getScaledInstance(750,450,Image.SCALE_SMOOTH);
    lblpic = new JLabel(new ImageIcon(img));
	
	

		//labels
		lblpic.setBounds(0,0,750,450);
		lblAttend=new JLabel("ATTENDANCE");
		lblAttend.setForeground(Color.red);
		lblAttend.setFont(new Font("ALGERIAN",Font.BOLD,40));
        lblAttend.setBounds(200,100,500,30);
		lblEmpCode=new JLabel("EMPLOYEE ID");
		lblEmpCode.setBounds(80,150,150,30);
		lblType=new JLabel("TYPE");
		lblType.setBounds(80,200,150,30);
		
		//textboxes
		txtEmpCode=new JTextField(loginform.usr);
		txtEmpCode.setEditable(false);
		txtEmpCode.setBounds(320,150,300,30);
		
		//buttons
		btnAttend=new JButton("CLICK TO MAKE ATTENDANCE");
		btnAttend.setBounds(100,300,250,40);
		btnAttend.addActionListener(this);
		btnClose=new JButton("CLOSE");
		btnClose.setBounds(400,300,100,40);
		btnClose.addActionListener(this);
		
		//comboboxes
		String type[] = {"In-time", "Out-time"};
        cbType = new JComboBox(type);
		cbType.setBounds(320,200,300,30);
		
		//addition
		add(lblAttend);
		add(lblEmpCode); add(lblType);
		add(txtEmpCode);
		add(cbType);
		add(btnClose); add(btnAttend);
		add(lblpic);
		
		
		//layout

		setVisible(true);
		setResizable(false);
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
         setBounds((screensize.width-600)/2,(screensize.height-400)/2,750,450);
       setSize(750,450);
      setTitle("ATTENDANCE FORM");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
  	   
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnAttend)
		{
			
			try 
			{
			 if(txtEmpCode.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"invalid userId");
				return;
			}
				DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
    				String dateString = dateFormat.format(new Date()).toString();
				String status="P";
    				if(cbType.getSelectedItem().toString().equals("In-time"))
				{

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st = con.createStatement();
				String sql = "select * from  attendence where eId='"+txtEmpCode.getText()+"' and attenDate = TO_CHAR(sysdate, 'dd-Mon-yyyy') ";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
				JOptionPane.showMessageDialog(this,"Already Attendance entered...");
				return;
				}
				con.close();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con2 = DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st2 = con2.createStatement();
				
               String sql2 = "insert into attendence (eId,attenDate,inTime,status) values ('"+txtEmpCode.getText()+"', TO_CHAR(sysdate,'dd-Mon-yyyy'), '"+dateString+"','"+status+"' )";
				st2.executeUpdate(sql2);
				
				
				con2.close();
				JOptionPane.showMessageDialog(this,"Attendance successfully made");
				}
				else {
					
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con3 = DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st3 = con3.createStatement();
				String sql3 = "select * from  attendence where eId='"+txtEmpCode.getText()+"' and attenDate= TO_CHAR(sysdate, 'dd-Mon-yyyy') ";
				ResultSet rs3=st3.executeQuery(sql3);
				if(rs3.next())
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con4 = DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st4 = con4.createStatement();
				
             String sql4 = "update attendence set outTime='"+dateString+"' where eId='"+txtEmpCode.getText()+"' and attenDate=TO_CHAR(sysdate, 'dd-Mon-yyyy') ";
				st4.executeUpdate(sql4);
				con4.close();
				JOptionPane.showMessageDialog(this,"Out-Time successfully entered...");
                				
				}
                 				
				else 
				    {
					JOptionPane.showMessageDialog(this,"InTime Attendance not entered.... ");
					}
					

				con3.close();   }
			}

			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,ex.getMessage());
			}
		}
		if (e.getSource() == btnClose)
		{
			dispose();
		}

	}
	
	public static void main(String args[])
	{
		new attend();
	}
}
