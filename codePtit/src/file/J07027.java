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

class Student {
    public String code, name, phoneNumber, task;
    public int group;

    public Student(String code, String name, String phoneNumber) {
        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setGroup(String group) {
        this.group = Integer.parseInt(group);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %s", code, name, phoneNumber, group, task);
    }
}

public class J07027 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arr.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        sc = new Scanner(new File("BAITAP.in"));
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> task = new ArrayList<>();
        for (int i = 0; i < m; i++)
            task.add(sc.nextLine());
        sc = new Scanner(new File("NHOM.in"));
        HashMap<String, String> hashGroup = new HashMap<>();
        for (int i = 0; i < n; i++)
            hashGroup.put(sc.next(), sc.next());
        for (Student x : arr)
            x.setGroup(hashGroup.get(x.code));
        for (Student x : arr)
            x.setTask(task.get(x.group - 1));
        arr.sort((x, y) -> {
            return x.code.compareTo(y.code);
        });
        for (Student x : arr)
            System.out.println(x);
    }
}
