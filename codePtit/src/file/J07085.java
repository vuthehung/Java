/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author Admin
 */
public class J07085 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream obj=new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a=(ArrayList<String>)obj.readObject();
        for(String s:a){
            s=new BigInteger(String.join("",s.split("[^0-9]+"))).toString();
            int sum=0;
            for(int i=0;i<s.length();i++){
                sum+=Integer.parseInt(s.substring(i,i+1));
            }
            System.out.printf("%s %d\n",s,sum);
        }
    }
}
