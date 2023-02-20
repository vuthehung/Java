/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05025;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static String chuanHoa(String s) {
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toUpperCase();
            res.append(tmp.charAt(0));
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<GV> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String boMon = chuanHoa(sc.nextLine());
            a.add(new GV(i, ten, boMon));
        }
        Collections.sort(a);
        for(GV gv : a) {
            System.out.println(gv);
        }
    }
}

