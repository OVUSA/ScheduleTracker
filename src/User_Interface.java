import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User_Interface extends JFrame{
    Tracker tracker;
    private static JTextField textField = new JTextField();



    public User_Interface(Tracker tracker){
       this.tracker = tracker;

    }

    public void init(){
        JFrame frame = new JFrame("Productivity tracker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton work = new JButton("Work");
        work.addActionListener(e -> textField.setText(tracker.getState().onWork()));
        JButton rest = new JButton("Rest");
        rest.addActionListener(e -> textField.setText(tracker.getState().onRest()));
        JButton stop = new JButton("Stop");
        rest.addActionListener(e -> textField.setText(tracker.getState().onStop()));

        frame.setVisible(true);
        frame.setSize(500,250);
        buttons.add(work);
        buttons.add(rest);

        this.pack();
    }


}
