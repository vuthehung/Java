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

class RoomInfo {

    public String code, type;
    public double unitPrice, serviceCost;

    public RoomInfo(String code, String type, double unitPrice, double serviceCost) {
        this.code = code;
        this.type = type;
        this.unitPrice = unitPrice;
        this.serviceCost = serviceCost;
    }
}

class Customer {

    public String code, name, roomCode;
    public long daysStay, dayPrint;
    public double discount, cost, total;

    public Customer(int orderNumber, String name, String roomCode, String arrive, String left, double unitPrice,
            double serviceCost) {
        this.code = String.format("KH%02d", orderNumber);
        this.name = name;
        this.roomCode = roomCode;
        this.dayPrint = getDaysStay(arrive, left);
        this.daysStay = Math.max(1, dayPrint);
        this.cost = getCost(serviceCost, unitPrice);
        this.discount = getDiscount();
        this.total = getTotal();
    }

    public long getDaysStay(String arrive, String left) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1, d2;
        try {
            d1 = sdf.parse(arrive);
            d2 = sdf.parse(left);
            long diffInMillies = d2.getTime() - d1.getTime();
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            return diff;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public double getCost(double serviceCost, double unitPrice) {
        return (unitPrice * daysStay) * (1.0 + serviceCost);
    }

    public double getDiscount() {
        if (daysStay >= 30) {
            return cost * 0.06;
        }
        if (daysStay >= 20) {
            return cost * 0.04;
        }
        if (daysStay >= 10) {
            return cost * 0.02;
        }
        return 0;
    }

    public double getTotal() {
        return (cost - discount);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %.2f", code, name, roomCode, dayPrint, total);
    }
}

public class J07047 {

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt();
        HashMap<String, RoomInfo> hashRoom = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String code = sc.next();
            hashRoom.put(code, new RoomInfo(code, sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
        n = sc.nextInt();
        sc.nextLine();
        ArrayList<Customer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String name = sc.nextLine();
            String roomCode = sc.nextLine();
            String arrive = sc.nextLine(), left = sc.nextLine();
            double unitPrice = hashRoom.get(roomCode.substring(2, 3)).unitPrice;
            double serviceCost = hashRoom.get(roomCode.substring(2, 3)).serviceCost;
            arr.add(new Customer(i, name, roomCode, arrive, left, unitPrice, serviceCost));
        }
        arr.sort((x, y) -> {
            if (x.daysStay > y.daysStay) {
                return -1;
            }
            return 1;
        });
        for (Customer x : arr) {
            System.out.println(x);
        }
    }
}
