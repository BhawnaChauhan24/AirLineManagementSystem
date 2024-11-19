package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{

	
	public Home()
	{
	setLayout(null);
	
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 1300,700);
    add(image);
    
    JLabel heading = new JLabel("AIR INDIA WELCOMES YOU.....");
    heading.setBounds(430, 40, 1000, 40);
    heading.setForeground(Color.BLUE);
    heading.setFont(new Font("Tahoma", Font.BOLD, 36));
    image.add(heading);
    
    JMenuBar menubar = new JMenuBar();
    setJMenuBar(menubar);
	
    JMenu details = new JMenu("Details");
    menubar.add(details);
    

    
    JMenuItem customerDetails = new JMenuItem("Add Customer Details");
    customerDetails.addActionListener(this);
    details.add(customerDetails);
    
    JMenuItem bookFlight = new JMenuItem("Book Flight");
    bookFlight.addActionListener(this);
    details.add(bookFlight);
    
    JMenu view = new JMenu("View");
    menubar.add(view);
    
    JMenuItem flightDetails = new JMenuItem("Flight Details");
    flightDetails.addActionListener(this);
    view.add(flightDetails);
    
    JMenuItem ShowCustomerDetails = new JMenuItem("Show Customer Details");
    ShowCustomerDetails.addActionListener(this);
    view.add(ShowCustomerDetails);
    
    JMenuItem showticket = new JMenuItem("Show Tickets");
    showticket.addActionListener(this);
    view.add(showticket);
    
    JMenuItem journeyDetails = new JMenuItem("Journey Details");
    journeyDetails.addActionListener(this);
    view.add(journeyDetails);
    
    JMenuItem Cancel = new JMenuItem("Cancel Ticket");
    Cancel.addActionListener(this);
    details.add(Cancel);
    
    JMenuItem ShowCancellationDetails = new JMenuItem("Show Cancellation Details");
    ShowCancellationDetails.addActionListener(this);
    view.add(ShowCancellationDetails);
    
    JMenu ticket = new JMenu("Ticket");
    menubar.add(ticket);
    
    JMenuItem BoardingPass = new JMenuItem("Boarding Pass");
    BoardingPass.addActionListener(this);
    ticket.add(BoardingPass);
    
	setVisible(true);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	 public void actionPerformed(ActionEvent ae) {
	        String text = ae.getActionCommand();
	        if (text.equals("Add Customer Details")) {
	            new AddCustomer();
	         
	        } 
	        else if (text.equals("Show Customer Details")) {
	            new ShowCustomerDetails();
	        }
	        else if (text.equals("Flight Details")) {
	            new FlightInfo();
	        }
	        else if (text.equals("Book Flight")) {
	            new BookFlight();
	        }
	        else if (text.equals("Show Tickets")) {
	            new ShowTicket();
	        }
	        else if (text.equals("Journey Details")) {
	            new JourneyDetails();
	        } 
	        else if (text.equals("Cancel Ticket")) {
	            new Cancel();
	        }
	        else if (text.equals("Show Cancellation Details")) {
	            new ShowCancellationDetails();
	        }
	        else if (text.equals("Boarding Pass")) {
	            new BoardingPass();
	        }
	        
	    }
	public static void main(String args[])
	{
		new Home();
	}
}
        
