/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05047;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static String chuanHoa(String s) {
        String[] tmp = s.toUpperCase().split(" ");
        String res = "";
        for(int i = 0; i <= 1; i++) {
            res += tmp[i].charAt(0);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MatHang> a = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ten = sc.nextLine();
            int soL = Integer.parseInt(sc.nextLine());
            int donGia = Integer.parseInt(sc.nextLine());
            
            String x = chuanHoa(ten);
            String ma = "";
            if(m.containsKey(x)) {
                ma = x + String.format("%02d", m.get(x) + 1);
                m.put(x, m.get(x) + 1);
            }else {
                ma = x + String.format("%02d", 1);
                m.put(x, 1);
            }
            
            a.add(new MatHang(ma, ten, soL, donGia));
        }
        Collections.sort(a);
        for(MatHang mh : a) {
            System.out.println(mh);
        }
    }
}

//3
//May lanh SANYO
//12
//4000000
//Dien thoai Samsung
//30
//3230000
//Dien thoai Nokia
//18
//1240000