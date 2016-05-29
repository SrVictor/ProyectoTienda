import java.awt.EventQueue;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
 
public class Calendario {
 
  private JFrame frame;
 
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
          Calendario window = new Calendario();
          window.frame.setVisible(true);
  }
 
  /**
   * Create the application.
   */
  public Calendario() {
    initialize();
  }
 
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
         
    JDateChooser dateChooser = new JDateChooser();
    dateChooser.setDateFormatString("yyyy-MM-dd");
    dateChooser.setBounds(20, 20, 200, 20);
    frame.getContentPane().add(dateChooser);
  }
}