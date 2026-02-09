import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;


class payslip extends JFrame implements ActionListener
  {      public static String eid=null;
		 public  static String mon=null;
		  public  static String yr=null;
       TitledBorder title;
       JPanel up,mid,all;
       JLabel lblEid,lblName,lblDept,lblMonth,lblYear;
	   JTextField txtName,txtDept;
	   JComboBox cbEid,cbYear,cbMonth;
	   
	   JButton btnGen ,btnPrint;
	   payslip()
	   {
		  all=new JPanel();
         all.setLayout(null);		  
	    up=new JPanel(); 
		mid=new JPanel(); 
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		title = javax.swing.BorderFactory.createTitledBorder(loweredbevel,"search");
         up.setBorder(title);
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		mid.setBorder(raisedbevel);

		
		Image icn=new ImageIcon("fotos//pslip.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);

		
		up.setBorder(title);
		//up.setBackground(new Color(204,255,255));
	    
	String mth[] = {"--select--","JAN" , "FEB" , "MAR" , "APR", "MAY" , "JUN" , "JUL" , "AUG", "SEP" , "OCT" , "NOV" , "DEC" };
	 String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
	    lblEid=new JLabel("Enter employee id");
	    lblName=new JLabel("Employee Name");
	    lblDept=new JLabel("Department");
	    lblMonth=new JLabel("Month");
	    lblYear=new JLabel("Year");
		btnGen=new JButton("Generate payslip ",new ImageIcon(icn));
		btnPrint=new JButton("Print payslip");
		cbEid=new JComboBox();
		cbMonth=new JComboBox(mth);
		cbYear=new JComboBox(yr);
		txtName=new JTextField();
		txtDept=new JTextField();
	  
      all.setBounds(0,0,600,350);	  
	  up.setBounds(20,0,560,100);
	  mid.setBounds(20,110,560,300);
	   
	   txtName.setEditable(false);
       txtDept.setEditable(false);
	   
	   lblEid.setBounds(30,40,150,30);
	   cbEid.setBounds(190,40,150,30);
	   
	   lblName.setBounds(30,120,100,30);
	   txtName.setBounds(140,120,130,30);
	    
	   lblDept.setBounds(300,120,150,30);
	   txtDept.setBounds(450,120,100,30);
	   
	   lblMonth.setBounds(30,160,100,30);
	   cbMonth.setBounds(140,160,100,30);
	   
	   lblYear.setBounds(300,160,100,30);
	   cbYear.setBounds(450,160,100,30);
	   btnGen.setBounds(150,230,200,50);
		btnPrint.setBounds(400,230,200,50);
	   up.add(lblEid);
	   up.add(cbEid);
	   mid.add(lblName);
	   mid.add(txtName);
	   mid.add(lblDept);
	   mid.add(txtDept);
	   mid.add(lblYear);
	   mid.add(cbYear);
	   mid.add(lblMonth);
	   mid.add(cbMonth);
	   btnGen.addActionListener(this);
	   btnPrint.addActionListener(this);
	   
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
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
	  // thehandler handler=new thehandler();
	  // txtEid.addKeyListener(handler);
	   
	   add(all);
	  add(up);
	   add(mid);
	   add(lblEid);   add(lblDept);   add(lblName);add(lblMonth);   add(lblYear);
	   add(cbEid);    add(txtDept);   add(txtName);   add(cbMonth);  add(cbYear); add(btnGen);
	   
	   all.add(lblEid);   all.add(lblDept);   all.add(lblName); all.add(lblMonth);   all.add(lblYear);
	   all.add(cbEid);    all.add(txtDept);   all.add(txtName);   all.add(cbMonth);  all.add(cbYear); all.add(btnGen); all.add(btnPrint);
	   all.add(up);
	   all.add(mid);
	   setSize(600,350);
	   setLayout(null);
	   setVisible(true);
	   
	   cbEid.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select employee.ename,dname from employee,department where eid='"+cbEid.getSelectedItem().toString()+"' and department.did=employee.edid";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtName.setText(rs.getString("eName"));
						 txtDept.setText(rs.getString("dname"));
                      }
                     else
                     {
				      
                       JOptionPane.showMessageDialog(null,"no such employee");
                     }
                     rs.close();
                     con.close();
                     }
          catch(Exception a)
                    {  JOptionPane.showMessageDialog (null,a.getMessage());  }
			 }
		}
	}
);	
	    }
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnGen)
			{
				eid=cbEid.getSelectedItem().toString();
				mon=cbMonth.getSelectedItem().toString();
				yr=cbYear.getSelectedItem().toString();
				System.out.println(eid);
				new samplePayslip();
				
			}
		}
		
		/*class thehandler implements KeyListener
		{
			public void keyPressed(KeyEvent eve){}
			public void keyReleased(KeyEvent eve)
			{
				
				try
		       {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		        String sql="select * from employee where eId='"+txtEid.getText()+"' ";
		        Statement st=con.createStatement();
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
		        String var1=r.getString("ename");
		        txtName.setText(var1);
		        String var2=r.getString("eDid");
		        txtDept.setText(var2);
		        }
			   
		   
		       r.close();
		       st.close();
		       con.close();
			   }
		      catch(Exception ex)
                  {JOptionPane.showMessageDialog(null,ex.getMessage());}
		   
		   
			}
			
			public void keyTyped(KeyEvent eve){}
		}*/
		
		
		public static void main(String arg[])
		{
			new payslip();
		}
		
}
