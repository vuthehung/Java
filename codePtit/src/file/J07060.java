/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

class Subject {

    public String code, name, form;

    public Subject(String code, String name, String form) {
        this.code = code;
        this.name = name;
        this.form = form;
    }
}

class Cathi {

    public String day, hour, roomCode;

    public Cathi(String day, String hour, String roomCode) {
        this.day = day;
        this.hour = hour;
        this.roomCode = roomCode;
    }
}

class Data {

    public String macathi, day, hour, roomCode, subjectName, groupCode, students;

    public Data(String macathi, String day, String hour, String roomCode, String subjectName, String groupCode,
            String students) {
        this.macathi = macathi;
        this.day = day;
        this.hour = hour;
        this.roomCode = roomCode;
        this.subjectName = subjectName;
        this.groupCode = groupCode;
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s", day, hour, roomCode, subjectName, groupCode, students);
    }
}

public class J07060 {

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("MONTHI.in"));
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Subject> hashSubject = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String code = sc.nextLine();
            hashSubject.put(code, new Subject(code, sc.nextLine(), sc.nextLine()));
        }
        sc = new Scanner(new File("CATHI.in"));
        n = sc.nextInt();
        HashMap<String, Cathi> hashCathi = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashCathi.put(String.format("C%03d", i), new Cathi(sc.next(), sc.next(), sc.next()));
        }
        sc = new Scanner(new File("LICHTHI.in"));
        n = sc.nextInt();
        ArrayList<Data> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String macathi = sc.next(), subjectCode = sc.next(), groupCode = sc.next(), students = sc.next();
            Cathi x = hashCathi.get(macathi);
            arr.add(new Data(macathi, x.day, x.hour, x.roomCode, hashSubject.get(subjectCode).name, groupCode,
                    students));
        }
        arr.sort((x, y) -> {
            if (!x.day.equals(y.day)) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date d1, d2;
                try {
                    d1 = sdf.parse(x.day);
                    d2 = sdf.parse(y.day);
                    return d1.compareTo(d2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if (!x.hour.equals(y.hour)) {
                return x.hour.compareTo(y.hour);
            }
            return x.macathi.compareTo(y.macathi);
        });
        for (Data x : arr) {
            System.out.println(x);
        }
    }
}
