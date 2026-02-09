import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;

class samplePayslip extends JFrame
{
  JLabel head,head1,head2,head3,lblMon,lblYr,lblNm,lblDesg,lblDept,lblAllow,lblDed,lblBasic,lblDa,lblHra,lblMed,lblOther,lblGross,lblItax,lblPf,lblGip,lblNet,sampMon,sampYr,sampNm,sampDesg,sampDept,sampAllow,sampDed,sampBasic,sampDa,sampHra,sampOther,sampMed,sampGross,sampItax,sampPf,sampGip,sampNet;
	JLabel lblTotDed,sampTotDed,lblNote ,lblAbDays,lblAbDed,sampAbDays,sampAbDed;
  
  samplePayslip()
  {
  head=new JLabel("BIHAR STATE HYDROELECTRIC POWER CORPORATION LIMITED");
  head1=new JLabel("2nd FLOOR,SONE BHAWAN,BIRCHAND PATEL MARG,PATNA-800001");
  head2=new JLabel("E.P.A.B.X TELEPHONE NO:-0612-2224002,22282667");
  head3=new JLabel("____________________________________________________________________________________________________");
  lblMon=new JLabel("For month:");
  lblYr=new JLabel("Year:");
  lblNm=new JLabel("Salary statement of");
  lblDesg=new JLabel("Designation:");
  lblDept=new JLabel("Department:");
  lblBasic=new JLabel("Basic");
  lblAllow=new JLabel("Admissible:");
  lblDa=new JLabel("Da");
  lblHra=new JLabel("Hra");
  lblMed=new JLabel("Medical");
  lblDed=new JLabel("Deductions");
  lblBasic=new JLabel("Basic");
  lblGross=new JLabel("Gross Salary");
  lblPf=new JLabel("GPF");
  lblGip=new JLabel("GIP");
  lblOther=new JLabel("Other allow");
  lblItax=new JLabel("Income tax");
  lblTotDed=new JLabel("Total Deductions");
  lblNote=new JLabel("<html>*This is a computer generated statement and does not require signature.<br>*Other allow = Transport allow + Driving allow + Washing allow</html>");
  lblAbDays=new JLabel("Absent Days");
  lblAbDed=new JLabel("Absently Deduction");
  lblNet=new JLabel("Net Salary");
  
   sampMon=new JLabel();
  sampYr=new JLabel();
  sampNm=new JLabel();
  sampDesg=new JLabel();
  sampDept=new JLabel();
  sampBasic=new JLabel();
  sampAllow=new JLabel();
  sampDa=new JLabel();
  sampHra=new JLabel();
  sampMed=new JLabel();
  sampOther=new JLabel();
  sampDed=new JLabel();
  sampBasic=new JLabel();
  sampGross=new JLabel();
  sampPf=new JLabel();
  sampGip=new JLabel();
  sampItax=new JLabel();
  sampTotDed=new JLabel();
  sampAbDays=new JLabel();
  sampAbDed=new JLabel();
  sampNet=new JLabel();
  
  head.setBounds(20,0,580,30);
  head1.setBounds(50,40,500,20);
  head2.setBounds(50,60,500,20);
  head3.setBounds(0,80,600,20);
  lblNm.setBounds(50,130,200,20);
  sampNm.setBounds(250,130,150,20);
  lblMon.setBounds(50,160,150,20);
  sampMon.setBounds(210,160,100,20);
  sampYr.setBounds(320,160,200,20);
  lblDept.setBounds(50,190,150,20);
  sampDept.setBounds(200,190,100,20);
  lblDesg.setBounds(350,190,150,20);
  sampDesg.setBounds(500,190,100,20);
  lblAllow.setBounds(150,230,100,20);
  lblDed.setBounds(350,230,100,20);
  lblBasic.setBounds(80,260,80,20);
  sampBasic.setBounds(170,260,100,20);
  lblDa.setBounds(80,290,100,20);
  sampDa.setBounds(180,290,80,20);
  lblHra.setBounds(80,320,100,20);
  sampHra.setBounds(180,320,80,20);
  lblMed.setBounds(80,350,100,20);
  lblOther.setBounds(80,380,100,20);
  sampOther.setBounds(180,380,80,20);
  sampMed.setBounds(180,350,80,20);
  lblPf.setBounds(320,260,80,20);
  sampPf.setBounds(490,260,80,20);
  lblGip.setBounds(320,290,80,20);
  sampGip.setBounds(490,290,80,20);
  lblItax.setBounds(320,320,100,20);
  sampItax.setBounds(490,320,80,20);
  lblGross.setBounds(80,430,100,20);
  sampGross.setBounds(180,430,100,20);
  lblTotDed.setBounds(330,430,150,20);
  sampTotDed.setBounds(480,430,100,20);
  lblNote.setBounds(30,550,550,80);
  lblNet.setBounds(80,460,100,20);
  sampNet.setBounds(180,460,100,20);
  lblAbDays.setBounds(320,350,100,20);
  sampAbDays.setBounds(490,350,80,20);
  lblAbDed.setBounds(320,380,170,20);
  sampAbDed.setBounds(500,380,80,20);
  
  head.setFont(new Font("Britannic",Font.BOLD,17));
  head1.setFont(new Font("Britannic",Font.BOLD,15));  head2.setFont(new Font("Britannic",Font.BOLD,15));
  lblAllow.setFont(new Font("Britannic",Font.BOLD,15)); lblDed.setFont(new Font("Britannic",Font.BOLD,15));
  lblGross.setFont(new Font("Britannic",Font.BOLD,15)); lblTotDed.setFont(new Font("Britannic",Font.BOLD,15));
  lblNet.setFont(new Font("Britannic",Font.BOLD,15));
  lblNm.setFont(new Font("Courier New",Font.PLAIN,15));
   lblMon.setFont(new Font("Courier New",Font.PLAIN,15));
   lblDept.setFont(new Font("Courier New",Font.PLAIN,15));
   lblDesg.setFont(new Font("Courier New",Font.PLAIN,15));
   lblBasic.setFont(new Font("Courier New",Font.PLAIN,15));
   lblDa.setFont(new Font("Courier New",Font.PLAIN,15));
   lblHra.setFont(new Font("Courier New",Font.PLAIN,15));
   lblMed.setFont(new Font("Courier New",Font.PLAIN,15));
   lblOther.setFont(new Font("Courier New",Font.PLAIN,15));
   lblPf.setFont(new Font("Courier New",Font.PLAIN,15));
   lblGip.setFont(new Font("Courier New",Font.PLAIN,15));
   lblItax.setFont(new Font("Courier New",Font.PLAIN,15));
   lblAbDays.setFont(new Font("Courier New",Font.PLAIN,15));
  lblAbDed.setFont(new Font("Courier New",Font.PLAIN,15));
  lblNet.setFont(new Font("Britannic",Font.BOLD,15));
  
  lblNote.setFont(new Font("Courier New",Font.PLAIN,15));
  sampYr.setFont(new Font("Courier New",Font.PLAIN,15));
  sampBasic.setFont(new Font("Courier New",Font.PLAIN,15));
  sampNm.setFont(new Font("Courier New",Font.PLAIN,15));
   sampMon.setFont(new Font("Courier New",Font.PLAIN,15));
   sampDept.setFont(new Font("Courier New",Font.PLAIN,15));
   sampDesg.setFont(new Font("Courier New",Font.PLAIN,15));
   sampDa.setFont(new Font("Courier New",Font.PLAIN,15));
   sampHra.setFont(new Font("Courier New",Font.PLAIN,15));
   sampMed.setFont(new Font("Courier New",Font.PLAIN,15));
   sampOther.setFont(new Font("Courier New",Font.PLAIN,15));
   sampPf.setFont(new Font("Courier New",Font.PLAIN,15));
   sampGip.setFont(new Font("Courier New",Font.PLAIN,15));
   sampItax.setFont(new Font("Courier New",Font.PLAIN,15));
   sampAbDays.setFont(new Font("Courier New",Font.PLAIN,15));
  sampAbDed.setFont(new Font("Courier New",Font.PLAIN,15));
  sampNet.setFont(new Font("Britannic",Font.BOLD,15));
  sampGross.setFont(new Font("Britannic",Font.BOLD,15));
  sampTotDed.setFont(new Font("Britannic",Font.BOLD,15));
  
    add(head); add(lblMon); add(lblYr); add(lblNm); add(lblDesg);  add(lblDept); add(lblBasic); add(lblAllow); add(lblDa); 
	add(lblHra); add(lblMed);  add(lblDed); add(lblBasic); add(lblGross); add(lblPf); add(lblGip); add(lblOther); add(lblItax);
	add(lblNote); add(lblTotDed); add(sampTotDed); add(lblAbDays); add(lblAbDed); add(sampAbDays); add(sampAbDed);
	add(sampMon); add(sampYr); add(sampNm); add(sampDesg);  add(sampDept); add(sampBasic); add(sampAllow); add(sampDa); 
	add(sampHra); add(sampMed);  add(sampDed); add(sampBasic); add(sampGross); add(sampPf); add(sampGip);  add(sampOther);  add(sampItax);
    add(head1);  add(head2); add(head3); add(lblNet); add(sampNet);
	
    setLayout(null);
    setSize(600,1000);
	setVisible(true);
  
     try{
		 
		 String ecode=payslip.eid;
		 String  month=payslip.mon;
		 String  year=payslip.yr;
		 System.out.println(ecode);
		 System.out.println(month);
		 System.out.println(year);
		 
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select basic,smonth,syear,da,hra,gip,gpf,allowance,netpay,total,totded,eName,dName,edesg from salary,employee,department where employee.eId=salary.eId and department.did=employee.eDid and salary.eId='"+ecode+"'and smonth='"+month+"' and syear='"+year+"'"; 
ResultSet rs = st.executeQuery(sql);
  if(rs.next())
  {
	  sampNm.setText(rs.getString("ename"));
	  sampDept.setText(rs.getString("dname"));
    sampBasic.setText(rs.getString("basic"));
	 sampMon.setText(rs.getString("smonth"));
	 sampYr.setText(rs.getString("syear"));
	 sampDa.setText(rs.getString("da"));
	  sampHra.setText(rs.getString("hra"));
	    sampDesg.setText(rs.getString("eDesg"));
	   sampGip.setText(rs.getString("gip"));
	    sampPf.setText(rs.getString("gpf"));
		sampAllow.setText(rs.getString("allowance"));
		sampNet.setText(rs.getString("netpay"));
		sampGross.setText(rs.getString("total"));
		sampTotDed.setText(rs.getString("totded"));
		
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
  
  }
  public static void main(String arg[])
  {new samplePayslip();}
}