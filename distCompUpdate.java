import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class distCompUpdate extends JFrame implements ActionListener
{
	JLabel lblStnId, lblStnNm, lblComp, lbl;
	JComboBox cbStnId, cbStnNm,txtComp;
	JTextField  txtStnNm;
	JButton btnCls, btnAdd, btnBack, btnDel;
	JLabel lblPic, lblPic1;
	distCompUpdate()
	{
    	lblPic =new JLabel(new ImageIcon("fotos\\y.jpg"));
	   	lblPic.setBounds(-200,0,600,300);
		lblPic1 =new JLabel(new ImageIcon("fotos\\y.jpg"));
	   	lblPic1.setBounds(200,0,600,300);
		
		//labels
		lbl=new JLabel("UPDATE DISTRIBUTION COMPANY");
		lbl.setBounds(60,10,500,40);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Tahoma",Font.BOLD,25));	
		
		lblStnId=new JLabel("STATION ID");
		lblStnId.setBounds(40,70,190,30);
		lblStnId.setForeground(Color.white);
		lblStnId.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblStnNm=new JLabel("STATION NAME");
		lblStnNm.setBounds(40,120,190,30);
		lblStnNm.setForeground(Color.white);
		lblStnNm.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblComp=new JLabel("COMPANY NAME");
		lblComp.setBounds(40,170,190,30);
		lblComp.setForeground(Color.white);
		lblComp.setFont(new Font("Tahoma",Font.BOLD,20));		
		

		
		//textfields
		//txtStnNm=new JTextField();
		//txtStnNm.setBounds(250,120,190,30);
		String compNm[] = {"","NORTH BIHAR","SOUTH BIHAR"};
		txtComp=new JComboBox(compNm);
		txtComp.setBounds(250,170,190,30);
		
		//buttons
		btnAdd=new JButton("UPDATE");
		btnAdd.setBounds(480,70,80,30);
		btnAdd.addActionListener(this);
		btnDel=new JButton("DELETE");
		btnDel.setBounds(480,120,80,30);
		btnDel.addActionListener(this);
		btnCls=new JButton("CLEAR");
		btnCls.setBounds(480,170,80,30);
		btnCls.addActionListener(this);
		btnBack=new JButton("BACK");
		btnBack.setBounds(480,220,80,30);
		btnBack.addActionListener(this);
	
		
		
		//comboboxes
		String stnId[] = {"--select--","1" , "2" , "3" , "4", "5" , "6" , "7" , "8","9" , "10" , "11" , "12", "13" };
        cbStnId = new JComboBox(stnId);
		cbStnId.setBounds(250,70,190,25);
		String stnNm[] = {"--select--","KATAIYA" , "VALMIKINAGAR" , "TRIVENI" , "DEHRI", "BARUN" , "AGNOOR" , "DHELABAGH" , "NASRIGANJ","SEBARI" , "JAINAGRA" , "SHRIKHINDA" , "BELSAR", "ARWAL" };
        cbStnNm = new JComboBox(stnNm);
		cbStnNm.setBounds(250,120,190,30);
		cbStnId.addActionListener(this);
		
		//addition
		add(lblStnId); add(lblStnNm);  add(lblComp); add(lbl);
		add(txtComp); add(cbStnNm);
		add(btnCls); add(btnAdd); add(btnBack); add(btnDel);
		add(cbStnId); 
		add(lblPic); add(lblPic1); 
		
		//layout
		setSize(600,300);
		setLayout(null);
		setResizable(false);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnAdd)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="update distComp set  CompNm='"+txtComp.getSelectedItem().toString()+"' where stnId= '"+cbStnId.getSelectedItem().toString()+"' and StnNm='"+cbStnNm.getSelectedItem().toString()+"' ";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records updated");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,  ex.getMessage());
			}
		}
		
		if(e.getSource()==btnDel)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="delete from distComp where stnId='"+cbStnId.getSelectedItem()+"'";
			st.executeUpdate(sql);
			st.close();
		    con.close();
			JOptionPane.showMessageDialog(this, "records deleted");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,  ex.getMessage());
			}
		} 
		
		if(e.getSource()==btnCls)
		{
			cbStnId.setSelectedIndex(0);
			cbStnNm.setSelectedIndex(0);
			 txtStnNm.setText("");
			 
			
		}
		
		if(e.getSource()==cbStnId)
		{
			cbStnNm.setSelectedIndex(cbStnId.getSelectedIndex());
		}	
		
		if(e.getSource()==btnBack)
		{
			dispose();
		}
	}
	
	public static void main(String args[])
	{
		new distCompUpdate();
	}
}