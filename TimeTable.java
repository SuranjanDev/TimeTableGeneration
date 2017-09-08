package TimeTable;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

/**
 *
 * @author Suranjan
 */
class Frame extends JFrame {

    Frame(Box b[][]) {
        Container c;
        setVisible(true);
        setTitle("TIME GENE");
        setSize(1366, 768);
        setLocation(0, 0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        c = getContentPane();
        c.add(new TTPanel(b));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class TTPanel extends JPanel implements ActionListener {

    JComboBox bra, y;
    JTextArea button[];
    Box b1[][];

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.drawRoundRect(10, 35, 1345, 30, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillRoundRect(10, 35, 1345, 30, 20, 20);
        g.setColor(Color.DARK_GRAY);
        g.drawRoundRect(50, 100, 1260, 600, 20, 20);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(50, 100, 1260, 600, 20, 20);

    }

    TTPanel(Box b[][]) {
        b1 = b;
        setLayout(null);
        JButton logout = new JButton("Logout");
        logout.setBounds(1260, 50, 90, 30);
        add(logout);
        JButton changeProfile = new JButton("Change Profile Details");
        changeProfile.setBounds(1040, 50, 200, 30);
        add(changeProfile);
        JButton modify = new JButton("Modify Database");
        modify.setBounds(870, 50, 150, 30);
        add(modify);
        JButton export = new JButton("Export Time Table");
        export.setBounds(700, 50, 150, 30);
        add(export);
        JButton generate = new JButton("Generate Time Table");
        generate.setBounds(200, 50, 480, 30);
        add(generate);
        String[] petStrings = {"CSE", "MECH", "CIVIL", "ECE", "EE"};
        bra = new JComboBox(petStrings);
        bra.setBounds(20, 50, 70, 30);
        add(bra);
        String[] petStrings1 = {"1", "2", "3", "4"};
        y = new JComboBox(petStrings1);
        y.setBounds(110, 50, 70, 30);
        add(y);
        button = new JTextArea[63];
        int ctr = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                String str = "-";
                if (i == 0 && j == 0) {
                    str = "Timings\n\n\nWorking Days";
                }
                if (i == 1 && j == 0) {
                    str = "\n\n9:00 AM - 10:00 AM";
                }
                if (i == 2 && j == 0) {
                    str = "\n\n10:00 AM - 11:00 AM";
                }
                if (i == 3 && j == 0) {
                    str = "\n\n11:00 AM - 12:00 PM";
                }
                if (i == 4 && j == 0) {
                    str = "\n\n12:00 PM - 1:00 PM";
                }
                if (i == 5 && j == 0) {
                    str = "\n\n1:00 PM - 2:00 PM";
                }
                if (i == 6 && j == 0) {
                    str = "\n\n2:00 PM - 3:00 PM";
                }
                if (i == 7 && j == 0) {
                    str = "\n\n3:00 PM - 4:00 PM";
                }
                if (i == 8 && j == 0) {
                    str = "\n\n4:00 PM - 5:00 PM";
                }
                if (i == 9 && j == 0) {
                    str = "\n\n5:00 PM - 6:00 PM";
                }
                if (i == 0 && j == 1) {
                    str = "\n\n   Monday";
                }
                if (i == 0 && j == 2) {
                    str = "\n\n   Tuesday";
                }
                if (i == 0 && j == 4) {
                    str = "\n\n   Thurday";
                }
                if (i == 0 && j == 3) {
                    str = "\n\n   Wednesday";
                }
                if (i == 0 && j == 5) {
                    str = "\n\n   Friday";
                }
                if (i == 0 && j == 6) {
                    str = "\n\n   Saturday";
                }
                if (str.equals("-")) {
                    button[ctr] = new JTextArea();
                    button[ctr].setText(str);
                    button[ctr].setBounds(40 + (i * 127), 120 + (j * 82), 125, 80);
                    button[ctr].setEditable(false);
                    add(button[ctr++]);
                } else {
                    JTextArea bu = new JTextArea();
                    bu = new JTextArea();
                    if (i == 0 && j == 0) {
                        bu.setForeground(Color.black);
                    } else {
                        bu.setForeground(Color.white);
                    }
                    bu.setText(str);
                    bu.setBounds(40 + (i * 127), 120 + (j * 82), 125, 80);
                    bu.setEditable(false);
                    if (i == 0 && j == 0) {
                        bu.setBackground(Color.green);
                    } else {
                        bu.setBackground(Color.blue);
                    }
                    add(bu);
                }
            }
        }
        JLabel tl = new JLabel("");
        tl.setIcon(new javax.swing.ImageIcon("background.png")); // NOI18N
        add(tl);
        tl.setBounds(0, 0, 2280, 1200);
        logout.addActionListener(this);
        generate.addActionListener(this);
        export.addActionListener(this);
        modify.addActionListener(this);
    }

//    public void modifyData()    {
//        modify1 dialog = new modify1((Frame) this.getParent(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//        dialog.setVisible(true);
//    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String str1 = ae.getActionCommand();
        System.out.println(str1);
        if (str1.equals("Logout")) {
            int option = JOptionPane.showConfirmDialog(null, "Do you wish to continue?", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        }

        if (str1.equals("Export Time Table")) {
            JOptionPane.showMessageDialog(null, "This feature will be available in the new version of Time Gene.");
        }
        if (str1.equals("Modify Database")) {
            modify m = new modify();
            m.setVisible(true);
        }
        //
        if (str1.equals("Generate Time Table")) {
            int ctr = 0;
            int start = 0;
            int end = 0;
            if (bra.getSelectedItem().toString().equals("CSE") && Integer.parseInt(y.getSelectedItem().toString()) == 1) {
                start = 0;
                end = 7;
            } else if (bra.getSelectedItem().toString().equals("MECH") && Integer.parseInt(y.getSelectedItem().toString()) == 1) {
                start = 7;
                end = 14;
            } else if (bra.getSelectedItem().toString().equals("CIVIL") && Integer.parseInt(y.getSelectedItem().toString()) == 1) {
                start = 14;
                end = 21;
            } else if (bra.getSelectedItem().toString().equals("ECE") && Integer.parseInt(y.getSelectedItem().toString()) == 1) {
                start = 21;
                end = 28;
            } else if (bra.getSelectedItem().toString().equals("EE") && Integer.parseInt(y.getSelectedItem().toString()) == 1) {
                start = 28;
                end = 35;
            } else if (bra.getSelectedItem().toString().equals("CSE") && Integer.parseInt(y.getSelectedItem().toString()) == 2) {
                start = 35;
                end = 42;
            } else if (bra.getSelectedItem().toString().equals("MECH") && Integer.parseInt(y.getSelectedItem().toString()) == 2) {
                start = 42;
                end = 49;
            } else if (bra.getSelectedItem().toString().equals("CIVIL") && Integer.parseInt(y.getSelectedItem().toString()) == 2) {
                start = 49;
                end = 56;
            } else if (bra.getSelectedItem().toString().equals("ECE") && Integer.parseInt(y.getSelectedItem().toString()) == 2) {
                start = 56;
                end = 63;
            } else if (bra.getSelectedItem().toString().equals("EE") && Integer.parseInt(y.getSelectedItem().toString()) == 2) {
                start = 63;
                end = 70;
            } else if (bra.getSelectedItem().toString().equals("CSE") && Integer.parseInt(y.getSelectedItem().toString()) == 3) {
                start = 70;
                end = 77;
            } else if (bra.getSelectedItem().toString().equals("MECH") && Integer.parseInt(y.getSelectedItem().toString()) == 3) {
                start = 77;
                end = 84;
            } else if (bra.getSelectedItem().toString().equals("CIVIL") && Integer.parseInt(y.getSelectedItem().toString()) == 3) {
                start = 84;
                end = 91;
            } else if (bra.getSelectedItem().toString().equals("ECE") && Integer.parseInt(y.getSelectedItem().toString()) == 3) {
                start = 91;
                end = 98;
            } else if (bra.getSelectedItem().toString().equals("EE") && Integer.parseInt(y.getSelectedItem().toString()) == 3) {
                start = 98;
                end = 105;
            } else if (bra.getSelectedItem().toString().equals("CSE") && Integer.parseInt(y.getSelectedItem().toString()) == 4) {
                start = 105;
                end = 112;
            } else if (bra.getSelectedItem().toString().equals("MECH") && Integer.parseInt(y.getSelectedItem().toString()) == 4) {
                start = 112;
                end = 119;
            } else if (bra.getSelectedItem().toString().equals("CIVIL") && Integer.parseInt(y.getSelectedItem().toString()) == 4) {
                start = 119;
                end = 126;
            } else if (bra.getSelectedItem().toString().equals("ECE") && Integer.parseInt(y.getSelectedItem().toString()) == 4) {
                start = 126;
                end = 133;
            } else if (bra.getSelectedItem().toString().equals("EE") && Integer.parseInt(y.getSelectedItem().toString()) == 4) {
                start = 133;
                end = 140;
            }
            for (int i = 0; i < 48; i++) {
                button[i].setBackground(Color.WHITE);
            }
            ctr = 0;
            for (int i = start; i < end; i++) {
                for (int j = 0; j < 6; j++) {
                    if (b1[j][i].sub == null || b1[j][i].sub.equals("@")) {
                        button[ctr++].setText("-");
                    } else {
                        button[ctr].setText(b1[j][i].sub + "\n" + b1[j][i].fac + "\n" + b1[j][i].cla + "\n" + b1[j][i].cT);
                        if (b1[j][i].cT == 'P') {
                            button[ctr++].setBackground(Color.red);
                        } else {
                            button[ctr++].setBackground(Color.YELLOW);
                        }
                    }
                }
            }
        }
    }
}

class Box {

