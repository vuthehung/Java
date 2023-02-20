/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05071;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        CuocGoi.m.put("Noi mang", new TTP("Noi mang", "Noi mang", 800L));
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long gia = Long.parseLong(sc.nextLine());
            CuocGoi.m.put(ma, new TTP(ma, ten, gia));
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String[] data = sc.nextLine().split(" +");
            CuocGoi cg = new CuocGoi(data[0], data[1], data[2]);
            System.out.println(cg);
        }
    }
}

//2
//53
//Da Nang
//3000
//64
//Vung Tau
//1000
//3
//064-824531 11:20 11:22
//8293567 09:07 09:15
//053-823532 12:00 12:05