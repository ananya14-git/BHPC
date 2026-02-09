import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
class distInsert extends JFrame implements ActionListener
{
	JLabel lblStnId, lblStnNm, lblCompNm, lblQnty, lbl, lblMth, lblYr;
	JComboBox cbStnId, cbStnNm, cbCompNm, cbMth, cbYr;
	JTextField txtQnty;
	JButton btnCls, btnAdd, btnBack;
	JLabel lblPic, lblPic3;
	JPanel j1;
	
	Dimension screensize;
	distInsert()
	{
    	//lblPic =new JLabel(new ImageIcon("fotos\\x.jpg"));
	   	//lblPic.setBounds(0,-100,600,300);
		//lblPic3 =new JLabel(new ImageIcon("fotos\\x1.jpg"));
	   	//lblPic3.setBounds(0,200,600,300);
		
		j1=new JPanel();
		j1.setLayout(null);
		j1.setBackground(new Color(255,144,0,96));
		//j1.setBackground(new Color(255,244,130));
		//labels
		 
		Image i=new ImageIcon("fotos\\dist.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
		lbl=new JLabel("DISTRIBUTION ENTRY",new ImageIcon(i),SwingConstants.HORIZONTAL);
		
		lbl.setBounds(15,10,575,35);
		lbl.setFont(new Font("Tahoma",Font.BOLD,30));	
		lbl.setBackground(new Color(255,179,0));
		lbl.setOpaque(true);
		
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
		lblQnty=new JLabel("QUANTITY(KWH)");
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
		String mth[] = {"--select--","JAN" , "FEB" , "MAR" , "APR", "MAY" , "JUN" , "JUL" , "AUG", "SEP" , "OCT" , "NOV" , "DEC" };
		String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
		txtQnty=new JTextField();
		txtQnty.setBounds(250,220,190,30);
		cbMth=new JComboBox(mth);
		cbMth.setBounds(250,270,190,30);
		cbYr=new JComboBox(yr);
		cbYr.setBounds(250,320,190,30);
		
		//buttons
		btnAdd=new JButton("ADD");
		btnAdd.setBounds(480,220,80,30);
		btnAdd.addActionListener(this);
		btnCls=new JButton("CLEAR");
		btnCls.setBounds(480,270,80,30);
		btnCls.addActionListener(this);
		btnBack=new JButton("BACK");
		btnBack.setBounds(480,320,80,30);
		btnBack.addActionListener(this);
		
		
		//comboboxes
		String stnId[] = {"--select--","1" , "2" , "3" , "4", "5" , "6" , "7" , "8","9" , "10" , "11" , "12", "13" };
        cbStnId = new JComboBox(stnId);
		cbStnId.setBounds(250,70,190,25);
		String stnNm[] = {"--select--","KATAIYA" , "VALMIKINAGAR" , "TRIVENI" , "DEHRI", "BARUN" , "AGNOOR" , "DHELABAGH" , "NASRIGANJ","SEBARI" , "JAINAGRA" , "SHRIKHINDA" , "BELSAR", "ARWAL" };
        cbStnNm = new JComboBox(stnNm);
		cbStnNm.setBounds(250,120,190,30);
		String compNm[] = {"--select--","NORTH BIHAR","SOUTH BIHAR"};
        cbCompNm = new JComboBox(compNm);
		cbCompNm.setBounds(250,170,190,30);
		cbStnId.addActionListener(this);
		
		//addition
		j1.add(lblStnId); j1.add(lblStnNm); j1.add(lblCompNm); j1.add(lblQnty); j1.add(lbl); j1.add(lblMth); j1.add(lblYr);
		j1.add(txtQnty); j1.add(cbMth); j1.add(cbYr);
		j1.add(btnCls); j1.add(btnAdd); j1.add(btnBack);
		j1.add(cbStnId); j1.add(cbStnNm); j1.add(cbCompNm); 
		add(j1);
        screensize=Toolkit.getDefaultToolkit().getScreenSize();     
		j1.setBounds(0,0,600,400);
		
        setBounds((screensize.width-615)/2,100,600,300);
		
		txtQnty.addKeyListener(new KeyAdapter(){
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
		
		//layout
		setSize(600,400);
		setLayout(null);
		setResizable(false);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{	if(e.getSource()==cbStnId)
		{
			cbStnNm.setSelectedIndex(cbStnId.getSelectedIndex());
		}
		
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
			
			if(cbCompNm.getSelectedItem().toString().equals("--select--"))
			{
				JOptionPane.showMessageDialog(this,"invalid company name");
				return;
			}
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			int x= Integer.parseInt(txtQnty.getText());
			String sql="insert into distribution (stnId,stnNm,CompNm,qty,dMonth,dYear) values('"+cbStnId.getSelectedItem()+"','"+cbStnNm.getSelectedItem().toString()+"','"+cbCompNm.getSelectedItem().toString()+"',"+x+",'"+cbMth.getSelectedItem().toString()+"','"+cbYr.getSelectedItem().toString()+"')";
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
			 cbCompNm.setSelectedIndex(0);
			 cbStnId.setSelectedIndex(0);
			 cbStnNm.setSelectedIndex(0);
			 txtQnty.setText("");
			 cbMth.setSelectedIndex(0);
			 cbYr.setSelectedIndex(0);
		}
		
		
		
		if(e.getSource()==btnBack)
		{
			dispose();
		}
		
		
		
	}
	
	public static void main(String args[])
	{
		new distInsert();
	}
}