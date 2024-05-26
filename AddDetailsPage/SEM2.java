package AddDetailsPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class SEM2 {
    JFrame frame;
    JLabel h1, h2, h3, l1, l2, l3, l4, l5,p1,p2,p3,p4;
    JTextField t1,t2,t3,t4,t5,t7,t8,t9,t10;
    
    JButton b1,b2;
    String sic;

    public SEM2(String sic) {
        this.sic = sic;
        

        // For Frame
        frame = new JFrame("SGPA Generator"); // THis Needs to be updated
        frame.setLocation(100, 100);
        frame.setSize(600, 600);
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
        l1 = new JLabel("1.Data Structure:");
        l1.setBounds(350, 170, 300, 50);
        l1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l1);

        //For Text-1   DSA
        t1=new JTextField("");   
        t1.setBounds(800,170,100,30);
        frame.add(t1);

        //For Text-2        JAVA
        t2=new JTextField("");   
        t2.setBounds(800,227,100,30);
        frame.add(t2);
        
        //For Text-3        DBMS
        t3=new JTextField("");   
        t3.setBounds(800,283,100,30);
        frame.add(t3);
        
        //For Text-4        ECOM
        t4=new JTextField("");   
        t4.setBounds(800,333,100,30);
        frame.add(t4);
        
        
        //For Text-5             SEU
        t5=new JTextField("");   
        t5.setBounds(800,383,100,30);
        frame.add(t5);
        

        // For Label-2
        l2 = new JLabel("2.Java:");
        l2.setBounds(350, 220, 400, 50);
        l2.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l2);

        // For Label-3
        l3 = new JLabel("3.DBMS:");
        l3.setBounds(350, 270, 400, 50);
        l3.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l3);
        
        // For Label-4
        l4 = new JLabel("4.E Commerce:");
        l4.setBounds(350, 320, 400, 50);
        l4.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l4);


        // For Label-5
        l5 = new JLabel("5.Software Eng:");
        l5.setBounds(350, 370, 400, 50);
        l5.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(l5);




        // For HEading-3
        h3 = new JLabel("Practicals: ");
        h3.setBounds(200, 490, 550, 50);
        h3.setFont(new Font("Arial", Font.CENTER_BASELINE, 40));
        frame.add(h3);

        // For Practical-1
        p1 = new JLabel("1.DSA Lab:");
        p1.setBounds(350, 550, 400, 50);
        p1.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p1);
        
        // For Practical-2
        p2 = new JLabel("2.Java Lab:");
        p2.setBounds(350, 600, 400, 50);
        p2.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p2);
        
        // For Practical-3
        p3 = new JLabel("3.Software Eng. Lab:");
        p3.setBounds(350, 650, 400, 50);
        p3.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p3);

        // For Practical-4
        p4 = new JLabel("4.DBMS Lab:");
        p4.setBounds(350, 700, 400, 50);
        p4.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        frame.add(p4);
 
         //For Text-7             DSA LAB
         t7=new JTextField("");   
         t7.setBounds(800,557,100,30);
         frame.add(t7);
         
         //For Text-8             JAVA LAB
         t8=new JTextField("");   
         t8.setBounds(800,607,100,30);
         frame.add(t8);
         
         //For Text-9              SEU LAB
         t9=new JTextField("");   
         t9.setBounds(800,656,100,30);
         frame.add(t9);

         // For Text-10          DBMS LAB
        t10 = new JTextField("");
        t10.setBounds(800, 710, 100, 30);
        frame.add(t10);

         // For Button-1
        b1 = new JButton("ADD");
        b1.setBounds(350, 750, 200, 50);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try {
          // here i Implimented to parse empty or non empty string to integer
          int dsa = (t1.getText().length() != 0) ? Integer.parseInt(t1.getText()) : 0;
          int java = (t2.getText().length() != 0) ? Integer.parseInt(t2.getText()) : 0;
          int dbms = (t3.getText().length() != 0) ? Integer.parseInt(t3.getText()) : 0;
          int ecom = (t4.getText().length() != 0) ? Integer.parseInt(t4.getText()) : 0;
          int seu = (t5.getText().length() != 0) ? Integer.parseInt(t5.getText()) : 0;
          int dsa_lab = (t7.getText().length() != 0) ? Integer.parseInt(t7.getText()) : 0;
          int java_lab = (t8.getText().length() != 0) ? Integer.parseInt(t8.getText()) : 0;
          int seu_lab = (t9.getText().length() != 0) ? Integer.parseInt(t9.getText()) : 0;
          int dbms_lab = (t10.getText().length() != 0) ? Integer.parseInt(t10.getText()) : 0;
          Class.forName("oracle.jdbc.driver.OracleDriver");

          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
          String qry = "INSERT INTO SEM_2 VALUES('" + sic.toUpperCase() + "'," + dsa+ "," + java + "," + dbms + "," + ecom + "," + seu+ "," + dsa_lab + "," + java_lab + "," + seu_lab + "," + dbms_lab + ")";
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
          JOptionPane.showMessageDialog(frame,"Enter Valid Input","Alert",JOptionPane.WARNING_MESSAGE);
        }
        catch(NumberFormatException ne)
        {
          JOptionPane.showMessageDialog(frame,"Enter Valid Input","Alert",JOptionPane.WARNING_MESSAGE);
        }
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        t5.setText(null);
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
    //     SEM2 sm = new SEM2("23mmci36");
    // }
}
