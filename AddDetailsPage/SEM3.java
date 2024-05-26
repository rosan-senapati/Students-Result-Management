package AddDetailsPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SEM3 {
    JFrame frame;
    JLabel h1, h2, h3, l1, l2, l3, l4, l5, l6, p1, p2, p3, p4;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

    JButton b1, b2;

    String sic;

    public SEM3(String sic) {
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
        l1 = new JLabel("1.DAA:");
        l1.setBounds(350, 170, 300, 50);
        l1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l1);

        // For Text-1
        t1 = new JTextField("");
        t1.setBounds(800, 170, 100, 30);
        frame.add(t1);

        // For Text-2
        t2 = new JTextField("");
        t2.setBounds(800, 227, 100, 30);
        frame.add(t2);

        // For Text-3
        t3 = new JTextField("");
        t3.setBounds(800, 283, 100, 30);
        frame.add(t3);

        // For Text-4
        t4 = new JTextField("");
        t4.setBounds(800, 333, 100, 30);
        frame.add(t4);

        // For Text-5
        t5 = new JTextField("");
        t5.setBounds(800, 383, 100, 30);
        frame.add(t5);

        // For Text-6
        t6 = new JTextField("");
        t6.setBounds(800, 430, 100, 30);
        frame.add(t6);

        // For Label-2
        l2 = new JLabel("2.Web Development:");
        l2.setBounds(350, 220, 400, 50);
        l2.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l2);

        // For Label-3
        l3 = new JLabel("3.PE-1:");
        l3.setBounds(350, 270, 400, 50);
        l3.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l3);

        // For Label-4
        l4 = new JLabel("4.PE-2:");
        l4.setBounds(350, 320, 400, 50);
        l4.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l4);

        // For Label-5
        l5 = new JLabel("5.PE-3:");
        l5.setBounds(350, 370, 400, 50);
        l5.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l5);

        // For Label-6
        l6 = new JLabel("6.UHV & PE:");
        l6.setBounds(350, 420, 400, 50);
        l6.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l6);

        // For HEading-3
        h3 = new JLabel("Practicals: ");
        h3.setBounds(200, 490, 550, 50);
        h3.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        frame.add(h3);

        // For Practical-1
        p1 = new JLabel("1.DAA Lab:");
        p1.setBounds(350, 550, 400, 50);
        p1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p1);

        // For Practical-2
        p2 = new JLabel("2.PYTHON Lab:");
        p2.setBounds(350, 600, 400, 50);
        p2.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p2);

        // For Practical-3
        p3 = new JLabel("3.WEB DEV Lab:");
        p3.setBounds(350, 650, 400, 50);
        p3.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p3);

        // For Practical-4
        p4 = new JLabel("4.Summer Internship Lab:");
        p4.setBounds(350, 700, 400, 50);
        p4.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p4);

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

        // For Text-10
        t10 = new JTextField("");
        t10.setBounds(800, 710, 100, 30);
        frame.add(t10);

        // For Button-1
        b1 = new JButton("ADD");
        b1.setBounds(350, 750, 200, 50);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        /**************************************
         * 23-05-24***********************************************************
         */
        /* Here i Implemented to push All the Mark detail to SEM_3 table */
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                try {
                    // here i Implimented to parse empty or non empty string to integer
                    int daa = (t1.getText().length() != 0) ? Integer.parseInt(t1.getText()) : 0;
                    int web_dev = (t2.getText().length() != 0) ? Integer.parseInt(t2.getText()) : 0;
                    int pe1 = (t3.getText().length() != 0) ? Integer.parseInt(t3.getText()) : 0;
                    int pe2 = (t4.getText().length() != 0) ? Integer.parseInt(t4.getText()) : 0;
                    int pe3 = (t5.getText().length() != 0) ? Integer.parseInt(t5.getText()) : 0;
                    int uhv_pe = (t6.getText().length() != 0) ? Integer.parseInt(t6.getText()) : 0;
                    int daa_lab = (t7.getText().length() != 0) ? Integer.parseInt(t7.getText()) : 0;
                    int python_lab = (t8.getText().length() != 0) ? Integer.parseInt(t8.getText()) : 0;
                    int webdev_lab = (t9.getText().length() != 0) ? Integer.parseInt(t9.getText()) : 0;
                    int summer_internship_lab = (t10.getText().length() != 0) ? Integer.parseInt(t10.getText()) : 0;
                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","1234");
                    String qry = "INSERT INTO SEM_3 VALUES('" + sic.toUpperCase() + "'," + daa + "," + web_dev + "," + pe1 + "," + pe2  + "," + pe3 + "," + uhv_pe + "," + daa_lab + "," + python_lab + "," + webdev_lab + "," + summer_internship_lab + ")";
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
                    JOptionPane.showMessageDialog(frame, "Enter Valid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(frame, "Enter Valid Input", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);
                t7.setText(null);
                t8.setText(null);
                t9.setText(null);
                t10.setText(null);

            }
        });
        frame.add(b1);

        // For Button-2
        b2 = new JButton("CLEAR");
        b2.setBounds(750, 750, 200, 50);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        // Clear Button Fun
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg2) {
                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);
                t7.setText(null);
                t8.setText(null);
                t9.setText(null);
                t10.setText(null);
            }
        });
        frame.add(b2);

        frame.setVisible(true);

    }

    // public static void main(String args[]) {
    //     SEM3 sm = new SEM3("23mmci36");
    // }
}
