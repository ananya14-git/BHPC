import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class empReport extends JFrame implements ActionListener
{
   JButton btn;
   static JTable etab;
   static JScrollPane jsp;
   DefaultTableModel model ;
    empReport()
	{
	btn=new JButton("show");
	btn.setBounds(100,50,100,30);
	btn.addActionListener(this);
	
	String[] col={"Id","Name","Designation","Department id","Father's Name","Mobile No","Appointment","Category","Gender","Marital Status","Blood Group","PAN","Address"};
	model = new DefaultTableModel();
    model.setColumnIdentifiers(col);
	etab=new JTable();
	jsp=new JScrollPane(etab);
	etab.setModel(model);
	jsp.setBounds(100,100,400,300);
	add(btn); add(jsp);
	setLayout(null);
	setSize(500,500);
	setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e)
	{   if(e.getSource()==btn)
		{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con =DriverManager.getConnection("jdbc:odbc:mydsn");
			String sql="select * from employee";
			 Statement ps = con.createStatement();
           ResultSet rs = ps.executeQuery(sql);
		   int i=0;
		   while(rs.next())
		   {
			    String eid="";
     String ename="";
      String desg="";
         String did="";
        String fname="";//String dob="";;
      String ph="";
      String appnt="";
      String ctgry="";
      String gen="";
      String mstatus="";
       String bgrp="";
      String doj="";
      String pan="";
      String add="";
			   
			     eid= rs.getString("eId");
           ename = rs.getString("eName");
           desg = rs.getString("eDesg");
           did = rs.getString("eDid");
           fname=rs.getString("eFatherName");
           ph=rs.getString("ePhoneNo");
           appnt=rs.getString("eAppntmt");
           ctgry=rs.getString("eCtgry");
           gen=rs.getString("eGen");
           mstatus=rs.getString("eMstatus");
           bgrp=rs.getString("eBgrp");
           //doj=rs.getDate("eDoj");    getInt
           pan=rs.getString("ePan");
           add=rs.getString("eAdd");
		   model.addRow(new Object[]{eid,ename,desg,did,fname,ph,appnt,ctgry,gen,mstatus,bgrp,pan,add});
		   i++;
		   }
		   rs.close();
		   ps.close();
		   con.close();
		   
		}
		catch(Exception ex)
		{JOptionPane.showMessageDialog(null,ex.getMessage());}
		}
	}
	
	public static void main(String arg[])
	{
	 new empReport();
	}
}