
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import AddDetailsPage.*;
import calculateSGPA.YourSGPA;
import ShowDetails.*;

class Home {
  JFrame frame;
  JLabel l1, l2, l3, l4,background;
  JButton b1, b2, b3;
  // ImageIcon img;

  public Home() { // for the Main Frame
    frame = new JFrame("SGPA Generator"); // THis Needs to be updated
    frame.setLocation(100, 100);
    frame.setSize(600, 600);
    frame.setResizable(false);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(null);

    // //For Background Image
    // img = new ImageIcon("background.jpg");
    // background = new JLabel("",img,JLabel.CENTER);
    // background.setBounds(0,0,1536,800);
    // frame.add(background);


    // for the Label-1
    l1 = new JLabel("Welcome to SGPA Generator");
    l1.setBounds(550, 10, 700, 50);
    l1.setFont(new Font("Serif", Font.BOLD, 40));
    l1.setForeground(Color.RED);
    frame.add(l1);

    // For Label-2
    l2 = new JLabel("Add Your Semester Mark Details Here");
    l2.setBounds(300, 120, 400, 50);
    l2.setFont(new Font("Arial", Font.PLAIN, 20));
    frame.add(l2);

    // For Button-1
    b1 = new JButton("Add Details");
    // here I Coonected Home Page With AddData_ChooseSem
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        AddData_ChooseSem ac = new AddData_ChooseSem();
      }
    });
    b1.setBounds(300, 170, 130, 30);
    b1.setFont(new Font("Arial", Font.PLAIN, 15));
    frame.add(b1);

    // For Label-3
    l2 = new JLabel("Check Your Mark Details Here");
    l2.setBounds(300, 210, 300, 50);
    l2.setFont(new Font("Arial", Font.PLAIN, 20));
    frame.add(l2);

    // For Button-2
    b2 = new JButton("Show Details");
    b2.setBounds(300, 260, 130, 30);
    b2.setFont(new Font("Arial", Font.PLAIN, 15));
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        ShowDetailsForm sdf = new ShowDetailsForm();
      }
    });
    frame.add(b2);

    // For Label-4
    l2 = new JLabel("Calculate SGPA Here");
    l2.setBounds(300, 300, 300, 50);
    l2.setFont(new Font("Arial", Font.PLAIN, 20));
    frame.add(l2);

    // For Button-3
    b3 = new JButton("Calculate");
    b3.setBounds(300, 350, 115, 30);
    b3.setFont(new Font("Arial", Font.PLAIN, 15));
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        YourSGPA ys = new YourSGPA();
      }
    });
    frame.add(b3);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    Home home = new Home();
  }
}