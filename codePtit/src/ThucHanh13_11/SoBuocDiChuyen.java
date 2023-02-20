/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

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
    public T1 getFirst() {
        return first;
    }
    public T2 getSecond() {
        return second;
    }
}
public class SoBuocDiChuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n + 5][m + 5];
            int[][] kq = new int[n + 5][m + 5];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    a[i][j] = sc.nextInt();
                    kq[i][j] = -1;
                }
            }
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            q.add(new Pair<>(1, 1));
            kq[1][1] = 0;
            while(!q.isEmpty()) {
                int x = q.peek().getFirst();
                int y = q.peek().getSecond();
                q.poll();
                int duoi = Math.abs(a[x + 1][y] - a[x][y]);
                int phai = Math.abs(a[x][y + 1] - a[x][y]);
                int cheo = Math.abs(a[x + 1][y + 1] - a[x][y]);
                if(x + duoi <= n && kq[x + duoi][y] == -1) {
                    kq[x + duoi][y] = kq[x][y] + 1;
                    q.add(new Pair<>(x + duoi, y));
                }
                if(y + phai <= m && kq[x][y + phai] == -1) {
                    kq[x][y + phai] = kq[x][y] + 1;
                    q.add(new Pair<>(x, y + phai));
                }
                if(x + cheo <= n && y + cheo <= m && kq[x + cheo][y + cheo] == -1) {
                    kq[x + cheo][y + cheo] = kq[x][y] + 1;
                    q.add(new Pair<>(x + cheo, y + cheo));
                }
                if(kq[n][m] != -1) {
                    System.out.println(kq[n][m]);
                    break;
                }
            }
            if(kq[n][m] == -1) System.out.println("-1");
        }
    }
}
