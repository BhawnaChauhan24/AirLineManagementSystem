package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	JButton lg,close;
	JFrame f;

	public Dashboard()

	{
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
	    f= new JFrame( "Dashboard");
	    f.setBackground(Color.WHITE);
	    f.setLayout(null);
	
		JLabel heading = new JLabel("AIRLINE MANAGEMENT SYSTEM");
		heading.setBounds(60, 30, 1800, 60);
		heading.setFont(new Font("serif",Font.PLAIN, 50));
		heading.setForeground(Color.DARK_GRAY);
		add(heading);
		

		
		lg = new JButton("Login");
	    lg.setBounds(500, 400, 150, 50);
	    lg.setFont(new Font("serif",Font.ITALIC, 25));
	    lg.setBackground(Color.BLACK);
	    lg.setForeground(Color.WHITE);
	    lg.addActionListener(this);
	    add(lg);
	    
	    close = new JButton("Exit");
	    close.setBounds(700,400, 150, 50);
	    close.setFont(new Font("serif",Font.ITALIC, 25));
	    close.setBackground(Color.BLACK);
	    close.setForeground(Color.WHITE);
	    close.addActionListener(this);
	    add(close);
	    
	    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/dashboard.jpg"));
	    JLabel image = new JLabel(i1);
	    image.setBounds(0, 0, 1400, 1400);
	    add(image);
	    
    	setVisible(true);
    	setTitle("Dashboard");
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	 public void actionPerformed(ActionEvent ae) {
	        String text = ae.getActionCommand();
	        if (text.equals("Login")) {
	            new Login();
	         
	        } 
	    	else if (ae.getSource() == close) {
	    		setVisible(false);
	 }
	 }

	public static void main(String args[])
	{
		new Dashboard();
	}
}


