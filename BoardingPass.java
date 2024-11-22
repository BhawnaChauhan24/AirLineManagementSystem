package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.print.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener , Printable{
    
    JTextField tfpnr;
    JLabel tff_name,tfl_name, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labelseat, labeldate, labelcls;
    JButton fetchButton,printButton,close;
    
    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(380, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblf_name = new JLabel("FIRST NAME");
        lblf_name.setBounds(60, 140, 150, 25);
        lblf_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblf_name);
        
        tff_name = new JLabel();
        tff_name.setBounds(220, 140, 150, 25);
        add(tff_name);
        
        JLabel lbll_name = new JLabel("LAST NAME");
        lbll_name.setBounds(60, 180, 150, 25);
        lbll_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbll_name);
        
        tfl_name = new JLabel();
        tfl_name.setBounds(220, 180, 150, 25);
        add(tfl_name);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 220, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 220, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 260, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 260, 150, 25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 260, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 260, 150, 25);
        add(lbldest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 300, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 300, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 300, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 300, 150, 25);
        add(labelfcode);
        
        JLabel lblseat = new JLabel("Seat No.");
        lblseat.setBounds(60, 340, 150, 25);
        lblseat.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblseat);
        
        labelseat = new JLabel();
        labelseat.setBounds(220, 340, 150, 25);
        add(labelseat);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 380, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 380, 150, 25);
        add(labeldate);
        
        JLabel lblcls = new JLabel("Class");
        lblcls.setBounds(60, 420, 150, 25);
        lblcls.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcls);
        
        labelcls = new JLabel();
        labelcls.setBounds(220, 420, 150, 25);
        add(labelcls);
        
        printButton = new JButton("Print");
        printButton.setBackground(Color.BLACK);
        printButton.setForeground(Color.WHITE);
        printButton.setBounds(380, 420, 120, 25);
        printButton.addActionListener(this);
        add(printButton);
        
        close = new JButton("Close");
        close.setBounds(530, 420, 120, 25);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        setSize(1000, 500);
        setLocation(200, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tff_name.setText(rs.getString("f_name")); 
                tfl_name.setText(rs.getString("l_name")); 
                tfnationality.setText(rs.getString("nationality")); 
                lblsrc.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("dest"));  
                labelfname.setText(rs.getString("flightname"));  
                labelfcode.setText(rs.getString("flightcode"));
                labelseat.setText(rs.getString("SEAT_NO"));
                labeldate.setText(rs.getString("date")); 
                labelcls.setText(rs.getString("flightclass")); 
            } else{
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         if (ae.getSource() == close) {
    		setVisible(false);}
         if (ae.getSource() == printButton) {
            try {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(this);
                if (job.printDialog()) {
                    job.print();    
                }
            } catch (PrinterException e) {
                e.printStackTrace();
            }
         }
    }
  
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

       
        g.drawString("Boarding Pass", 100, 100);
        g.drawString("First Name: " + tff_name.getText(), 100, 120);
        g.drawString("Last Name: " + tfl_name.getText(), 100, 140);
        g.drawString("Nationality: " + tfnationality.getText(), 100, 160);
        g.drawString("Source: " + lblsrc.getText(), 100, 180);
        g.drawString("Destination: " + lbldest.getText(), 100, 200);
        g.drawString("Flight Name: " + labelfname.getText(), 100, 220);
        g.drawString("Flight Code: " + labelfcode.getText(), 100, 240);
        g.drawString("Seat No.: " + labelseat.getText(), 100, 260);
        g.drawString("Date: " + labeldate.getText(), 100, 280);
        g.drawString("Class: " + labelcls.getText(), 100, 300);
        return PAGE_EXISTS;
    }
    
    public static void main(String[] args) {
        new BoardingPass();
    }
}