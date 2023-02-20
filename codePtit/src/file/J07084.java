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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Online implements Comparable<Online> {

    private String Name, Start, End;
    private long Time;

    Online(String Name, String Start, String End) {
        this.Name = Name;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime s = LocalDateTime.parse(Start, format);
        LocalDateTime e = LocalDateTime.parse(End, format);
        this.Time = ChronoUnit.MINUTES.between(s, e);
    }

    public long getTime() {
        return this.Time;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public int compareTo(Online x) {
        if (this.getTime() > x.getTime()) {
            return -1;
        }
        if (this.getTime() < x.getTime()) {
            return 1;
        }
        return this.getName().compareTo(x.getName());
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.Name, this.Time);
    }
}

public class J07084 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        //Scanner sc=new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Online> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Online(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for (Online x : a) {
            System.out.println(x);
        }
    }
}
