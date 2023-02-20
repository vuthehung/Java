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
class ThiSinh implements Comparable<ThiSinh> {
    private String ma, ten, info;
    
    public ThiSinh(int n, String ten, String info) {
        this.ma = String.format("C%03d", n);
        this.ten = ten;
        this.info = info;
    }
    
    @Override
    public int compareTo(ThiSinh o) {
        return this.ten.compareTo(o.ten);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + info;
    }

}
public class DanhSachThiICPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> team = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            team.add(sc.nextLine() + " " + sc.nextLine());
        }
        n = Integer.parseInt(sc.nextLine());
        ArrayList<ThiSinh> ts = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String maT = sc.nextLine();
            int l = maT.length();
            int k = (maT.charAt(l - 2) - '0') * 10 + (maT.charAt(l - 1) - '0') - 1;
            ts.add(new ThiSinh(i + 1, ten, team.get(k)));
        }
        Collections.sort(ts);
        for(ThiSinh x : ts) {
            System.out.println(x);
        }
    }
}
