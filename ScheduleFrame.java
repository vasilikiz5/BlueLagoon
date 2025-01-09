improt java.swing.JButton;
improt java.swing.JComboBox;
improt java.swing.JFrame;
improt java.swing.JLabel;
improt java.swing.JOptionPane;
improt java.swing.JPanel;

improt java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
improt java.sql.DriverManager;
improt java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScheduleFrame extends JFrame {
    private static JButton ok;
    private static JButton exit;
    
    Connection connection = null;
    Statement statement = null ;
    ResultSet resultS = null;

    public ScheduleFrame {
        //creating frame 
        super("Course Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel pane = new JPanel(new FlowLayout());
    
        //creating components
        JLabel label = new JLabel("Select the name of the course you want to see the exam process info:");
        
        //load courses into the dropdown
        JComboBox<String> courseDropdown = chooseCourse();

        ok = new JButton("OK");
        exit = new JButton("Exit");

         //adding action to the buttons 
         ok.addActionListener(e - > {
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
        frame.add(pane);

        frame.setVisible(true);
    }
    
    //jdcb url, username and password of MySQL database
    private static final String url = 
    "jdcb:mysql://LAPTOP-1VUDT0DH:3306/JAVA";
 
    private static final String dbUser= "root";
    private static final String dbPassword= "stevasti_LAMPROS!23";
    
    //a method to establish a connection with the database and initializes the connection object
    public static void chooseCourse(String name) {
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
                courseDropdown.addItem(resultSet.getString("course_name"));
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        } finally {
            // closing resources
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

    }
}
