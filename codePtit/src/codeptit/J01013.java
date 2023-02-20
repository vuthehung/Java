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
public class J01013 {

    public static void main(String[] args) {

        boolean[] mark = new boolean[(int) 2e3 + 3];
        for (int i = 2; i <= 2e3; ++i) {
            mark[i] = true;
        }
        for (int i = 2; i * i <= 2e3; ++i) {
            if (mark[i]) {
                for (int j = i * i; j <= 2e3; j += i) {
                    mark[j] = false;
                }
            }
        }
        int[] prime = new int[400];
        int len = 0;
        for (int i = 2; i <= 2e3; ++i) {
            if (mark[i]) {
                prime[len++] = i;
            }
        }

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        long res = 0;
        while (t-- > 0) {
            int n = scanner.nextInt();

            for (int i = 0; prime[i] <= Math.sqrt(n); ++i) {
                int tmp = 0;
                while (n % prime[i] == 0) {
                    tmp++;
                    n /= prime[i];
                }
                res += prime[i] * tmp;
            }
            if (n != 1) {
                res += n;
            }
        }
        System.out.println(res);
    }
}
