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

public class revReport extends JPanel
{
  String[] colhead={"STATION ID","STATION NAME","COMPANY NAME","QUANTITY","REVENYE"};
  Object data[][]=new Object[100][10];
  JTable table;
  ResultSet rs;
  private JPanel p1,p2,p;
  private JButton dispall, print, exit, pgSetup;
  private JComboBox cbYr, cbMth;
  private JLabel title,  lblMth,lblYr, lblTotRev,lblGetTotRev;
  
  //private Container cn; 
  String scd,dcd,dnm,ddate,carea,nomp,nomla,stc;
  int i,r;

  PageFormat pageFormat;
  Dimension screensize;
  Connection connection;
  Statement statement;

 public revReport()
 {
        //setTitle("REVENUE REPORT");
        setSize(1000,1000);
        setVisible(true);
        p1=new JPanel();
        p2=new JPanel();
        p=new JPanel();

        setLayout(null);
        //cn=getContentPane();
        //cn.setBackground(new Color(224,232,248));


//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        title =new JLabel("REVENUE Report");
        title.setFont(new Font("Engravers MT", 1, 30));

        title.setForeground(new Color(247,251,249));

        p1.add(title);

		
		
		
		lblMth=new JLabel("MONTH");
		lblMth.setBounds(290,90,100,40);

		lblYr=new JLabel("YEAR");
		lblYr.setBounds(50,90,200,40);
		
		lblTotRev=new JLabel("TOTAL REVENUE");
		lblTotRev.setBounds(150,510,200,40);
		
		lblGetTotRev=new JLabel();
		lblGetTotRev.setBounds(260,510,90,40);
		

        p1.setBackground(new Color(145,210,70));
        add(p1);
        p1.setBounds(0,0,745,50);
		
		String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
		String mon[] = {"--select--","JAN" , "FEB" , "MAR" , "APR", "MAY" , "JUN" , "JUL" , "AUG", "SEP" , "OCT" , "NOV" , "DEC" };
		
        cbYr = new JComboBox(yr);
        cbMth = new JComboBox(mon);
		cbYr.setBounds(350,90,100,30);
		cbMth.setBounds(150,90,130,30);
		
		
       /* cn.add(cbYr);
		cn.add(lblStnNm);
		cn.add(lblTotRev);
		cn.add(lblMth);
		cn.add(cbMth);
		cn.add(lblGetTotRev);*/
		
		add(cbYr);
		
		add(lblTotRev);
	     add(lblMth);
		add(cbMth);
		add(lblGetTotRev);
		add(lblYr);
		

        dispall=new JButton("SHOW REVENUE");
        dispall.setMnemonic('S');
        dispall.addActionListener(new dispallListener());
        dispall.setBounds(110,150,130,25);
        add(dispall);

        pgSetup=new JButton("PAGE SETUP");
        pgSetup.setMnemonic('G');
        pgSetup.addActionListener(new setupListener());
        pgSetup.setBounds(240,150,130,25);
        add(pgSetup);
    
        print=new JButton("PRINT");
        print.setMnemonic('P');
        print.addActionListener(new printListener());
        print.setBounds(370,150,130,25);
        add(print);


        exit=new JButton("EXIT");
        exit.setMnemonic('E');
        exit.setBounds(500,150,130,25);

        //exit.addActionListener(new exitListener());
        add(exit);

    

        screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-750)/2,(screensize.height-550)/2,1000,1000);
        /*setVisible(true);
        setResizable(false);*/
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
			double d=0;
                if(e.getSource()==dispall)
				{
					try
                      {
						String q="",q1="",q2="",q3="",q5="",q4="";
						int i=0;
						rs=statement.executeQuery("select stnId,stnNm,compNm,Qty from distribution where dMonth='"+cbMth.getSelectedItem().toString()+"' and dYear='"+cbYr.getSelectedItem().toString()+"'"); 
						 while(rs.next())
						{
						data[i][0]=rs.getString("stnId");
						data[i][1]=rs.getString("stnNm");
						data[i][2]=rs.getString("compNm");
						String qty=rs.getString("Qty");
						data[i][3]=qty;
						
						int iQty=Integer.parseInt(qty);
						double rev=(iQty*2.79);
						d=d+rev;
						String revenue=String.valueOf(rev);
						data[i][4]=revenue;
						i++;
						}
						//rs1=statement.executeQuery("select sum(Revenue));			
					lblTotRev.setText(""+d);
					table=new JTable(data,colhead);
					table.setFont(new Font("Arial",Font.BOLD,12));
					table.setForeground(Color.blue);
					JScrollPane jsp=new JScrollPane(table);
					jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					jsp.setBounds(110,200,740,302);
					table.setFont(new Font("Arial",Font.BOLD,15));
					table.setShowGrid(false);
					table.setShowVerticalLines(true);
					add(jsp);
					}
					catch(Exception sq)
					{
					JOptionPane.showMessageDialog(null,sq);
					}
				}
				
        }   
 }
 
 	
public void clear()
{
	int i=0;
	
    while(i<100)
    {
        data[i][0]="";
        data[i][1]="";
        data[i][2]="";
        i++;
    }
}
 /*public class exitListener implements ActionListener
 {
     public void actionPerformed(ActionEvent e)
     {
       int n= JOptionPane.showConfirmDialog(null,"Are You Sure","Enter Carefully",JOptionPane.WARNING_MESSAGE);
       if(n==JOptionPane.YES_OPTION)
       
     }

 }*/
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


/* public static void main(String args[])
 {
         revReport s=new  revReport();
 }*/
  
}
 


