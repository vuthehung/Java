/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

/**
 *
 * @author Admin
 */

import java.io.IOException;
import java.util.*;


class Pair implements  Comparable<Pair>{
    int key;
    int value;
    Pair(int key, int value){
        this.key=key;
        this.value=value;
    }
    @Override
    public int compareTo(Pair a){
        if((int)this.key==(int)a.key){
            if((int)this.value>(int)a.value)
                return 1;
            else if((int)this.value<(int)a.value)
                return -1;
            else return 0;
        }
        else if((int)this.key>(int)a.key)
            return 1;
        else if((int)this.key<(int)a.key)
            return -1;
        else return 0;
    }
}

public class J02009 {
    public static void main(String[] args) throws IOException {
        ArrayList<Pair> a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            a.add(new Pair(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(a);
        int time=0;
        for(Pair x:a){
           if(time<=x.key){
               time=x.key+x.value;
           } else {
               time+=x.value;           }
        }
        System.out.print(time);
    }
}
