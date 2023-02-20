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
public class KiemTraCau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            int ok = 1;
            Stack<Character> st = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                    st.push(s.charAt(i));
                }else if(s.charAt(i) == ')') {
                    if(!st.empty() && st.peek() == '(') {
                        st.pop();
                    }else {
                        ok = 0;
                        break;
                    }
                }else if(s.charAt(i) == ']') {
                    if(!st.empty() && st.peek() == '[') {
                        st.pop();
                    }else {
                        ok = 0;
                        break;
                    }
                }
            }
            if(!st.empty()) ok = 0;
            if(ok == 1) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
