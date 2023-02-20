/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05081;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MatHang> l_mh = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String dvTinh = sc.nextLine();
            int giaMua = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());
            l_mh.add(new MatHang(i, ten, dvTinh, giaMua, giaBan));
        }
        Collections.sort(l_mh);
        for(MatHang mh : l_mh) {
            System.out.println(mh);
        }
    }
}
