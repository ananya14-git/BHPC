import java.util.*;
import javax.swing.JTable.*;
import java.lang.String;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import java.net.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;
import java.awt.print.*;	
import javax.swing.table.*;
public class leaveRep extends JFrame implements ActionListener
{
	DefaultTableModel  dtm=null;
	int row=0;
  String[] colhead={"LEAVE ID","EMPLOYEE ID","STARTING DATE","ENDING DATE","NO OF DAYS"};
  Object data[][]=new Object[50][13];
  JTable table;
  ResultSet rs,rs1;
  private JPanel p1,p2,p;
  private JButton dispall, print, exit, pgSetup;
  private JComboBox cbDept,cbLeaveName;
  private JLabel title, lblLeaveName, lblDept; 
  
  private Container cn; 
  String scd,dcd,dnm,ddate,carea,nomp,nomla,stc;
  JLabel lbl;
  int i,r;

  PageFormat pageFormat;
  Dimension screensize;
  Connection connection;
  Statement statement;

 public leaveRep()
 {
        
        p1=new JPanel();
        p2=new JPanel();
        p=new JPanel();

        p1.setLayout(null);
        cn=getContentPane();
        setBackground(new Color(224,232,248));
		
		//Image lbl=new ImageIcon(("fotos//bhpc1.jpg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        title =new JLabel("EMPLOYEE REPORT");
        title.setFont(new Font("Engravers MT", 1, 30));
        title.setForeground(new Color(247,251,249));
		
		
		p1.add(title);

		lblLeaveName=new JLabel("Select Leave Name");
		lblDept=new JLabel("Select Deppartment");
		
		
		String s[]={"--select--",};
		
		cbDept=new JComboBox(s);
        cbLeaveName = new JComboBox(s);

		try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn","bas","123");
					  System.out.println("Connected");
                      Statement st = con.createStatement();
                      String sql = "select lvName from lvMaster";
                      ResultSet rs = st.executeQuery(sql);
                      while(rs.next())
                      {
                         cbLeaveName.addItem(rs.getString("lvName"));
                      }
                     }
          catch(Exception a)
                    {  System.out.println("Error"+a.getMessage());  }
	try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn","bas","123");
					  System.out.println("Connected");
                      Statement st = con.createStatement();
                      String sql = "select dname from department";
                      ResultSet rs = st.executeQuery(sql);
                      while(rs.next())
                      {
                         cbDept.addItem(rs.getString("dname"));
                      }
                     }
          catch(Exception a)
                    {  System.out.println("Error"+a.getMessage());  }
	
		lblDept.setBounds(50,90,100,40);
		lblLeaveName.setBounds(310,90,100,40);
		
		
		cbDept.setBounds(160,90,100,30);
		cbLeaveName.setBounds(420,90,100,30);
		
		

        p1.setBackground(new Color(145,210,70));
        cn.add(p1);
        p1.setBounds(0,0,745,50);
		
		
       	p1.add(lblLeaveName);
		p1.add(lblDept);
		
		p1.add(cbDept);
		p1.add(cbLeaveName);
		
		

        dispall=new JButton("SHOW");
        dispall.setMnemonic('S');
        dispall.addActionListener(this);
        dispall.setBounds(80,150,190,25);
        p1.add(dispall);

        pgSetup=new JButton("PAGE SETUP");
        pgSetup.setMnemonic('G');
        pgSetup.addActionListener(new setupListener());
        pgSetup.setBounds(270,150,130,25);
        p1.add(pgSetup);
    
        print=new JButton("PRINT");
        print.setMnemonic('P');
        print.addActionListener(new printListener());
        print.setBounds(400,150,130,25);
        p1.add(print);


        exit=new JButton("EXIT");
        exit.setMnemonic('E');
        exit.setBounds(530,150,130,25);

        exit.addActionListener(new exitListener());
        p1.add(exit);
		table=new JTable();
        table.setFont(new Font("Arial",Font.BOLD,12));
        table.setForeground(Color.blue);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(0,200,740,302);
		table.setShowGrid(false);
		table.setShowVerticalLines(true);
        p1.add(jsp);
    

        screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-750)/2,(screensize.height-550)/2,800,650);
        setVisible(true);
        setResizable(false);
        connect();
        setLayout(null);
        setTitle("EMPLOYEE REPORT");
        //setSize(1000,700);
  }

 public void connect()
 {
        try
        {
                try
                {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        connection=DriverManager.getConnection("jdbc:odbc:mydsn");
                        statement=connection.createStatement();
                }
                catch(Exception ee)
                {
                        JOptionPane.showMessageDialog(null,ee);
                }
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null,"NOT CONNECTED");
        }
 }



      public void actionPerformed(ActionEvent e)
        {
			try
    {
    	String q="",q1="",q2="",q3="",q5="",q4="";
		int i=0;
		System.out.print(row);
		if(row>0)
		{
			for(int j=0;j<=row;j++)
				dtm.removeRow(0);
		}
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        connection=DriverManager.getConnection("jdbc:odbc:mydsn");
        statement=connection.createStatement();
		if(cbLeaveName.getSelectedItem().toString().equals("--select--")&&cbDept.getSelectedItem().toString().equals("--select--"))
       {
			rs=statement.executeQuery("select l.leaveId,l.eid,l.fromdate,l.todate,l.nodays from leave l,employee e,department d where l.eid=e.eid and e.edid=d.did");}
		else if(!cbLeaveName.getSelectedItem().toString().equals("--select--")&&cbDept.getSelectedItem().toString().equals("--select--"))
        {rs=statement.executeQuery("select l.leaveId,l.eid,l.fromdate,l.todate,l.nodays from leave l,employee e,department d where l.eid=e.eid and e.edid=d.did and d.dname='"+cbDept.getSelectedItem().toString()+"'");}/*
		else if(cbLeaveName.getSelectedItem().toString().equals("--select--")&& !cbDept.getSelectedItem().toString().equals("--select--"))
        {rs=statement.executeQuery("select l.leaveId,l.eid,l.fromdate,l.todate,l.nodays from leave l,employee e,department d where l.eid=e.eid and e.edid=d.did and lvName='"+cbLeaveName.getSelectedItem().toString()+"' ");}
		else if(!cbLeaveName.getSelectedItem().toString().equals("--select--")&& !cbDept.getSelectedItem().toString().equals("--select--"))
        {rs=statement.executeQuery("select l.leaveId,l.eid,l.fromdate,l.todate,l.nodays from leave l,employee e,department d where l.eid=e.eid and e.edid=d.did lvName='"+cbLeaveName.getSelectedItem().toString()+"' and dname='"+cbDept.getSelectedItem().toString()+"' ");}*/
		
	
        while(rs.next())
        {
            data[i][0]=rs.getString("leaveId");
            data[i][1]=rs.getString("eId");
            data[i][2]=rs.getString("fromDate");
			data[i][3]=rs.getString("toDate");
			data[i][4]=rs.getString("noDays");
			
            i++;
        }		
		row=i;
		System.out.print(i);
		dtm=new DefaultTableModel(data,colhead);
		table.setModel(dtm);
    }
    catch(Exception sq)
    {
        JOptionPane.showMessageDialog(null,sq);
    }
 
        }    
 
 
 	
