package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tff_name,tfl_name, tfnationality, tfaddress, labelgender, labelfname, labelfcode, labelfamt, lblclass, lblpym;

    JButton bookflight, fetchButton, flight;
    Choice f_source, f_destination;
    JDateChooser dcdate;
    JComboBox<String> classComboBox,pymComboBox;
    
    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(490,20,500,35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
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
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 230, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 230, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 280, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 280, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 330, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 330, 150, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 380, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        f_source = new Choice();
        f_source.setBounds(220, 380, 150, 25);       
        add(f_source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 430, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        f_destination = new Choice();
        f_destination.setBounds(220, 430, 150, 25);       
        add(f_destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                f_source.add(rs.getString("f_source"));
                f_destination.add(rs.getString("f_destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 430, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 480, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 480, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 530, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 530, 150, 25);
        add(labelfcode);
        
        JLabel lblfamt = new JLabel("Ticket Amount");
        lblfamt.setBounds(60, 580, 150, 25);
        lblfamt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfamt);
        
        labelfamt = new JLabel();
        labelfamt.setBounds(220, 580, 150, 25);
        add(labelfamt);
         
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(700, 80, 120, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(860, 80, 150, 25);
        add(dcdate);
        
        lblclass = new JLabel("Select Class");
        lblclass.setBounds(700, 130, 150, 25);
        lblclass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblclass);

        String[] classOptions = {"Normal", "Business"};
        classComboBox = new JComboBox<>(classOptions);
        classComboBox.setBounds(860, 130, 150, 25);
        add(classComboBox);
        
        lblpym = new JLabel("Payment Mode");
        lblpym.setBounds(700, 180, 150, 25);
        lblpym.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpym);

        String[] pymOptions = {"Cash", "Card","UPI"};
        pymComboBox = new JComboBox<>(pymOptions);
        pymComboBox.setBounds(860, 180, 150, 25);
        add(pymComboBox);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(700, 250, 500, 410);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(860, 230, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
    	setVisible(true);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from passenger where aadhar = '"+aadhar+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tff_name.setText(rs.getString("f_name")); 
                    tfl_name.setText(rs.getString("l_name")); 
                    tfnationality.setText(rs.getString("nationality")); 
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));                 
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = f_source.getSelectedItem();
            String dest = f_destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where f_source = '"+src+"' and f_destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name")); 
                    labelfcode.setText(rs.getString("f_code"));
                    labelfamt.setText(rs.getString("f_amt"));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String f_name = tff_name.getText(); 
            String l_name = tfl_name.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String flightamt = labelfamt.getText();
            String src = f_source.getSelectedItem(); 
            String dest = f_destination.getSelectedItem();
            String flightclass = (String) classComboBox.getSelectedItem();
            String flightpym = (String) pymComboBox.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            
            try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+f_name+"', '"+l_name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+flightamt+"', '"+src+"', '"+dest+"', 'Seat_NO-"+random.nextInt(100)+"','"+date+"','"+flightclass+"','"+flightpym+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }
}