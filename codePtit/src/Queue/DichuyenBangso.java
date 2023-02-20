package queue;

import java.util.*;

public class DichuyenBangso {

    static int[][] a = new int[505][505];
    static boolean[][] mark = new boolean[505][505];
    static int n, m;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = sc.nextInt();
                }
                Arrays.fill(mark[i], false);
            }
            xuly();
        }
    }

    public static void xuly() {
        int res = Integer.MAX_VALUE;
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new PriorityQueue<>(500, (u, v) -> {
            return u.second.compareTo(v.second);
        });

        queue.add(new Pair<>(new Pair<>(1, 1), a[1][1]));
        mark[1][1] = true;
        while (!queue.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> e = queue.poll();
            Pair<Integer, Integer> point = e.first;
            if (point.first == n && point.second == m) {
                res = e.second;
            } else {
                for (int i = 0; i < 4; i++) {
                    int u = point.first + dx[i], v = point.second + dy[i];
                    if (valid(u, v) && !mark[u][v] && e.second + a[u][v] < res) {
                        queue.add(new Pair<>(new Pair<>(u, v), e.second + a[u][v]));
                        mark[u][v] = true;
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static boolean valid(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }

    static class Pair<U, V> {

        private U first;
        private V second;

        public Pair(U u, V v) {
            this.first = u;
            this.second = v;
        }
    }
}
