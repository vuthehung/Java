/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.util.*;

/**
 *
 * @author Admin
 */
class Pair<T1, T2> {
    T1 dau;
    T2 index;
    
    Pair(T1 dau, T2 index) {
        this.dau = dau;
        this.index = index;
    }
}
public class DanhSoThuTuDauNgoac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            Stack<Pair> st = new Stack<>();
            int cnt = 0;
            String s = sc.next();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(') {
                    cnt++;
                    st.push(new Pair(s.charAt(i), cnt));
                    System.out.printf(cnt + " ");
                }else if(s.charAt(i) == ')' && !st.empty()) {
                    System.out.printf(st.peek().index + " ");
                    st.pop();
                }
            }
            System.out.println();
        }
    }
}
