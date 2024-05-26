package calculateSGPA;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class YourSGPA {
    JFrame frame;
    JLabel h1, l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JComboBox c1;
    JButton b1, b2;

    public static int grade(int mark) {
        if (mark >= 90)
            return 10;
        else if (mark >= 80)
            return 9;
        else if (mark >= 70)
            return 8;
        else if (mark >= 60)
            return 7;
        else if (mark >= 50)
            return 6;
        else if (mark >= 40)
            return 5;
        else
            return 4;
    }

    public YourSGPA() {
        frame = new JFrame("SGPA Generator"); // THis Needs to be updated
        frame.setLocation(100, 100);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // for the Heading-1
        h1 = new JLabel("Check Your SGPA");
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

        // // For Label-2
        // l2 = new JLabel("Enter Name: ");
        // l2.setBounds(260, 200, 200, 50);
        // l2.setFont(new Font("Arial", Font.BOLD, 25));
        // frame.add(l2);

        // // For Text-2
        // t2 = new JTextField();
        // t2.setBounds(500, 210, 150, 30);
        // frame.add(t2);

        // For Label-2
        l3 = new JLabel("Enter Semester: ");
        l3.setBounds(260, 200, 200, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(l3);

        // For ComboBox-1
        String[] semester = { "Semester-1", "Semester-2", "Semester-3", "Semester-4" };
        c1 = new JComboBox<>(semester);
        c1.setBounds(500, 210, 250, 30);
        c1.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(c1);

        // For Button-1
        b1 = new JButton("CHECK");
        b1.setBounds(260, 330, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        /*
         * Here I added Functionality for Submit button
         * -> where User have to enter his SIC to see his SGPA
         * what i did for Semester-1 same for all other Semester With Minor Changes
         */
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                // If User Check Semester-1 in ComboBox
                if (c1.getSelectedItem() == "Semester-1") {
                    try {
                        String sic = t1.getText().toUpperCase(); // Get the sic from TextField

                        // JDBC Connection
                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "1234");
                        Statement stmt = conn.createStatement();
                        // Query To Extract data From database
                        ResultSet rs = stmt.executeQuery(
                                "select * from STUDENT_INFO SI,SEM_1 S1 WHERE SI.SIC = S1.SIC AND SI.SIC = '" + sic
                                        + "' ");
                        while (rs.next()) {
                            // Got the Data from data base and Assigned in Variable
                            int MATH = rs.getInt("MATH");
                            int OS = rs.getInt("OS");
                            int COA = rs.getInt("COA");
                            int C = rs.getInt("C");
                            int CN = rs.getInt("CN");
                            int ENG = rs.getInt("ENG");
                            int C_LAB = rs.getInt("C_LAB");
                            int OS_LAB = rs.getInt("OS_LAB");
                            int ENG_LAB = rs.getInt("ENG_LAB");

                            // User score
                            int Score = (grade(MATH) * 4) + (grade(OS) * 3) + (grade(COA) * 3) + (grade(C) * 3)
                                    + (grade(CN) * 3) + (grade(ENG) * 3) + (grade(C_LAB) * 2) + (grade(OS_LAB) * 1)
                                    + (grade(ENG_LAB) * 1);

                            // total credit
                            int total_credit = 23;

                            // SGPA formula User Score /Total_credits
                            double sgpa = Score / total_credit;
                            l4.setText(rs.getString("NAME") + " Your SGPA is " + String.valueOf(sgpa));
                            // If the Student Pass the exam
                            if (sgpa > 4) {
                                l4.setForeground(Color.GREEN);
                                l5.setText("Congratulations");
                            }
                            // If he/She Fails
                            else {
                                l4.setForeground(Color.RED);
                                l5.setText("Better Luck Next Time!!");
                                l5.setForeground(Color.RED);
                            }

                        }
                        conn.close();

                    } catch (ClassNotFoundException cn) {
                        System.out.println(cn);
                    } catch (SQLException se) {
                        System.out.println(se);
                    }
                }
                // If User Check Semester-2 In Combobox
                if (c1.getSelectedItem() == "Semester-2") {
                    try {
                        String sic = t1.getText().toUpperCase();
                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "1234");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(
                                "select * from STUDENT_INFO SI,SEM_2 S2 WHERE SI.SIC = S2.SIC AND SI.SIC = '" + sic
                                        + "' ");
                        while (rs.next()) {
                            int DSA = rs.getInt("DSA");
                            int JAVA = rs.getInt("JAVA");
                            int DBMS = rs.getInt("DBMS");
                            int ECOM = rs.getInt("ECOM");
                            int SEU = rs.getInt("SEU");
                            int DSA_LAB = rs.getInt("DSA_LAB");
                            int JAVA_LAB = rs.getInt("JAVA_LAB");
                            int SEU_LAB = rs.getInt("SEU_LAB");
                            int DBMS_LAB = rs.getInt("DBMS_LAB");
                            int Score = (grade(DSA) * 4) + (grade(JAVA) * 3) + (grade(DBMS) * 4) + (grade(ECOM) * 3)
                                    + (grade(SEU) * 3) + (grade(DSA_LAB) * 2) + (grade(JAVA_LAB) * 1)
                                    + (grade(SEU_LAB) * 1) + (grade(DBMS_LAB) * 1);
                            int total_credit = 23;

                            double sgpa = Score / total_credit;
                            l4.setText(rs.getString("NAME") + " Your SGPA is " + String.valueOf(sgpa));
                            if (sgpa > 4) {
                                l4.setForeground(Color.GREEN);
                                l5.setText("Congratulations");
                                l5.setForeground(Color.GREEN);
                            } else {
                                l4.setForeground(Color.RED);
                                l5.setText("Better Luck Next Time!!");
                                l5.setForeground(Color.RED);
                            }

                        }
                        conn.close();

                    } catch (ClassNotFoundException cn) {
                        System.out.println(cn);
                    } catch (SQLException se) {
                        System.out.println(se);
                    }
                }
                // if User Selects Semester-3 from combobox
                else if (c1.getSelectedItem() == "Semester-3") {
                    try {
                        String sic = t1.getText().toUpperCase();
                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "1234");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(
                                "select * from STUDENT_INFO SI,SEM_3 S3 WHERE SI.SIC = S3.SIC AND SI.SIC = '" + sic
                                        + "' ");
                        while (rs.next()) {
                            int DAA = rs.getInt("DAA");
                            int WEB_DEV = rs.getInt("WEB_DEV");
                            int PE1 = rs.getInt("PE1");
                            int PE2 = rs.getInt("PE2");
                            int PE3 = rs.getInt("PE3");
                            int UHV_PE = rs.getInt("UHV_PE");
                            int DAA_LAB = rs.getInt("DAA_LAB");
                            int PYTHON_LAB = rs.getInt("PYTHON_LAB");
                            int WEBDEV_LAB = rs.getInt("WEBDEV_LAB");
                            int SUMMER_INTERNSHIP_LAB = rs.getInt("SUMMER_INTERNSHIP_LAB");
                            int Score = (grade(DAA) * 3) + (grade(WEB_DEV) * 4) + (grade(PE1) * 3) + (grade(PE2) * 3)
                                    + (grade(PE3) * 3) + (grade(UHV_PE) * 0) + (grade(DAA_LAB) * 1)
                                    + (grade(PYTHON_LAB) * 2) + (grade(WEBDEV_LAB) * 2)
                                    + (grade(SUMMER_INTERNSHIP_LAB) + 1);
                            int total_credit = 22;

                            double sgpa = Score / total_credit;
                            l4.setText(rs.getString("NAME") + " Your SGPA is " + String.valueOf(sgpa));
                            if (sgpa > 4) {
                                l4.setForeground(Color.GREEN);
                                l5.setText("Congratulations");
                                l5.setForeground(Color.GREEN);
                            } else {
                                l4.setForeground(Color.RED);
                                l5.setText("Better Luck Next Time!!");
                                l5.setForeground(Color.RED);
                            }

                        }
                        conn.close();

                    } catch (ClassNotFoundException cn) {
                        System.out.println(cn);
                    } catch (SQLException se) {
                        System.out.println(se);
                    }
                }
                // If User Selects Semester-4
                if (c1.getSelectedItem() == "Semester-4") {
                    try {
                        String sic = t1.getText().toUpperCase();

                        Class.forName("oracle.jdbc.driver.OracleDriver");

                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "1234");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(
                                "select * from STUDENT_INFO SI,SEM_4 S4 WHERE SI.SIC = S4.SIC AND SI.SIC = '" + sic
                                        + "' ");
                        while (rs.next()) {
                            int MOOC = rs.getInt("MOOC");
                            int PROJECT = rs.getInt("PROJECT");
                            int COMP_VIVA = rs.getInt("COMP_VIVA");
                            int YOGA_NCC_NSS = rs.getInt("YOGA_NCC_NSS");
                            int Score = (grade(MOOC) * 3) + (grade(PROJECT) * 12) + (grade(COMP_VIVA) * 1)
                                    + (grade(YOGA_NCC_NSS) * 0);
                            int total_credit = 16;

                            double sgpa = Score / total_credit;
                            l4.setText(rs.getString("NAME") + " Your SGPA is " + String.valueOf(sgpa));
                            if (sgpa > 4) {
                                l4.setForeground(Color.GREEN);
                                l5.setText("Congratulations");
                                l5.setForeground(Color.GREEN);
                            } else {
                                l4.setForeground(Color.RED);
                                l5.setText("Better Luck Next Time!!");
                                l5.setForeground(Color.RED);
                            }

                        }
                        conn.close();

                    } catch (ClassNotFoundException cn) {
                        System.out.println(cn);
                    } catch (SQLException se) {
                        System.out.println(se);
                    }
                }

            }
        });
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

        // For Label-4
        l4 = new JLabel();
        l4.setBounds(260, 400, 500, 50);
        l4.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(l4);

        // For Label-5
        l5 = new JLabel();
        l5.setBounds(260, 440, 300, 50);
        l5.setFont(new Font("Arial", Font.BOLD, 25));
        l5.setForeground(Color.GREEN);
        frame.add(l5);

        frame.setVisible(true);

    }

    // public static void main(String[] args) {
    //     YourSGPA ys = new YourSGPA();
    // }
}