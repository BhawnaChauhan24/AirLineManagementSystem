package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JButton close,reset,submit;
	JTextField tfusername;
	JPasswordField tfpassword;
	
	public Login()
	{
		
	getContentPane().setBackground(Color.white);
	setLayout(null);
	
	JLabel lblLogin = new JLabel("Login Account");
	lblLogin.setBounds(140,10,100,20);
    lblLogin.setForeground(Color.black);
	lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
	add(lblLogin);

	
	JLabel lblusername = new JLabel("Username");
	lblusername.setBounds(20,40,100,20);
	add(lblusername);

	JLabel lblpassword = new JLabel("Password");
	lblpassword.setBounds(20,70,100,20);
	add(lblpassword);	
	
	tfusername = new JTextField();
	tfusername.setBounds(130,40,200,20);
	add(tfusername);
	
	tfpassword = new JPasswordField();
	tfpassword.setBounds(130,70,200,20);
	add(tfpassword);
	
	reset = new JButton("Reset");
    reset.setBounds(40, 120, 120, 20);
    reset.addActionListener(this);
    add(reset);
    
    submit = new JButton("Submit");
    submit.setBounds(190, 120, 120, 20);
    submit.addActionListener(this);
    add(submit);
    
    close = new JButton("Close");
    close.setBounds(120, 160, 120, 20);
    close.addActionListener(this);
    add(close);
	
    setSize(400, 250);
    setTitle("Login Account");
    setLocation(600, 250);
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
        