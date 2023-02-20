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
public class J03005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine().toLowerCase(), res = "";
            String[] arr = s.trim().split("\\s+");
            for(int i = 1; i < arr.length; i++) {
                char tmp = Character.toUpperCase(arr[i].charAt(0));
                res += tmp;
                for(int j = 1; j < arr[i].length(); j++) {
                    res += arr[i].charAt(j);
                }
                if(i != arr.length - 1)
                    res += " ";
                else
                    res += ", ";
            }
            res += arr[0].toUpperCase();
            System.out.println(res);
        }
    }
}
