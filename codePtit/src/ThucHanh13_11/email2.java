/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class email2 {
    public static String chuanHoaTen(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            sb.append(tmp);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static String chuanHoaEmail(String s) {
        ArrayList<String> a = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
           a.add(st.nextToken().toLowerCase());
        }
        String res = "";
        res += a.get(a.size() - 1);
        for(int i = 0; i < a.size() - 1; i++)
            res += a.get(i).charAt(0);
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("D:\\code\\Java\\codePtit\\src\\file\\SV.in"));
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        Set<String> set = new LinkedHashSet<>();
        Map<String, Integer> m = new HashMap<>();
        while(sc.hasNextLine()) {
            String s = sc.nextLine();   
            set.add(chuanHoaTen(s));
        }
        for(String s : set) {
            String res = chuanHoaEmail(s);
            System.out.print(res);
            if(m.containsKey(res)) {
                System.out.print(m.get(res));
                m.put(res, m.get(res) + 1);
            } else {
                m.put(res, 2);
            }
            System.out.println("@ptit.edu.vn");

        }
    }
}
