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
public class J02102 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a= new int[n][n];
        int[] b=new int[n*n];
        for(int i=0;i<n*n;i++)b[i]=sc.nextInt();
        Arrays.sort(b);
        int dong=n,cot=n,p=0,dem=0;
        while(dem<n*n){
            for(int i=p;i<cot;i++)a[p][i]=b[dem++];
            for(int i=p+1;i<dong;i++)a[i][cot-1]=b[dem++];
            if(p!=dong-1)for(int i=cot-2;i>=p;i--)a[dong-1][i]=b[dem++];
            if(p!=cot-1)for(int i=dong-2;i>p;i--)a[i][p]=b[dem++];
            dong--;cot--;p++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }
}
