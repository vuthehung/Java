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
public class J02025 {
    public static boolean sont(int n){
        if(n==2||n==3)return true;
        if(n%2==0||n%3==0||n==1)return false;
        int i=5;
        while(i*i<=n){
            if(n%i==0||n%(i+2)==0)return false;
            i+=6;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
            int n=scan.nextInt();
            ArrayList<Integer> M=new ArrayList<>();
            for(int i=0;i<n;i++){
                int x=scan.nextInt();
                M.add(x);
            }
            Collections.sort(M);
            Collections.reverse(M);
            int[] A=new int[n];
            Arrays.fill(A,0);
            while (true){
                int a=0;
                for(int i=n-1;i>=0;i--){
                    if(A[i]==0){
                        A[i]=1;
                        a++;
                        for(int j=i+1;j<n;j++)A[j]=0;
                        break;
                    }
                }
                if(a==0)break;
                int sum=0;
                for(int i=0;i<n;i++)sum+=A[i]*M.get(i);
                if(sont(sum)) {
                    for (int i = 0; i < n; i++)
                        if (A[i] == 1) System.out.print(M.get(i) + " ");
                    System.out.println();
                }
            }
        }
    }
}
