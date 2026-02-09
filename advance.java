import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
class advance extends JFrame  implements ActionListener
{
	float p,r,t,getemi;
JLabel lblEmpId,  lblLoanType, lblAdvType, lblLoanAmt, lblAdvAmt, lblHead, lblInt, lblInstall, lblStartDt, lblEndDt, lblTotAmt,lblEMI,lblGetEMI;
JTextField   txtLoanAmt, txtAdvAmt, txtInt, txtInstall, txtStartDt, txtTotAmt, txtEndDt;
JButton btnIns, btnUp, btnShow, btnClear,btncal,btnemi;
JRadioButton rbAdv, rbLoan;
JComboBox txtEmpId,cbLoanType, cbAdvnceType;
ButtonGroup btn;
JSeparator js;
Dimension screenSize;
advance()
{ 
	Image scal=new ImageIcon("fotos\\cal.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
	Image emiBtn=new ImageIcon("fotos\\emi.png").getImage().getScaledInstance(40,30,Image.SCALE_SMOOTH);
  screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  js=new JSeparator();
  lblHead=new JLabel("Loan/Advance Details");
  rbAdv=new JRadioButton("ADVANCE:");
  rbLoan=new JRadioButton("LOAN");
  lblEmpId=new JLabel("Employee ID");
  lblLoanAmt=new JLabel("Loan Amount");
  lblAdvAmt=new JLabel("Advance Amount");
  lblLoanType=new JLabel("Loan Type");
  lblAdvType=new JLabel("Advance Type");
  lblInt=new JLabel("Interest");
  lblInstall=new JLabel("Installment");
  lblStartDt=new JLabel("Start Date");
  lblEndDt=new JLabel("End Date");
  lblTotAmt=new JLabel("Total Loan/Advance Taken");
  lblEMI=new JLabel("EMI");
  lblGetEMI=new JLabel();
  txtEmpId=new JComboBox();
  txtAdvAmt=new JTextField();
  txtLoanAmt=new JTextField();
  txtInstall=new JTextField();
  txtInt=new JTextField();
  txtStartDt=new JTextField();
  txtEndDt=new JTextField();
  txtTotAmt=new JTextField();
  btnIns=new JButton("Insert");
  btnShow=new JButton("Search");
  btnUp=new JButton("Update");
  btnClear=new JButton("Clear");
  btncal=new JButton(new ImageIcon(scal));
  btnemi=new JButton(new ImageIcon(emiBtn));
  String adv[]={"Marriage advance","Home Advance","Vehicle Advance","Festival Advance"};
  String loan[]={"Home Loan","Vehicle Loan","Electronics Loan","Education loan"};
  cbAdvnceType=new JComboBox(adv);
  cbLoanType=new JComboBox(loan);
  lblHead.setBounds(0,0,screenSize.width-250,50);
  lblHead.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblHead.setOpaque(true);
  lblHead.setBackground(new Color(0,204,204));
  lblHead.setForeground(new Color(0,0,0)); 
  lblEmpId.setBounds(50,70,150,20); txtEmpId.setBounds(200,70,100,20);
  rbAdv.setBounds(50,110,150,20);      
  rbLoan.setBounds(500,110,150,20);
  lblAdvType.setBounds(50,140,150,20);        cbAdvnceType.setBounds(210,140,150,20);
  lblAdvAmt.setBounds(50,170,150,20);		txtAdvAmt.setBounds(210,170,150,20);
  lblLoanType.setBounds(500,140,150,20);   cbLoanType.setBounds(660,140,150,20);
  lblLoanAmt.setBounds(500,170,150,20);		txtLoanAmt.setBounds(660,170,150,20);
  lblInt.setBounds(500,200,150,20);		txtInt.setBounds(660,200,150,20);
  lblInstall.setBounds(500,230,150,20);			txtInstall.setBounds(660,230,150,20);   btnemi.setBounds(830,230,40,30);
  lblStartDt.setBounds(50,260,200,20);			lblEMI.setBounds(500,260,150,20);				lblGetEMI.setBounds(660,260,150,20);
  txtStartDt.setBounds(260,260,150,20);
  btncal.setBounds(410,260,30,20);
  btnIns.setBounds(150,300,100,30);
  btnShow.setBounds(350,70,100,20);
  btnUp.setBounds(430,300,100,30);
  btnClear.setBounds(570,300,100,30);
  btnIns.addActionListener(this);
  btnShow.addActionListener(this);
  btnUp.addActionListener(this);
  btnClear.addActionListener(this);
  rbAdv.addActionListener(this);
  rbLoan.addActionListener(this);
  btncal.addActionListener(this);
   btnemi.addActionListener(this);
  rbAdv.setFont(new Font("Britannic",Font.BOLD,15));
  rbLoan.setFont(new Font("Britannic",Font.BOLD,15));
  lblEmpId.setFont(new Font("Tahoma",Font.PLAIN,15));
   lblAdvType.setFont(new Font("Tahoma",Font.PLAIN,15));
    lblLoanType.setFont(new Font("Tahoma",Font.PLAIN,15));
	 cbLoanType.setFont(new Font("Tahoma",Font.PLAIN,15));
    cbAdvnceType.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblAdvAmt.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblLoanAmt.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblInstall.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblInt.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblStartDt.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblEndDt.setFont(new Font("Tahoma",Font.PLAIN,15));
   lblEMI.setFont(new Font("Tahoma",Font.PLAIN,15));
    lblGetEMI.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblTotAmt.setFont(new Font("Britannic",Font.BOLD,15));
  cbAdvnceType.setEnabled(false);
  cbLoanType.setEnabled(false);
  txtAdvAmt.setEnabled(false);
  txtLoanAmt.setEnabled(false);
  txtInstall.setEnabled(false);
  txtInt.setEnabled(false);
  txtStartDt.setEnabled(false);
  btnUp.setEnabled(false);
	  try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select eId from employee order by eId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    txtEmpId.addItem(rs.getString("eId"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
  add(lblHead); add(lblEmpId); add(lblAdvType); add(lblAdvAmt); add(lblLoanType); add(lblLoanAmt); add(lblInt); add(lblInstall); add(lblStartDt); add(lblEndDt); add(lblTotAmt);
  add(txtEmpId);  add(cbAdvnceType); add(cbLoanType); add(txtAdvAmt); add(txtLoanAmt); add(txtInt); add(txtInstall); add(txtStartDt); add(txtEndDt);add(txtTotAmt);
  add(btnClear); add(btnIns); add(btnUp); add(btnShow);  add(btncal); add(lblEMI); add(lblGetEMI);	add(btnemi);
   add(rbAdv); add(rbLoan);
   btn=new ButtonGroup();
  btn.add(rbAdv); btn.add(rbLoan);
  setLayout(null);
  setBounds((screenSize.width-900)/2,(screenSize.height-400)/2,900,400);
  setSize(900,400);
  setVisible(true);
}
 public void actionPerformed(ActionEvent e)
  {
	   if(rbAdv.isSelected())
  {
	cbAdvnceType.setEnabled(true); 
    txtAdvAmt.setEnabled(true);
	 txtStartDt.setEnabled(true);
	 txtLoanAmt.setEnabled(false);
  txtInstall.setEnabled(false);
  txtInt.setEnabled(false);
  cbLoanType.setEnabled(false);
  }
  if(rbLoan.isSelected())
  {
	    cbAdvnceType.setEnabled(false);
  cbLoanType.setEnabled(false);
  txtAdvAmt.setEnabled(false);
	   cbLoanType.setEnabled(true);
	   txtLoanAmt.setEnabled(true);
		txtInstall.setEnabled(true);
		txtInt.setEnabled(true);
		txtStartDt.setEnabled(true);
  }
     if(e.getSource()==btnIns)
	  {
		   try
			  {  
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				if(rbAdv.isSelected())
				  {
					  JOptionPane.showMessageDialog(null," Adv sec");
				String sql="insert into loan(eId,advType,advAmt,strtDate) values ('"+txtEmpId.getSelectedItem().toString()+"','"+cbAdvnceType.getSelectedItem().toString()+"','"+txtAdvAmt.getText()+"','"+txtStartDt.getText()+"')";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this, "advance record inserted");
				  }
				else  if(rbLoan.isSelected())
				  { 
				String sql="insert into loan(eId,loanType,loanAmt,interest,install,strtDate,emi) values ('"+txtEmpId.getSelectedItem().toString()+"','"+cbLoanType.getSelectedItem().toString()+"','"+txtLoanAmt.getText()+"','"+txtInt.getText()+"','"+txtInstall.getText()+"','"+txtStartDt.getText()+"',"+lblGetEMI.getText()+")";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this," Loan record  inserted");
				  }
				st.close();
				con.close();
				  }
			  catch (Exception ex)
			  {JOptionPane.showMessageDialog(this,ex.getMessage());}
		}
	  if(e.getSource()==btnShow)
	  {
		  try
		  { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select loanAmt,loanType,interest,install,emi,advAmt,advType,TO_CHAR(strtDate,'dd/Mon/yyyy') as strtDate from loan where eId='"+txtEmpId.getSelectedItem().toString()+"'";
		        ResultSet rs=st.executeQuery(sql);
		        if(rs.next())
				{
					btnUp.setEnabled(true);
					btnIns.setEnabled(false);
					if(rs.getString("loanType")!=null)
					{	 
							cbLoanType.setEnabled(true);
  
							txtLoanAmt.setEnabled(true);
							txtInstall.setEnabled(true);
							txtInt.setEnabled(true);
							txtStartDt.setEnabled(true);
		               txtLoanAmt.setText(rs.getString("loanAmt"));
		                cbLoanType.setSelectedItem(rs.getString("loanType"));
						txtInstall.setText(rs.getString("install"));
						txtInt.setText(rs.getString("interest"));
						txtStartDt.setText(rs.getString("strtDate"));
						lblGetEMI.setText("emi");
					}
					else if(rs.getString("advType")!=null)
					{
						 cbAdvnceType.setEnabled(true);
						 txtAdvAmt.setText(rs.getString("advAmt"));
						 cbAdvnceType.setSelectedItem(rs.getString("advType"));
						 txtStartDt.setText(rs.getString("strtDate")); 
                    }
				}
				else 
				{
				JOptionPane.showMessageDialog(null,"no Advance or Loan is taken ");
				btnUp.setEnabled(false);
					btnIns.setEnabled(true);
				}
		  }
				catch(Exception ex)
				{JOptionPane.showMessageDialog(this,ex.getMessage());}
		   }
  if(e.getSource()==btnUp)
  {
	   try
			  {  
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				if(rbAdv.isSelected())
				  {
				 rbLoan.setSelected(false);
				String sql="update loan set advAmt='"+txtAdvAmt.getText()+"',strtDate ='"+txtStartDt.getText()+"' ";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this, "advance record updated");
				  }
				else  if(rbLoan.isSelected())
				  {
					  rbAdv.setSelected(false);
				String sql="update loan set loanAmt='"+txtLoanAmt.getText()+"',install='"+txtInstall.getText()+"',strtDate= '"+txtStartDt.getText()+"'  ,emi='"+lblGetEMI.getText()+"'";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this," Loan record  updated");
				  }
				st.close();
				con.close();
				  }
			  catch (Exception ex)
			  {JOptionPane.showMessageDialog(this,ex.getMessage());}
  }
      if(e.getSource()==btnClear)
              {txtAdvAmt.setText("");
				txtLoanAmt.setText("");
				txtStartDt.setText("");
				txtInstall.setText("");
			  txtInt.setText("");}
			  if(e.getSource()==btncal)
			  {
				  String dt=new DatePicker(new JFrame()).setPickedDate();
				txtStartDt.setText(dt);
			  }
			  if(e.getSource()==btnemi)
			  {
				  String prin=txtLoanAmt.getText();
				  String rate=txtInt.getText();
				  String time=txtInstall.getText();
				  p=Float.parseFloat(prin);
				  r=Float.parseFloat(rate);
				  t=Float.parseFloat(time);
				  r = r / (12 * 100);              // one month interest
                  t = t * 12;                               // one month period
                 getemi = (p * r * (float)Math.pow(1 + r, t))  / (float)(Math.pow(1 + r, t) - 1);
				 lblGetEMI.setText(String.valueOf(getemi));
			  }
}  
    public static void main(String arg[])
     {new advance();}
  }