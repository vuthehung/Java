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
public class J03006 {
    public static boolean check(String s) {
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            if((int)s.charAt(i) % 2 != 0) {
                return false;
            }
            tmp = s.charAt(i) + tmp;
        }
        if(tmp.compareTo(s) == 0) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check(s)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
