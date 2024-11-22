package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tff_name,tfl_name, cancellationno, lblfcode, lbldateoftravel, labelseat;
    JButton fetchButton, flight,close;
    
    public Cancel() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblf_name = new JLabel("First Name");
        lblf_name.setBounds(60, 130, 150, 25);
        lblf_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblf_name);
        
        tff_name = new JLabel();
        tff_name.setBounds(220, 130, 150, 25);
        add(tff_name);
        
        JLabel lbll_name = new JLabel("Last Name");
        lbll_name.setBounds(60, 180, 150, 25);
        lbll_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbll_name);
        
        tfl_name = new JLabel();
        tfl_name.setBounds(220, 180, 150, 25);
        add(tfl_name);
        
        JLabel lblnationality = new JLabel("Cancellation No");
        lblnationality.setBounds(60, 230, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 230, 150, 25);
        add(cancellationno);
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 280, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 280, 150, 25);
        add(lblfcode);
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 330, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 330, 150, 25);
        add(lbldateoftravel);
        
        JLabel lblseat = new JLabel("Seat No.");
        lblseat.setBounds(60, 380, 150, 25);
        lblseat.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblseat);
        
        labelseat = new JLabel();
        labelseat.setBounds(220, 380, 150, 25);
        add(labelseat);
        
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 430, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        close = new JButton("Close");
        close.setBounds(390, 430, 120, 25);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);
        
        setSize(800, 550);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tff_name.setText(rs.getString("f_name"));
                    tfl_name.setText(rs.getString("l_name"));
                    lblfcode.setText(rs.getString("flightcode")); 
                    lbldateoftravel.setText(rs.getString("date"));
                    labelseat.setText(rs.getString("SEAT_NO")); 
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String f_name = tff_name.getText();
            String l_name = tfl_name.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
            String SEAT_NO = labelseat.getText(); 
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+f_name+"', '"+l_name+"', '"+cancelno+"', '"+fcode+"', '"+date+"', '"+SEAT_NO+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        if (ae.getSource() == close) {
    		setVisible(false);
    		}   
    }

    public static void main(String[] args) {
        new Cancel();
    }
}