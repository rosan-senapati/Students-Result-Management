package AddDetailsPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddData_ChooseSem {
    JFrame frame;
    JLabel l1,l2,l3;
    JButton b1, b2, b3,b4,b5;
    JTextField t1,t2;

    public AddData_ChooseSem() {
        // For frame
        frame = new JFrame("SGPA Generator"); // THis Needs to be updated
        frame.setLocation(100, 100);
        frame.setSize(600, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // For Label-1
        l1 = new JLabel("Select Semesster: ");
        l1.setBounds(100, 80, 600, 100);
        l1.setFont(new Font("Arial", Font.BOLD, 50));
        frame.add(l1);

        //For Label-2
        l2 = new JLabel("Enter SIC: ");
        l2.setBounds(130, 150, 150, 100);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(l2);

        //For  Text-1
        t1=new JTextField();
        t1.setBounds(260,189,150,25);
        frame.add(t1);


        //For Label-3
        l3 = new JLabel("Enter Name: ");
        l3.setBounds(450, 150, 150, 100);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(l3);

        //For  Text-2
        t2=new JTextField();
        t2.setBounds(620,189,150,25);
        frame.add(t2);

        //For Button-5
        b5=new JButton("Submit");
        b5.setBounds(810,188,120,25);
        frame.add(b5);
        
        // For Button-1
        b1 = new JButton("SEM-1");
        b1.setBounds(100, 250, 200, 50);
        b1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg1) {
              SEM1 sm1 = new SEM1();
            }
          });
      
        frame.add(b1);

        // For Button-2
        b2 = new JButton("SEM-2");
        b2.setBounds(320, 250, 200, 50);
        b2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        b2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg3) {
            SEM2 sm2 = new SEM2();
          }
        });
        frame.add(b2);

        // For Button-3
        b3 = new JButton("SEM-3");
        b3.setBounds(540, 250, 200, 50);
        b3.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        b3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg3) {
            SEM3 sm3 = new SEM3();
          }
        });
        frame.add(b3);

        // For Button-4
        b4 = new JButton("SEM-4");
        b4.setBounds(760, 250, 200, 50);
        b4.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        b4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg4) {
            SEM4 sm4 = new SEM4();
          }
        });
        frame.add(b4);

        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     AddData_ChooseSem ac = new AddData_ChooseSem();
    // }
}
