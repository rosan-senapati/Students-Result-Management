package ShowDetails;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDetailsForm {
    JFrame frame;
    JLabel h1, l1, l2, l3;
    JTextField t1, t2, t3;
    JComboBox c1;
    JButton b1, b2;

    public ShowDetailsForm() {
        frame = new JFrame("SGPA Generator"); // THis Needs to be updated
        frame.setLocation(100, 100);
        frame.setSize(600, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // for the Heading-1
        h1 = new JLabel("Enter Details");
        h1.setBounds(200, 40, 700, 50);
        h1.setFont(new Font("Serif", Font.BOLD, 50));
        frame.add(h1);

        // For Label-1
        l1 = new JLabel("Enter SIC: ");
        l1.setBounds(260, 150, 200, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(l1);

        // For Text-1
        t1 = new JTextField();
        t1.setBounds(500, 158, 150, 30);
        frame.add(t1);

        // For Label-2
        l2 = new JLabel("Enter Name: ");
        l2.setBounds(260, 200, 200, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(l2);

        // For Text-1
        t2 = new JTextField();
        t2.setBounds(500, 210, 150, 30);
        frame.add(t2);

        // For Label-2
        l3 = new JLabel("Enter Semester: ");
        l3.setBounds(260, 250, 200, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(l3);

        // For ComboBox-1
        String[] semester = { "All","Semester-1", "Semester-2", "Semester-3", "Semester-4" };
        c1 = new JComboBox<>(semester);
        c1.setBounds(500, 260, 250, 30);
        c1.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(c1);

        // For Button-1
        b1 = new JButton("SHOW");
        b1.setBounds(260, 330, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(b1);

        // For Button-1
        b2 = new JButton("CLEAR");
        b2.setBounds(460, 330, 150, 40);
        b2.setFont(new Font("Arial", Font.PLAIN, 20));

        // Clear Function
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                t1.setText(null);
                t2.setText(null);
                c1.setSelectedIndex(0);
            }
        });

        frame.add(b2);

        frame.setVisible(true);


    }

    // public static void main(String[] args) {
    //     ShowDetailsForm ys = new ShowDetailsForm();
    // }
}