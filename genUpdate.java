import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class genUpdate extends JFrame implements ActionListener
{
JComboBox cbStnId, cbStnNm,cbMth,cbYr;
	JTextField txtCapacity, txtMonthlyGen;
	JLabel lblStnId, lblStnNm, lblCapacity, lblDailyGen, lbl,lblMth,lblYr;
	JButton btnCls, btnAdd, btnBack,btnDel,btnShow;
	Dimension screensize;
	JPanel j1;
	genUpdate()
	{
		 j1=new JPanel();
		 j1.setLayout(null);
		j1.setBackground(new Color(26,35,126,96));
		Image i=new ImageIcon("fotos\\gen.png").getImage().getScaledInstance(60,40,Image.SCALE_SMOOTH);
		//labels
		lbl=new JLabel("GENERATION UPDATION",new ImageIcon(i),SwingConstants.HORIZONTAL);
		lbl.setBounds(0,0,600,40);
		lbl.setFont(new Font("Tahoma",Font.BOLD,30));
		lbl.setBackground(new Color(26,35,126));
		lbl.setForeground(new Color(24,255,255));
		lbl.setOpaque(true);
		lblStnId=new JLabel("STATION ID");
		lblStnNm=new JLabel("STATION NAME");
		lblCapacity=new JLabel("CAPACITY(KWH)");
		lblDailyGen=new JLabel("MONTHLY GENERATION(KWH)");
		lblMth=new JLabel("Month");
		lblYr=new JLabel("Year");
		lblStnId.setBounds(40,70,190,30);
		lblStnNm.setBounds(40,120,190,30);
		lblCapacity.setBounds(40,170,190,30);
		lblDailyGen.setBounds(40,220,190,30);
		lblMth.setBounds(40,270,190,30);
		lblYr.setBounds(40,320,190,30);
		lblStnId.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblStnNm.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblCapacity.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblDailyGen.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblMth.setFont(new Font("Tahoma",Font.PLAIN,18));	
		lblYr.setFont(new Font("Tahoma",Font.PLAIN,18));
		//textfields
		txtCapacity=new JTextField();
		txtCapacity.setBounds(350,170,150,25);
		txtMonthlyGen=new JTextField();
		txtMonthlyGen.setBounds(350,220,150,25);
		//buttons
		btnAdd=new JButton("UPDATE");
		btnCls=new JButton("CLEAR");
		btnBack=new JButton("BACK");
		btnDel=new JButton("DELETE");
		btnShow=new JButton("SHOW");
		btnAdd.setBounds(100,380,80,30);
		btnCls.setBounds(230,380,80,30);
		btnBack.setBounds(460,380,80,30);
		btnDel.setBounds(590,380,80,30);
		btnBack.addActionListener(this);
		btnAdd.addActionListener(this);
		btnCls.addActionListener(this);
		btnDel.addActionListener(this);
		btnShow.addActionListener(this);
		//comboboxes
		String stnId[] = {"--select--","1" , "2" , "3" , "4", "5" , "6" , "7" , "8","9" , "10" , "11" , "12", "13" };
		String stnNm[] = {"--select--","KATAIYA" , "VALMIKINAGAR" , "TRIVENI" , "DEHRI", "BARUN" , "AGNOOR" , "DHELABAGH" , "NASRIGANJ","SEBARI" , "JAINAGRA" , "SHRIKHINDA" , "BELSAR", "ARWAL" };
		String mon[] = {"--select--","JAN" , "FEB" , "MAR" , "APR", "MAY" , "JUN" , "JUL" , "AUG", "SEP" , "OCT" , "NOV" , "DEC" };
		String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
        cbStnId = new JComboBox(stnId);
        cbStnNm = new JComboBox(stnNm);
		cbMth=new JComboBox(mon);
		cbYr=new JComboBox(yr);
		cbStnId.setBounds(350,70,150,25);
		cbStnNm.setBounds(350,120,150,25);
		cbMth.setBounds(350,270,150,25);
		cbYr.setBounds(350,320,150,25);
		cbStnId.addActionListener(this);
		//addition
		j1.add(lblStnId); j1.add(lblStnNm); j1.add(lblCapacity); j1.add(lblDailyGen); j1.add(lbl);
		j1.add(txtCapacity); j1.add(txtMonthlyGen);
		j1.add(btnCls); j1.add(btnAdd); j1.add(btnBack); j1.add(lblMth); j1.add(lblYr); j1.add(cbMth); j1.add(cbYr);  j1.add(btnDel);
		j1.add(cbStnId); j1.add(cbStnNm);
		add(j1);	
	txtMonthlyGen.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='.' && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtCapacity.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='.' && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
        screensize=Toolkit.getDefaultToolkit().getScreenSize();     
		j1.setBounds(0,0,600,450);
        setBounds((screensize.width-615)/2,100,600,300);
		//layout
		setSize(600,450);
		setLayout(null);
		setResizable(false);
		//setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnShow)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			String sql1="select * from generation where  stnId= '"+cbStnId.getSelectedItem().toString()+"'and genMonth='"+cbMth.getSelectedItem().toString()+"'and genYr='"+cbYr.getSelectedItem().toString()+"' " ;
		        Statement st=con.createStatement();
		        ResultSet r=st.executeQuery(sql1);
				if(r.next())
				{
					txtCapacity.setText(r.getString("capactity"));
					txtMonthlyGen.setText(r.getString("monthlyGen"));
				}
				else
				{JOptionPane.showMessageDialog(null,"no records found");}
			r.close();
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records updated");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,  ex.getMessage());
			}
		}
		if(e.getSource()==btnAdd)
		{
			if(cbStnId.getSelectedItem().toString().equals("--select--"))
			{
				JOptionPane.showMessageDialog(this,"invalid station id");
				return;
			}
			if(cbStnNm.getSelectedItem().toString().equals("--select--"))
			{
				JOptionPane.showMessageDialog(this,"invalid station name");
				return;
			}
			if(cbMth.getSelectedItem().toString().equals("--select--"))
			{
				JOptionPane.showMessageDialog(this,"invalid month");
				return;
			}
			if(cbYr.getSelectedItem().toString().equals("--select--"))
			{
				JOptionPane.showMessageDialog(this,"invalid year");
				return;
			}
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			int x= Integer.parseInt(txtCapacity.getText());
			int y= Integer.parseInt(txtMonthlyGen.getText());
			String sql="update generation set Capacity= "+x+", monthlyGen="+txtMonthlyGen.getText()+" where stnId= '"+cbStnId.getSelectedItem().toString()+"'and genMonth='"+cbMth.getSelectedItem().toString()+"'and genYear='"+cbYr.getSelectedItem().toString()+"'";
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
			int n= JOptionPane.showConfirmDialog(null,"Are You Sure to Delete","Enter Carefully",JOptionPane.WARNING_MESSAGE);
            if(n==JOptionPane.YES_OPTION){
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="delete from generation where stnId='"+cbStnId.getSelectedItem()+"'and genMonth='"+cbMth.getSelectedItem().toString()+"'and genYr='"+cbYr.getSelectedItem().toString()+"'";
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
		} 
		if(e.getSource()==btnCls)
		{
			cbStnId.setSelectedIndex(0);
			cbStnNm.setSelectedIndex(0);
			 txtCapacity.setText("");
			 txtMonthlyGen.setText("");
			 cbMth.setSelectedIndex(0);
			 cbYr.setSelectedIndex(0);
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
		new genUpdate();
	}
}