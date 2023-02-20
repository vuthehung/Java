/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class ThiSinh implements Comparable<ThiSinh> {

    String ma, name;
    double tongdiem, uutien;

    ThiSinh(String ma, String name, double a, double b, double c) {
        this.ma = ma;
        this.name = "";
        StringTokenizer st = new StringTokenizer(name);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            this.name += s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";
        }
        if (this.ma.substring(0, 3).equals("KV1")) {
            this.uutien = 0.5;
            this.tongdiem = a * 2 + b + c + 0.5;
        } else if (this.ma.substring(0, 3).equals("KV2")) {
            this.uutien = 1;
            this.tongdiem = a * 2 + b + c + 1;
        } else if (this.ma.substring(0, 3).equals("KV3")) {
            this.uutien = 2.5;
            this.tongdiem = a * 2 + b + c + 2.5;
        }
    }

    @Override
    public int compareTo(ThiSinh a) {
        if (a.tongdiem == this.tongdiem) {
            return this.ma.compareTo(a.ma);
        } else if (this.tongdiem > a.tongdiem) {
            return -1;
        } else if (this.tongdiem < a.tongdiem) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s%s %s ", this.ma, this.name, new DecimalFormat("0.#").format(this.uutien), new DecimalFormat("0.#").format(this.tongdiem));
    }
}

public class J07052 {

    public static void main(String[] args) throws IOException {
        ArrayList<ThiSinh> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            ds.add(new ThiSinh(in.nextLine(), in.nextLine(), Double.parseDouble(in.nextLine()), Double.parseDouble(in.nextLine()), Double.parseDouble(in.nextLine())));
        }
        int chitieu = in.nextInt();
        int count = 0;
        double diemchuan = 0;
        Collections.sort(ds);
        for (ThiSinh tmp : ds) {
            if (++count == chitieu) {
                diemchuan = tmp.tongdiem;
                break;
            }
            if (count == ds.size()) {
                diemchuan = tmp.tongdiem;
            }
        }
        System.out.printf("%.1f\n", diemchuan);
        for (ThiSinh tmp : ds) {
            if (tmp.tongdiem >= diemchuan) {
                System.out.printf("%sTRUNG TUYEN\n", tmp);
            } else {
                System.out.printf("%sTRUOT\n", tmp);
            }
        }
    }
}
