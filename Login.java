/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Suranjan
 */
public class Login extends javax.swing.JFrame {
    int count=0,total=0;
    private String username = "admin";
    private String password = "password";

    /**
     * Creates new form 
     */
    public void TTAlgo() {
        TimeTable t = new TimeTable();
        try {
            Scanner input = new Scanner(new File("test.txt"));
             Scanner temp = new Scanner(new File("test.txt"));
           while (temp.hasNextLine()) {
               count++;
               temp.nextLine();
           }
             total=count/8;
            if (input.hasNextLine()) {
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.nameOfSubject[i] = data;
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.nameOfFaculty[i] = data;
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.credits[i] = Integer.parseInt(data);
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.category[i] = data;
                }
                /*for(int i=0;i<150;i++){
                String data = input.nextLine();
                t.forbiddenTimeSlots[i] = data;
                }*/
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.creditType[i] = data.charAt(0);
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.branchName[i] = data;
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.year[i] = Integer.parseInt(data);
                }
                for (int i = 0; i < total; i++) {
                    String data = input.nextLine();
                    t.classCapacity[i] = Integer.parseInt(data);
                }
            }
        } catch (IOException e) {
            System.out.print("Exception");
        }
        Box b[][] = new Box[6][140];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 140; j++) {
                b[i][j] = new Box();
                if (i == 5 && j < 35) {
                    b[i][j].sub = "@";
                }
            }
        }
        int dummy = 0;
        while (dummy != 140) {
            for (int i = 0; i < t.nameOfSubject.length; i++) {
                if (t.branchName[i].equals(t.returnBranch(dummy)) && t.year[i] == t.returnYear(dummy) && t.creditType[i] == 'P' && t.credits[i] > 0 && t.category[i].equals("ELEC")) {
                    int cre = t.credits[i];
                    while (t.checkCreditsVanish(t.returnBranch(dummy), t.returnYear(dummy), 'P', t.nameOfSubject[i]) != true) {
                        System.out.println(t.nameOfSubject[i] + "\t" + t.nameOfFaculty[i] + "\t" + t.branchName[i] + "\t" + t.year[i] + "\t" + dummy + "\t" + t.creditType[i]);
                        label1:
                        {
                            int col = dummy + (int) (Math.random() * 7);
                            int row = (int) (Math.random() * 6);
                            if (col < dummy + 6) {
                                if (b[row][col].sub == null && b[row][col + 1].sub == null) {
                                    int f = 0, c = 0, possible = 0, f1 = 0, c1 = 0;
                                    java.util.Arrays.fill(t.allocatedClasses, null);
                                    java.util.Arrays.fill(t.allocatedFaculties, null);
                                    for (f = dummy / 7; f > 0; f--) {
                                        t.allocatedFaculties[f1++] = b[row][col - 7 * f].fac;
                                        t.allocatedFaculties[f1++] = b[row][col + 1 - 7 * f].fac;
                                    }
                                    for (c = dummy / 7; c > 0; c--) {
                                        t.allocatedClasses[c1++] = b[row][col - 7 * c].cla;
                                        t.allocatedClasses[c1++] = b[row][col + 1 - 7 * c].cla;
                                    }
                                    String a1 = "", b1 = "", c2 = "", d3 = "", d4 = "";
                                    if (t.branchName[i].equals("CSE")) {
                                        a1 = t.labNames[0];
                                        b1 = t.labNames[1];
                                        c2 = t.labNames[2];
                                        d3 = t.labNames[3];
                                        d4 = t.labNames[4];
                                    }
                                    if (t.branchName[i].equals("MECH")) {
                                        a1 = t.labNames[5];
                                        b1 = t.labNames[6];
                                        c2 = t.labNames[7];
                                        d3 = t.labNames[8];
                                        d4 = t.labNames[9];
                                    }
                                    if (t.branchName[i].equals("CIVIL")) {
                                        a1 = t.labNames[10];
                                        b1 = t.labNames[11];
                                        c2 = t.labNames[12];
                                        d3 = t.labNames[13];
                                        d4 = t.labNames[14];
                                    }
                                    if (t.branchName[i].equals("ECE")) {
                                        a1 = t.labNames[15];
                                        b1 = t.labNames[16];
                                        c2 = t.labNames[17];
                                        d3 = t.labNames[18];
                                        d4 = t.labNames[19];
                                    }
                                    if (t.branchName[i].equals("EE")) {
                                        a1 = t.labNames[20];
                                        b1 = t.labNames[21];
                                        c2 = t.labNames[22];
                                        d3 = t.labNames[23];
                                        d4 = t.labNames[24];
                                    }
                                    int dc = 0, dm = 0, dci = 0, de = 0, dee = 0;
                                    if (t.year[i] == 1) {
                                        dc = 0;
                                        dm = 7;
                                        dci = 14;
                                        de = 21;
                                        dee = 28;
                                    }
                                    if (t.year[i] == 2) {
                                        dc = 35;
                                        dm = 42;
                                        dci = 49;
                                        de = 56;
                                        dee = 63;
                                    }
                                    if (t.year[i] == 3) {
                                        dc = 70;
                                        dm = 77;
                                        dci = 84;
                                        de = 91;
                                        dee = 98;
                                    }
                                    if (t.year[i] == 4) {
                                        dc = 105;
                                        dm = 112;
                                        dci = 119;
                                        de = 126;
                                        dee = 133;
                                    }
                                    if (t.checkPossibilityOfAllocation(t.nameOfFaculty[i], t.allocatedFaculties) == true) {
                                        if (t.checkPossibilityOfAllocation(a1, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = a1;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(b1, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = b1;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(c2, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = c2;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(d3, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = d3;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(d4, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = d4;
                                            possible++;
                                        }
                                        if (possible > 0) {
                                            b[row][col].cT = 'P';
                                            b[row][col].fac = t.nameOfFaculty[i];
                                            b[row][col].sub = t.nameOfSubject[i];
                                            b[row][col].cla = t.allocatedClasses[c1];
                                            b[row][col + 1].cT = 'P';
                                            b[row][col + 1].fac = t.nameOfFaculty[i];
                                            b[row][col + 1].sub = t.nameOfSubject[i];
                                            b[row][col + 1].cla = t.allocatedClasses[c1];
                                            t.credits[i]--;
                                            if (t.checkInRack("CSE", t.branchName[i], t.nameOfSubject[i], 'P', t.year[i]) == false) {
                                                if (t.checkInBranchBox(b, dc, t.nameOfSubject[i], 2 * cre, 'P') == false) {
                                                    if (t.branchName[i].equals("MECH") && b[row][col - 7].sub == null && b[row][col - 7 + 1].sub == null) {
                                                        b[row][col - 7].cT = 'P';
                                                        b[row][col - 7].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7].sub = t.nameOfSubject[i];
                                                        b[row][col - 7].cla = t.allocatedClasses[c1];
                                                        b[row][col - 7 + 1].cT = 'P';
                                                        b[row][col - 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CIVIL") && b[row][col - 14].sub == null && b[row][col - 14 + 1].sub == null) {
                                                        b[row][col - 14].cT = 'P';
                                                        b[row][col - 14].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14].sub = t.nameOfSubject[i];
                                                        b[row][col - 14].cla = t.allocatedClasses[c1];
                                                        b[row][col - 14 + 1].cT = 'P';
                                                        b[row][col - 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("ECE") && b[row][col - 21].sub == null && b[row][col - 21 + 1].sub == null) {
                                                        b[row][col - 21].cT = 'P';
                                                        b[row][col - 21].fac = t.nameOfFaculty[i];
                                                        b[row][col - 21].sub = t.nameOfSubject[i];
                                                        b[row][col - 21].cla = t.allocatedClasses[c1];
                                                        b[row][col - 21 + 1].cT = 'P';
                                                        b[row][col - 21 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 21 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 21 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("EE") && b[row][col - 28].sub == null && b[row][col - 28 + 1].sub == null) {
                                                        b[row][col - 28].cT = 'P';
                                                        b[row][col - 28].fac = t.nameOfFaculty[i];
                                                        b[row][col - 28].sub = t.nameOfSubject[i];
                                                        b[row][col - 28].cla = t.allocatedClasses[c1];
                                                        b[row][col - 28 + 1].cT = 'P';
                                                        b[row][col - 28 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 28 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 28 + 1].cla = t.allocatedClasses[c1];
                                                    } else {
                                                        b[row][col].cT = ' ';
                                                        b[row][col].fac = null;
                                                        b[row][col].sub = null;
                                                        b[row][col].cla = null;
                                                        b[row][col + 1].cT = ' ';
                                                        b[row][col + 1].fac = null;
                                                        b[row][col + 1].sub = null;
                                                        b[row][col + 1].cla = null;
                                                        t.credits[i]++;
                                                        break label1;
                                                    }
                                                }
                                            }
                                            if (t.checkInRack("MECH", t.branchName[i], t.nameOfSubject[i], 'P', t.year[i]) == false) {
                                                if (t.checkInBranchBox(b, dm, t.nameOfSubject[i], 2 * cre, 'P') == false) {
                                                    if (t.branchName[i].equals("CSE") && b[row][col + 7].sub == null && b[row][col + 7 + 1].sub == null) {
                                                        b[row][col + 7].cT = 'P';
                                                        b[row][col + 7].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7].sub = t.nameOfSubject[i];
                                                        b[row][col + 7].cla = t.allocatedClasses[c1];
                                                        b[row][col + 7 + 1].cT = 'P';
                                                        b[row][col + 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("ECE") && b[row][col - 14].sub == null && b[row][col - 14 + 1].sub == null) {
                                                        b[row][col - 14].cT = 'P';
                                                        b[row][col - 14].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14].sub = t.nameOfSubject[i];
                                                        b[row][col - 14].cla = t.allocatedClasses[c1];
                                                        b[row][col - 14 + 1].cT = 'P';
                                                        b[row][col - 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("EE") && b[row][col - 21].sub == null && b[row][col - 21 + 1].sub == null) {
                                                        b[row][col - 21].cT = 'P';
                                                        b[row][col - 21].fac = t.nameOfFaculty[i];
                                                        b[row][col - 21].sub = t.nameOfSubject[i];
                                                        b[row][col - 21].cla = t.allocatedClasses[c1];
                                                        b[row][col - 21 + 1].cT = 'P';
                                                        b[row][col - 21 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 21 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 21 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CIVIL") && b[row][col - 7].sub == null && b[row][col - 7 + 1].sub == null) {
                                                        b[row][col - 7].cT = 'P';
                                                        b[row][col - 7].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7].sub = t.nameOfSubject[i];
                                                        b[row][col - 7].cla = t.allocatedClasses[c1];
                                                        b[row][col - 7 + 1].cT = 'P';
                                                        b[row][col - 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else {
                                                        b[row][col].cT = ' ';
                                                        b[row][col].fac = null;
                                                        b[row][col].sub = null;
                                                        b[row][col].cla = null;
                                                        b[row][col + 1].cT = ' ';
                                                        b[row][col + 1].fac = null;
                                                        b[row][col + 1].sub = null;
                                                        b[row][col + 1].cla = null;
                                                        t.credits[i]++;
                                                        break label1;
                                                    }
                                                }
                                            }
                                            if (t.checkInRack("CIVIL", t.branchName[i], t.nameOfSubject[i], 'P', t.year[i]) == false) {
                                                if (t.checkInBranchBox(b, dci, t.nameOfSubject[i], 2 * cre, 'P') == false) {
                                                    if (t.branchName[i].equals("MECH") && b[row][col + 7].sub == null && b[row][col + 7 + 1].sub == null) {
                                                        b[row][col + 7].cT = 'P';
                                                        b[row][col + 7].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7].sub = t.nameOfSubject[i];
                                                        b[row][col + 7].cla = t.allocatedClasses[c1];
                                                        b[row][col + 7 + 1].cT = 'P';
                                                        b[row][col + 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("EE") && b[row][col - 14].sub == null && b[row][col - 14 + 1].sub == null) {
                                                        b[row][col - 14].cT = 'P';
                                                        b[row][col - 14].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14].sub = t.nameOfSubject[i];
                                                        b[row][col - 14].cla = t.allocatedClasses[c1];
                                                        b[row][col - 14 + 1].cT = 'P';
                                                        b[row][col - 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("ECE") && b[row][col - 7].sub == null && b[row][col - 7 + 1].sub == null) {
                                                        b[row][col - 7].cT = 'P';
                                                        b[row][col - 7].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7].sub = t.nameOfSubject[i];
                                                        b[row][col - 7].cla = t.allocatedClasses[c1];
                                                        b[row][col - 7 + 1].cT = 'P';
                                                        b[row][col - 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CSE") && b[row][col + 14].sub == null && b[row][col + 14 + 1].sub == null) {
                                                        b[row][col + 14].cT = 'P';
                                                        b[row][col + 14].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14].sub = t.nameOfSubject[i];
                                                        b[row][col + 14].cla = t.allocatedClasses[c1];
                                                        b[row][col + 14 + 1].cT = 'P';
                                                        b[row][col + 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else {
                                                        b[row][col].cT = ' ';
                                                        b[row][col].fac = null;
                                                        b[row][col].sub = null;
                                                        b[row][col].cla = null;
                                                        b[row][col + 1].cT = ' ';
                                                        b[row][col + 1].fac = null;
                                                        b[row][col + 1].sub = null;
                                                        b[row][col + 1].cla = null;
                                                        t.credits[i]++;
                                                        break label1;
                                                    }
                                                }
                                            }
                                            if (t.checkInRack("ECE", t.branchName[i], t.nameOfSubject[i], 'P', t.year[i]) == false) {
                                                if (t.checkInBranchBox(b, de, t.nameOfSubject[i], 2 * cre, 'P') == false) {
                                                    if (t.branchName[i].equals("CIVIL") && b[row][col + 7].sub == null && b[row][col + 7 + 1].sub == null) {
                                                        b[row][col + 7].cT = 'P';
                                                        b[row][col + 7].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7].sub = t.nameOfSubject[i];
                                                        b[row][col + 7].cla = t.allocatedClasses[c1];
                                                        b[row][col + 7 + 1].cT = 'P';
                                                        b[row][col + 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CSE") && b[row][col + 21].sub == null && b[row][col + 21 + 1].sub == null) {
                                                        b[row][col + 21].cT = 'P';
                                                        b[row][col + 21].fac = t.nameOfFaculty[i];
                                                        b[row][col + 21].sub = t.nameOfSubject[i];
                                                        b[row][col + 21].cla = t.allocatedClasses[c1];
                                                        b[row][col + 21 + 1].cT = 'P';
                                                        b[row][col + 21 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 21 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 21 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("EE") && b[row][col - 7].sub == null && b[row][col - 7 + 1].sub == null) {
                                                        b[row][col - 7].cT = 'P';
                                                        b[row][col - 7].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7].sub = t.nameOfSubject[i];
                                                        b[row][col - 7].cla = t.allocatedClasses[c1];
                                                        b[row][col - 7 + 1].cT = 'P';
                                                        b[row][col - 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col - 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col - 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("MECH") && b[row][col + 14].sub == null && b[row][col + 14 + 1].sub == null) {
                                                        b[row][col + 14].cT = 'P';
                                                        b[row][col + 14].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14].sub = t.nameOfSubject[i];
                                                        b[row][col + 14].cla = t.allocatedClasses[c1];
                                                        b[row][col + 14 + 1].cT = 'P';
                                                        b[row][col + 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else {
                                                        b[row][col].cT = ' ';
                                                        b[row][col].fac = null;
                                                        b[row][col].sub = null;
                                                        b[row][col].cla = null;
                                                        b[row][col + 1].cT = ' ';
                                                        b[row][col + 1].fac = null;
                                                        b[row][col + 1].sub = null;
                                                        b[row][col + 1].cla = null;
                                                        t.credits[i]++;
                                                        break label1;
                                                    }
                                                }
                                            }
                                            if (t.checkInRack("EE", t.branchName[i], t.nameOfSubject[i], 'P', t.year[i]) == false) {
                                                if (t.checkInBranchBox(b, dee, t.nameOfSubject[i], 2 * cre, 'P') == false) {
                                                    if (t.branchName[i].equals("ECE") && b[row][col + 7].sub == null && b[row][col + 7 + 1].sub == null) {
                                                        b[row][col + 7].cT = 'P';
                                                        b[row][col + 7].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7].sub = t.nameOfSubject[i];
                                                        b[row][col + 7].cla = t.allocatedClasses[c1];
                                                        b[row][col + 7 + 1].cT = 'P';
                                                        b[row][col + 7 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 7 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 7 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("MECH") && b[row][col + 21].sub == null && b[row][col + 21 + 1].sub == null) {
                                                        b[row][col + 21].cT = 'P';
                                                        b[row][col + 21].fac = t.nameOfFaculty[i];
                                                        b[row][col + 21].sub = t.nameOfSubject[i];
                                                        b[row][col + 21].cla = t.allocatedClasses[c1];
                                                        b[row][col + 21 + 1].cT = 'P';
                                                        b[row][col + 21 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 21 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 21 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CSE") && b[row][col + 28].sub == null && b[row][col + 28 + 1].sub == null) {
                                                        b[row][col + 28].cT = 'P';
                                                        b[row][col + 28].fac = t.nameOfFaculty[i];
                                                        b[row][col + 28].sub = t.nameOfSubject[i];
                                                        b[row][col + 28].cla = t.allocatedClasses[c1];
                                                        b[row][col + 28 + 1].cT = 'P';
                                                        b[row][col + 28 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 28 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 28 + 1].cla = t.allocatedClasses[c1];
                                                    } else if (t.branchName[i].equals("CIVIL") && b[row][col + 14].sub == null && b[row][col + 14 + 1].sub == null) {
                                                        b[row][col + 14].cT = 'P';
                                                        b[row][col + 14].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14].sub = t.nameOfSubject[i];
                                                        b[row][col + 14].cla = t.allocatedClasses[c1];
                                                        b[row][col + 14 + 1].cT = 'P';
                                                        b[row][col + 14 + 1].fac = t.nameOfFaculty[i];
                                                        b[row][col + 14 + 1].sub = t.nameOfSubject[i];
                                                        b[row][col + 14 + 1].cla = t.allocatedClasses[c1];
                                                    } else {
                                                        b[row][col].cT = ' ';
                                                        b[row][col].fac = null;
                                                        b[row][col].sub = null;
                                                        b[row][col].cla = null;
                                                        b[row][col + 1].cT = ' ';
                                                        b[row][col + 1].fac = null;
                                                        b[row][col + 1].sub = null;
                                                        b[row][col + 1].cla = null;
                                                        t.credits[i]++;
                                                        break label1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < t.nameOfSubject.length; i++) {
                if (t.branchName[i].equals(t.returnBranch(dummy)) && t.year[i] == t.returnYear(dummy) && t.creditType[i] == 'P' && t.credits[i] > 0 && t.category[i].equals("CC")) {
                    while (t.checkCreditsVanish(t.returnBranch(dummy), t.returnYear(dummy), 'P', t.nameOfSubject[i]) != true) {
                        System.out.println(t.nameOfSubject[i] + "\t" + t.nameOfFaculty[i] + "\t" + t.branchName[i] + "\t" + t.year[i] + "\t" + dummy + "\t" + t.creditType[i]);
                        int col = dummy + (int) (Math.random() * 7);
                        int row = (int) (Math.random() * 6);
                        if (col < dummy + 6) {
                            if (b[row][col].sub == null && b[row][col + 1].sub == null) {
                                int f = 0, c = 0, possible = 0, f1 = 0, c1 = 0;
                                java.util.Arrays.fill(t.allocatedClasses, null);
                                java.util.Arrays.fill(t.allocatedFaculties, null);
                                for (f = dummy / 7; f > 0; f--) {
                                    t.allocatedFaculties[f1++] = b[row][col - 7 * f].fac;
                                    t.allocatedFaculties[f1++] = b[row][col + 1 - 7 * f].fac;
                                }
                                for (c = dummy / 7; c > 0; c--) {
                                    t.allocatedClasses[c1++] = b[row][col - 7 * c].cla;
                                    t.allocatedClasses[c1++] = b[row][col + 1 - 7 * c].cla;
                                }
                                if (t.checkPossibilityOfAllocation(t.nameOfFaculty[i], t.allocatedFaculties) == true) {
                                    if (t.nameOfSubject[i].equals("Chemistry")) {
                                        if (t.checkPossibilityOfAllocation(t.labNames[25], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.labNames[25];
                                            possible++;
                                        }
                                    } else {
                                        String a1 = "", b1 = "", c2 = "", d3 = "", d4 = "";
                                        if (t.branchName[i].equals("CSE") || t.year[i] == 1) {
                                            a1 = t.labNames[0];
                                            b1 = t.labNames[1];
                                            c2 = t.labNames[2];
                                            d3 = t.labNames[3];
                                            d4 = t.labNames[4];
                                        }
                                        if (t.branchName[i].equals("MECH") && t.year[i] != 1) {
                                            a1 = t.labNames[5];
                                            b1 = t.labNames[6];
                                            c2 = t.labNames[7];
                                            d3 = t.labNames[8];
                                            d4 = t.labNames[9];
                                        }
                                        if (t.branchName[i].equals("CIVIL") && t.year[i] != 1) {
                                            a1 = t.labNames[10];
                                            b1 = t.labNames[11];
                                            c2 = t.labNames[12];
                                            d3 = t.labNames[13];
                                            d4 = t.labNames[14];
                                        }
                                        if (t.branchName[i].equals("ECE") && t.year[i] != 1) {
                                            a1 = t.labNames[15];
                                            b1 = t.labNames[16];
                                            c2 = t.labNames[17];
                                            d3 = t.labNames[18];
                                            d4 = t.labNames[19];
                                        }
                                        if (t.branchName[i].equals("EE") && t.year[i] != 1) {
                                            a1 = t.labNames[20];
                                            b1 = t.labNames[21];
                                            c2 = t.labNames[22];
                                            d3 = t.labNames[23];
                                            d4 = t.labNames[24];
                                        }
                                        if (t.checkPossibilityOfAllocation(a1, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = a1;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(b1, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = b1;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(c2, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = c2;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(d3, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = d3;
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(d4, t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = d4;
                                            possible++;
                                        }
                                    }
                                    if (possible > 0) {
                                        b[row][col].cT = 'P';
                                        b[row][col].fac = t.nameOfFaculty[i];
                                        b[row][col].sub = t.nameOfSubject[i];
                                        b[row][col].cla = t.allocatedClasses[c1];
                                        b[row][col + 1].cT = 'P';
                                        b[row][col + 1].fac = t.nameOfFaculty[i];
                                        b[row][col + 1].sub = t.nameOfSubject[i];
                                        b[row][col + 1].cla = t.allocatedClasses[c1];
                                        t.credits[i]--;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < t.nameOfSubject.length; i++) {
                if (t.branchName[i].equals(t.returnBranch(dummy)) && t.year[i] == t.returnYear(dummy) && (t.creditType[i] != 'P') && t.credits[i] > 0 && t.category[i].equals("ELEC")) {
                    int cre = t.credits[i];
                    while (t.checkCreditsVanish(t.returnBranch(dummy), t.returnYear(dummy), t.creditType[i], t.nameOfSubject[i]) != true) {
                        System.out.println(t.nameOfSubject[i] + "\t" + t.nameOfFaculty[i] + "\t" + t.branchName[i] + "\t" + t.year[i] + "\t" + dummy + "\t" + t.creditType[i]);
                        label:
                        {
                            int col = dummy + (int) (Math.random() * 7);
                            int row = (int) (Math.random() * 6);
                            if (b[row][col].sub == null) {
                                int f = 0, c = 0, possible = 0, f1 = 0, c1 = 0;
                                java.util.Arrays.fill(t.allocatedClasses, null);
                                java.util.Arrays.fill(t.allocatedFaculties, null);
                                for (f = dummy / 7; f > 0; f--) {
                                    t.allocatedFaculties[f1++] = b[row][col - 7 * f].fac;
                                }
                                for (c = dummy / 7; c > 0; c--) {
                                    t.allocatedClasses[c1++] = b[row][col - 7 * c].cla;
                                }
                                int dc = 0, dm = 0, dci = 0, de = 0, dee = 0;
                                if (t.year[i] == 1) {
                                    dc = 0;
                                    dm = 7;
                                    dci = 14;
                                    de = 21;
                                    dee = 28;
                                }
                                if (t.year[i] == 2) {
                                    dc = 35;
                                    dm = 42;
                                    dci = 49;
                                    de = 56;
                                    dee = 63;
                                }
                                if (t.year[i] == 3) {
                                    dc = 70;
                                    dm = 77;
                                    dci = 84;
                                    de = 91;
                                    dee = 98;
                                }
                                if (t.year[i] == 4) {
                                    dc = 105;
                                    dm = 112;
                                    dci = 119;
                                    de = 126;
                                    dee = 133;
                                }
                                if (t.checkPossibilityOfAllocation(t.nameOfFaculty[i], t.allocatedFaculties) == true) {
                                    if (t.classCapacity[i] > 60) {
                                        if (t.checkPossibilityOfAllocation(t.classNames[20], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[20];
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(t.classNames[21], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[21];
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(t.classNames[22], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[22];
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(t.classNames[23], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[23];
                                            possible++;
                                        } else if (t.checkPossibilityOfAllocation(t.classNames[24], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[24];
                                            possible++;
                                        }
                                    } else {
                                        for (int k = 0; k < t.classNames.length - 5; k++) {
                                            if (t.checkPossibilityOfAllocation(t.classNames[k], t.allocatedClasses) == true) {
                                                t.allocatedClasses[c1] = t.classNames[k];
                                                k = t.classNames.length;
                                                possible++;
                                            }
                                        }
                                    }
                                    if (possible > 0) {
                                        b[row][col].cT = t.creditType[i];
                                        b[row][col].fac = t.nameOfFaculty[i];
                                        b[row][col].sub = t.nameOfSubject[i];
                                        b[row][col].cla = t.allocatedClasses[c1];
                                        t.credits[i]--;
                                        if (t.classCapacity[i] > 60) {
                                            for (int m = 0; m < t.nameOfSubject.length; m++) {
                                                if (t.year[m] == t.returnYear(dummy) && t.nameOfSubject[i].equals(t.nameOfSubject[m]) && t.nameOfFaculty[i].equals(t.nameOfFaculty[m]) && t.credits[m] > 0 && t.classCapacity[m] > 60 && t.creditType[i] == t.creditType[m]) {
                                                    if (t.branchName[i].equals("CSE") && i != m) {
                                                        int a[] = {7, 14, 21, 28};
                                                        String bra[] = {"MECH", "CIVIL", "ECE", "EE"};
                                                        t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                    } else if (t.branchName[i].equals("MECH") && i != m) {
                                                        int a[] = {-7, 7, 14, 21};
                                                        String bra[] = {"CSE", "CIVIL", "ECE", "EE"};
                                                        t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                    } else if (t.branchName[i].equals("CIVIL") && i != m) {
                                                        int a[] = {-14, -7, 7, 14};
                                                        String bra[] = {"CSE", "MECH", "ECE", "EE"};
                                                        t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                    } else if (t.branchName[i].equals("ECE") && i != m) {
                                                        int a[] = {-21, -14, -7, 7};
                                                        String bra[] = {"CSE", "MECH", "CIVIL", "EE"};
                                                        t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                    } else if (t.branchName[i].equals("EE") && i != m) {
                                                        int a[] = {-28, -21, -14, -7};
                                                        String bra[] = {"CSE", "MECH", "CIVIL", "ECE"};
                                                        t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                    }
                                                }
                                            }
                                        }
                                        if (t.checkInRack("CSE", t.branchName[i], t.nameOfSubject[i], t.creditType[i], t.year[i]) == false) {
                                            if (t.checkInBranchBox(b, dc, t.nameOfSubject[i], cre, t.creditType[i]) == false) {
                                                if (t.branchName[i].equals("MECH") && b[row][col - 7].sub == null) {
                                                    b[row][col - 7].cT = t.creditType[i];
                                                    b[row][col - 7].fac = t.nameOfFaculty[i];
                                                    b[row][col - 7].sub = t.nameOfSubject[i];
                                                    b[row][col - 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CIVIL") && b[row][col - 14].sub == null) {
                                                    b[row][col - 14].cT = t.creditType[i];
                                                    b[row][col - 14].fac = t.nameOfFaculty[i];
                                                    b[row][col - 14].sub = t.nameOfSubject[i];
                                                    b[row][col - 14].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("ECE") && b[row][col - 21].sub == null) {
                                                    b[row][col - 21].cT = t.creditType[i];
                                                    b[row][col - 21].fac = t.nameOfFaculty[i];
                                                    b[row][col - 21].sub = t.nameOfSubject[i];
                                                    b[row][col - 21].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("EE") && b[row][col - 28].sub == null) {
                                                    b[row][col - 28].cT = t.creditType[i];
                                                    b[row][col - 28].fac = t.nameOfFaculty[i];
                                                    b[row][col - 28].sub = t.nameOfSubject[i];
                                                    b[row][col - 28].cla = t.allocatedClasses[c1];
                                                } else {
                                                    b[row][col].cT = ' ';
                                                    b[row][col].fac = null;
                                                    b[row][col].sub = null;
                                                    b[row][col].cla = null;
                                                    t.credits[i]++;
                                                    break label;
                                                }
                                            }
                                        }
                                        if (t.checkInRack("MECH", t.branchName[i], t.nameOfSubject[i], t.creditType[i], t.year[i]) == false) {
                                            if (t.checkInBranchBox(b, dm, t.nameOfSubject[i], cre, t.creditType[i]) == false) {
                                                if (t.branchName[i].equals("CSE") && b[row][col + 7].sub == null) {
                                                    b[row][col + 7].cT = t.creditType[i];
                                                    b[row][col + 7].fac = t.nameOfFaculty[i];
                                                    b[row][col + 7].sub = t.nameOfSubject[i];
                                                    b[row][col + 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("ECE") && b[row][col - 14].sub == null) {
                                                    b[row][col - 14].cT = t.creditType[i];
                                                    b[row][col - 14].fac = t.nameOfFaculty[i];
                                                    b[row][col - 14].sub = t.nameOfSubject[i];
                                                    b[row][col - 14].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("EE") && b[row][col - 21].sub == null) {
                                                    b[row][col - 21].cT = t.creditType[i];
                                                    b[row][col - 21].fac = t.nameOfFaculty[i];
                                                    b[row][col - 21].sub = t.nameOfSubject[i];
                                                    b[row][col - 21].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CIVIL") && b[row][col - 7].sub == null) {
                                                    b[row][col - 7].cT = t.creditType[i];
                                                    b[row][col - 7].fac = t.nameOfFaculty[i];
                                                    b[row][col - 7].sub = t.nameOfSubject[i];
                                                    b[row][col - 7].cla = t.allocatedClasses[c1];
                                                } else {
                                                    b[row][col].cT = ' ';
                                                    b[row][col].fac = null;
                                                    b[row][col].sub = null;
                                                    b[row][col].cla = null;
                                                    t.credits[i]++;
                                                    break label;
                                                }
                                            }
                                        }
                                        if (t.checkInRack("CIVIL", t.branchName[i], t.nameOfSubject[i], t.creditType[i], t.year[i]) == false) {
                                            if (t.checkInBranchBox(b, dci, t.nameOfSubject[i], cre, t.creditType[i]) == false) {
                                                if (t.branchName[i].equals("MECH") && b[row][col + 7].sub == null) {
                                                    b[row][col + 7].cT = t.creditType[i];
                                                    b[row][col + 7].fac = t.nameOfFaculty[i];
                                                    b[row][col + 7].sub = t.nameOfSubject[i];
                                                    b[row][col + 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("EE") && b[row][col - 14].sub == null) {
                                                    b[row][col - 14].cT = t.creditType[i];
                                                    b[row][col - 14].fac = t.nameOfFaculty[i];
                                                    b[row][col - 14].sub = t.nameOfSubject[i];
                                                    b[row][col - 14].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("ECE") && b[row][col - 7].sub == null) {
                                                    b[row][col - 7].cT = t.creditType[i];
                                                    b[row][col - 7].fac = t.nameOfFaculty[i];
                                                    b[row][col - 7].sub = t.nameOfSubject[i];
                                                    b[row][col - 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CSE") && b[row][col + 14].sub == null) {
                                                    b[row][col + 14].cT = t.creditType[i];
                                                    b[row][col + 14].fac = t.nameOfFaculty[i];
                                                    b[row][col + 14].sub = t.nameOfSubject[i];
                                                    b[row][col + 14].cla = t.allocatedClasses[c1];
                                                } else {
                                                    b[row][col].cT = ' ';
                                                    b[row][col].fac = null;
                                                    b[row][col].sub = null;
                                                    b[row][col].cla = null;
                                                    t.credits[i]++;
                                                    break label;
                                                }
                                            }
                                        }
                                        if (t.checkInRack("ECE", t.branchName[i], t.nameOfSubject[i], t.creditType[i], t.year[i]) == false) {
                                            if (t.checkInBranchBox(b, de, t.nameOfSubject[i], cre, t.creditType[i]) == false) {
                                                if (t.branchName[i].equals("CIVIL") && b[row][col + 7].sub == null) {
                                                    b[row][col + 7].cT = t.creditType[i];
                                                    b[row][col + 7].fac = t.nameOfFaculty[i];
                                                    b[row][col + 7].sub = t.nameOfSubject[i];
                                                    b[row][col + 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CSE") && b[row][col + 21].sub == null) {
                                                    b[row][col + 21].cT = t.creditType[i];
                                                    b[row][col + 21].fac = t.nameOfFaculty[i];
                                                    b[row][col + 21].sub = t.nameOfSubject[i];
                                                    b[row][col + 21].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("EE") && b[row][col - 7].sub == null) {
                                                    b[row][col - 7].cT = t.creditType[i];
                                                    b[row][col - 7].fac = t.nameOfFaculty[i];
                                                    b[row][col - 7].sub = t.nameOfSubject[i];
                                                    b[row][col - 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("MECH") && b[row][col + 14].sub == null) {
                                                    b[row][col + 14].cT = t.creditType[i];
                                                    b[row][col + 14].fac = t.nameOfFaculty[i];
                                                    b[row][col + 14].sub = t.nameOfSubject[i];
                                                    b[row][col + 14].cla = t.allocatedClasses[c1];
                                                } else {
                                                    b[row][col].cT = ' ';
                                                    b[row][col].fac = null;
                                                    b[row][col].sub = null;
                                                    b[row][col].cla = null;
                                                    t.credits[i]++;
                                                    break label;
                                                }
                                            }
                                        }
                                        if (t.checkInRack("EE", t.branchName[i], t.nameOfSubject[i], t.creditType[i], t.year[i]) == false) {
                                            if (t.checkInBranchBox(b, dee, t.nameOfSubject[i], cre, t.creditType[i]) == false) {
                                                if (t.branchName[i].equals("ECE") && b[row][col + 7].sub == null) {
                                                    b[row][col + 7].cT = t.creditType[i];
                                                    b[row][col + 7].fac = t.nameOfFaculty[i];
                                                    b[row][col + 7].sub = t.nameOfSubject[i];
                                                    b[row][col + 7].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("MECH") && b[row][col + 21].sub == null) {
                                                    b[row][col + 21].cT = t.creditType[i];
                                                    b[row][col + 21].fac = t.nameOfFaculty[i];
                                                    b[row][col + 21].sub = t.nameOfSubject[i];
                                                    b[row][col + 21].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CSE") && b[row][col + 28].sub == null) {
                                                    b[row][col + 28].cT = t.creditType[i];
                                                    b[row][col + 28].fac = t.nameOfFaculty[i];
                                                    b[row][col + 28].sub = t.nameOfSubject[i];
                                                    b[row][col + 28].cla = t.allocatedClasses[c1];
                                                } else if (t.branchName[i].equals("CIVIL") && b[row][col - 14].sub == null) {
                                                    b[row][col + 14].cT = t.creditType[i];
                                                    b[row][col + 14].fac = t.nameOfFaculty[i];
                                                    b[row][col + 14].sub = t.nameOfSubject[i];
                                                    b[row][col + 14].cla = t.allocatedClasses[c1];
                                                } else {
                                                    b[row][col].cT = ' ';
                                                    b[row][col].fac = null;
                                                    b[row][col].sub = null;
                                                    b[row][col].cla = null;
                                                    t.credits[i]++;
                                                    break label;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < t.nameOfSubject.length; i++) {
                if (t.branchName[i].equals(t.returnBranch(dummy)) && t.year[i] == t.returnYear(dummy) && t.creditType[i] != 'P' && t.credits[i] > 0 && t.category[i].equals("CC")) {
                    while (t.checkCreditsVanish(t.returnBranch(dummy), t.returnYear(dummy), t.creditType[i], t.nameOfSubject[i]) != true) {
                        System.out.println(t.nameOfSubject[i] + "\t" + t.nameOfFaculty[i] + "\t" + t.branchName[i] + "\t" + t.year[i] + "\t" + dummy + "\t" + t.creditType[i]);
                        int col = dummy + (int) (Math.random() * 7);
                        int row = (int) (Math.random() * 6);
                        if (b[row][col].sub == null) {
                            int f = 0, c = 0, possible = 0, f1 = 0, c1 = 0;
                            java.util.Arrays.fill(t.allocatedClasses, null);
                            java.util.Arrays.fill(t.allocatedFaculties, null);
                            for (f = dummy / 7; f > 0; f--) {
                                t.allocatedFaculties[f1++] = b[row][col - 7 * f].fac;
                            }
                            for (c = dummy / 7; c > 0; c--) {
                                t.allocatedClasses[c1++] = b[row][col - 7 * c].cla;
                            }
                            if (t.checkPossibilityOfAllocation(t.nameOfFaculty[i], t.allocatedFaculties) == true) {
                                if (t.classCapacity[i] > 60) {
                                    if (t.checkPossibilityOfAllocation(t.classNames[20], t.allocatedClasses) == true) {
                                        t.allocatedClasses[c1] = t.classNames[20];
                                        possible++;
                                    } else if (t.checkPossibilityOfAllocation(t.classNames[21], t.allocatedClasses) == true) {
                                        t.allocatedClasses[c1] = t.classNames[21];
                                        possible++;
                                    } else if (t.checkPossibilityOfAllocation(t.classNames[22], t.allocatedClasses) == true) {
                                        t.allocatedClasses[c1] = t.classNames[22];
                                        possible++;
                                    } else if (t.checkPossibilityOfAllocation(t.classNames[23], t.allocatedClasses) == true) {
                                        t.allocatedClasses[c1] = t.classNames[23];
                                        possible++;
                                    } else if (t.checkPossibilityOfAllocation(t.classNames[24], t.allocatedClasses) == true) {
                                        t.allocatedClasses[c1] = t.classNames[24];
                                        possible++;
                                    }

                                } else {
                                    for (int k = 0; k < t.classNames.length - 5; k++) {
                                        if (t.checkPossibilityOfAllocation(t.classNames[k], t.allocatedClasses) == true) {
                                            t.allocatedClasses[c1] = t.classNames[k];
                                            k = t.classNames.length;
                                            possible++;
                                        }
                                    }
                                }
                                if (possible > 0) {
                                    b[row][col].cT = t.creditType[i];
                                    b[row][col].fac = t.nameOfFaculty[i];
                                    b[row][col].sub = t.nameOfSubject[i];
                                    b[row][col].cla = t.allocatedClasses[c1];
                                    t.credits[i]--;
                                    if (t.classCapacity[i] > 60) {
                                        for (int m = 0; m < t.nameOfSubject.length; m++) {
                                            if (t.year[m] == t.returnYear(dummy) && t.nameOfSubject[i].equals(t.nameOfSubject[m]) && t.nameOfFaculty[i].equals(t.nameOfFaculty[m]) && t.credits[m] > 0 && t.classCapacity[m] > 60 && t.creditType[i] == t.creditType[m]) {
                                                if (t.branchName[i].equals("CSE") && i != m) {
                                                    int a[] = {7, 14, 21, 28};
                                                    String bra[] = {"MECH", "CIVIL", "ECE", "EE"};
                                                    t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                } else if (t.branchName[i].equals("MECH") && i != m) {
                                                    int a[] = {-7, 7, 14, 21};
                                                    String bra[] = {"CSE", "CIVIL", "ECE", "EE"};
                                                    t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                } else if (t.branchName[i].equals("CIVIL") && i != m) {
                                                    int a[] = {-14, -7, 7, 14};
                                                    String bra[] = {"CSE", "MECH", "ECE", "EE"};
                                                    t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                } else if (t.branchName[i].equals("ECE") && i != m) {
                                                    int a[] = {-21, -14, -7, 7};
                                                    String bra[] = {"CSE", "MECH", "CIVIL", "EE"};
                                                    t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                } else if (t.branchName[i].equals("EE") && i != m) {
                                                    int a[] = {-28, -21, -14, -7};
                                                    String bra[] = {"CSE", "MECH", "CIVIL", "EE"};
                                                    t.boxAllocationForMoreThan60Capacity(m, i, c1, row, col, b, a, bra);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            dummy += 7;
        }
        Frame myTimeT = new Frame(b);
    }

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TimeTable/login.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 410, 220, 30);

        userName.setFont(new java.awt.Font("Arial", 0, 18));
        userName.setToolTipText("Enter Username ");
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(110, 265, 270, 40);

        passwordField.setToolTipText("Enter Password");
        getContentPane().add(passwordField);
        passwordField.setBounds(110, 330, 270, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TimeTable/password.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 330, 210, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TimeTable/username.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 240, 100, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TimeTable/background.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(5500, 4500));
        jLabel1.setMinimumSize(new java.awt.Dimension(5000, 4000));
        jLabel1.setPreferredSize(new java.awt.Dimension(4500, 3500));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-30, 60, 2280, 1320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (userName.getText().equals(username) && passwordField.getText().equals(password)) {
            Thread thread = new Thread(new Runnable()   {
                @Override
                public void run()   {
                    try {
                Scanner input = new Scanner(new File("test1.txt"));
                if (input.hasNext()) {
                    TTAlgo();
                } else {
                    dataEntry dataEntryFrame = new dataEntry();
                    dataEntryFrame.setVisible(true);
                   
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
                }
            });
            thread.start();
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Details!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_userNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
