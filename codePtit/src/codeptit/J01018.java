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
public class J01018 {
    public static boolean khongLienKe(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            sum += (int)s.charAt(i) - 48;
            if((int)s.charAt(i) - (int)s.charAt(i + 1) != 2 && (int)s.charAt(i) - (int)s.charAt(i + 1) != -2){
                return false;
            }
        }
        sum += (int)s.charAt(s.length() - 1) - 48;
        if(sum % 10 != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            if(khongLienKe(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
