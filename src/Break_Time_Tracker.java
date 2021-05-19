import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Break_Time_Tracker extends JFrame{
    private JPanel mainPanel;
    private JTextField celsiusTextField;
    private JButton STARTButton;

    public Break_Time_Tracker(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // grab a description
                //

            }
        });
    }
    public static void main(String [] args){
        JFrame frame = new Break_Time_Tracker("Track the time spend on resting.");
        frame.setVisible(true);
    }


}
