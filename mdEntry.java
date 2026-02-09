import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
class mdEntry extends JFrame implements ActionListener
{
  JLabel lblpic,lbldept,lblId,lblName,lblManager;
   JTextField txtManager;
  JTextField  txtName;
  JComboBox cbDid;
  JButton bUpdate,bDelete,bClear, bClose;
  Dimension screensize;
  mdEntry()
  {
	 Image dimg=new ImageIcon("fotos\\delete.png").getImage().getScaledInstance(40,30,Image.SCALE_SMOOTH);
	 Image uimg=new ImageIcon("fotos\\update.jpeg").getImage().getScaledInstance(40,30,Image.SCALE_SMOOTH);
  setLayout(null);
  Image img=new ImageIcon("fotos\\l1.jpg").getImage().getScaledInstance(750,450,Image.SCALE_SMOOTH);
     lblpic=new JLabel(new ImageIcon(img));
	 //Labels
  lbldept=new JLabel("DEPARTMENT ENTRY DETAILS");
  lblId=new JLabel(" Department id");
  lblName=new JLabel("Department name");
  lblManager=new JLabel("Department manager");
   //TextBox
  txtManager=new JTextField();
  txtName= new JTextField();
  cbDid=new JComboBox();
  //buttons
  bUpdate=new JButton("Update",new ImageIcon(uimg));
  //bUpdate.setContentAreaFilled(false);
  //bUpdate.setBorderPainted(false);
  bDelete=new JButton("Delete",new ImageIcon(dimg));
  bClear=new JButton("Clear");
  bClose=new JButton("Close");
  //Sizes
  lblpic.setBounds(0,0,750,450);
  lbldept.setFont(new Font("ALGERIAN",Font.BOLD,30));
  lbldept.setForeground(Color.red);
  lbldept.setBounds(200,50,500,30);
  lblId.setBounds(80,110,150,30);
  lblName.setBounds(80,150,150,30);
  lblManager.setBounds(80,190,150,30);
  cbDid.setBounds(320,110,300,30);
  txtName.setBounds(320,150,300,30);
  txtManager.setBounds(320,190,300,30);
  bUpdate.setBounds(50,300,125,40);
  bDelete.setBounds(225,300,125,40);
  bClear.setBounds(400,300,100,40);
  bClose.setBounds(550,300,100,40);
	  try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
Statement st = con.createStatement();
String sql = "select dId from department order by dId";
ResultSet rs = st.executeQuery(sql);
  while(rs.next())
  {
    cbDid.addItem(rs.getString("dId"));
  }
rs.close();
con.close();
}catch(Exception ex)
{
  JOptionPane.showMessageDialog(this,ex.getMessage());
}
  
  
	cbDid.addItemListener(new ItemListener()
{
        public void itemStateChanged(ItemEvent ex)
        {  if(ex.getStateChange() == ItemEvent.SELECTED)
             {
            try
                     {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                      Connection con = DriverManager.getConnection("jdbc:odbc:mydsn");
                      Statement st = con.createStatement();
                      String sql = "select * from department where dId = '"+cbDid.getSelectedItem().toString()+"'";
                      ResultSet rs = st.executeQuery(sql);
                      if(rs.next())
                      {
                         txtName.setText(rs.getString("dName"));
		                 txtManager.setText(rs.getString("dManager"));
                      }
                     else
                     {
                       JOptionPane.showMessageDialog(null,"no such employee");
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

  //Adding
  add(lblId);  add(lblName);  add(lblManager); add(cbDid);  add(txtName); 
  add(txtManager); add(lbldept); add(bUpdate);add(bDelete);add(bClear);add(bClose); add(lblpic);
  setTitle("DEPARTMENT DETAILS MODIFICATION FORM");
  screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screensize.width-600)/2,(screensize.height-400)/2,750,450);
        setSize(750,450);
  setVisible(true);
  setResizable(false);
  bUpdate.addActionListener(this);
  bDelete.addActionListener(this);
  bClear.addActionListener(this);
   bClose.addActionListener(this);
  }
public void actionPerformed(ActionEvent a)
{
	if(a.getSource()==bUpdate)
	{try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="update department set dName='"+txtName.getText()+"', dManager='"+txtManager.getText()+"' where dId='"+cbDid.getSelectedItem().toString()+"'";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records updated");
		} 
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,  ex.getMessage());
		}
	}
		if(a.getSource()==bDelete)
	{
		int n= JOptionPane.showConfirmDialog(null,"Are You Sure","Enter Carefully",JOptionPane.WARNING_MESSAGE);
            if(n==JOptionPane.YES_OPTION)
			{			
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn");
			Statement st=con.createStatement();
			String sql="delete from department where dId='"+cbDid.getSelectedItem().toString()+"'";
			st.executeUpdate(sql);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "records deleted");
			txtManager.setText("");
			txtName.setText("");
		} 
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this,  ex.getMessage());
		}
			}
	}
	 if (a.getSource()==bClear)
	    {
			txtManager.setText("");
			txtName.setText("");
		}
	if (a.getSource()==bClose)
	{
		dispose();
	}	
	}
  public static void main(String args[])
  { new mdEntry();}
} 