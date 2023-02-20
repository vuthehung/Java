/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;

/**
 *
 * @author Admin
 */
class Pair<T, S> {
    T first;
    S second;
    
    Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
    
    boolean ngto(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) 
                return false;
        }
        return n > 1;
    }
    
    boolean isPrime() {
        if(ngto((Integer) first) && ngto((Integer) second))
            return true;
        return false;
    }
    
    @Override
    public String toString() {
        return first + " " + second; 
    }
}
public class J04020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
