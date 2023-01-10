import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Home implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl;
    JButton ab, re, dr, cr, ex, m;
    Color c;
    String s;
    // initialising display

    Home() {

        fr = new JFrame("Home Page");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Gossner Health Care Management System");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Home Page");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        ab = new JButton("About HC");
        ab.setFont(new Font("Serif", Font.BOLD, 24));
        ab.setForeground(new Color(15, 0, 255));

        re = new JButton("Registration");
        re.setFont(new Font("Serif", Font.BOLD, 24));
        re.setForeground(new Color(15, 0, 255));

        dr = new JButton("Drug Store");
        dr.setFont(new Font("Serif", Font.BOLD, 24));
        dr.setForeground(new Color(15, 0, 255));

        cr = new JButton("Case Records");
        cr.setFont(new Font("Serif", Font.BOLD, 24));
        cr.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        m = new JButton("Setup");
        m.setFont(new Font("Serif", Font.BOLD, 24));
        m.setForeground(new Color(15, 0, 255));
        m.setBackground(new Color(233, 30, 99));

        fr.setSize(1900, 1000);
        ml.setSize(1500, 100);
        sl.setSize(300, 75);
        ab.setSize(200, 50);
        re.setSize(200, 50);
        dr.setSize(200, 50);
        cr.setSize(200, 50);
        ex.setSize(200, 50);
        m.setSize(100, 50);

        ml.setLocation(200, 30);
        sl.setLocation(800, 150);
        ab.setLocation(100, 250);
        re.setLocation(100, 350);
        dr.setLocation(100, 450);
        cr.setLocation(100, 550);
        ex.setLocation(100, 650);
        m.setLocation(1700, 850);

        fr.setLayout(null);
        ab.addActionListener(this);
        re.addActionListener(this);
        dr.addActionListener(this);
        cr.addActionListener(this);
        ex.addActionListener(this);
        m.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add(ab);
        fr.add(re);
        fr.add(dr);
        fr.add(cr);
        fr.add(ex);
        fr.add(m);
        fr.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ab) {
            s = "ABSTRACT \n  \n  \n  The main intention of introducing ths system is to reduce the manual work at Health center counters.\n  Every sort of task is performed by the system_ such as registering different types of persons \n (i.e employees _ students and others) _enquiries_ and complaints etc. reducing much paper work and burden \n of file storage. Also the latest information is right available for the officials and executives wherever  \n they require. The system also facilitates the pharmacist  to enquire about the drugs and about the   \n stock to be ordered and about the expiry date . \n \n ";
            s += "\n Where the system must be placed.\n	There are a lot of benefits to the Health center  by placing the system at their registration and at  \n drug store office . At the same time the patients are also benefited using ths system. They can get   \n the work done within no time \n \n.";
            s += "\n \n How to use the system. \n Using the system is as simple as using the personal computer. Since end user computing is  \n developing in our country_ It is beneficial to both Health center  and the patients. Every step is clearly  \n defined and help is provided through out the application to the user. Even the exceptions are handled  \n well to avoid confusion. ";
            s += "\n  \n  \n How is it beneficial to the Health Center.\n The heath center  can get much out of the system. The  system is used to enter the patient  details  \n and to enter the details about  the health center and the details about the in-patient and out-patient  in  \n detail  and about the reports of the patients . Ths system represents  the patient by the  OP number  \n and ths is main  criteria how the patient is provided by the free services . The drug information and  \n the specifications is also provided in ths Health Center Management System.";

            showMessege(s);
        }
        if (e.getSource() == re) {
            Reg obj = new Reg();
        }
        if (e.getSource() == dr) {
            Drug obj = new Drug();
        }
        if (e.getSource() == cr) {
            Case obj = new Case();
        }
        if (e.getSource() == m) {
            JOptionPane.showMessageDialog(null, "Record Saved Successfully");
        }
        if (e.getSource() == ex) {
            System.exit(0);
        }
    }

    public void paint(Graphics g) {}
    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }
    public static void main(String k[]) {
        Home obj = new Home();
        //obj.display();
    }
}




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Reg implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl;
    JButton in , vi, ex;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s;
    Reg() {
        fr = new JFrame("Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));
        fr.setLayout(null);

        ml = new JLabel("Atanu Health Centre");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Registration Recrods");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        in = new JButton("Insert "); in .setFont(new Font("Serif", Font.BOLD, 24)); in .setForeground(new Color(15, 0, 255));

        vi = new JButton("View");
        vi.setFont(new Font("Serif", Font.BOLD, 24));
        vi.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75); in .setSize(200, 50);
        vi.setSize(200, 50);
        ex.setSize(200, 50);

        ml.setLocation(500, 30);
        sl.setLocation(600, 150); in .setLocation(100, 400);
        vi.setLocation(100, 550);
        ex.setLocation(100, 700);

        fr.setLayout(null); in .addActionListener(this);
        vi.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add( in );
        fr.add(vi);
        fr.add(ex);
        fr.setVisible(true);
        makeConnection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == in ) {
            Ireg obj = new Ireg();
        }
        if (e.getSource() == vi) {
            Vreg obj = new Vreg();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }
    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }
    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Reg obj = new Reg();

    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Ireg implements ActionListener {
    int chk;

    JFrame fr;
    JLabel ml, sl, on, na, oc, ag, se, ad, fm;
    JButton su, ex;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    Color c;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s, sqr;


    // initialising display
    Ireg() {

        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Health Centre");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Registration Records");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        on = new JLabel("O.P. No");
        on.setFont(new Font("Serif", Font.BOLD, 24));
        on.setForeground(new Color(15, 0, 255));

        na = new JLabel("Name");
        na.setFont(new Font("Serif", Font.BOLD, 24));
        na.setForeground(new Color(15, 0, 255));

        oc = new JLabel("Occupation");
        oc.setFont(new Font("Serif", Font.BOLD, 24));
        oc.setForeground(new Color(15, 0, 255));

        ag = new JLabel("Age");
        ag.setFont(new Font("Serif", Font.BOLD, 24));
        ag.setForeground(new Color(15, 0, 255));

        se = new JLabel("Sex");
        se.setFont(new Font("Serif", Font.BOLD, 24));
        se.setForeground(new Color(15, 0, 255));

        ad = new JLabel("Address");
        ad.setFont(new Font("Serif", Font.BOLD, 24));
        ad.setForeground(new Color(15, 0, 255));

        fm = new JLabel("Family Member");
        fm.setFont(new Font("Serif", Font.BOLD, 24));
        fm.setForeground(new Color(15, 0, 255));

        su = new JButton("Submit");
        su.setFont(new Font("Serif", Font.BOLD, 24));
        su.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        t1 = new JTextField();
        t2 = new JTextField();
        t5 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();

        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75);
        on.setSize(300, 30);
        na.setSize(300, 30);
        oc.setSize(300, 30);
        ag.setSize(300, 30);
        se.setSize(300, 30);
        ad.setSize(300, 30);
        fm.setSize(300, 30);
        t1.setSize(100, 30);
        t2.setSize(400, 30);
        t3.setSize(300, 30);
        t4.setSize(50, 30);
        t5.setSize(50, 30);
        t6.setSize(300, 80);
        t7.setSize(300, 80);

        su.setSize(200, 50);
        ex.setSize(200, 50);



        ml.setLocation(500, 30);
        sl.setLocation(600, 150);
        on.setLocation(100, 300);
        na.setLocation(100, 350);
        oc.setLocation(100, 400);
        ag.setLocation(100, 450);
        se.setLocation(100, 500);
        ad.setLocation(100, 550);
        fm.setLocation(100, 700);
        su.setLocation(600, 850);
        ex.setLocation(900, 850);
        t1.setLocation(400, 300);
        t2.setLocation(400, 350);
        t3.setLocation(400, 400);
        t4.setLocation(400, 450);
        t5.setLocation(400, 500);
        t6.setLocation(400, 550);
        t7.setLocation(400, 700);

        fr.setLayout(null);


        su.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add(on);
        fr.add(na);
        fr.add(oc);
        fr.add(ag);
        fr.add(se);
        fr.add(ad);
        fr.add(fm);
        fr.add(t1);
        fr.add(t2);
        fr.add(t3);
        fr.add(t4);
        fr.add(t5);
        fr.add(t6);
        fr.add(t7);
        fr.add(su);
        fr.add(ex);
        fr.setVisible(true);
        makeConnection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == su) {
            saveRecord();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }


    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }

    void saveRecord() {
        chk = 0;
        try {
            sqr = "insert into Pat values('" + t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "')";
            stm = cn.createStatement();
            chk = stm.executeUpdate(sqr);
            if (chk == 1)
                s = "Record added successfully";
            else
                s = "Rrcord not added";
            showMessege(s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Ireg obj = new Ireg();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Vreg implements ActionListener {
    int chk;

    JFrame fr;
    JLabel ml, sl, on, na, oc, ag, se, ad, fm;
    JButton su, ex;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    Color c;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s, sqr;


    // initialising display
    Vreg() {

        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Health Centre");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Registration Records");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        on = new JLabel("O.P. No");
        on.setFont(new Font("Serif", Font.BOLD, 24));
        on.setForeground(new Color(15, 0, 255));

        na = new JLabel("Name");
        na.setFont(new Font("Serif", Font.BOLD, 24));
        na.setForeground(new Color(15, 0, 255));

        oc = new JLabel("Occupation");
        oc.setFont(new Font("Serif", Font.BOLD, 24));
        oc.setForeground(new Color(15, 0, 255));

        ag = new JLabel("Age");
        ag.setFont(new Font("Serif", Font.BOLD, 24));
        ag.setForeground(new Color(15, 0, 255));

        se = new JLabel("Sex");
        se.setFont(new Font("Serif", Font.BOLD, 24));
        se.setForeground(new Color(15, 0, 255));

        ad = new JLabel("Address");
        ad.setFont(new Font("Serif", Font.BOLD, 24));
        ad.setForeground(new Color(15, 0, 255));

        fm = new JLabel("Family Member");
        fm.setFont(new Font("Serif", Font.BOLD, 24));
        fm.setForeground(new Color(15, 0, 255));

        su = new JButton("View Record");
        su.setFont(new Font("Serif", Font.BOLD, 24));
        su.setForeground(new Color(15, 0, 255));
        su.setBackground(new Color(233, 30, 99));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        t1 = new JTextField();
        t2 = new JTextField();
        t5 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();

        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75);
        on.setSize(300, 30);
        na.setSize(300, 30);
        oc.setSize(300, 30);
        ag.setSize(300, 30);
        se.setSize(300, 30);
        ad.setSize(300, 30);
        fm.setSize(300, 30);
        t1.setSize(100, 30);
        t2.setSize(400, 30);
        t3.setSize(300, 30);
        t4.setSize(50, 30);
        t5.setSize(50, 30);
        t6.setSize(300, 80);
        t7.setSize(300, 80);

        su.setSize(200, 30);
        ex.setSize(200, 50);



        ml.setLocation(500, 30);
        sl.setLocation(600, 150);
        on.setLocation(100, 300);
        na.setLocation(100, 350);
        oc.setLocation(100, 400);
        ag.setLocation(100, 450);
        se.setLocation(100, 500);
        ad.setLocation(100, 550);
        fm.setLocation(100, 700);
        su.setLocation(550, 300);
        ex.setLocation(900, 850);
        t1.setLocation(400, 300);
        t2.setLocation(400, 350);
        t3.setLocation(400, 400);
        t4.setLocation(400, 450);
        t5.setLocation(400, 500);
        t6.setLocation(400, 550);
        t7.setLocation(400, 700);

        fr.setLayout(null);


        su.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add(on);
        fr.add(na);
        fr.add(oc);
        fr.add(ag);
        fr.add(se);
        fr.add(ad);
        fr.add(fm);
        fr.add(t1);
        fr.add(t2);
        fr.add(t3);
        fr.add(t4);
        fr.add(t5);
        fr.add(t6);
        fr.add(t7);
        fr.add(su);
        fr.add(ex);
        fr.setVisible(true);
        makeConnection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == su) {
            searchRecord();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }


    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }

    void searchRecord() {

        try {
            sqr = "select * from Pat where pn='" + t1.getText() + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sqr);

            while (rs.next()) {
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Vreg obj = new Vreg();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Drug implements ActionListener {
    int chk;

    JFrame fr;
    JLabel ml, sl;
    JButton in , ab, up, ex;
    Connection cn;
    ResultSet rs;
    Statement stm;
    Color c;
    String s;


    // initialization
    Drug() { //creation
        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Health Centre");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Atanu Drug Store");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        in = new JButton("Insert Drugs"); in .setFont(new Font("Serif", Font.BOLD, 24)); in .setForeground(new Color(15, 0, 255));

        ab = new JButton("About Stock");
        ab.setFont(new Font("Serif", Font.BOLD, 24));
        ab.setForeground(new Color(15, 0, 255));

        up = new JButton("Update Drug");
        up.setFont(new Font("Serif", Font.BOLD, 24));
        up.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        //set size
        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75); in .setSize(200, 50);
        ab.setSize(200, 50);
        up.setSize(200, 50);
        ex.setSize(200, 50);


        //setloaction

        fr.setLayout(null);
        ml.setLocation(500, 30);
        sl.setLocation(600, 150); in .setLocation(600, 300);
        ab.setLocation(1100, 550);
        up.setLocation(100, 550);
        ex.setLocation(600, 850);


        //adding
        in .addActionListener(this);
        ab.addActionListener(this);
        up.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add( in );
        fr.add(ab);
        fr.add(up);
        fr.add(ex);
        fr.setVisible(true);


    }

    // main coding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == in ) {
            Idrug obj = new Idrug();
        }
        if (e.getSource() == ab) {
            Sdrug obj = new Sdrug();
        }
        if (e.getSource() == up) {
            Udrug obj = new Udrug();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }


    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }

    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Drug obj = new Drug();
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Idrug implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl, dr, st, ed;
    JTextField t1, t2, t3;
    JButton su, ex;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s, sqr;

    Idrug() {
        // creation
        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Drug Store");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Insert Drug Record");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        //la
        dr = new JLabel("Drug Name");
        dr.setFont(new Font("Serif", Font.BOLD, 24));
        dr.setForeground(new Color(15, 0, 255));

        st = new JLabel("Quantity");
        st.setFont(new Font("Serif", Font.BOLD, 24));
        st.setForeground(new Color(15, 0, 255));

        ed = new JLabel("EX-Date");
        ed.setFont(new Font("Serif", Font.BOLD, 24));
        ed.setForeground(new Color(15, 0, 255));

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        su = new JButton("Submit");
        su.setFont(new Font("Serif", Font.BOLD, 24));
        su.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        //size

        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75);
        dr.setSize(300, 30);
        st.setSize(300, 30);
        ed.setSize(300, 30);

        t1.setSize(400, 30);
        t2.setSize(60, 30);
        t3.setSize(100, 30);
        su.setSize(200, 50);
        ex.setSize(200, 50);
        //location
        fr.setLayout(null);
        ml.setLocation(500, 30);
        sl.setLocation(600, 150);

        dr.setLocation(100, 400);
        st.setLocation(100, 550);
        ed.setLocation(100, 700);

        t1.setLocation(600, 400);
        t2.setLocation(600, 550);
        t3.setLocation(600, 700);

        su.setLocation(600, 850);
        ex.setLocation(900, 850);

        //Adding
        su.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add(dr);
        fr.add(st);
        fr.add(ed);
        fr.add(t1);
        fr.add(t2);
        fr.add(t3);
        fr.add(su);
        fr.add(ex);
        fr.setVisible(true);
        makeConnection();
    }

    // Main coding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == su) {
            saveRecord();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }
    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }

    void saveRecord() {
        chk = 0;
        try {
            sqr = "insert into drug values('" + t1.getText() + "'," + t2.getText() + ",'" + t3.getText() + "')";
            stm = cn.createStatement();
            chk = stm.executeUpdate(sqr);
            if (chk == 1)
                s = "Record added successfully";
            else
                s = "Rrcord not added";
            showMessege(s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Idrug obj = new Idrug();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Udrug implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl, dns, dn, st, ns, ed, nd;
    JButton su, ex, gd;
    JTextField t1, t2, t3, t4, t5, t6;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s, sqr;

    Udrug() {
        makeConnection();
        //create
        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Drug Store");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Update Drug Record");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        dns = new JLabel("Drug Name");
        dns.setFont(new Font("Serif", Font.BOLD, 24));
        dns.setForeground(new Color(15, 0, 255));

        dn = new JLabel("Drug Name");
        dn.setFont(new Font("Serif", Font.BOLD, 24));
        dn.setForeground(new Color(15, 0, 255));

        st = new JLabel("Old Stock");
        st.setFont(new Font("Serif", Font.BOLD, 24));
        st.setForeground(new Color(15, 0, 255));

        ns = new JLabel("New Stock");
        ns.setFont(new Font("Serif", Font.BOLD, 24));
        ns.setForeground(new Color(15, 0, 255));

        ed = new JLabel("Old Expiry Date");
        ed.setFont(new Font("Serif", Font.BOLD, 24));
        ed.setForeground(new Color(15, 0, 255));

        nd = new JLabel("New Expiry Date");
        nd.setFont(new Font("Serif", Font.BOLD, 24));
        nd.setForeground(new Color(15, 0, 255));

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        gd = new JButton("Get Details");
        gd.setFont(new Font("Serif", Font.BOLD, 24));
        gd.setForeground(new Color(15, 0, 255));

        su = new JButton("Submit");
        su.setFont(new Font("Serif", Font.BOLD, 24));
        su.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));


        //size
        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75);

        dns.setSize(300, 30);
        dn.setSize(300, 30);
        st.setSize(300, 30);
        ns.setSize(300, 30);
        ed.setSize(300, 30);
        nd.setSize(300, 30);

        t1.setSize(100, 30);
        t2.setSize(400, 30);
        t3.setSize(50, 30);
        t4.setSize(50, 30);
        t5.setSize(300, 30);
        t6.setSize(300, 30);

        gd.setSize(200, 40);
        su.setSize(200, 50);
        ex.setSize(200, 50);

        //location
        fr.setLayout(null);
        ml.setLocation(500, 30);
        sl.setLocation(600, 150);

        t1.setLocation(400, 300);
        t2.setLocation(400, 450);
        t3.setLocation(400, 500);
        t4.setLocation(400, 550);
        t5.setLocation(400, 600);
        t6.setLocation(400, 650);

        gd.setLocation(800, 300);
        su.setLocation(600, 850);
        ex.setLocation(900, 850);

        dns.setLocation(100, 300);
        dn.setLocation(100, 450);
        st.setLocation(100, 500);
        ns.setLocation(100, 550);
        ed.setLocation(100, 600);
        nd.setLocation(100, 650);
        //add
        gd.addActionListener(this);
        su.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);

        fr.add(dns);
        fr.add(dn);
        fr.add(st);
        fr.add(ns);
        fr.add(ed);
        fr.add(nd);
        fr.add(t1);
        fr.add(t2);
        fr.add(t3);
        fr.add(t4);
        fr.add(t5);
        fr.add(t6);

        fr.add(gd);
        fr.add(su);
        fr.add(ex);
        fr.setVisible(true);
    }


    // main coding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gd) {
            searchRecord();
        }
        if (e.getSource() == su) {
            updateRecord();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }

    }
    void updateRecord() {
        chk = 0;
        try {
            sqr = "update drug set dn='" + t2.getText() + "',s='" + t4.getText() + "',d='" + t6.getText() + "' where dn='" + t1.getText() + "'";
            stm = cn.createStatement();
            chk = stm.executeUpdate(sqr);
            if (chk == 1)
                s = "Record added successfully";
            else
                s = "Rrcord not added";
            showMessege(s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void searchRecord() {

        try {
            sqr = "select * from drug where dn='" + t1.getText() + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sqr);

            while (rs.next()) {
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(1));
                t3.setText(rs.getString(2));
                t5.setText(rs.getString(3));


            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }
    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }


    public static void main(String k[]) {
        Udrug obj = new Udrug();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Sdrug implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl, dn, re, ed;
    JButton su, ex;
    JTextField t1, t2, t3;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s, sqr;

    Sdrug() {
        // Creation
        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Drug Store");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("View Stock Details");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        dn = new JLabel("Drug Name");
        dn.setFont(new Font("Serif", Font.BOLD, 24));
        dn.setForeground(new Color(15, 0, 255));

        re = new JLabel("Remaining");
        re.setFont(new Font("Serif", Font.BOLD, 24));
        re.setForeground(new Color(15, 0, 255));

        ed = new JLabel("EX-Date");
        ed.setFont(new Font("Serif", Font.BOLD, 24));
        ed.setForeground(new Color(15, 0, 255));

        su = new JButton("Submit");
        su.setFont(new Font("Serif", Font.BOLD, 24));
        su.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));


        //Size
        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(500, 75);

        dn.setSize(200, 40);
        re.setSize(200, 40);
        ed.setSize(200, 40);

        t1.setSize(400, 30);
        t2.setSize(100, 30);
        t3.setSize(500, 30);

        su.setSize(200, 50);
        ex.setSize(200, 50);

        //location
        fr.setLayout(null);
        ml.setLocation(500, 30);
        sl.setLocation(600, 150);

        dn.setLocation(600, 400);
        re.setLocation(400, 650);
        ed.setLocation(1000, 650);
        t1.setLocation(800, 400);
        t2.setLocation(600, 650);
        t3.setLocation(1200, 650);

        su.setLocation(800, 500);
        ex.setLocation(800, 850);

        //Add
        su.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);

        fr.add(t1);
        fr.add(t2);
        fr.add(t3);
        fr.add(re);
        fr.add(dn);
        fr.add(ed);
        fr.add(su);
        fr.add(ex);
        fr.setVisible(true);
        makeConnection();
    }


    // main coding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == su) {
            searchRecord();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }
    }

    void searchRecord() {

        try {
            sqr = "select * from drug where dn='" + t1.getText() + "'";
            stm = cn.createStatement();
            rs = stm.executeQuery(sqr);

            while (rs.next()) {
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }
    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }

    public static void main(String k[]) {
        Sdrug obj = new Sdrug();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Case implements ActionListener {
    int chk;
    JFrame fr;
    JLabel ml, sl;
    JButton ir, or, ex;
    Connection cn;
    ResultSet rs;
    Statement stm;
    String s;


    Case() {
        //initialization
        fr = new JFrame("Patients Registration");
        fr.getContentPane().setBackground(new Color(49, 153, 255));

        ml = new JLabel("Atanu Health Centre");
        ml.setFont(new Font("Serif", Font.BOLD, 75));
        ml.setForeground(new Color(255, 31, 48));

        sl = new JLabel("Case Records of in and out patient");
        sl.setFont(new Font("Serif", Font.BOLD, 50));
        sl.setForeground(new Color(15, 0, 255));

        ir = new JButton("Patient -IN");
        ir.setFont(new Font("Serif", Font.BOLD, 24));
        ir.setForeground(new Color(15, 0, 255));

        or = new JButton("Drug   -IN");
        or.setFont(new Font("Serif", Font.BOLD, 24));
        or.setForeground(new Color(15, 0, 255));

        ex = new JButton("Exit");
        ex.setFont(new Font("Serif", Font.BOLD, 24));
        ex.setForeground(new Color(15, 0, 255));

        //size
        fr.setSize(1900, 1000);
        ml.setSize(800, 100);
        sl.setSize(1000, 75);

        ir.setSize(200, 50);
        or.setSize(200, 50);
        ex.setSize(200, 50);


        //location
        fr.setLayout(null);
        ml.setLocation(550, 30);
        sl.setLocation(500, 150);
        ir.setLocation(500, 400);
        or.setLocation(500, 650);
        ex.setLocation(800, 850);
        //add
        ir.addActionListener(this);
        or.addActionListener(this);
        ex.addActionListener(this);
        fr.add(ml);
        fr.add(sl);
        fr.add(ir);
        fr.add(or);
        fr.add(ex);
        fr.setVisible(true);
    }


    // main coding
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ir) {
            Vreg obj = new Vreg();
        }
        if (e.getSource() == or) {
            Sdrug obj = new Sdrug();
        }
        if (e.getSource() == ex) {
            fr.setVisible(false);
        }

    }
    void makeConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            JOptionPane.showMessageDialog(null, "Connection Established");
        } catch (Exception e) {}
    }
    void showMessege(String mes) {
        JOptionPane.showMessageDialog(null, mes);
    }
    public static void main(String k[]) {
        Case obj = new Case();
    }
}