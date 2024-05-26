package ShowDetails;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.table.*;

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
        frame.setResizable(false);
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
        String[] semester = { "Semester-1", "Semester-2", "Semester-3", "Semester-4" };
        c1 = new JComboBox<>(semester);
        c1.setBounds(500, 260, 250, 30);
        c1.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(c1);

        // For Button-1
        b1 = new JButton("SHOW");
        b1.setBounds(260, 330, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg) {
                if (t1.getText().length() == 0 || t2.getText().length() == 0)
                    JOptionPane.showMessageDialog(frame, "Please Enter Both Field!!!!");
                else {
                    String sic = t1.getText().toUpperCase();
                    String name = t2.getText().toUpperCase();
                    ArrayList columnNames = new ArrayList();
                    ArrayList data = new ArrayList();
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                "system", "1234");
                        Statement stmt = connection.createStatement();
                        ResultSet rs;
                        if (c1.getSelectedItem() == "Semester-1")
                            rs = stmt.executeQuery("Select * from student_info natural join sem_1 where sic = '" + sic
                                    + "' and name = '" + name + "'");
                        else if (c1.getSelectedItem() == "Semester-2")
                            rs = stmt.executeQuery("select * from Student_info Natural Join sem_2 where sic = '" + sic
                                    + "' and name = '" + name + "'");
                        else if (c1.getSelectedItem() == "Semester-3")
                            rs = stmt.executeQuery("select * from Student_info Natural Join sem_3 where sic = '" + sic
                                    + "' and name = '" + name + "'");
                        else if (c1.getSelectedItem() == "Semester-4")
                            rs = stmt.executeQuery("select * from Student_info Natural Join sem_4 where sic = '" + sic
                                    + "' and name = '" + name + "'");
                        else {
                            rs = null;
                        }

                        {
                            ResultSetMetaData md = rs.getMetaData();
                            int columns = md.getColumnCount();

                            // Get column names
                            for (int i = 1; i <= columns; i++) {
                                columnNames.add(md.getColumnName(i));
                            }

                            // Get row data
                            while (rs.next()) {
                                ArrayList row = new ArrayList(columns);

                                for (int i = 1; i <= columns; i++) {
                                    row.add(rs.getObject(i));
                                }

                                data.add(row);
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } catch (ClassNotFoundException cf) {
                        System.out.println(cf);
                    }

                    Vector columnNamesVector = new Vector();
                    Vector dataVector = new Vector();

                    for (int i = 0; i < data.size(); i++) {
                        ArrayList subArray = (ArrayList) data.get(i);
                        Vector subVector = new Vector();
                        for (int j = 0; j < subArray.size(); j++) {
                            subVector.add(subArray.get(j));
                        }
                        dataVector.add(subVector);
                    }

                    for (int i = 0; i < columnNames.size(); i++)
                        columnNamesVector.add(columnNames.get(i));

                    // Create table with database data
                    JTable table = new JTable(dataVector, columnNamesVector) {
                        public Class getColumnClass(int column) {
                            for (int row = 0; row < getRowCount(); row++) {
                                Object o = getValueAt(row, column);

                                if (o != null) {
                                    return o.getClass();
                                }
                            }

                            return Object.class;
                        }
                    };

                    table.setBackground(Color.CYAN);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(850, 200, 670, 100);
                    frame.add(scrollPane);
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

        frame.setVisible(true);

    }

    // public static void main(String[] args) {
    //     ShowDetailsForm ys = new ShowDetailsForm();
    // }
}