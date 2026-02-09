import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class entryleaveUp extends JFrame implements ActionListener
{
	int lCode;
JLabel lblLdet,lblLid,lblNm,lblLdetal,lblHead,lblStatus;
JTextField txtLnm,txtLdetal;
JComboBox cbStaus,cbLid;
JButton btnUp, btnCan,btnDel;
Dimension screensize;
entryleaveUp()
{
	setLayout(null);
 lblHead=new JLabel("Leave Master");
btnUp = new JButton("Update");
btnCan = new JButton("Close");
btnDel=new JButton("Delete");
lblLid = new JLabel("Leave Id");
lblNm = new JLabel("Leave Name");
lblLdetal = new JLabel("Leave Detail");
lblStatus=new JLabel("Leave status");
txtLnm = new JTextField();
txtLdetal= new JTextField();
String status[]={"Paid","Unpaid"};
cbStaus=new JComboBox(status);
cbLid= new JComboBox();
  try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select leaveId from lvMaster order by leaveId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbLid.addItem(rs.getString("leaveId"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
lblHead.setFont(new Font("Britannic",Font.BOLD,30));
lblNm.setFont(new Font("Tahoma",Font.PLAIN,15));
lblStatus.setFont(new Font("Tahoma",Font.PLAIN,15));
lblLdetal.setFont(new Font("Tahoma",Font.PLAIN,15));
lblLid.setFont(new Font("Tahoma",Font.PLAIN,15));
lblHead.setForeground(Color.blue);
lblHead.setBounds(0,0,604,50);
lblHead.setOpaque(true);
lblHead.setBackground(Color.cyan);
lblLid.setBounds(150,70,100,30);
lblNm.setBounds(150,120,100,30);
lblLdetal.setBounds(150,170,100,30);
lblStatus.setBounds(150,220,100,30);
cbLid.setBounds(300,70,150,30);
txtLnm.setBounds(300,120,150,30);
txtLdetal.setBounds(300,170,150,30);
cbStaus.setBounds(300,220,150,30);
btnUp.setBounds(100,270,100,40); 
btnCan.setBounds(250,270,100,40);
btnDel.setBounds(400,270,100,40);
btnUp.addActionListener(this);
btnCan.addActionListener(this);
btnDel.addActionListener(this);
cbLid.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select * from lvMaster where leaveId = '"+cbLid.getSelectedItem().toString()+"'";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtLnm.setText(rs.getString("lvType"));
						 cbStaus.setSelectedItem(rs.getString("lvStatus"));
						 txtLdetal.setText(rs.getString("lvDetail"));
                      }
                     else
                     {
				      System.out.println("txtDepName.setText");
                     }
                     rs.close();
                     con.close();
                     }
          catch(Exception a)
                    {  System.out.println(a.getMessage());  }
			 }
		}
	}
);
 txtLdetal.addKeyListener(new KeyAdapter(){
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e)
	{
		char ch=e.getKeyChar();
		if(( ch<'0' || ch>'9') && ch!='\b' )
		{e.consume();
		JOptionPane.showMessageDialog(null,"Characters other than numeric not allowed");}
	}
});

add(lblLid);add(lblNm);add(lblLdetal);add(lblStatus);
add(cbLid);add(txtLdetal);add(txtLnm); add(cbStaus);   add(btnDel);
add(btnUp);add(btnCan);add(lblHead); 
screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-604)/2,(screensize.height-355)/2,604,355);
        setVisible(true);
        setResizable(false);
setSize(604,355);
setVisible(true);
setTitle("LEAVE DETAILS");
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource() == btnUp)
{
try
{
	if(txtLnm.getText().equals(""))
	{ 
		JOptionPane.showMessageDialog(this,"Enter name");
		return;}
    if(txtLdetal.getText().equals(""))
    {JOptionPane.showMessageDialog(this,"Enter details");
    return;
	}
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "update lvMaster set lvDetail='"+txtLdetal.getText()+"' where leaveId='txtLid.getText()'";
st.executeUpdate(sql);
con.close();
JOptionPane.showMessageDialog(this,"record updated");
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(this,ex.getMessage());
}
}
if(e.getSource() == btnCan)
{
dispose();
}
if(e.getSource() == btnDel)
{   int n= JOptionPane.showConfirmDialog(null,"Are You Sure","Enter Carefully",JOptionPane.WARNING_MESSAGE);
            if(n==JOptionPane.YES_OPTION)
			{   try{	
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
           String sql ="delete  from lvMaster where leaveId='"+cbLid.getSelectedItem().toString()+"'";
		   cbLid.removeItem(cbLid.getSelectedIndex());
		   st.executeUpdate(sql);
				st.close();
				con.close();
			JOptionPane.showMessageDialog(null,"Record deleted");
			}
			catch(Exception ex)
			{JOptionPane.showMessageDialog(this,ex.getMessage());}
			}
}
}
public static void main(String args[])
{
new entryleaveUp();
}
}