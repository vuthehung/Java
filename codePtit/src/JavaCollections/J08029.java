/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCollections;

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
        return first + " " + second;
    }
}
public class J08029 {
    
    public static String b = "abcdefgh";
    public static int[][] res = new int[10][10];
    
    public static int find(char c, String s) {
        for(int i = 0; i < s.length(); i++) {
            if(c == s.charAt(i))
                return i + 1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) 
                    res[i][j] = -1;
            }
            Pair p1 = new Pair(find(s1.charAt(0), b), s1.charAt(1) - '0');
            Pair p2 = new Pair(find(s2.charAt(0), b), s2.charAt(1) - '0');
            Queue<Pair> q = new LinkedList<>();
            Pair p = new Pair(p1.first, p1.second);
            int m = (int) p2.first;
            int n = (int) p2.second;
            
            q.add(p);
            res[(int)p1.first][(int)p1.second] = 0;
            while(res[m][n] == -1) {
                Pair tmp = q.poll();
                int x = (int) tmp.first;
                int y = (int) tmp.second;
                if(res[x - 2][y - 1] == 0 && x - 2 >= 1 && y - 1 >= 1) {
                    res[x - 2][y - 1] = res[x][y] + 1;
                    q.add(new Pair(x - 2, y - 1));
                }else if(res[x - 1][y - 2] == 0 && x - 1 >= 1 && y - 2 >= 1) {
                    res[x - 1][y - 2] = res[x][y] + 1;
                    q.add(new Pair(x - 1, y - 2));
                }else if(res[x + 2][y + 1] == 0 && x + 2 <= 8 && y + 1 <= 8) {
                    res[x + 2][y + 1] = res[x][y] + 1;
                    q.add(new Pair(x + 2, y + 1));
                }else if(res[x + 1][y + 2] == 0 && x + 1 <= 8 && y + 2 <= 8) {
                    res[x + 1][y + 2] = res[x][y] + 1;
                    q.add(new Pair(x + 1, y + 2));
                }else if(res[x - 2][y + 1] == 0 && x - 2 >= 1 && y + 1 <= 8) {
                    res[x - 2][y + 1] = res[x][y] + 1;
                    q.add(new Pair(x - 2, y + 1));
                }else if(res[x - 1][y + 2] == 0 && x - 1 >= 1 && y + 2 <= 8) {
                    res[x - 1][y + 2] = res[x][y] + 1;
                    q.add(new Pair(x - 1, y + 2));
                }else if(res[x + 1][y - 2] == 0 && x + 1 <= 8 && y - 2 >= 1) {
                    res[x + 1][y - 2] = res[x][y] + 1;
                    q.add(new Pair(x + 1, y - 2));
                }else if(res[x + 2][y - 1] == 0 && x + 2 <= 8 && y - 1 >= 1) {
                    res[x + 2][y - 1] = res[x][y] + 1;
                    q.add(new Pair(x + 2, y - 1));
                }
            }
            System.out.println(res[m][n]);
        }
    }
}
