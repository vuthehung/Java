/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05042;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<XepHang> bxh = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String tenSV = sc.nextLine();
            String[] tmp = sc.nextLine().split(" ");
            int ac = Integer.parseInt(tmp[0]);
            int submit = Integer.parseInt(tmp[1]);
            bxh.add(new XepHang(tenSV, ac, submit));
        }
        Collections.sort(bxh);
        for(XepHang x : bxh) {
            System.out.println(x);
        }
    }
}
//2
//Nguyen Van Nam
//168 600
//Tran Thi Ngoc
//168 600