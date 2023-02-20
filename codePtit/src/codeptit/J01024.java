/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J01024 {
    public static boolean TamPhan(int n) {
        while(n != 0) {
            int tmp = n % 10;
            if(tmp != 0 && tmp != 1 && tmp != 2) {
                return false;
        
            }
            n /= 10;      
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            t--;
            int n = sc.nextInt();
            if(TamPhan(n)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
