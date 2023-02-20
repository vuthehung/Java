/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_hanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class G_LocEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> email = new TreeSet<>();
        while(sc.hasNextLine()) {
            email.add(sc.nextLine().toLowerCase().trim());
        }
        for(String s : email) {
            System.out.println(s);
        }
    }
}
