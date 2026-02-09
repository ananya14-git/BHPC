import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.util.Date;
class scale extends JFrame implements ActionListener
{ 
String rb;
int a,c,d,r;
JLabel lblEtype,lblPrcnt,lblAmt,lblScale,lblDa,lblHra,lblMed,lblTransport,lblWashing,lblDriving,lblGPF,lblGIP,lblLstUp,lblGetLstUp,lblDesg, lblBasic;
JTextField txtDa,txtHra,txtMed,txtTransport,txtWashing,txtDriving,txtGPF,txtGIP,txtBasic;
JButton btnIns,btnUp,btnClear,btnDelete,btnClose;
JRadioButton rbDep, rbReg, rbCon,rbAgncy;
JComboBox cbDesg;
JSeparator js;
Dimension screenSize;
scale()
{ 
   setBackground(Color.red);
  screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  js=new JSeparator();
  lblEtype=new JLabel("Employee Type");
  lblScale=new JLabel("Scale Details");
  lblPrcnt=new JLabel("BY PERCENTAGE:");
  lblAmt=new JLabel("BY AMOUNT:");
  lblDa=new JLabel("DA");
  lblHra=new JLabel("HRA");
  lblMed=new JLabel("Medical Allowance");
   lblTransport=new JLabel("Transport Allowance");
  lblDriving=new JLabel("Driving Allowance");
  lblWashing=new JLabel("Washing Allowance");
  lblGPF=new JLabel("GPF");
  lblGIP=new JLabel("GIP");
  lblLstUp=new JLabel("Last Updated On:");
  lblGetLstUp=new JLabel();
  lblDesg=new JLabel("Designation");
  lblBasic=new JLabel("Basic");
  txtDa=new JTextField();
  txtHra=new JTextField();
  txtMed=new JTextField();
  txtTransport=new JTextField();
  txtWashing=new JTextField();
  txtDriving=new JTextField();
  txtGPF=new JTextField();
  txtGIP=new JTextField();
  txtBasic=new JTextField();
  rbAgncy=new JRadioButton("Agency");
  rbCon=new JRadioButton("Contract");
  rbDep=new JRadioButton("Deputational");
  rbReg=new JRadioButton("Regular");
  String desg[]={"","Multi-tasking Staff","Clerical","Manager","Worker","Engineers"};
  cbDesg=new JComboBox(desg);
  btnIns=new JButton("Insert");
  btnUp=new JButton("Update");
  btnDelete=new JButton("Delete");
  btnClear=new JButton("Clear");
  btnClose=new JButton("Close");
  lblScale.setBounds(0,0,screenSize.width-250,50);
  lblScale.setFont(new Font("Tahoma",Font.PLAIN,35));
  lblScale.setOpaque(true);
  lblScale.setBackground(new Color(0,204,204));
  lblScale.setForeground(new Color(0,0,0)); 
  lblEtype.setBounds(320,70,120,20);
  rbAgncy.setBounds(440,70,80,20); rbCon.setBounds(520,70,100,20); rbDep.setBounds(620,70,120,20); rbReg.setBounds(740,70,80,20);
  lblDesg.setBounds(50,70,100,20);             cbDesg.setBounds(160,70,150,20);
  lblBasic.setBounds(50,110,100,20);           txtBasic.setBounds(170,110,100,20);
  lblPrcnt.setBounds(50,160,150,20);      
  lblAmt.setBounds(500,160,150,20);
  lblDa.setBounds(50,180,50,20);        txtDa.setBounds(110,180,100,20);
  lblHra.setBounds(50,210,50,20);		txtHra.setBounds(110,210,100,20);
  lblGPF.setBounds(50,240,50,20);		txtGPF.setBounds(110,240,100,20);
  lblGIP.setBounds(50,270,50,20);		txtGIP.setBounds(110,270,100,20);
  lblTransport.setBounds(500,180,150,20);   txtTransport.setBounds(660,180,100,20);
  lblDriving.setBounds(500,210,150,20);		txtDriving.setBounds(660,210,100,20);
  lblWashing.setBounds(500,240,150,20);		txtWashing.setBounds(660,240,100,20);
  lblMed.setBounds(500,270,150,20);			txtMed.setBounds(660,270,100,20);
  lblLstUp.setBounds(50,300,200,20);
  lblGetLstUp.setBounds(260,300,150,20);
  btnIns.setBounds(150,330,100,30);
  btnUp.setBounds(290,330,100,30);
  btnClear.setBounds(570,330,100,30);
  btnDelete.setBounds(430,330,100,30);
  btnClose.setBounds(700,330,100,30);
  
  btnIns.addActionListener(this);
  btnUp.addActionListener(this);
  btnDelete.addActionListener(this);
  btnClear.addActionListener(this);
  btnClose.addActionListener(this);
  rbAgncy.addActionListener(this);
  rbCon.addActionListener(this);
  rbDep.addActionListener(this);
  rbReg.addActionListener(this);
  
  btnIns.setEnabled(false);
  btnDelete.setEnabled(false);
  btnUp.setEnabled(false);
  txtDa.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
 txtHra.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='.' && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
 txtGPF.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{   char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9')  && ch!='.'&& ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtGIP.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{   char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9')  && ch!='.' && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtTransport.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtDriving.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtWashing.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
txtMed.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		  char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{
			e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed"); }
	}
});
  lblBasic.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblDesg.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblPrcnt.setFont(new Font("Britannic",Font.BOLD,15));
  lblAmt.setFont(new Font("Britannic",Font.BOLD,15));
  lblEtype.setFont(new Font("Tahoma",Font.PLAIN,15));
  rbAgncy.setFont(new Font("Tahoma",Font.PLAIN,15));
  rbCon.setFont(new Font("Tahoma",Font.PLAIN,15));
  rbDep.setFont(new Font("Tahoma",Font.PLAIN,15));
  rbReg.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblDa.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblHra.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblGPF.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblGIP.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblDriving.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblTransport.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblWashing.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblMed.setFont(new Font("Tahoma",Font.PLAIN,15));
  lblLstUp.setFont(new Font("Britannic",Font.BOLD,15));
  lblGetLstUp.setFont(new Font("Britannic",Font.BOLD,15));
  add(lblScale); add(lblEtype); add(lblPrcnt); add(lblAmt); add(lblDa); add(lblTransport); add(lblHra); add(lblDriving); add(lblGPF); add(lblGIP);add(lblDesg); add(lblBasic);
  add(lblWashing); add(lblMed); add(txtDa); add(txtHra); add(txtGPF); add(txtGIP); add(txtTransport); add(txtDriving); add(txtWashing);    add(cbDesg); add(txtBasic);
  add(txtMed);  add(lblLstUp); add(lblGetLstUp); add(btnIns);  add(btnUp); add(btnClear); add(btnDelete);add(btnClose);
   add(rbAgncy); add(rbCon); add(rbDep); add(rbReg);
   ButtonGroup bg=new ButtonGroup();
  bg.add(rbAgncy); bg.add(rbCon); bg.add(rbDep); bg.add(rbReg);
  setBounds((screenSize.width-900)/2,(screenSize.height-400)/2,900,400);
  setLayout(null);
  setSize(900,400);
  setVisible(true);
}
  public void actionPerformed(ActionEvent e)
  {
	  if((rbAgncy.isSelected()&&e.getSource()==rbAgncy))
   { 
   try
   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select * from scale where eAppntmt='Agency' and desg='"+cbDesg.getSelectedItem().toString()+"'";
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
				String var=r.getString("basic");
		        txtBasic.setText(var);
		        String var1=r.getString("da");
		        txtDa.setText(var1);
		        String var2=r.getString("hra");
		        txtHra.setText(var2);
				txtGIP.setText(r.getString("gip"));
				txtGPF.setText(r.getString("gpf"));
				txtTransport.setText(r.getString("transAllow"));
				txtDriving.setText(r.getString("drivAllow"));
				txtWashing.setText(r.getString("washAllow"));
				txtMed.setText(r.getString("medAllow"));
				lblGetLstUp.setText(r.getString("lstUpdate"));
				btnUp.setEnabled(true);
				btnDelete.setEnabled(true);
				btnIns.setEnabled(false);
				}
				else{
					btnUp.setEnabled(false);
					btnDelete.setEnabled(false);
				btnIns.setEnabled(true);
				}
   }
   catch(Exception ex)
   {JOptionPane.showMessageDialog(this,ex.getMessage());}
   }
  else if((rbCon.isSelected()&&e.getSource()==rbCon))
   {
   try
   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select * from scale where eAppntmt='Contract'and desg='"+cbDesg.getSelectedItem().toString()+"'";
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
				String var=r.getString("basic");
				txtBasic.setText(var);
		        txtDa.setText(var);
		        String var1=r.getString("da");
		        txtDa.setText(var1);
		        String var2=r.getString("hra");
		        txtHra.setText(var2);
				txtGIP.setText(r.getString("gip"));
				txtGPF.setText(r.getString("gpf"));
				txtTransport.setText(r.getString("transAllow"));
				txtDriving.setText(r.getString("drivAllow"));
				txtWashing.setText(r.getString("washAllow"));
				txtMed.setText(r.getString("medAllow"));
				lblGetLstUp.setText(r.getString("lstUpdate"));
				btnUp.setEnabled(true);
				btnDelete.setEnabled(true);
				btnIns.setEnabled(false);
				}
				else{
					btnUp.setEnabled(false);
					btnDelete.setEnabled(false);
				btnIns.setEnabled(true);
				}
   }
   catch(Exception ex)
   {JOptionPane.showMessageDialog(this,ex.getMessage());}
   }
   else  if((rbReg.isSelected()&& e.getSource()==rbReg))
   {
	    try
   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select * from scale where eAppntmt='Regular'and desg='"+cbDesg.getSelectedItem().toString()+"'";
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
				String var=r.getString("basic");
		        txtBasic.setText(var);
		        String var1=r.getString("da");
		        txtDa.setText(var1);
		        String var2=r.getString("hra");
		        txtHra.setText(var2);
				txtGIP.setText(r.getString("gip"));
				txtGPF.setText(r.getString("gpf"));
				txtTransport.setText(r.getString("transAllow"));
				txtDriving.setText(r.getString("drivAllow"));
				txtWashing.setText(r.getString("washAllow"));
				txtMed.setText(r.getString("medAllow"));
				lblGetLstUp.setText(r.getString("lstUpdate"));
				btnUp.setEnabled(true);
				btnDelete.setEnabled(true);
				btnIns.setEnabled(false);
				}
				else{
					btnUp.setEnabled(false);
					btnDelete.setEnabled(false);
				btnIns.setEnabled(true);
				}
   }
   catch(Exception ex)
   {JOptionPane.showMessageDialog(this,ex.getMessage());}
   }
   
   else if((rbDep.isSelected()&&e.getSource()==rbDep))
   {
	  try
   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
			     String sql="select * from scale where eAppntmt='Deputational'and desg='"+cbDesg.getSelectedItem().toString()+"'";
		        ResultSet r=st.executeQuery(sql);
		        if(r.next())
				{
				String var=r.getString("basic");
		        txtBasic.setText(var);
		        String var1=r.getString("da");
		        txtDa.setText(var1);
		        String var2=r.getString("hra");
		        txtHra.setText(var2);
				txtGIP.setText(r.getString("gip"));
				txtGPF.setText(r.getString("gpf"));
				txtTransport.setText(r.getString("transAllow"));
				txtDriving.setText(r.getString("drivAllow"));
				txtWashing.setText(r.getString("washAllow"));
				txtMed.setText(r.getString("medAllow"));
				lblGetLstUp.setText(r.getString("lstUpdate"));
				btnUp.setEnabled(true);
				btnDelete.setEnabled(true);
				btnIns.setEnabled(false);
				}
				else{
					btnUp.setEnabled(false);
					btnDelete.setEnabled(false);
				btnIns.setEnabled(true);
				}
   }
   catch(Exception ex)
   {JOptionPane.showMessageDialog(this,ex.getMessage());}
   }
	  if(e.getSource()==btnIns)
	  { 
		   try
			  {
				   rb=null;
                 if(rbAgncy.isSelected())
                 { rb= rbAgncy.getText(); }
                 if(rbCon.isSelected())
                 { rb= rbCon.getText(); } 
				 if(rbDep.isSelected())
                 { rb= rbDep.getText(); } 
				 if(rbReg.isSelected())
                 { rb= rbReg.getText(); } 
			  
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="insert into scale(eAppntmt,basic,da,hra,gpf,gip,transAllow,drivAllow,washAllow,medAllow,lstUpdate,desg) values ('"+rb+"','"+txtDa.getText()+"','"+txtBasic.getText()+"','"+txtHra.getText()+"','"+txtGPF.getText()+"','"+txtGIP.getText()+"','"+txtTransport.getText()+"','"+txtDriving.getText()+"','"+txtWashing.getText()+"','"+txtMed.getText()+"',sysDate,'"+cbDesg.getSelectedItem().toString()+"')";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this,"records inserted");
			  }
			  catch (Exception ex)
			  {JOptionPane.showMessageDialog(this,ex.getMessage());}
	  }  
  if(e.getSource()==btnUp)
  {
	   rb=null;
                 if(rbAgncy.isSelected())
                 { rb= rbAgncy.getText(); }
                 if(rbCon.isSelected())
                 { rb= rbCon.getText(); } 
				 if(rbDep.isSelected())
                 { rb= rbDep.getText(); } 
				 if(rbReg.isSelected())
                 { rb= rbReg.getText(); }
	  try
	  {      
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
		   String sql="update scale set basic="+txtBasic.getText()+",da="+txtDa.getText()+",hra="+txtHra.getText()+",gip="+txtGIP.getText()+",gpf="+txtGPF.getText()+",transAllow="+txtTransport.getText()+",drivAllow="+txtDriving.getText()+",washAllow="+txtWashing.getText()+",medAllow="+txtMed.getText()+",lstUpdate=sysDate  where eAppntmt='"+rb+"' and desg='"+cbDesg.getSelectedItem().toString()+"' ";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"records updated");
	  }
	  catch(Exception ex)
	  {
		  JOptionPane.showMessageDialog(this,ex.getMessage());
	  }
  }
  if(e.getSource()==btnDelete)
  {
	   rb=null;
                 if(rbAgncy.isSelected())
                 { rb= rbAgncy.getText(); }
                 if(rbCon.isSelected())
                 { rb= rbCon.getText(); } 
				 if(rbDep.isSelected())
                 { rb= rbDep.getText(); } 
				 if(rbReg.isSelected())
                 { rb= rbReg.getText(); }
	  try
	  {      
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
		   String sql="delete from scale  where eAppntmt='"+rb+"' and desg='"+cbDesg.getSelectedItem().toString()+"' ";
				st.executeUpdate(sql);
				st.close();
				con.close();
				JOptionPane.showMessageDialog(this,"records deleted");
				txtBasic.setText("");
				txtDa.setText("");
				txtHra.setText("");
				txtGIP.setText("");
				txtGPF.setText("");
				txtMed.setText("");
				txtTransport.setText("");
				txtDriving.setText("");
				lblGetLstUp.setText("");
				txtWashing.setText("");
				txtBasic.setText("");
	  }
	  catch(Exception ex)
	  {
		  JOptionPane.showMessageDialog(this,ex.getMessage());
	  }
  }
      if(e.getSource()==btnClear)
              {
				 txtBasic.setText("");
				txtDa.setText("");
				txtHra.setText("");
				txtGIP.setText("");
				txtGPF.setText("");
				txtMed.setText("");
				txtTransport.setText("");
				txtDriving.setText("");
				lblGetLstUp.setText("");
				txtWashing.setText("");
               }
			    if(e.getSource()==btnClose)
				{
					dispose();
				}
  }
    public static void main(String arg[])
     {new scale();}

}