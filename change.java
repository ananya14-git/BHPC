import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class change extends Frame implements ActionListener
{
	JLabel lblUserId, lblNewPass, lblConfirm,  lblComp1,lblComp2,lblChange,lblpic;
	JPasswordField  txtNewPass, txtConfirm;
	JTextField txtUserId;
	JButton btnClose,btnOk;
	Dimension screensize;
	change()
	{
		setLayout(null);
		Image img1=new ImageIcon("fotos\\zig.png").getImage().getScaledInstance(450,300,Image.SCALE_SMOOTH);
        lblpic=new JLabel(new ImageIcon(img1));
		//labels
		lblChange=new JLabel("CHANGE PASSWORD");
		lblChange.setForeground(new Color(200,0,0));
		lblChange.setBounds(100,30,450,50);
		lblChange.setFont(new Font("Tahoma",Font.PLAIN,22));
		lblComp1=new JLabel("*");
		lblComp1.setForeground (new Color(255,0,0));
		lblComp1.setBounds(400,130,10,10);
		lblComp2=new JLabel("*");
		lblComp2.setForeground (new Color(255,0,0));
		lblComp2.setBounds(400,170,10,10);
		lblUserId=new JLabel("USER ID");
		lblUserId.setBounds(50,90,100,30);
		lblNewPass=new JLabel("NEW PASSWORD");
		lblNewPass.setBounds(50,130,100,30);
		lblConfirm=new JLabel("CONFIRM PASSWORD");
		lblConfirm.setBounds(50,170,200,30);
		lblpic.setBounds(0,0,450,300);
		//textboxes
		txtUserId=new JTextField(forget.txtUserId.getText());
		txtUserId.setEditable(false);
		txtUserId.setBounds(200,90,190,30);
		txtNewPass=new JPasswordField();
		txtNewPass.setBounds(200,130,190,30);
		txtConfirm=new JPasswordField();
		txtConfirm.setBounds(200,170,190,30);
		//buttons
		btnOk=new JButton("OK");
		btnOk.setBounds(150,230,80,30);
		btnOk.addActionListener(this);
	    btnClose=new JButton("CLOSE");
		btnClose.setBounds(250,230,80,30);
		btnClose.addActionListener(this);
		//addition
		add(lblUserId); add(lblNewPass); add(lblConfirm);  add(lblComp1); add(lblComp2);
		add(txtUserId); add(txtNewPass); add(txtConfirm); add(lblChange);
		add(btnClose); add(btnOk); add(lblpic);
		//layout
		setSize(450,300);
		setVisible(true);
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screensize.width-450)/2,(screensize.height-300)/2,450,300);
		setTitle("CHANGE PASSWORD");
	}	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnOk)
		{ if(txtUserId.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"invalid userId");
				return;
			}
			if(txtConfirm.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"Confirm password");
				return;
			}
			if(txtNewPass.getText()=="")
			{
				JOptionPane.showMessageDialog(this,"enter new password");
				return;
			}
			 if(!txtNewPass.getText().equals(txtConfirm.getText()))
		   {
			  
			   JOptionPane.showMessageDialog(this," Password Mismatch ");
			   return;
		   }   
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="update  login set psswd='"+txtNewPass.getText()+"'  where userId='"+txtUserId.getText()+"'";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"Password updated");
			     loginform obj= new loginform();
				dispose();
			}
			catch(Exception ex)
			{JOptionPane.showMessageDialog(this,"invalid data");}
		}
		
		if(e.getSource()==btnClose)
		{
			dispose();
		}
	}
	public static void main(String args[])
	{
		new change();
	}
}