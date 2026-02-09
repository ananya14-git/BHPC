import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
class dEntry extends JFrame implements ActionListener
{
	int dCode,a; String name;
  JLabel lblpic,lbldept,lblId,lblName,lblManager;
  JTextField txtDid,txtName,txtManager;
  JButton bAdd,bClear,bClose;
  Dimension screensize;
  dEntry()
  {
	  Image img=new ImageIcon("fotos\\dept.jpg").getImage().getScaledInstance(40,30,Image.SCALE_SMOOTH);
      setLayout(null);
     Image img1=new ImageIcon("fotos\\l1.jpg").getImage().getScaledInstance(750,450,Image.SCALE_SMOOTH);
     lblpic=new JLabel(new ImageIcon(img1)); 
	//Labels 
  lbldept=new JLabel("DEPARTMENT  ENTRY  DETAILS");
  lblId=new JLabel(" Department id");
  lblName=new JLabel("Department name");
  lblManager=new JLabel("Department manager");
   //Textbox
  txtDid=new JTextField();
  txtName=new JTextField();
  txtManager=new JTextField();
  //Buttons
  bAdd=new JButton("Add",new ImageIcon(img));
  bClear=new JButton("Clear");
  bClose=new JButton("Close");
  //sizes
  lblpic.setBounds(0,0,750,450);
  lbldept.setFont(new Font("Britannic",Font.BOLD,30));
  lbldept.setForeground(Color.blue);
  lbldept.setBounds(100,50,500,30);
  lblId.setBounds(80,110,150,30);
  lblName.setBounds(80,150,150,30);
  lblManager.setBounds(80,190,150,30);
  txtDid.setBounds(320,110,300,30);
  txtName.setBounds(320,150,300,30);
  txtManager.setBounds(320,190,300,30);
  bAdd.setBounds(100,300,100,40);
  bClear.setBounds(250,300,100,40);
  bClose.setBounds(400,300,100,40);
   txtDid.setEditable(false);
   bAdd.addActionListener(this);
  bClear.addActionListener(this);
  bClose.addActionListener(this);
  //Adding
  add(lblId);  add(lblName);  add(lblManager); add(txtDid); add(txtName); 
  add(txtManager); add(lbldept); add(bAdd);add(bClear);add(bClose); add(lblpic);
  setTitle("DEPARTMENT DETAILS ENTRY FORM");
  try
	  {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				Statement st=con.createStatement();
				String sql="select max(drNo)+1 as drNo from department";
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					 dCode=rs.getInt("drNo");
					String dId="D-"+String.valueOf(dCode);
					txtDid.setText(dId);
				}
				con.close();
	  }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
	 screensize=Toolkit.getDefaultToolkit().getScreenSize(); 
	 setSize(910,screensize.height-200);
  setBounds((screensize.width-600)/2,(screensize.height-400)/2,750,450);
  setSize(750,450);
  setVisible(true);
  setResizable(false);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
public void actionPerformed(ActionEvent a)
{
	name=txtName.getText();
	if(txtName.getText()=="")
			{JOptionPane.showMessageDialog(this,"Enter Department name");
				return;
		    }
		   if(txtManager.getText()=="")
		   {JOptionPane.showMessageDialog( this,"Enter Manager name");
			return;
		   }	  	
	if(a.getSource()==bAdd)
	{try
		{  
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select count(dName) from department where dName='"+name+"'");
			int cnt=0;
			if(rs.next())
			{ 
				cnt=rs.getInt(1);
			}
			if(cnt>=1)
			{
				JOptionPane.showMessageDialog(this,"Already existing,enter new department ");
				txtName.setText("");
				txtManager.setText("");
			}
			else
			{
				String sql="insert into department (dId,dName,dManager,drNo) values('"+txtDid.getText()+"','"+txtName.getText()+"','"+txtManager.getText()+"',depSeq.nextval)";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(this, "records inserted");
			}
			st.close();
			con.close();
		} 
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,  ex.getMessage());
		}
	}
	 if (a.getSource()==bClear)
	    {
			  try
	           {
		           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				   Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
				   Statement st=con.createStatement();
				   String sql="select max(drNo)+1 as drNo from department";
				   ResultSet rs=st.executeQuery(sql);
				   if(rs.next())
				   {
					 dCode=rs.getInt("drNo");
					String dId="D-"+String.valueOf(dCode);
					txtDid.setText(dId);
				   }
				  con.close();
	            }
	  catch(Exception ex)
	  {JOptionPane.showMessageDialog(this,ex.getMessage());}
			txtManager.setText("");
            txtName.setText("");
		}	
     if(a.getSource()==bClose)
	 {
		 dispose();
	 }		 	
}
  public static void main(String args[])
  { new dEntry();}
} 