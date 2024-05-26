package AddDetailsPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SEM4 {
  JFrame frame;
  JLabel h1, h2, h3, l1, p1, p2, p3;
  JTextField t1, t7, t8, t9;

  JButton b1, b2;
  String sic;

  public SEM4(String sic) {
    this.sic = sic;

    // For Frame
    frame = new JFrame("SGPA Generator"); // THis Needs to be updated
    frame.setLocation(100, 100);
    frame.setSize(600, 600);
    frame.setResizable(false);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setLayout(null);

    // For Heading-1
    h1 = new JLabel("ENTER SUBJECT DETAILS");
    h1.setBounds(450, 30, 700, 50);
    h1.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
    frame.add(h1);

    // For Heading-2
    h2 = new JLabel("Theory:");
    h2.setBounds(200, 100, 550, 50);
    h2.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
    frame.add(h2);

    // For Label-1
    l1 = new JLabel("1.MOOC:");
    l1.setBounds(350, 170, 300, 50);
    l1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
    frame.add(l1);

    // For Text-1
    t1 = new JTextField("");
    t1.setBounds(800, 170, 100, 30);
    frame.add(t1);

    // For HEading-3
    h3 = new JLabel("Practicals: ");
    h3.setBounds(200, 490, 550, 50);
    h3.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
    frame.add(h3);

    // For Practical-1
    p1 = new JLabel("1.Project:");
    p1.setBounds(350, 550, 400, 50);
    p1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
    frame.add(p1);

    // For Practical-2
    p2 = new JLabel("2.Comprehensive Viva:");
    p2.setBounds(350, 600, 400, 50);
    p2.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
    frame.add(p2);

    // For Practical-3
    p3 = new JLabel("3.Yoga/NCC/NSS:");
    p3.setBounds(350, 650, 400, 50);
    p3.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
    frame.add(p3);

    // For Text-7
    t7 = new JTextField("");
    t7.setBounds(800, 557, 100, 30);
    frame.add(t7);

    // For Text-8
    t8 = new JTextField("");
    t8.setBounds(800, 607, 100, 30);
    frame.add(t8);

    // For Text-9
    t9 = new JTextField("");
    t9.setBounds(800, 656, 100, 30);
    frame.add(t9);

    // For Button-1
    b1 = new JButton("ADD");
    b1.setBounds(350, 710, 200, 50);
    b1.setFont(new Font("Arial", Font.BOLD, 20));
    /**************************************
     * 23-05-24***********************************************************
     */
    /* Here i Implemented to push All the Mark detail to SEM_4 table */
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try {
          // here i Implimented to parse empty or non empty string to integer
          int mooc = (t1.getText().length() != 0) ? Integer.parseInt(t1.getText()) : 0;
          int project = (t7.getText().length() != 0) ? Integer.parseInt(t7.getText()) : 0;
          int comp_viva = (t8.getText().length() != 0) ? Integer.parseInt(t8.getText()) : 0;
          int yoga_ncc_nss = (t9.getText().length() != 0) ? Integer.parseInt(t9.getText()) : 0;
          Class.forName("oracle.jdbc.driver.OracleDriver");

          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
          String qry = "INSERT INTO SEM_4 VALUES('" + sic.toUpperCase() + "'," + mooc + "," + project + "," + comp_viva + ","
              + yoga_ncc_nss + ")";
          Statement s1 = conn.createStatement();
          int i = s1.executeUpdate(qry);
          if (i > 0) {
            JOptionPane.showMessageDialog(frame, "Data Added");

          }
          s1.close();
          conn.close();

        } catch (ClassNotFoundException cne) {
          System.out.println(cne);
        } catch (SQLException se) {
          System.out.println(se);
          JOptionPane.showMessageDialog(frame, "Enter Valid Input", "Alert", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ne) {
          System.out.println(ne);
          JOptionPane.showMessageDialog(frame, "Enter Valid Input", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        t1.setText(null);
        t7.setText(null);
        t8.setText(null);
        t9.setText(null);

      }
    });
    frame.add(b1);

    // For Button-2
    b2 = new JButton("CLEAR");
    b2.setBounds(750, 710, 200, 50);
    b2.setFont(new Font("Arial", Font.BOLD, 20));
    // Clear Button Fun
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg2) {
        t1.setText(null);
        t7.setText(null);
        t8.setText(null);
        t9.setText(null);
      }
    });
    frame.add(b2);

    frame.setVisible(true);

  }

  // public static void main(String args[]) {
  //   SEM4 sm = new SEM4("23mmci36");
  // }
}
