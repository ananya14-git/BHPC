import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class distUpdate extends JFrame implements ActionListener
{
	JLabel lblStnId, lblStnNm, lblCompNm, lblQnty, lbl, lblMth, lblYr;
	JComboBox cbStnId, cbStnNm, cbCompNm;
	JTextField txtQnty, txtMth, txtYr;
	JButton btnCls, btnAdd, btnBack, btnJcal, btnDel;
	JLabel lblPic, lblPic3;
	Dimension screensize;
	distUpdate()
	{
    	lblPic =new JLabel(new ImageIcon("fotos\\x.jpg"));
	   	lblPic.setBounds(0,-100,600,300);
		lblPic3 =new JLabel(new ImageIcon("fotos\\x1.jpg"));
	   	lblPic3.setBounds(0,200,600,300);
		
		//labels
		lbl=new JLabel("DISTRIBUTION UPDATION");
		lbl.setBounds(60,20,500,35);
		lbl.setFont(new Font("Tahoma",Font.BOLD,35));	
	
		
		lblStnId=new JLabel("STATION ID");
		lblStnId.setBounds(40,70,190,30);
		lblStnId.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblStnNm=new JLabel("STATION NAME");
		lblStnNm.setBounds(40,120,190,30);
		lblStnNm.setForeground(Color.black);
		lblStnNm.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblCompNm=new JLabel("COMPANY NAME");
		lblCompNm.setBounds(40,170,190,30);
		lblCompNm.setForeground(Color.black);
		lblCompNm.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblQnty=new JLabel("QUANTITY");
		lblQnty.setBounds(40,220,190,30);
		lblQnty.setFont(new Font("Tahoma",Font.BOLD,20));		
		lblMth=new JLabel("MONTH");
		lblMth.setBounds(40,270,190,30);
		lblMth.setFont(new Font("Tahoma",Font.BOLD,20));	
		lblYr=new JLabel("YEAR");
		lblYr.setBounds(40,320,190,30);
		lblYr.setFont(new Font("Tahoma",Font.BOLD,20));	

		Image jcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
		Image bcal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
		
		//textfields
		//txtStnNm=new JTextField();
		//txtStnNm.setBounds(250,120,190,30);
		//txtCompNm=new JTextField();
		//txtCompNm.setBounds(250,170,190,30);
		txtQnty=new JTextField();
		txtQnty.setBounds(250,220,190,30);
		txtMth=new JTextField();
		txtMth.setBounds(250,270,190,30);
		txtYr=new JTextField();
		txtYr.setBounds(250,320,190,30);
		
		//buttons
		btnAdd=new JButton("UPDATE");
		btnAdd.setBounds(480,170,80,30);
		btnAdd.addActionListener(this);
		btnDel=new JButton("DELETE");
		btnDel.setBounds(480,220,80,30);
		btnDel.addActionListener(this);
		btnCls=new JButton("CLEAR");
		btnCls.setBounds(480,270,80,30);
		btnCls.addActionListener(this);
		btnBack=new JButton("BACK");
		btnBack.setBounds(480,320,80,30);
		btnBack.addActionListener(this);
		
		btnJcal=new JButton(new ImageIcon(jcal));			//pls see this..!! Jcal is not comming..!!
		btnJcal.setBounds(500,270,20,30);
		btnJcal.setContentAreaFilled(false);
		btnJcal.setBorderPainted(false);
		btnJcal.addActionListener(this);
			
		
			
		
		//comboboxes
		String stnId[] = {"","1" , "2" , "3" , "4", "5" , "6" , "7" , "8","9" , "10" , "11" , "12", "13" };
        cbStnId = new JComboBox(stnId);
	
		cbStnId.setBounds(250,70,190,30);
		String stnNm[] = {"","KATAIYA" , "VALMIKINAGAR" , "TRIVENI" , "DEHRI", "BARUN" , "AGNOOR" , "DHELABAGH" , "NASRIGANJ","SEBARI" , "JAINAGRA" , "SHRIKHINDA" , "BELSAR", "ARWAL" };
        cbStnNm = new JComboBox(stnNm);
		cbStnNm.setBounds(250,120,190,30);
		String compNm[] = {"","NORTH BIHAR","SOUTH BIHAR"};
        cbCompNm = new JComboBox(compNm);
		cbCompNm.setBounds(250,170,190,30);
		//cbStnId.addActionListener(this);
		
		//addition
		add(lblStnId); add(lblStnNm); add(lblCompNm); add(lblQnty); add(lbl); add(lblMth); add(lblYr);
		add(txtQnty); add(txtMth); add(txtYr);
		add(cbStnId); add(cbStnNm); add(cbCompNm);
		add(btnCls); add(btnAdd); add(btnBack); add(btnDel);  add(btnJcal); 
		
		add(lblPic);  add(lblPic3);
		
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-615)/2,100,600,300);
		
		//layout
		setSize(600,400);
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{	if(e.getSource()==cbStnId)
		{
			cbStnNm.setSelectedIndex(cbStnId.getSelectedIndex());
		}
		if(e.getSource()==btnAdd)
		{
			if(cbStnId.getSelectedItem().toString().equals(""))
			{
				JOptionPane.showMessageDialog(this,"invalid station id");
				return;
			}
			
			if(cbStnNm.getSelectedItem().toString().equals(""))
			{
				JOptionPane.showMessageDialog(this,"invalid station name");
				return;
			}			
			
		
			
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			int x= Integer.parseInt(txtQnty.getText());
			String sql="update distribution set stnNm='"+cbStnId.getSelectedItem()+"' ,CompNm='"+cbStnNm.getSelectedItem()+"',qty="+x+",dMonth='"+txtMth.getText()+"',dYear='"+txtYr.getText()+"' where stnId='"+cbStnId.getSelectedItem()+"'";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records updated");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,  ex.getMessage());
			}
			
			if(e.getSource()==cbStnId)
			{
				cbStnNm.setSelectedIndex(cbStnId.getSelectedIndex());
			}
		
		}
		
		
		if(e.getSource()==btnDel)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="delete from distribution where stnId='"+cbStnId.getSelectedItem()+"'";
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
			// txtStnNm.setText("");
			 //txtCompNm.setText("");
			  txtQnty.setText("");
			 txtMth.setText("");
			 txtYr.setText("");
		}
		
		 if(e.getSource()==btnJcal)
		  {
			  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtMth.setText(dt);
		  }
		
		if(e.getSource()==btnBack)
		{
			dispose();
		}
		
		
		
	}
	
	public static void main(String args[])
	{
		new distUpdate();
	}
}