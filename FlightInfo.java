package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.MessageFormat;

import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame implements ActionListener{
	 JButton printButton,close ;
	 JTable table;
	public FlightInfo() {
		
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table = new JTable();
        
        JLabel heading = new JLabel("Flights Information");
        heading.setBounds(250,15,500,35);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 80, 800, 200);
        add(jsp);
		
        printButton = new JButton("Print");
        printButton.setBounds(250, 350, 100, 30);
        printButton.setForeground(Color.WHITE);
        printButton.setBackground(Color.BLACK);
        printButton.addActionListener(this); 
        add(printButton);
        
        close = new JButton("Back");
        close.setBounds(450, 350, 100, 30);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.addActionListener(this);
        add(close);
        
        setSize(800, 500);
        setLocation(200, 100);
        setVisible(true); 
		
	}
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == printButton) {
            try {
                MessageFormat header = new MessageFormat("Flights Information");
                MessageFormat footer = new MessageFormat("Page {0}");
                boolean printed = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);

                if (printed) {
                    JOptionPane.showMessageDialog(this, "Printed Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing Cancelled");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to Print: " + e.getMessage());
            }
            
        }
        else if (ae.getSource() == close) {
    		setVisible(false);
    }
  }
	
    public static void main(String[] args) {
        new FlightInfo();
    }
}
