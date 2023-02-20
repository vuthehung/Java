/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class J03004 {
//    public static String chuanHoa(String s) {
//        StringTokenizer st = new StringTokenizer(s);
//        StringBuilder kq = new StringBuilder(s);
//        while(st.hasMoreTokens()) {
//            String t = st.nextToken();
//            kq.append(Character.toUpperCase(t.charAt(0)));
//            for(int i = 1; i < t.length(); i++) {
//                kq.append(Character.toLowerCase(t.charAt(i)));
//            }
//            kq.append(" ");
//        }
//        return kq.toString().trim();
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = Integer.parseInt(sc.nextLine());
//        while(t-- > 0) {
//            String s = sc.nextLine();
//            System.out.println(chuanHoa(s));
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine().toLowerCase();
            s = s.replaceAll("\\s\\s+", " ").trim();
            String[] s_arr = s.split(" ");
            for(String x : s_arr) {
                System.out.print(Character.toUpperCase(x.charAt(0)));
                System.out.print(x.substring(1) + " ");
            }
            System.out.println("");
        }
    }
}
