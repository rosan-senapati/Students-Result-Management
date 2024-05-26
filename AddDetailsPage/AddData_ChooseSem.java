package AddDetailsPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddData_ChooseSem {
  JFrame frame;
  JLabel l1, l2, l3;
  JButton b1, b2, b3, b4, b5,b6;
  JTextField t1, t2;

  public AddData_ChooseSem() {
    // For frame
    frame = new JFrame("SGPA Generator"); // This Needs to be updated
    frame.setLocation(100, 100);
    frame.setSize(600, 600);
    frame.setResizable(false);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(null);

    // For Label-1
    l1 = new JLabel("Select Semesster: ");
    l1.setBounds(100, 80, 600, 100);
    l1.setFont(new Font("Arial", Font.BOLD, 50));
    frame.add(l1);

    // For Label-2
    l2 = new JLabel("Enter SIC: ");
    l2.setBounds(130, 150, 150, 100);
    l2.setFont(new Font("Arial", Font.BOLD, 20));
    frame.add(l2);

    // For Text-1
    t1 = new JTextField();
    t1.setBounds(260, 189, 150, 25);
    frame.add(t1);

    // For Label-3
    l3 = new JLabel("Enter Name: ");
    l3.setBounds(450, 150, 150, 100);
    l3.setFont(new Font("Arial", Font.BOLD, 20));
    frame.add(l3);

    // For Text-2
    t2 = new JTextField();
    t2.setBounds(620, 189, 150, 25);
    frame.add(t2);

    // For Button-1
    b1 = new JButton("SEM-1");
    b1.setBounds(100, 250, 200, 50);
    b1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg1) {
        SEM1 sm1 = new SEM1(t1.getText().toUpperCase());
      }
    });

    frame.add(b1);
    b1.setVisible(false);

    // For Button-2
    b2 = new JButton("SEM-2");
    b2.setBounds(320, 250, 200, 50);
    b2.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg3) {
        SEM2 sm2 = new SEM2(t1.getText().toUpperCase());
      }
    });
    frame.add(b2);
    b2.setVisible(false);

    // For Button-3
    b3 = new JButton("SEM-3");
    b3.setBounds(540, 250, 200, 50);
    b3.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg3) {
       SEM3 sm3 = new SEM3(t1.getText().toUpperCase());
      }
    });
    frame.add(b3);
    b3.setVisible(false);

    // For Button-4
    b4 = new JButton("SEM-4");
    b4.setBounds(760, 250, 200, 50);
    b4.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
    b4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg4) {
        SEM4 sm4 = new SEM4(t1.getText().toUpperCase());
      }
    });
    frame.add(b4);
    b4.setVisible(false);

    // For Button-5
    b5 = new JButton("Submit");
    b5.setBounds(810, 188, 120, 25);

    // ************************************21-05-24 modified here*************************************
    /*
     * Here i Added the Functionality for submit button
     * 1.it will check user inserted both field or not
     * 2.if true then we will add the data to STUDENT_INFO database
     * 3.if data already existed it will show respective message
     * 4.if user left any field empty or one field emppty it will show respective
     * message
     */

    b5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        String sic = t1.getText().toUpperCase();
        String name = t2.getText().toUpperCase();
        // to check user filled both the fields or not
        if (name.length() == 0 || sic.length() == 0)
          JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!!!", "Important",
              JOptionPane.WARNING_MESSAGE);
        // to add the data to database
        else {
          try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
            String qry = "INSERT INTO STUDENT_INFO VALUES('" + sic + "','" + name + "')";
            Statement s1 = conn.createStatement();
            int i = s1.executeUpdate(qry);
            if (i > 0) {
              JOptionPane.showMessageDialog(frame, "Data Inserted");
          b1.setVisible(true);
          b2.setVisible(true);
          b3.setVisible(true);
          b4.setVisible(true);

            }
            s1.close();
            conn.close();

          } catch (ClassNotFoundException cn) {
            System.out.println(cn);
          } catch (SQLException se) {
            System.err.println(se);
            // if data already exist then show this message
            JOptionPane.showMessageDialog(frame, "Data Already Existed..");
          

          }
          // t1.setText(null);
          // t2.setText(null);
          //This is for showing semester button after successfully submiting the data
          
        }

      }
    });
    frame.add(b5);

    // ImageIcon icon = new ImageIcon("home.png");
    // b6 = new JButton();
    // Image img = icon.getImage();
    // Image newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
    // icon = new ImageIcon(newimg);  
    // b6.setIcon(icon);
    // b6.setBounds(1470,40,40,40);
    // b6.addActionListener(new ActionListener() {
    //   public void actionPerformed(ActionEvent arg) {
       
    //   }
    // });
    // frame.add(b6);

    frame.setVisible(true);
  }

  // public static void main(String[] args) {
  // AddData_ChooseSem ac = new AddData_ChooseSem();
  // }
}
