import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
class salMaster extends JFrame implements ActionListener
  {    Dimension screenSize; 
       double basic,da,hra,gpf,gip,allow,med,wash,drv,ta,gross,net,ded,loan,adv;
	   String DA,HRA,GPF,GIP,MED,WAS,DRV,TRANS;
	   double a,b,c,d, x,y,z,w;
       TitledBorder upTitle,leftTitle,rightTitle;
       JPanel up,left,right;
       JLabel lblHeading,lblEid,lblDeptId,lblName,lblDesg,lblEmpType,lblBasic,lblMonth,lblYear,lblDa,lblHra,lblMedical,lblAdditional,lblGpf,lblGip,lblLeave,lblLvDed,lblLoan,lblAdv,lblTotDed,lblGross,lblNet,lblGetTotDed,lblGetNet,lblGetGross;
	   JTextField  txtDeptNm, txtName, txtDesg, txtEmpType, txtBasic, txtYear, txtDa, txtHra, txtMedical, txtAdditional, txtGpf, txtGip, txtLeave, txtLvDed, txtLoan,txtAdv;
	   JComboBox cbMth, cbYear;
	   JCheckBox chk;
	   JComboBox cbEid;
	   JButton find, back,calc,ins,clear;
	   salMaster()
	   { screenSize=Toolkit.getDefaultToolkit().getScreenSize();  	  
	    up=new JPanel(); 
		left=new JPanel(); 		
		right=new JPanel(); 
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		upTitle = javax.swing.BorderFactory.createTitledBorder(loweredbevel,"search");
		leftTitle = javax.swing.BorderFactory.createTitledBorder(loweredbevel,"Allowance");
		rightTitle = javax.swing.BorderFactory.createTitledBorder(loweredbevel,"Deduction");
         up.setBorder(upTitle);
		 left.setBorder(leftTitle);
		 right.setBorder(rightTitle);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Image icn=new ImageIcon("fotos//pslip.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
		lblHeading=new JLabel("_____Salary Master_____");
	    lblEid=new JLabel(" Employee id");
		lblDeptId=new JLabel("Department id");
	    lblName=new JLabel("Employee Name");
	    lblDesg=new JLabel("Designation");
		lblEmpType=new JLabel("Employee Type");
		lblBasic=new JLabel("Basic");
	    lblMonth=new JLabel("Month");
	    lblYear=new JLabel("Year");
		lblDa=new JLabel("DA");
		lblHra=new JLabel("HRA");
		lblMedical=new JLabel("Medical");
		lblAdditional=new JLabel("Additional");
		lblGpf=new JLabel("GPF");
		lblGip=new JLabel("GIP");
		lblLeave=new JLabel("Leave days");
		lblLvDed=new JLabel("Leave deduction");
		lblLoan=new JLabel("Loan Amount");
		lblAdv=new JLabel("Advance Amount");
		lblTotDed=new JLabel("Total Deduction");
		lblGross=new JLabel("Gross Salary");
		lblNet=new JLabel("Net Amount Payable");
		lblGetGross=new JLabel("S");
		lblGetNet=new JLabel("H");
		lblGetTotDed=new JLabel("T");
		chk=new JCheckBox("Check for loan/advance");
		cbEid=new JComboBox();
		txtDeptNm=new JTextField();
		txtName=new JTextField();
		txtDesg=new JTextField();
		txtBasic=new JTextField();
		txtEmpType=new JTextField();
		cbMth=new JComboBox();
		cbYear=new JComboBox();
		txtDa=new JTextField();
		txtHra=new JTextField();
		txtMedical=new JTextField();
		txtAdditional=new JTextField();
		txtGpf=new JTextField();
		txtGip=new JTextField();
		txtLeave=new JTextField();
		txtLvDed=new JTextField();
		txtLoan=new JTextField("0.0");
		txtAdv=new JTextField("0.0");
		txtBasic.setEditable(false);
		find=new JButton("FIND");
		find.setBounds(380,20,80,20);
		back=new JButton("BACK");
		back.setBounds(990,530,80,30);
		calc=new JButton("CALCULATE");
		ins=new JButton("INSERT");
		ins.setBounds(700,530,80,30);
	   clear=new JButton("CLEAR");
	   clear.setBounds(830,530,80,30);
	  up.setBounds(20,70,1080,100);
	  left.setBounds(20,240,450,200);
	   right.setBounds(560,240,500,200);
	   txtName.setEditable(false);
       txtDesg.setEditable(false);
	   txtEmpType.setEditable(false);
	   txtDeptNm.setEditable(false);
	    lblHeading.setBounds(0,0,screenSize.width-250,50);
	    lblHeading.setFont(new Font("Tahoma",Font.PLAIN,40));
		lblHeading.setBackground(new Color(255,153,153));
		lblHeading.setForeground(new Color(153,0,0));
		lblHeading.setOpaque(true);
		lblHeading.setVerticalAlignment(SwingConstants.TOP);
	   lblEid.setBounds(30,20,100,20);
	   cbEid.setBounds(140,20,100,20);
	   lblDeptId.setBounds(30,60,100,20);  
	   txtDeptNm.setBounds(140,60,100,20);  
	   lblName.setBounds(290,60,120,20); 
	   txtName.setBounds(410,60,120,20);    
	   lblDesg.setBounds(580,60,80,20);  
	   txtDesg.setBounds(660,60,100,20);   
	   lblEmpType.setBounds(810,60,120,20);  
	   txtEmpType.setBounds(930,60,100,20); 
	   lblBasic.setBounds(50,200,80,20);
	   txtBasic.setBounds(130,200,100,20);
	   lblMonth.setBounds(500,200,80,20);
	   	String mth[] = {"--select--","JAN" , "FEB" , "MAR" , "APR", "MAY" , "JUN" , "JUL" , "AUG", "SEP" , "OCT" , "NOV" , "DEC" };
        cbMth = new JComboBox(mth);
		cbMth.setBounds(580,200,100,20);	   
	   lblYear.setBounds(700,200,80,20);
	    String yr[] = {"--select--","2010" , "2011" , "2012" , "2013", "2014" , "2015" , "2016" , "2017", "2018" , "2019" , "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" };
        cbYear = new JComboBox(yr);
	   cbYear.setBounds(780,200,100,20);
	   lblGross.setBounds(50,440,100,20);
	   lblGetGross.setBounds(150,440,100,20);
	   lblTotDed.setBounds(600,440,150,20);
	    lblGetTotDed.setBounds(760,440,100,20);
	   lblNet.setBounds(30,530,190,20);
	   lblGetNet.setBounds(170,530,100,20);
	   calc.setBounds(300,200,150,20);
		lblDa.setBounds(40,20,80,20);
		txtDa.setBounds(150,20,150,20);
		lblHra.setBounds(40,55,80,20);
		txtHra.setBounds(150,55,150,20);
		lblMedical.setBounds(40,90,80,20);
		txtMedical.setBounds(150,90,150,20);
		lblAdditional.setBounds(40,125,80,20);
		txtAdditional.setBounds(150,125,150,20);
		lblGip.setBounds(40,20,50,20);
		txtGip.setBounds(120,20,100,20);
		lblGpf.setBounds(270,20,50,20);
		txtGpf.setBounds(390,20,100,20);
		lblLeave.setBounds(40,55,80,20);
		txtLeave.setBounds(120,55,100,20);
		lblLvDed.setBounds(270,55,110,20);
		txtLvDed.setBounds(390,55,100,20);
		chk.setBounds(40,90,200,20);
		lblLoan.setBounds(270,90,150,20);    lblAdv.setBounds(250,125,150,20);
		txtLoan.setBounds(390,90,100,20);		txtAdv.setBounds(390,125,100,20);
		lblEid.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblDeptId.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblEmpType.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblDesg.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblName.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblBasic.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblAdditional.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblMonth.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblYear.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblMedical.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblDa.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblHra.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblGip.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblGpf.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblGross.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblLeave.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblLvDed.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblLoan.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblAdv.setFont(new Font("Tahoma",Font.PLAIN,15));
		chk.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblNet.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblTotDed.setFont(new Font("Tahoma",Font.PLAIN,15));
		lblGetGross.setForeground(new Color(0,0,204));
		lblGetNet.setForeground(new Color(0,0,204));
		lblGetTotDed.setForeground(new Color(0,0,204));
	   up.setLayout(null);    left.setLayout(null);  right.setLayout(null);
	   up.add(lblEid);  up.add(find);  up.add(cbEid); add(back);
	   up.add(lblDeptId);   up.add(txtDeptNm);   up.add(lblName);  up.add(txtName);   up.add(lblDesg);
	   up.add(txtDesg);    up.add(lblEmpType);   up.add(txtEmpType);   up.add(lblYear);  
	   up.add(lblMonth);  
	   left.add(lblDa);   left.add(lblHra);   left.add(lblMedical);   left.add(txtDa);   left.add(txtHra);  left.add(txtMedical);
	   left.add(txtAdditional); left.add(lblAdditional);
	   right.add(lblGip);  right.add(txtGip);  right.add(lblGpf);  right.add(txtGpf);  right.add(lblLeave); right.add(chk); 
	   right.add(txtLeave);  right.add(txtLvDed);  right.add(lblLvDed);  right.add(lblLoan);  right.add(txtLoan);   right.add(lblAdv);  right.add(txtAdv);
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
}
catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
	  find.addActionListener(this);
	  calc.addActionListener(this);
	  ins.addActionListener(this);
	   clear.addActionListener(this);
	  chk.addActionListener(this);
	  add(up);
	    add(left);add(right); add(lblHeading);
	   add(lblBasic); add(lblMonth); add(lblYear); 
	   add(txtBasic); add(cbMth); add(cbYear);  add(calc);
	    add(lblTotDed); add(lblGross); add(lblNet);
	      add(lblGetGross); add(lblGetNet); add(lblGetTotDed);    add(ins); add(clear);
		  setBounds((screenSize.width-250)/2,(screenSize.height-150)/2,250,screenSize.height-150);
	   setLayout(null);
	   setSize(screenSize.width-250,screenSize.height-150);
	   setVisible(true);
	    }
		public void actionPerformed(ActionEvent e)
		{	
			if(e.getSource()==back)
			{
				dispose();
			}
			if(e.getSource()==find)
			{
				try
		       {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
		        String sql="select  employee.eName as eName,dName,employee.eAppntmt as eAppntmt,employee.eDesg as eDesg from employee,department where eid='"+cbEid.getSelectedItem().toString()+"' and department.did=employee.edid";
		        Statement st=con.createStatement();
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
		        String var1=r.getString("eName");
		        txtName.setText(var1);
		        String var2=r.getString("eDesg");
		        txtDesg.setText(var2);
				String var3=r.getString("eAppntmt");
				txtEmpType.setText(var3);
				txtDeptNm.setText(r.getString("dName"));
		        }
			   r.close();
			   st.close();
			   con.close();
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con1 = DriverManager.getConnection("jdbc:odbc:mydsn");
		        String sql1="select basic  from scale where eAppntmt='"+txtEmpType.getText()+"' and Desg='"+txtDesg.getText()+"'" ;
		        Statement st1=con1.createStatement();
		        ResultSet r1=st1.executeQuery(sql1);
				if(r1.next())
				{
					txtBasic.setText(r1.getString("basic"));
				}
		       r1.close();
		       st1.close();
		       con1.close();
			   }
		      catch(Exception ex)
                  {JOptionPane.showMessageDialog(null,ex.getMessage());}
			}
			if(e.getSource()==calc)
			{ try{
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
				 String sql1="select * from scale where eAppntmt='"+txtEmpType.getText()+"' and Desg='"+txtDesg.getText()+"'" ;
		        Statement st1=con.createStatement();
		        ResultSet r1=st1.executeQuery(sql1);
				if(r1.next())
				{
					DA=r1.getString("da");
					HRA=r1.getString("hra");
					GIP=r1.getString("gip");
					GPF=r1.getString("gpf");
					MED=r1.getString("medAllow");
					WAS=r1.getString("washAllow");
					TRANS=r1.getString("transAllow");
					DRV=r1.getString("drivAllow");
					 basic=Double.parseDouble(txtBasic.getText());
					  loan=Double.parseDouble(txtLoan.getText());
					  adv=Double.parseDouble(txtAdv.getText());
					 x=Double.parseDouble(DA);
					 y=Double.parseDouble(HRA);
					 z=Double.parseDouble(GIP);
					 w=Double.parseDouble(GPF);
					 a=Double.parseDouble(MED);
					 b=Double.parseDouble(WAS);
					 c=Double.parseDouble(DRV);
					 d=Double.parseDouble(TRANS);
					 da=basic *x/100;
					hra=basic *y/100;
					gip=basic *z/100;
					gpf=basic *w/100;
				    med=a;
					allow=b+c+d;
					gross=basic+allow+med;
					ded=gip+gpf+loan+adv;
					net=gross-ded;
					txtDa.setText(String.valueOf(da));
					txtHra.setText(String.valueOf(hra));
					txtAdditional.setText(String.valueOf(allow));
					txtMedical.setText(String.valueOf(med));
					lblGetGross.setText(String.valueOf(gross));
					lblGetNet.setText(String.valueOf(net));
					txtGip.setText(String.valueOf(gip));
					txtGpf.setText(String.valueOf(gpf));
					lblGetTotDed.setText(String.valueOf(ded));
				}
		       r1.close();
		       st1.close();
		       con.close();
			}
			catch(Exception ex)
			{JOptionPane.showMessageDialog(this,ex.getMessage());}
		
			}
			if(e.getSource()==ins)
			{
				try
                 {
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
              Statement st = con.createStatement(); 
			 String sql = "insert into salary(eId,sMonth,sYear,basic,da,allowance,hra,total,gpf,gip,loan,totded,netpay) values('"+cbEid.getSelectedItem().toString()+"','"+cbMth.getSelectedItem().toString()+"','"+cbYear.getSelectedItem().toString()+"',"+txtBasic.getText()+","+txtDa.getText()+","+txtAdditional.getText()+","+txtHra.getText()+","+lblGetGross.getText()+","+txtGpf.getText()+","+txtGip.getText()+","+txtLoan.getText()+","+lblGetTotDed.getText()+", "+lblGetNet.getText()+")"; 
              st.executeUpdate(sql);
              con.close();
              JOptionPane.showMessageDialog(this,"record inserted");
              }
              catch(Exception ex)
               {JOptionPane.showMessageDialog(this,ex.getMessage());}
			}
           if(e.getSource()==clear)
			{
              txtDeptNm.setText("");
			  txtName.setText("");
			  txtDesg.setText("");
			  txtEmpType.setText("");
			  txtBasic.setText("");
			  txtDa.setText("");
			  txtHra.setText("");
			  txtGip.setText("");
			  txtGpf.setText("");
			  txtMedical.setText("");
			  txtAdditional.setText("");
			  txtLeave.setText("");
			  txtLvDed.setText("");
			  txtLoan.setText("");
			   txtAdv.setText("");
			}
				if(e.getSource()==chk && chk.isSelected()==true)
				{
					try{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
				 String sql1="select * from loan where eId='"+cbEid.getSelectedItem().toString()+"' " ;
		        Statement st1=con.createStatement();
		        ResultSet rs1=st1.executeQuery(sql1);
				if(rs1.next())
				{
					if(rs1.getString("loanType")!=null)
					{
						txtLoan.setText("");
						String emi=rs1.getString("emi");
						txtLoan.setText(emi);
					}
					else
					{txtLoan.setText("0");
					 }
					 if(rs1.getString("advType")!=null)
					{
						String a=rs1.getString("advAmt");
						System.out.println(rs1.getString("advAmt"));
						txtAdv.setText(a);
					}
					else
					{txtAdv.setText("0");}
				}
		       rs1.close();
		       st1.close();
		       con.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());	
				JOptionPane.showMessageDialog(this,ex.getMessage());}
		    }
		}
		public static void main(String arg[])
		{
			new salMaster();
		}
}
