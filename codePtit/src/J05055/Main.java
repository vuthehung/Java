/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05055;


import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<VanDongVien> a = new ArrayList<>();
        ArrayList<VanDongVien> b = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1;i <= n; i++) {
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            String start = sc.nextLine();
            String end = sc.nextLine();
            VanDongVien vdv = new VanDongVien(i, ten, ns, start, end);
            a.add(vdv);
            b.add(vdv);
        }
        Collections.sort(a);
        int i = 1, cnt = 0;
        a.get(0).setSTT(1);
        for(int j = 1; j < n; j++) {
            if(a.get(j - 1).getKetqua() == a.get(j).getKetqua()) {
                a.get(j).setSTT(i);
                cnt += 1;
            }else {
                i += cnt + 1;
                a.get(j).setSTT(i);
                cnt = 0;
            }
        }
        for(VanDongVien vdv : b) {
            System.out.println(vdv);
        }
    }
}

//3
//Nguyen Van Thanh
//20/03/1990
//07:00:00
//07:10:01
//Nguyen Hoa Binh
//01/10/1993
//07:02:00
//07:11:20
//Le Thanh Van
//15/03/1998
//07:05:00
//07:15:30
