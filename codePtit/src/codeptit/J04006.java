/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J04006 {
     static Scanner sc = new Scanner(System.in);

    static class Student {
        String rollnumber;
        String name;
        String classname;
        String dob;
        float gpa;

        public void input() {
            rollnumber = "B20DCCN001";
            name = sc.nextLine();
            classname = sc.nextLine();
            dob = sc.nextLine();
            gpa = sc.nextFloat();

            if (dob.charAt(1) == '/') {
                dob = '0' + dob;
            }
            if (dob.charAt(4) == '/') {
                dob = dob.substring(0, 3) + '0' + dob.substring(3);
            }

        }

        public void output() {
            System.out.printf("%s %s %s %s %.2f", rollnumber, name, classname, dob, gpa);
        }
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.input();
        s.output();
    }
}
