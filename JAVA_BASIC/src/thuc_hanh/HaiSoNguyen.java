    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiem_tra_1;

import java.util.Scanner;

/**
 *
 * @author tdz20
 */
public class HaiSoNguyen {

    private long m, n;
    public HaiSoNguyen(){
        m = 0; n = 0;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap m:");
        m = Long.parseLong(sc.nextLine());
        System.out.print("Nhap n > m:");
        n = Long.parseLong(sc.nextLine());
    }
    public void uocChungLonNhat(){
        System.out.println(ucln(m, n));
    }
    public static long ucln(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return ucln(b, a % b);
        }
    }
    public void boiChungNhoNhat(){
        System.out.println(bcnn(m, n));
    }
    public static long bcnn(long a, long b) {
        return a * b / ucln(a, b);
    }

    public void soNguyenTo() {
        for (long i = m; i <= n; i++) {
            if (ngTo(i) == true) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean ngTo(long x) {
        if (x < 4) {
            return x > 1;
        }
        if (x % 2 == 0 || x % 3 == 0) {
            return false;
        }
        long k = 5;
        while(k * k <= x){
            if(x % k == 0 || x % (k + 2) == 0){
                return false;
            }
            k += 6;
        }
        return true;
    }
}
