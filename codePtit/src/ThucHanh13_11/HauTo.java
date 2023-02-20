/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.util.*;

/**
 *
 * @author Admin
 */
public class HauTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            System.out.println(tinhGiaTriHauTo(s));
        }
    }
    
    public static long tinhGiaTriHauTo(String s) {
        Stack<Long> st = new Stack<>();
        String[] tmp = s.split(" ");
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i].equals("+") || tmp[i].equals("-") || tmp[i].equals("*") || tmp[i].equals("/")) {
                long a = st.pop(), b = st.pop();
                long res = 0;
                switch(tmp[i]) {
                    case "+":
                        res = b + a;
                        break;
                    case "-":
                        res = b - a;
                        break;
                    case "*":
                        res = b * a;
                        break;
                    case "/":
                        res = b / a;
                        break;
                }
                st.push(res);
            }else {
                st.push(Long.parseLong(tmp[i]));
            }
        }
        return st.peek();
    }
}