    String sub;
    String fac;
    char cT;
    String cla;
}

public class TimeTable {

    String nameOfSubject[] = new String[150];
    String nameOfFaculty[] = new String[150];
    int credits[] = new int[150];
    String category[] = new String[150];
    String forbiddenTimeSlots[] = new String[150];
    char creditType[] = new char[150];
    String branchName[] = new String[150];
    int year[] = new int[150];
    int classCapacity[] = new int[150];
    String[] classNames = {"CR001", "CR002", "CR003", "CR004", "CR005", "CR006", "CR007", "CR008", "CR009", "CR010", "CR101", "CR102", "CR103", "CR104", "CR105", "CR106", "CR107", "CR108", "CR109", "CR110", "SHOO1", "SHOO2", "SHOO3", "SHOO4", "SHOO5"};
    String[] labNames = {"CSELAB01", "CSELAB02", "CSELAB03", "CSELAB04", "CSELAB05", "MECHLAB01", "MECHLAB02", "MECHLAB03", "MECHLAB04", "MECHLAB05", "CIVILLAB01", "CIVILLAB02", "CIVILLAB03", "CIVILLAB04", "CIVILLAB05", "ECELAB01", "ECELAB02", "ECELAB03", "ECELAB04", "ECELAB05", "EELAB01", "EELAB02", "EELAB03", "EELAB04", "EELAB05", "CHEMLAB01"};
    String[][] resultantTimetable;
    String[][] branchWiseTimeTable;
    String[] allocatedClasses;
    String[] allocatedFaculties;

