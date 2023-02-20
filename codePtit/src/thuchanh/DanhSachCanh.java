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
class Pair<T1, T2> {

    T1 first;
    T2 second;

    Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}

public class DanhSachCanh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> p = new ArrayList<>();
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1 && i < j) {
                    p.add(new Pair(i + 1, j + 1));
                }
            }
        }
        for(Pair x : p) {
            System.out.println(x);
        }
    }
}
