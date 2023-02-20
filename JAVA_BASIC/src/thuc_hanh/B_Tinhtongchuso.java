/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuc_hanh;

import java.util.*;

/**
 *
 * @author Admin
 */
public class B_Tinhtongchuso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s = sc.next();
            ArrayList<Character> a = new ArrayList<>();
            int sum_digit = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    a.add(s.charAt(i));
                }else {
                    sum_digit += s.charAt(i) - '0';
                }
            }
            Collections.sort(a);
            String res = "";
            for(Character x : a)
                res += x;
            res += Integer.toString(sum_digit);
            System.out.println(res);
            
            
                
        }
    }
}
