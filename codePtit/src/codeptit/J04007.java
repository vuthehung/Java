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
public class J04007 {
    static Scanner sc = new Scanner(System.in);

    static class Employee {
        String rollNumber;
        String name;
        String gender;
        String dob;
        String address;
        String taxNumber;
        String contractDate;

        public void input() {
            rollNumber = "00001";
            name = sc.nextLine();
            gender = sc.nextLine();
            dob = sc.nextLine();
            address = sc.nextLine();
            taxNumber = sc.nextLine();
            contractDate = sc.nextLine();
        }

        public void output() {
            System.out.printf("%s %s %s %s %s %s %s", rollNumber, name, gender, dob, address, taxNumber, contractDate);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.input();
        e.output();
    }
}
