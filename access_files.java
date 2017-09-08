/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Suranjan
 */
//String subject_name[],String faculty_name[],String branch[],int year[],int no_of_credits[],char credit_type[],String f_time_slot,String type_of_course
public class access_files {

    public void input(String subject_name[], String faculty_name[], int no_of_credits[], String type_of_course[], char credit_type[], String branch[], int year[], int class_capacity[]) throws FileNotFoundException, IOException {
        try {

            File file = new File("test1.txt");

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //    System.out.println("Hey");
            for (int i = 0; i < 150; i++) {
                //   System.out.println("a");

                pw.println(subject_name[i]);

            }
            for (int i = 0; i < 150; i++) {
                pw.println(faculty_name[i]);
            }
            for (int i = 0; i < 150; i++) {
                pw.println(no_of_credits[i]);
            }
            for (int i = 0; i < 150; i++) {
                pw.println(type_of_course[i]);
            }

            for (int i = 0; i < 150; i++) {
                pw.println(credit_type[i]);
            }
            for (int i = 0; i < 150; i++) {
                pw.println(branch[i]);

            }
            for (int i = 0; i < 150; i++) {
                pw.println(year[i]);
            }
            for (int i = 0; i < 150; i++) {
                pw.println(class_capacity[i]);
            }
            pw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
