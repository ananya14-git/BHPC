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

public class DashLeave extends JFrame 
{
  String[] colhead={"LEAVE ID","DEPARTMENT","FROM","TO","LEAVE NAME","NO.OF DAYS"};
  Object data[][]=new Object[50][10];
  JTable table;
  ResultSet rs,rs1;
  private JPanel p1,p2,p;
  private JButton dispall, print, exit, pgSetup;
  private JComboBox cbMth;
  private JLabel title, lblMth, lblEmpId; 
  private JTextField txtEmpId;
  private Container cn; 
  String scd,dcd,dnm,ddate,carea,nomp,nomla,stc;
  JLabel lbl;
  int i,r;

  PageFormat pageFormat;
  Dimension screensize;
  Connection connection;
  Statement statement;

 public DashLeave()
 {
	 
	// txtEmpId.setText(loginform.usr);
        setTitle("LEAVE REPORT");
        setSize(750,550);
        setVisible(true);
        p1=new JPanel();
        p2=new JPanel();
        p=new JPanel();

        setLayout(null);
        cn=getContentPane();
        cn.setBackground(new Color(224,232,248));
		
		//Image lbl=new ImageIcon(("fotos//bhpc1.jpg").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        title =new JLabel("LEAVE Report");
        title.setFont(new Font("Engravers MT", 1, 30));
        title.setForeground(new Color(247,251,249));
		
		
		p1.add(title);

		lblEmpId=new JLabel("EMPLOYEE ID");
		lblEmpId.setBounds(190,90,200,40);
		
		lblMth=new JLabel("MONTH");
		lblMth.setBounds(390,90,100,40);
		
		txtEmpId=new JTextField();
		txtEmpId.setBounds(280,90,90,30);
		

        p1.setBackground(new Color(145,210,70));
        cn.add(p1);
        p1.setBounds(0,0,745,50);
		
		
		String mon[] = {"","JANUARY" , "FEBRUARY" , "MARCH" , "APRIL", "MAY" , "JUNE" , "JULY" , "AUGUST", "SEPTEMBER" , "OCTOBER" , "NOVEMBER" , "DECEMBER" };
        cbMth = new JComboBox(mon);
		cbMth.setBounds(450,90,100,30);
       	cn.add(lblEmpId);
		cn.add(lblMth);
		cn.add(cbMth);
		cn.add(txtEmpId);
		

        dispall=new JButton("SHOW LEAVE");
        dispall.setMnemonic('S');
        dispall.addActionListener(new dispallListener());
        dispall.setBounds(80,150,190,25);
        cn.add(dispall);

        pgSetup=new JButton("PAGE SETUP");
        pgSetup.setMnemonic('G');
        pgSetup.addActionListener(new setupListener());
        pgSetup.setBounds(270,150,130,25);
        cn.add(pgSetup);
    
        print=new JButton("PRINT");
        print.setMnemonic('P');
        print.addActionListener(new printListener());
        print.setBounds(400,150,130,25);
        cn.add(print);


        exit=new JButton("EXIT");
        exit.setMnemonic('E');
        exit.setBounds(530,150,130,25);

        exit.addActionListener(new exitListener());
        cn.add(exit);

    

        screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-750)/2,(screensize.height-550)/2,750,550);
        setVisible(true);
        setResizable(false);
        connect();

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



public class dispallListener implements ActionListener
{
        
        public void actionPerformed(ActionEvent e)
        {
			try
    {
    	String q="",q1="",q2="",q3="",q5="",q4="";
		int i=0;
        rs=statement.executeQuery("select * from leave  where eId='"+loginform.usr+"' and lmon='"+cbMth.getSelectedItem().toString()+"' "); 
        while(rs.next())
        {
            data[i][0]=rs.getString("leaveId");
            data[i][5]=rs.getString("noDays");
            data[i][4]=rs.getString("lvName");
			data[i][2]=rs.getString("fromDate");
			data[i][3]=rs.getString("toDate");
		rs1=statement.executeQuery("select * from department"); 
		int j=0;
		 while(rs1.next())
        {
            data[j][1]=rs1.getString("dName");
			
        }
            i++;
        }
		            
		
		
		table=new JTable(data,colhead);
        table.setFont(new Font("Arial",Font.BOLD,12));
        table.setForeground(Color.blue);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(0,200,740,302);
		table.setShowGrid(false);
		table.setShowVerticalLines(true);
        cn.add(jsp);
    }
    catch(Exception sq)
    {
        JOptionPane.showMessageDialog(null,sq);
    }
 
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
         DashLeave s=new  DashLeave();
 }
  
}
 


