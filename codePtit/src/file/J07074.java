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
import java.util.*;

class teachingSchedule {
    public String groupCode, code, lecturerName, roomName;
    public int day, kip;

    public teachingSchedule(int orderNumber, String groupCode, String day, String kip, String lecturerName,
            String roomName) {
        this.code = String.format("HP%03d", orderNumber);
        this.groupCode = groupCode;
        this.day = Integer.parseInt(day);
        this.kip = Integer.parseInt(kip);
        this.lecturerName = lecturerName;
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %s %s", code, day, kip, lecturerName, roomName);
    }
}
public class J07074 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int m = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> subject = new HashMap<>();
        for (int i = 0; i < m; i++) {
            subject.put(sc.nextLine(), sc.nextLine());
            sc.nextLine();
        }
        sc = new Scanner(new File("LICHGD.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<teachingSchedule> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new teachingSchedule(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    sc.nextLine()));
        }
        String q = sc.next();
        ArrayList<teachingSchedule> res = new ArrayList<>();
        for (teachingSchedule x : arr) {
            if (x.groupCode.equals(q))
                res.add(x);
        }
        res.sort((x, y) -> {
            if (x.day != y.day)
                return x.day - y.day;
            if (x.kip != y.kip)
                return x.kip - y.kip;
            return x.lecturerName.compareTo(y.lecturerName);
        });
        System.out.printf("LICH GIANG DAY MON %s:\n", subject.get(q));
        for (teachingSchedule x : res)
            System.out.println(x);
    }
}