    TimeTable() {
        allocatedClasses = new String[100];
        allocatedFaculties = new String[500];
    }

    boolean checkCreditsVanish(String bra, int y, char cT, String sub) {
        for (int i = 0; i < nameOfSubject.length; i++) {
            if (branchName[i].equals(bra) && year[i] == y && creditType[i] == cT && credits[i] > 0 && nameOfSubject[i].equals(sub)) {
                return false;
            }
        }
        return true;
    }

    boolean checkPossibilityOfAllocation(String str, String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null); else if (str.equals(arr[i])) {
                return false;
            }
        }
        return true;
    }

    String returnBranch(int i) {
        if (i == 0 || i == 35 || i == 70 || i == 105) {
            return "CSE";
        } else if (i == 7 || i == 42 || i == 77 || i == 112) {
            return "MECH";
        } else if (i == 14 || i == 49 || i == 84 || i == 119) {
            return "CIVIL";
        } else if (i == 21 || i == 56 || i == 91 || i == 126) {
            return "ECE";
        }
        return "EE";
    }

    int returnYear(int i) {
        if (i < 35) {
            return 1;
        } else if (i >= 35 && i < 70) {
            return 2;
        } else if (i >= 70 && i < 105) {
            return 3;
        }
        return 4;
    }

    void boxAllocationForMoreThan60Capacity(int m, int i, int c1, int row, int col, Box b[][], int a[], String bra[]) {
        if (branchName[m].equals(bra[0])) {
            b[row][col + a[0]].cT = creditType[i];
            b[row][col + a[0]].cla = allocatedClasses[c1];
            b[row][col + a[0]].fac = nameOfFaculty[i];
            b[row][col + a[0]].sub = nameOfSubject[i];
            credits[m]--;
        } else if (branchName[m].equals(bra[1])) {
            b[row][col + a[1]].cT = creditType[i];
            b[row][col + a[1]].cla = allocatedClasses[c1];
            b[row][col + a[1]].fac = nameOfFaculty[i];
            b[row][col + a[1]].sub = nameOfSubject[i];
            credits[m]--;
        } else if (branchName[m].equals(bra[2])) {
            b[row][col + a[2]].cT = creditType[i];
            b[row][col + a[2]].cla = allocatedClasses[c1];
            b[row][col + a[2]].fac = nameOfFaculty[i];
            b[row][col + a[2]].sub = nameOfSubject[i];
            credits[m]--;
        } else if (branchName[m].equals(bra[3])) {
            b[row][col + a[3]].cT = creditType[i];
            b[row][col + a[3]].cla = allocatedClasses[c1];
            b[row][col + a[3]].fac = nameOfFaculty[i];
            b[row][col + a[3]].sub = nameOfSubject[i];
            credits[m]--;
        }
    }

    boolean checkInRack(String bra, String bra1, String sub, char cT, int y) {
        int ctr = 0;
        if (bra.equals(bra1)) {
            return true;
        } else {
            for (int i = 0; i < nameOfSubject.length; i++) {
                if (branchName[i].equals(bra) && year[i] == y && creditType[i] == cT && nameOfSubject[i].equals(sub) && category[i].equals("ELEC")) {
                    ctr++;
                }
            }
        }
        if (ctr == 0) {
            return false;
        }
        return true;
    }

    boolean checkInBranchBox(Box b[][], int col, String sub, int credits, char cT) {
        int ctr = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = col; j < col + 7; j++) {
                if (b[i][j].sub != null) {
                    if (b[i][j].sub.equals(sub) && b[i][j].cT == cT) {
                        ctr++;
                    }
                }
            }
        }
        if (ctr < credits) {
            return false;
        }
        return true;
    }
}
