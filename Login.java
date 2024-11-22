package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton close,reset,submit;
	  JTextField tfusername;
	    JPasswordField tfpassword;
	
	public Login(){
		
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setLayout(null);
	
	JLabel lblLogin = new JLabel("Login Account");
	lblLogin.setBounds(150,15,250,60);
	lblLogin.setForeground(Color.BLACK);
	lblLogin.setFont(new Font("Tahoma",Font.BOLD,19));
	add(lblLogin);
	
	
	JLabel lblusername = new JLabel("Username");
	lblusername.setBounds(15,70,100,30);
	lblusername.setBackground(Color.BLACK);
	lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
	add(lblusername);

	JLabel lblpassword = new JLabel("Password");
	lblpassword.setBounds(15,110,100,30);
	lblpassword.setFont(new Font("Tahoma",Font.BOLD,16));
	add(lblpassword);	
	
	tfusername = new JTextField();
	tfusername.setBounds(130,70,200,30);
	add(tfusername);
	
	tfpassword = new JPasswordField();
	tfpassword.setBounds(130,110,200,30);
	add(tfpassword);
	
	reset = new JButton("Reset");
    reset.setBounds(40, 150, 100, 40);
    reset.addActionListener(this);
    add(reset);
    
    submit = new JButton("Submit");
    submit.setBounds(190, 150, 100, 40);
    submit.addActionListener(this);
    add(submit);
    
    close = new JButton("Close");
    close.setBounds(120, 200, 100, 40);
    close.addActionListener(this);
    add(close);
    
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airplain.png"));
    Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(i2);
    JLabel lblimage = new JLabel(image);
    lblimage.setBounds(340, 0, 300, 300);
    add(lblimage);

	
    setSize(680, 320);
    setLocation(300, 150);
    setTitle("Login Account");
    setVisible(true);
    
	}
	
    public void actionPerformed(ActionEvent ae) {
    	if (ae.getSource() == submit) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                	new Home();
                	setVisible(false);


                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }    
            
    	}
    	else if (ae.getSource() == close) {
    		setVisible(false);
    	}
    	else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");
    	}
    }
    
	public static void main(String args[])
	{
		new Login();
	}
}
        