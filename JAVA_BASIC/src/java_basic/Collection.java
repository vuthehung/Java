/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;


/**
 *
 * @author Admin
 */
public class Collection {
    public static void main(String[] args) {
//        // ArrayList chi luu object: Integer Long Double(datatype: wrapper)
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(100);
//        arr.add(300);
//        arr.add(200);
//        for(int x : arr){
//            System.out.println(x);
//        }
//        System.out.println(arr.size());
//        for(int i = 0; i < arr.size(); i++) {
//            System.out.println(arr.get(i)); // a[i]
//        }
//         Collections.sort(arr);
//        //search: Collection.binarySearch(idx_s, idx_finish);
//            
//        //sort ArrayList: dung Collections
//        //xay dung comparator(dk so sanh):cho sort
//        //cmp chi ap dung cho object(wrapper)
        //chuyen so thanh str: String s = x + "";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        //sort giam dan
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int x : a){
            System.out.println(x);
        }
       
        //STACK
        // Stack<wapper> st = new Stack<>();
        
        //QUEUE
        //Queue<wapper> q = new LinkedList<>();
        //PriorityQueue<wapper> pq = new PriorityQueue<>();
        //Tao comparator: de thay doi dieu kien sap xep trong hand doi uu tien
//        Comparator<Integer> cmp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };
    }
}
