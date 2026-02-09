import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class forget extends Frame implements ActionListener
{   
	JLabel lblUserId, lblUserType, lblDob, lblSques,lblSans,lblForget,lblpic;
	 static JTextField txtUserId; 
	JTextField txtDob,txtSans;
	JComboBox cbUserType,cbSques;
	JButton btnClose,btnOk;
	Dimension screensize;
	forget()
	{
		setLayout(null);
		Image img1=new ImageIcon("fotos\\zig.png").getImage().getScaledInstance(550,500,Image.SCALE_SMOOTH);
        lblpic=new JLabel(new ImageIcon(img1));
		lblForget=new JLabel("FORGOT PASSWORD");
		lblForget.setForeground(new Color(200,0,0));
		lblForget.setBounds(150,40,400,50);
		lblForget.setFont(new Font("Tahoma",Font.PLAIN,28));
		lblUserId=new JLabel("User Id");
		lblUserId.setBounds(50,100,150,30);
		lblUserType=new JLabel("User Type");
		lblUserType.setBounds(50,150,150,30);
		lblDob=new JLabel("Date of Birth");
		lblDob.setBounds(50,200,150,30);
		lblSques=new JLabel("Security Question");
		lblSques.setBounds(50,250,150,30);
		lblSans=new JLabel("Security Answer");
		lblSans.setBounds(50,300,150,30);
		lblpic.setBounds(0,0,550,500);
		//textfields
		txtUserId=new JTextField();
		txtUserId.setBounds(200,100,100,30);
		txtSans=new JTextField();
		txtSans.setBounds(200,300,300,30);
		txtDob=new JTextField();
		txtDob.setBounds(200,200,100,30);
		//buttons
		 btnClose=new JButton("CLOSE");
		btnClose.setBounds(300,400,80,30);
		btnClose.addActionListener(this);
		 btnOk=new JButton("PROCEED");
		btnOk.setBounds(150,400,120,30);
		btnOk.addActionListener(this);
		//comboboxes
		String type[] = {"User" , "Admin" };
        cbUserType = new JComboBox(type);
		cbUserType.setBounds(200,150,100,30);
		String ques[]={"Which school you went to as a child?","Which is your favourite color?","Who was your favourite teacher in school?","Which was your favourite cartoon in childhood?","Which lane you lived in childhood?"};
	 cbSques=new JComboBox(ques);
		cbSques.setBounds(200,250,300,30);
		//addition
		add(lblUserId); add(lblUserType);  add(lblDob);  add(lblSques); add(lblSans);
		add(txtUserId);  add(txtDob);  add(txtSans); add(lblForget);
		add(btnClose); add(btnOk);
		add(cbUserType); add(cbSques); add(lblpic);
		//layout
		setSize(500,550);
		setVisible(true);
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screensize.width-550)/2,(screensize.height-500)/2,550,500);
		setTitle("FORGOT PASSWORD");
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnOk)
		{
			if(txtUserId.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"Enter user name");
				return;
		    }
			if(txtDob.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"Enter date of birth");
				return;
		    }
			if(txtSans.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"Enter answer");
				return;
		    }
			try
			{
				  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select userId,secQue,uDob,userType,ans from login where userId='"+txtUserId.getText()+"' and secQue='"+cbSques.getSelectedItem().toString()+"' and uDob='"+txtDob.getText()+"' and userType='"+cbUserType.getSelectedItem().toString()+"' and ans='"+txtSans.getText()+"'";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					change obj=new change();
					dispose();
				}
				else{
						JOptionPane.showMessageDialog(this,"invalid data");
				}
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,ex.getMessage());
			}
		}
		if(e.getSource()==btnClose)
		{
			dispose();
		}
	}
	public static void main(String args[])
	{
		new forget();
	}
}