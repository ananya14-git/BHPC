import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class mleave extends JFrame implements ActionListener
{
JLabel lblpic,lblEid, lblleave, lblleaveid, lblfrom, lblto,lbltype,lbldays;
JTextField txtleaveid, txtfrom,txtto,txtdays;
JButton btnupdate,btndelete,btnclear, btnclose , btnfrom , btnto,btnFind ;
JComboBox cbType,cbEid;
Dimension screensize;
mleave()
{
	setLayout(null);
	Image scal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image ecal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
    btnupdate = new JButton("Update");
	btnclear=new JButton("Clear");
	btndelete=new JButton("Delete");
    btnclose = new JButton("CLOSE");
	btnFind=new JButton("Find");
	btnfrom=new JButton(new ImageIcon(scal));
	btnto=new JButton(new ImageIcon(ecal));
	lblEid=new JLabel("Employee Id");
	lblleave = new JLabel("LEAVE DETAILS");
	lblleaveid = new JLabel("Leave ID");
	lblfrom = new JLabel("From");
	lblto=new JLabel("To");
	lbltype = new JLabel("Leave Type");
	lbldays = new JLabel("No. of Leave Days");
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
	lblleave.setBounds(0,0,630,30);
	lblEid.setBounds(150,60,100,30);
	lbltype.setBounds(150,110,100,30);
	lblleaveid.setBounds(150,160,100,30);
	lblfrom.setBounds(150,210,100,30);
	lblto.setBounds(150,260,100,30);
	lbldays.setBounds(150,310,150,30);
	cbEid.setBounds(300,60,150,30);
	cbType.setBounds(300,110,150,30);
	txtleaveid.setBounds(300,160,150,30);
	txtfrom.setBounds(300,210,150,30);
	txtto.setBounds(300,260,150,30);
	txtdays.setBounds(300,310,150,30);
	btnFind.setBounds(480,60,100,30);
	btnupdate.setBounds(50,390,100,30);
	btndelete.setBounds(200,390,100,30);
	btnclear.setBounds(350,390,100,30);
	btnclose.setBounds(500,390,100,30);
	btnfrom.setBounds(450,210,30,30);
	btnto.setBounds(450,260,30,30);
	btnFind.addActionListener(this);
	btnupdate.addActionListener(this);
	btnclear.addActionListener(this);
	btnclose.addActionListener(this);
	btndelete.addActionListener(this);
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
  sql="select lvType from lvMaster order by lvType";
   while(rs.next())
  {
    cbType.addItem(rs.getString("lvType"));
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
                      String sql = "select leaveId from lvMaster where leaveId = '"+cbType.getSelectedItem().toString()+"'";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtleaveid.setText(rs.getString("leaveId"));
                      }
                     else
                     {
				      System.out.println("no such leave");
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
	add(txtleaveid);add(txtfrom);add(txtto);add(cbType);add(txtdays);
	add(btnupdate);add(btnclear);add(btnclose);add(btnfrom);add(btnto); add(btndelete); add(btnFind);
	
	screensize=Toolkit.getDefaultToolkit().getScreenSize();
	setBounds((screensize.width-630)/2,(screensize.height-500)/2,630,500);
       setSize(630,500);
		setVisible(true);
        setResizable(false);
		


	setTitle("LEAVE DETAILS MODIFY FORM");
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
		}
	if (e.getSource() == btnupdate)
	{
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st = con.createStatement();
			String sql = "update leave set fromDate='"+txtfrom.getText()+"',toDate='"+txtto.getText()+"',lvType ='"+cbType.getSelectedItem()+"' ,noDays='"+txtdays.getText()+"'  where eId='"+cbEid.getSelectedItem().toString()+"'";
			st.executeUpdate(sql);
			con.close();
			JOptionPane.showMessageDialog(this,"record updated");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,ex.getMessage());
		}
	}
		if(e.getSource()==btndelete)
		{ JOptionPane.showMessageDialog(this,"Sure,to delete?");
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="delete from leave where eId='"+cbEid.getSelectedItem().toString()+"'";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records deleted");
			txtleaveid.setText("");
			txtfrom.setText("");
			txtto.setText("");
			txtdays.setText("");
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(this,  ex.getMessage());
			}
		}
		if (e.getSource() == btnclear)
			{
				txtleaveid.setText("");
				txtfrom.setText("");
				txtto.setText("");
				
				txtdays.setText("");
			}
		if(e.getSource()== btnclose)
		{
			dispose();
		}
		if(e.getSource()== btnFind)
		{
			  try
		   {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		   String sql="select * leave  where eId='"+cbEid.getSelectedItem().toString()+"' ";
		   Statement st=con.createStatement();
		   ResultSet r=st.executeQuery(sql);
		   if(r.next()){
		   
		   txtto.setText("toDate");
		   txtfrom.setText("fromDate");
		   txtdays.setText("noDays");
		   cbType.setSelectedItem("lvType");
		   txtleaveid.setText("leaveId");
		   }
		   r.close();
		   st.close();
		   con.close();
		   }
		   catch(Exception ex)
            {JOptionPane.showMessageDialog(null,ex.getMessage());}
		}
		}
public static void main(String args[])
{
new mleave();
}
}