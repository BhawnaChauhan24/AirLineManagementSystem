package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.MessageFormat;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show,printButton,close;
    
    public JourneyDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        printButton = new JButton("Print");
        printButton.setBackground(Color.BLACK);
        printButton.setForeground(Color.WHITE);
        printButton.setBounds(420, 50, 120, 25);
        printButton.addActionListener(this);
        add(printButton);
        
        close = new JButton("Back");
        close.setBounds(550, 50, 120, 25);
        close.setForeground(Color.WHITE);
        close.setBackground(Color.BLACK);
        close.addActionListener(this);
        add(close);
        
        JLabel heading = new JLabel("Journey Details");
        heading.setBounds(380, 80, 150, 100);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 800, 100);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(800, 600);
        setTitle("Journey Details");
        setLocation(200, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
   
        if (ae.getSource() == printButton) {
            try {
                MessageFormat header = new MessageFormat("Customer Details Report");
                MessageFormat footer = new MessageFormat("Page {0}");
                boolean printed = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                if (printed) {
                    JOptionPane.showMessageDialog(this, "Printed Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Printing Cancelled");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }         else if (ae.getSource() == close) {
    		setVisible(false);
    
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}