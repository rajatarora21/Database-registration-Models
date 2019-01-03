import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
class RegistrationForm
{
	static JTextField name_t;
	static JTextField mobile_t;
	static JComboBox day;
	static JComboBox month;
	static JComboBox year;
	static JComboBox Country;
	static JRadioButton male;
	static JRadioButton female;
	static JTextArea area;
	static JButton btn1;
	static JCheckBox terms;
	static JTextArea output;
	static JLabel address;
	//static JLabel message;
	static JFrame f;
	static JLabel course;
	static JCheckBox cb1,cb2,cb3;
	
	public static void main(String[] args) throws Exception
	{
		f=new JFrame("Registration Form");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(200,100,700,800);
		Border border=BorderFactory.createLineBorder(Color.BLACK,2);
		Container c=f.getContentPane();
		c.setBackground(Color.BLUE);
		c.setLayout(null);
		JLabel title=new JLabel("REGISTRATION PAGE");
		title.setBounds(300,30,500,15);
		title.setFont(new Font("Serif",Font.BOLD,25));
		title.setForeground(Color.RED);
		//title.setBorder(new LineBorder(Color.RED));
		f.add(title);
		JLabel name=new JLabel("Name : ");
		name.setBounds(50,50,60,35);
		name.setForeground(Color.WHITE);
		name_t=new JTextField();
		name_t.setBounds(150,50,150,30);
		name_t.setBorder(border);

		JLabel mobile=new JLabel("Mobile : ");
		mobile.setBounds(50,100,60,30);
		mobile.setForeground(Color.WHITE);
		mobile_t=new JTextField();
		mobile_t.setBounds(150,100,150,30);
		mobile_t.setBorder(border);

		JLabel dob=new JLabel("DOB : ");
		dob.setBounds(50,150,60,30);
		dob.setForeground(Color.WHITE);

		String[] day_arr=new String[31];
		for(int i=1;i<=31;i++)
			day_arr[i-1]=Integer.toString(i);
		day=new JComboBox(day_arr);
		day.setBounds(150,150,40,25);
		String[] month_arr={"JAN","FEB","March","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		month=new JComboBox(month_arr);
		month.setBounds(210,150,70,25);
		String[] year_arr=new String[80];
		for(int i=1940;i<=2018;i++)
			year_arr[i-1940]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(300,150,70,25);
		String[] s={"INDIA","PAKISTAN","BANGLADESH"};
		String[] s1={"NEW DELHI","MUMBAI","BANGALORE","KASHMIR(INDIA)"};
		String[] s2={"LAHORE","RAWALPINDI","ISLAMABAD"};
		String[] s3={"DHAKA","KHULNA","BARISAL"};
		Country=new JComboBox(s);
		Country.setBounds(250,440,250,30);
		c.add(Country);
		Country.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent event)
		{
			String c1=(String)Country.getSelectedItem();
			if(c1=="INDIA")
			{
					JComboBox cbo1=new JComboBox(s1);
					cbo1.setBounds(250,460,250,30);
					c.add(cbo1);
			}
			else if(c1=="PAKISTAN")
			{	
					 JComboBox cbo2=new JComboBox(s2);
					cbo2.setBounds(250,480,250,30);
					c.add(cbo2);
			}
			else if(c1=="BANGLADESH")
			{	
					JComboBox cbo3=new JComboBox(s3);
					cbo3.setBounds(250,500,250,30);
					c.add(cbo3);
			}
	}
		});

		JLabel gender=new JLabel("Gender : ");
		gender.setBounds(50,200,60,30);
		gender.setForeground(Color.WHITE);
		male=new JRadioButton("Male");
		male.setBounds(150,200,100,50);
		male.setBorder(border);
		male.setBorderPainted(true);
		female=new JRadioButton("Female");
		//female.setEnabled(false);
		female.setBounds(270,200,100,50);
		female.setBorder(border);
		female.setBorderPainted(true);
		ButtonGroup g=new ButtonGroup();
		g.add(male);
		g.add(female);

		address=new JLabel("Address : ");
		address.setBounds(50,250,60,30);
		address.setForeground(Color.WHITE);
		area=new JTextArea();
		area.setBounds(150,260,220,50);
		area.setBorder(border);
		course=new JLabel("Courses Offered : ");
		course.setBounds(50,320,130,50);
		course.setForeground(Color.WHITE);
		cb1=new JCheckBox("Core Java",true);
		cb1.setBounds(170,320,100,50);
		cb1.setBorder(border);
		cb1.setBorderPainted(true);
		cb2=new JCheckBox("Advanced Java");
		cb2.setBounds(300,320,130,50);
		cb2.setBorder(border);
		cb2.setBorderPainted(true);
		cb3=new JCheckBox("Oracle");
		cb3.setBounds(460,320,80,50);
		cb3.setBorder(border);
		cb3.setBorderPainted(true);
		terms=new JCheckBox("I Accept");
		terms.setBounds(50,390,250,30);
		terms.setBorder(border);
		terms.setBorderPainted(true);
		output=new JTextArea();
		output.setBounds(560,60,300,350);
		output.setBorder(border);
		btn1=new JButton("Submit");
		btn1.setBounds(150,440,80,40);
		btn1.setBorder(border);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				if(terms.isSelected())
				{
					String name1=name_t.getText();
					String mobile1=mobile_t.getText();
					String day1=(String)day.getSelectedItem();
					String month1=(String)month.getSelectedItem();
					String year1=(String)year.getSelectedItem();
					String dob=day1+"-"+month1+"-"+year1;
					String add=area.getText();
					String gen="Male";
					//String[] crs=new String[3];
					String crs="";
					if(cb1.isSelected())
					{
						//crs[0]=cb1.getText();
						crs=crs+" "+cb1.getText();
					}
					if(cb2.isSelected())
					{
						//crs[1]=cb2.getText();
						crs=crs+" "+cb2.getText();
					}
					if(cb3.isSelected())
					{
						//crs[2]=cb3.getText();
						crs=crs+" "+cb3.getText();
					}
					if(female.isSelected())
						gen="Female";
					System.out.println(cb1.getText());
					output.setText("Name :"+name1+"\nMobile : "+mobile1+"\nDay : "+day1+"\nMonth:"+
					month1+"\nYear : "+year1+"\n Gneder : "+gen+"\nAddress :"+add
					+"\nCourse Selected : "+crs);
					
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajat");
						PreparedStatement ps=con.prepareStatement("insert into registrationform values(?,?,?,?,?)");
						ps.setString(1,name1);
						ps.setString(2,mobile1);
						ps.setString(3,dob);
						ps.setString(4,gen);
						ps.setString(5,add);
						int i=ps.executeUpdate();
						JLabel message=new JLabel("records inserted  :"+i);
						message.setBounds(150,400,120,40);
						f.add(message);
						f.repaint();
						
							
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}

				}

				
			}
		});
		c.add(name);
		c.add(output);
		c.add(name_t);
		c.add(mobile);
		c.add(mobile_t);
		c.add(dob);
		c.add(day);
		c.add(month);
		c.add(year);
		c.add(gender);
		c.add(male);
		c.add(female);
		c.add(address);
		c.add(area);
		c.add(course);
		c.add(cb1);
		c.add(cb2);
		c.add(cb3);
		c.add(terms);
		c.add(btn1);
		f.repaint();
	}
	/*public static Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			return conn;
		}
		catch (Exception e)
		{
			return null;
		}
	}*/
}
