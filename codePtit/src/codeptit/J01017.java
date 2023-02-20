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
public class J01017 {
    public static boolean lienKe(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if((int)s.charAt(i) - (int)s.charAt(i + 1) != 1 && (int)s.charAt(i) - (int)s.charAt(i + 1) != -1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            if(lienKe(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
