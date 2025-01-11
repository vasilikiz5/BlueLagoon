import java.swing.JButton;
import java.swing.JComboBox;
import java.swing.JFrame;
import java.swing.JLabel;
import java.swing.JOptionPane;
import java.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScheduleFrame extends JFrame {
    private static JButton ok;
    private static JButton exit;
    
    Connection connection = null;
    Statement statement = null ;
    ResultSet resultS = null;

    public ScheduleFrame() {
        //create frame 
        super("Course Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

        JPanel pane = new JPanel(new FlowLayout());
    
        //create components
        JLabel label = new JLabel("Select the name of the course you want to see the exam process info:");
        
        //load courses into the dropdown
        JComboBox<String> courseDropdown = chooseCourse();

        ok = new JButton("OK");
        exit = new JButton("Exit");

         //add action to the buttons 
         ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add the new page 
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pane.add(label);
        pane.add(courseDropdown);
        pane.add(ok);
        pane.add(exit);
        this.add(pane);

        this.setVisible(true);
    }
    
    //jdcb url, username and password of MySQL database
    private static final String url = 
    "jdbc:mysql://LAPTOP-1VUDT0DH:3306/JAVA";
 
    private static final String dbUser= "root";
    private static final String dbPassword= "stevasti_LAMPROS!23";
    
    //a method to establish a connection with the database and initializes the connection object
    public JComboBox<String> chooseCourse(String name) {
        
        JComboBox<String> courseDropdown = new JComboBox<>();
        try {
            connection = DriverManager.getConnection(url);			
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			System.exit(0);
		}
        //execute SQL statements 
        try {           
            statement = connection.createStatement();
            resultS = statement.executeQuery("SELECT course_name FROM COURSE" );
            
            while (resultS.next()) {
                //adding the available courses to the dropdown
                courseDropdown.addItem(resultS.getString("course_name"));
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        } finally {
            // close resources
            try {
                if (resultS != null) resultS.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
        return courseDropdown;
    }
    public static void main (String[] args) {
        new ScheduleFrame();
    }
}
