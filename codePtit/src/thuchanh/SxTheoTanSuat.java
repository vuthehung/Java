/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.util.*;



public class SxTheoTanSuat {

    public static HashMap<String, Integer> sortedByVal(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<String, Integer> m = new LinkedHashMap<>();
            int n = sc.nextInt();
            while (n-- > 0) {
                String tmp = sc.next();
                if (m.containsKey(tmp)) {
                    m.put(tmp, m.get(tmp) + 1);
                } else {
                    m.put(tmp, 1);
                }
            }
            HashMap<String, Integer> hm1 = sortedByVal(m);
            for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                for(int i = 0; i < en.getValue(); i++) {
                    System.out.printf(en.getKey() + " ");
                }
            }
            System.out.println();
        }
    }
}
