/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05077;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Luong> l = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
           String[] tmp = sc.nextLine().split(" ");
           String maPB = tmp[0];
           String t = "";
           for(int i = 1; i < tmp.length; i++) {
               t += tmp[i] + " ";
           }
           String tenPB = t.trim();
           PhongBan.setPhongBan(maPB, tenPB);
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            l.add(new Luong(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        for(Luong x : l) {
            System.out.println(x);
        }
    }
}
//2
//HC Hanh chinh
//KH Ke hoach Dau tu
//2
//C06HC
//Tran Binh Minh
//65
//25
//D03KH
//Le Hoa Binh
//59
//24