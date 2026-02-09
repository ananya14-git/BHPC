import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class genInsert extends JFrame implements ActionListener
{
	JComboBox cbStnId, cbStnNm,cbMth,cbYr;
	JTextField txtCapacity, txtDailyGen;
	JLabel lblStnId, lblStnNm, lblCapacity, lblDailyGen, lbl,lblMth,lblYr;
	JButton btnCls, btnAdd, btnBack;
	Dimension screensize;
	JPanel j1;
	genInsert()
	{
		 j1=new JPanel();
		 j1.setLayout(null);
		j1.setBackground(new Color(26,35,126,96));
		Image i=new ImageIcon("fotos\\gen.png").getImage().getScaledInstance(60,40,Image.SCALE_SMOOTH);
		//labels
		lbl=new JLabel("GENERATION ENTRY",new ImageIcon(i),SwingConstants.HORIZONTAL);
		lbl.setBounds(0,0,600,40);
		lbl.setFont(new Font("Tahoma",Font.BOLD,30));
		lbl.setBackground(new Color(26,35,126));
		lbl.setForeground(new Color(24,255,255));
		lbl.setOpaque(true);
		lblStnId=new JLabel("Station Id");
		lblStnId.setBounds(40,70,190,30);
		lblStnId.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblStnNm=new JLabel("Station Name");
		lblStnNm.setBounds(40,120,190,30);
		lblStnNm.setForeground(Color.black);
		lblStnNm.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblCapacity=new JLabel("Capacity(KWH)");
		lblCapacity.setBounds(40,170,190,30);
		lblCapacity.setForeground(Color.black);
		lblCapacity.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblDailyGen=new JLabel("Monthly Generation(KWH)");
		lblDailyGen.setBounds(40,220,250,30);
		lblDailyGen.setFont(new Font("Tahoma",Font.PLAIN,18));		
		lblMth=new JLabel("Month");
		lblMth.setBounds(40,270,190,30);
		lblMth.setFont(new Font("Tahoma",Font.PLAIN,18));	
		lblYr=new JLabel("Year");
		lblYr.setBounds(40,320,190,30);
		lblYr.setFont(new Font("Tahoma",Font.PLAIN,18));
		//textfields
		txtCapacity=new JTextField();
		txtCapacity.setBounds(350,170,150,25);
		txtDailyGen=new JTextField();
		txtDailyGen.setBounds(350,220,150,25);
		//buttons
		btnAdd=new JButton("INSERT");
		btnAdd.setBounds(150,380,80,30);
		btnAdd.addActionListener(this);
		btnCls=new JButton("CLEAR");
		btnCls.setBounds(300,380,80,30);
		btnCls.addActionListener(this);
		btnBack=new JButton("BACK");
		btnBack.setBounds(460,380,80,30);
		btnBack.addActionListener(this);
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
		j1.add(txtCapacity); j1.add(txtDailyGen);
		j1.add(btnCls); j1.add(btnAdd); j1.add(btnBack);
		j1.add(cbStnId); j1.add(cbStnNm); j1.add(lblMth); j1.add(lblYr); j1.add(cbMth); j1.add(cbYr);
		add(j1);
		try
   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select capacity from generation where stnId= '"+cbStnId.getSelectedItem().toString()+"'and genMonth='"+cbMth.getSelectedItem().toString()+"' and genYear='"+cbYr.getSelectedItem().toString()+"' ";
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
				String var=r.getString("capacity");
				txtCapacity.setText(var);
		        txtCapacity.setEditable(false);
				}	
   }
   catch(Exception ex)
   {JOptionPane.showMessageDialog(this,ex.getMessage());}
		txtDailyGen.addKeyListener(new KeyAdapter(){
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
		if(e.getSource()==btnAdd)
		{  
			try
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
			if(txtCapacity.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"enter capacity");
				return;}
				if(txtDailyGen.getText().equals(""))
			{JOptionPane.showMessageDialog(this,"enter capacity");
				return;}
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			int x= Integer.parseInt(txtCapacity.getText());
			int y= Integer.parseInt(txtDailyGen.getText());
			String sql="insert into generation (stnId,stnNm,Capacity,monthlyGen,genMonth,genYear) values('"+cbStnId.getSelectedItem().toString()+"','"+cbStnNm.getSelectedItem().toString()+"',"+x+","+y+",'"+cbMth.getSelectedItem().toString()+"','"+cbYr.getSelectedItem().toString()+"')";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records inserted");
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
			 txtCapacity.setText("");
			 txtDailyGen.setText("");				
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
		new genInsert();
	}
}