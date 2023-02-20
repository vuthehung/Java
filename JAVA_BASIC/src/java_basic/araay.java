/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_basic;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class araay {
    //Truyen mang cho ham
    public static int[] thayDoi(int a[]) {
         //nhung gi thay doi trong ham, anh huong den mang truyen cho ham
         //co the su dung (int... arr)
         return a;
    }
    //Sang nguyen to
    public static boolean prime[] = new boolean[10000001];
    public static void sang(){
        //Ban dau cho tat ca cac phan tu trong mang prime = True
        Arrays.fill(prime, true);
        //
        //prime[i] = true : i la so ngto
        //prime[i] = false : i ko la so ngto   
        prime[0] = false;
        prime[1] = false;
        //duyet [2, sqrt(n)]
        for(int i = 2; i <= (int)Math.sqrt(10000000); i++) {
            if(prime[i]) {
                for(int j = i * i; j <= 10000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        //khai bao mang: dataType[] ten mang = new dataType[so luong ptu]
        //Thao tac voi mang: su dung Arrays.phuongthuc()
        //gan phan tu cho mang: Arrays.fill(a, -1) (gan cho doan [0, 9]: Arrays.fill(0, 0, 10, -1))
    }
}
