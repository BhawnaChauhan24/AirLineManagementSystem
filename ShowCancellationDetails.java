package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ShowCancellationDetails extends JFrame{
	
	public ShowCancellationDetails() {
		
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try {
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from cancel");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);
		
        setSize(800, 500);
        setTitle("Show Cancelled Ticket");
        setLocation(200, 100);
        setVisible(true); 
		
	}
	
    public static void main(String[] args) {
        new ShowCancellationDetails();
    }
}