public void clear()
{
	int i=0;
	int j=0;
    while(i<100)
    {
        data[i][0]="";
        data[i][2]="";
        data[i][3]="";
		data[i][4]="";
		data[i][5]="";
		data[j][1]="";
        i++;
    }
}
 public class exitListener implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
     {
       int n= JOptionPane.showConfirmDialog(null,"Are You Sure","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(n==JOptionPane.YES_OPTION)
       dispose();
     }

 }
public class printListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
      String cmd = e.getActionCommand();
      if (cmd.equals("PRINT"))
       {
			PrinterJob printJob = PrinterJob.getPrinterJob();
			if (pageFormat == null)
            pageFormat = printJob.defaultPage();
         
			if(printJob.printDialog())
			{
				try
				{
					printJob.print();
				}
				catch (PrinterException exception)
				{
					JOptionPane.showMessageDialog(null, exception);
				}
			}
        }
    }
  }
  

public class setupListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
        String cmd = e.getActionCommand();

      if(cmd.equals("PAGE SETUP"))
      {
        PrinterJob printJob = PrinterJob.getPrinterJob();
         if (pageFormat == null)
            pageFormat = printJob.defaultPage();
         pageFormat = printJob.pageDialog(pageFormat);
      }

   }
} 


 public static void main(String args[])
 {
         leaveRep s=new  leaveRep();
 }
  
}
 


