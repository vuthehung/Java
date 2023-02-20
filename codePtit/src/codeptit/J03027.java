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
public class J03027 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        boolean c=true;
        while(c){
            c=false;
            int i=0;
            while(i<list.size()-1){
                if(list.get(i).equals(list.get(i+1))){
                    c=true;
                    list.remove(i);
                    list.remove(i);
                    i-=1;
                }
                i++;
            }
        }
        if(list.size()==0){
            System.out.println("Empty String");
        } else {
            for(char x:list)
                System.out.print(x);
            System.out.println();
        }
    }
}
