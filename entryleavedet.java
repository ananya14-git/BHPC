import java.sql.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.awt.*;
public class entryleavedet extends JFrame implements ActionListener
{
	int lCode;
JLabel lblLdet,lblLid ,lblNm,lblLdetal,lblHead,lblStatus,lblDesc,lblpic;
JTextField txtLid,txtLnm,txtLdays;
JComboBox cbStaus,cbPeriod;
JTextArea t1;
JButton btnOk, btnCan,btnClr;
JScrollPane scroll;
Dimension screensize;
entryleavedet()
{
	setLayout(null);
	Image img1=new ImageIcon("fotos\\ch.jpeg").getImage().getScaledInstance(604,400,Image.SCALE_SMOOTH);
        lblpic=new JLabel(new ImageIcon(img1));
		lblpic.setBounds(0,0,604,400);
 lblHead=new JLabel("Leave Master");
btnOk = new JButton("Add");
btnCan = new JButton("Close");
btnClr=new JButton("Clear");
lblLid = new JLabel("Leave Id");
lblNm = new JLabel("Leave Name");
lblLdetal = new JLabel("No of days");
lblStatus=new JLabel("Leave status");
lblDesc=new JLabel("Leave Description");
txtLid= new JTextField();
txtLnm = new JTextField();
txtLdays= new JTextField();
t1=new JTextArea();
int x=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int y=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
 scroll= new JScrollPane(t1,x,y);
String status[]={"Paid","Unpaid"};
cbStaus=new JComboBox(status);
String Period[]={"in a month","in a year"};
cbPeriod=new JComboBox(Period);
lblHead.setFont(new Font("Britannic",Font.BOLD,30));
lblNm.setFont(new Font("Tahoma",Font.PLAIN,15));
lblStatus.setFont(new Font("Tahoma",Font.PLAIN,15));
lblLdetal.setFont(new Font("Tahoma",Font.PLAIN,15));
lblLid.setFont(new Font("Tahoma",Font.PLAIN,15));
lblHead.setForeground(Color.blue);
lblHead.setBounds(0,0,604,50);
lblHead.setOpaque(true);
lblHead.setBackground(Color.cyan);
txtLid.setEditable(false);
lblLid.setBounds(150,70,100,30);
lblNm.setBounds(150,120,100,30);
lblLdetal.setBounds(150,170,100,30);
lblStatus.setBounds(150,220,100,30);
txtLid.setBounds(300,70,150,30);
txtLnm.setBounds(300,120,150,30);
txtLdays.setBounds(300,170,150,30);
cbStaus.setBounds(300,220,150,30);
lblDesc.setBounds(150,270,150,30);
scroll.setBounds(300,270,200,40);
btnOk.setBounds(100,330,100,40); 
btnCan.setBounds(250,330,100,40);
btnClr.setBounds(400,330,100,40);
cbPeriod.setBounds(460,170,100,30);
btnOk.addActionListener(this);
btnCan.addActionListener(this);
btnClr.addActionListener(this);
txtLdays.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){int val=Integer.parseInt(txtLdays.getText());
		if(val<31)
		{cbPeriod.setSelectedItem("in a month");}
	else
		cbPeriod.setSelectedItem("in a year");
		}
	public void keyPressed(KeyEvent e){	
	}
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		if((ch<'0' || ch>'9') && ch!='\b' )
		{e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed");}
	}
});
 try
	  {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select max(lrNo)+1 as lrNo from lvMaster";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					 lCode=rs.getInt("lrNo");
					String lvId="L/"+String.valueOf(lCode);
					txtLid.setText(lvId);
				}
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
add(lblLid);add(lblNm);add(lblLdetal);add(lblStatus);
add(txtLid);add(txtLdays);add(txtLnm); add(cbStaus);   add(btnClr);
add(btnOk);add(btnCan);add(lblHead); add(cbPeriod); add(scroll);  add(lblDesc); add(lblpic); 
screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-604)/2,(screensize.height-355)/2,604,400);
        setVisible(true);
        setResizable(false);
setSize(604,400);
setVisible(true);
setTitle("LEAVE DETAILS");
}
public void actionPerformed(ActionEvent e)
{
	
   
if(e.getSource() == btnOk)
{
	
try
{
	if(txtLnm.getText().equals(""))
	{ 
		JOptionPane.showMessageDialog(this,"Enter name");
		return;}
    if(txtLdays.getText().equals(""))
    {JOptionPane.showMessageDialog(this,"Enter details");
    return;
	}
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "insert into lvMaster(leaveId,lvName,lvDesc,lvDays,lvPeriod,lvStatus,lrNo) values('"+txtLid.getText()+"','"+txtLnm.getText()+"','"+t1.getText()+"','"+txtLdays.getText()+"','"+cbPeriod.getSelectedItem().toString()+"','"+cbStaus.getSelectedItem().toString()+"',lvSeq.nextval)";
st.executeUpdate(sql);
con.close();
JOptionPane.showMessageDialog(this,"record inserted");
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(this,ex.getMessage());
}
dispose();
new entryleavedet();
}
if(e.getSource() == btnCan)
{
dispose();
}
if(e.getSource() == btnClr)
{
	 	  try
	  {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select max(lrNo)+1 as lrNo from lvMaster";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					 lCode=rs.getInt("lrNo");
					String lId="L/"+String.valueOf(lCode);
					txtLid.setText(lId);
				}
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
txtLnm.setText("");
txtLdays.setText("");

}
}
public static void main(String args[])
{
new entryleavedet();
}
}