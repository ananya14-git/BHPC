import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class distCompInsert extends JFrame implements ActionListener
{
	JLabel lblStnId,  lblComp, lbl, lblStnNm;
	JComboBox cbStnId,cbStnNm,txtComp;
	JTextField  txtStnNm;
	JButton btnCls, btnAdd, btnBack;
	JLabel lblPic, lblPic1;
	Dimension screensize;
	distCompInsert()
	{
    	lblPic =new JLabel(new ImageIcon("fotos\\zig.png"));
	   	lblPic.setBounds(-200,0,600,300);
		lblPic1 =new JLabel(new ImageIcon("fotos\\zig1.png"));
	   	lblPic1.setBounds(200,0,600,300);
		
		//labels
		lbl=new JLabel("DISTRIBUTION COMPANY");
		lbl.setBounds(60,10,500,40);
		lbl.setFont(new Font("Tahoma",Font.BOLD,35));	
		
		lblStnId=new JLabel("STATION ID");
		lblStnId.setBounds(40,70,190,30);
		lblStnId.setFont(new Font("Tahoma",Font.BOLD,20));	

		lblStnNm=new JLabel("STATION NAME");
		lblStnNm.setBounds(40,120,190,30);
		lblStnNm.setFont(new Font("Tahoma",Font.BOLD,20));	
		
		
		
		lblComp=new JLabel("COMPANY NAME");
		lblComp.setBounds(40,170,190,30);
		lblComp.setForeground(Color.black);
		lblComp.setFont(new Font("Tahoma",Font.BOLD,20));		
		

		
		//textfields
		//txtStnNm=new JTextField();
		//txtStnNm.setBounds(250,120,190,30);
		String compNm[] = {"","NORTH BIHAR","SOUTH BIHAR"};
		txtComp=new JComboBox(compNm);
		txtComp.setBounds(250,170,190,30);
		
		//buttons
		btnAdd=new JButton("INSERT");
		btnAdd.setBounds(480,70,80,30);
		btnAdd.addActionListener(this);
		btnCls=new JButton("CLEAR");
		btnCls.setBounds(480,120,80,30);
		btnCls.addActionListener(this);
		btnBack=new JButton("BACK");
		btnBack.setBounds(480,170,80,30);
		btnBack.addActionListener(this);
	
		
		
		//comboboxes
		String stnId[] = {"","1" , "2" , "3" , "4", "5" , "6" , "7" , "8","9" , "10" , "11" , "12", "13" };
        cbStnId = new JComboBox(stnId);
		cbStnId.setBounds(250,70,190,25);
		String stnNm[] = {"","KATAIYA" , "VALMIKINAGAR" , "TRIVENI" , "DEHRI", "BARUN" , "AGNOOR" , "DHELABAGH" , "NASRIGANJ","SEBARI" , "JAINAGRA" , "SHRIKHINDA" , "BELSAR", "ARWAL" };
        cbStnNm = new JComboBox(stnNm);
		cbStnNm.setBounds(250,120,190,30);
		cbStnId.addActionListener(this);
		
		
		//addition
		add(lblStnId);  add(cbStnNm);  add(lblComp); add(lbl); add(lblComp);
		add(txtComp); //add(txtStnNm); 
		add(lblStnNm);
		add(btnCls); add(btnAdd); add(btnBack);
		add(cbStnId); add(cbStnNm); 
		add(lblPic); add(lblPic1); 
		
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-600)/2,(screensize.height-300)/2,600,300);
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
			String sql="insert into distComp (stnId,stnNm,CompNm) values('"+cbStnId.getSelectedItem().toString()+"','"+txtStnNm.getText().toString()+"','"+txtComp.getSelectedItem().toString()+"')";
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
		new distCompInsert();
	}
}