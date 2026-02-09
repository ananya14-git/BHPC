import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class leave extends JFrame implements ActionListener
{
	int lvAvailable,lvTaken,rem,getRem;
	String x,y,z;
JLabel lblpic,lblEid, lblleave, lblleaveid, lblfrom, lblto,lbltype,lbldays,lblMth,lblYr;
JTextField txtleaveid, txtfrom,txtto,txtdays;
JButton btnOk,btnClear, btnCan , btnfrom , btnto ;
JComboBox cbType,cbEid,cbMon,cbYr;
Dimension screensize;
leave()
{
	setLayout(null);
	Image scal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image ecal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
    btnOk = new JButton("OK");
	btnClear=new JButton("Clear");
    btnCan = new JButton("CLOSE");
	btnfrom=new JButton(new ImageIcon(scal));
	btnto=new JButton(new ImageIcon(ecal));
	String mth[] = {"--select--","JANUARY" , "FEBRUARY" , "MARCH" , "APRIL", "MAY" , "JUNE" , "JULY" , "AUGUST", "SEPTEMBER" , "OCTOBER" , "NOVEMBER" , "DECEMBER" };
	 String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "" , "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
	cbMon=new JComboBox(mth);
	cbYr=new JComboBox(yr);
	lblEid=new JLabel("Employee Id");
	lblleave = new JLabel("LEAVE DETAILS");
	lblleaveid = new JLabel("Leave ID");
	lblfrom = new JLabel("From");
	lblto=new JLabel("To");
	lbltype = new JLabel("Leave Name");
	lbldays = new JLabel("No. of Leave Days");
	lblMth=new JLabel("Month");
	lblYr=new JLabel("Year");
	txtleaveid = new JTextField();
	txtfrom = new JTextField();
	txtto = new JTextField();
	cbType = new JComboBox();
	txtdays = new JTextField();
	cbEid=new JComboBox();
	txtleaveid.setEditable(false);
	lblleave.setFont(new Font("Britannic",Font.PLAIN,40));
	lblEid.setFont(new Font("Tahoma",Font.PLAIN,15));
	lbltype.setFont(new Font("Tahoma",Font.PLAIN,15));
	lblto.setFont(new Font("Tahoma",Font.PLAIN,15));
	lblfrom.setFont(new Font("Tahoma",Font.PLAIN,15));
	lbldays.setFont(new Font("Tahoma",Font.PLAIN,15));
	lblleaveid.setFont(new Font("Tahoma",Font.PLAIN,15));
	lblleave.setOpaque(true);
	lblleave.setForeground(Color.red);
	lblleave.setBackground(Color.cyan);
	lblleave.setBounds(0,0,600,30);
	lblEid.setBounds(100,60,100,30);
	lblMth.setBounds(100,110,50,30);  
	lblYr.setBounds(350,110,50,30);
	lbltype.setBounds(100,160,100,30);
	lblleaveid.setBounds(100,210,100,30);
	lblfrom.setBounds(100,260,100,30);
	lblto.setBounds(100,310,100,30);
	lbldays.setBounds(100,360,150,30);
	cbEid.setBounds(230,60,150,30);
	cbMon.setBounds(230,110,100,30);
	cbYr.setBounds(430,110,100,30);
	cbType.setBounds(230,160,150,30);
	txtleaveid.setBounds(230,210,150,30);
	txtfrom.setBounds(230,260,150,30);
	txtto.setBounds(230,310,150,30);
	txtdays.setBounds(230,360,150,30);
	btnOk.setBounds(100,410,100,40);
	btnClear.setBounds(250,410,100,40);
	btnCan.setBounds(400,410,100,40);
	btnfrom.setBounds(400,260,30,30);
	btnto.setBounds(400,310,30,30);
	btnOk.addActionListener(this);
	btnClear.addActionListener(this);
	btnCan.addActionListener(this);
	btnfrom.addActionListener(this);
	btnto.addActionListener(this);
 try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select eId from employee order by eId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbEid.addItem(rs.getString("eId"));
  }
  sql="select lvName from lvMaster order by lvName";
  rs=st.executeQuery(sql);
   while(rs.next())
  {
    cbType.addItem(rs.getString("lvName"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
cbType.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select leaveId from lvMaster where lvName = '"+cbType.getSelectedItem().toString()+"'";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtleaveid.setText(rs.getString("leaveId"));
                      }
                     else
                     {
                      JOptionPane.showMessageDialog(null,"no such leave");
                     }
                     rs.close();
                     con.close();
                     }
          catch(Exception a)
                    {  System.out.println(a.getMessage());  }
			 }
		}
	}
	
);
	add(lblEid);  add(cbEid); add(lblleave);add(lblleaveid);add(lblfrom);add(lblto);add(lbltype);add(lbldays);
	add(txtleaveid);add(txtfrom);add(txtto);add(cbType);add(txtdays); add(lblMth); add(lblYr); add(cbMon); add(cbYr);
	add(btnOk);add(btnClear);add(btnCan);add(btnfrom);add(btnto);
	screensize=Toolkit.getDefaultToolkit().getScreenSize();
	setBounds((screensize.width-600)/2,(screensize.height-400)/2,600,550);
       setSize(600,550);
		setVisible(true);
        setResizable(false);
	setTitle("LEAVE DETAILS ENTRY FORM");
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==btnfrom)
		{
				String dt=new DatePicker(new JFrame()).setPickedDate();
				txtfrom.setText(dt);
		}
		if(e.getSource()==btnto)
		{
				String dt=new DatePicker(new JFrame()).setPickedDate();
				txtto.setText(dt);
				try 
				{
					//first check that to is greater than from
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
					Statement st = con.createStatement();
					String sql = "select to_number(months_between('"+txtto.getText()+"','"+txtfrom.getText()+"')) from dual";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next())
					{
						int nday=(int)(Math.ceil(rs.getDouble(1)*30));
						if(nday<0)
						{
							JOptionPane.showMessageDialog(null,"TO-DATE date must be greater \n RESET DATE");
							txtdays.setText("");
							txtto.setText("");
						}
						else{
						txtdays.setText(""+nday);
						}
					}
					con.close();
				}
				catch(Exception ex)
				{
				JOptionPane.showMessageDialog(this,ex.getMessage());
				}
		}
	if (e.getSource() == btnOk)
	{
		String a=txtdays.getText();
		lvTaken=Integer.parseInt(a);
		System.out.println(lvTaken);
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st = con.createStatement();
			String sql="select lvDays from lvMaster where leaveId='"+txtleaveid.getText()+"' ";
			ResultSet r=st.executeQuery(sql);
			if(r.next())
			{
				String b;
				b=r.getString("lvDays");
				System.out.println(b);
				lvAvailable=Integer.parseInt(b);
				System.out.println(lvAvailable);
				rem=lvAvailable-lvTaken;
			}
			String sql1="select remDays,lMon,lYr from leave where leaveId='"+txtleaveid.getText()+"' ";
			ResultSet r1=st.executeQuery(sql1);
			if(r1.next())
			{
				x=r1.getString("remDays");
				y=r1.getString("lMon");
				z=r1.getString("lYr");
				getRem=Integer.parseInt(x);
				if(getRem==0)
				{JOptionPane.showMessageDialog(null,"Cannot take more leave of this type");}
			}
			String sql2 = "insert into leave(eId,leaveId,fromDate,toDate,lvName,noDays,remDays,lMon,lYr) values('"+cbEid.getSelectedItem().toString()+"','"+txtleaveid.getText()+"','"+txtfrom.getText()+"','"+txtto.getText()+"','"+cbType.getSelectedItem().toString()+"','"+txtdays.getText()+"',"+rem+",'"+cbMon.getSelectedItem().toString()+"','"+cbYr.getSelectedItem().toString()+"')";
			st.executeUpdate(sql2);
			con.close();
			JOptionPane.showMessageDialog(this,"record inserted");
		}

	catch(Exception ex)
	{
	JOptionPane.showMessageDialog(this,ex.getMessage());
	}
}
	if (e.getSource() == btnClear)
	{
		txtleaveid.setText("");
		txtfrom.setText("");
		txtto.setText("");
		txtdays.setText("");
	}
	if(e.getSource()==btnCan)
	{
		dispose();
	}
}
public static void main(String args[])
{
new leave();
}
}