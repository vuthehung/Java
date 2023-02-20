/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.util.*;
import java.io.*;
class TenVietTat implements Comparable<TenVietTat>{
    private String Thuong,Tat;
    TenVietTat(String Thuong){
        this.Thuong=Thuong;
        StringTokenizer st=new StringTokenizer(Thuong);
        this.Tat=st.nextToken().substring(0,1);
        while(st.hasMoreTokens())this.Tat+="."+st.nextToken().substring(0,1);
    }
    public String get(){
        return this.Thuong;
    }
    public String getTat(){
        return this.Tat;
    }
    @Override
    public int compareTo(TenVietTat x){
        String[] s1=this.Thuong.split(" ");
        String[] s2=x.get().split(" ");
        if(s1[s1.length-1].compareTo(s2[s2.length-1])==0){
            return s1[0].compareTo(s2[0]);
        }
        return s1[s1.length-1].compareTo(s2[s2.length-1]);
    }
}
public class J07071 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new File("DANHSACH.in"));
        int n=Integer.valueOf(sc.nextLine());
        ArrayList<TenVietTat> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new TenVietTat(sc.nextLine()));
        }
        Collections.sort(a);        
        int m=Integer.valueOf(sc.nextLine());
        for(int i=0;i<m;i++){
            String s1=sc.nextLine();
            String[] s2=s1.split("\\*");
            if(s2.length>1){
                for(TenVietTat x:a){
                    if(s1.length()==x.getTat().length()&&x.getTat().startsWith(s2[0])&&x.getTat().endsWith(s2[1]))
                        System.out.println(x.get());
                }
            } else {
                for(TenVietTat x:a){
                    if(s1.length()==x.getTat().length()&&x.getTat().startsWith(s2[0]))
                        System.out.println(x.get());
                }
            }
        }
    }
}
