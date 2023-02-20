/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;


/**
 *
 * @author Admin
 */
public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- != 0) {
            String tmp = sc.nextLine();
            String[] s1 = tmp.trim().split("\\s+");
            tmp = sc.nextLine();
            String[] s2 = tmp.trim().split("\\s+");
            TreeSet<String> set1 = new TreeSet<>(Arrays.asList(s1));
            TreeSet<String> set2 = new TreeSet<>(Arrays.asList(s2));
            for (String i : set1) {
                if (!set2.contains(i))
                    System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}
