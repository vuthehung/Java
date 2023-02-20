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
public class C_Chuanhoten {
    public static String chuanHoa(String s) {
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String t = st.nextToken().toLowerCase();
            res.append(Character.toUpperCase(t.charAt(0)));
            for(int i = 1; i < t.length(); i++)
                res.append(t.charAt(i));
            res.append(" ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String tmp = chuanHoa(s);
            if(n == 1) {
                String[] a = tmp.split(" ");
                String res = "";
                res += a[a.length - 1];
                for(int i = 0; i < a.length - 1; i++)
                    res += " " + a[i];
                System.out.println(res);
            }else {
                String[] a = tmp.split(" ");
                String res = "";
                for(int i = 1; i < a.length; i++)
                    res += a[i] + " ";
                res += a[0];
                System.out.println(res);
            }
        }
    }
}
