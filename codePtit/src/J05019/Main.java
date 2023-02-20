/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05019;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, TramDo> m = new LinkedHashMap<>();
        while(n-- > 0) {
            String ten = sc.nextLine();
            String bd = sc.nextLine();
            String kt = sc.nextLine();
            int luongMua = Integer.parseInt(sc.nextLine());
            if(m.containsKey(ten)) {
                m.get(ten).addData(bd, kt, luongMua);
            }else {
                m.put(ten, new TramDo(m.size() + 1, ten, bd, kt, luongMua));
            }
        }
        for(String s : m.keySet()) {
            System.out.println(m.get(s));
        }
    }
}


//10
//Dong Anh
//07:30
//08:00
//60
//Cau Giay
//07:45
//08:12
//50
//Soc Son
//08:00
//09:15
//78
//Dong Anh
//18:50
//20:00
//88
//Cau Giay
//19:01
//20:00
//77
//Soc Son
//19:06
//20:21
//66
//Dong Anh
//21:00
//21:40
//49
//Cau Giay
//21:50
//22:20
//68
//Dong Anh
//22:15
//23:45
//30
//Cau Giay
//22:50
//23:45
//35