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
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Product {

    public String code, name;
    public int price, warranty;

    public Product(String code, String name, int price, int warranty) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }
}

class Customer {

    public String code, name, address, productCode, purchaseDate, expires;
    public int quantity, totalCost;
    public Product purchaseProduct;

    public Customer(int orderNumber, String name, String address, String productCode, String quantity,
            String purchaseDate,
            Product purchaseProduct) {
        this.code = String.format("KH%02d", orderNumber);
        this.name = name;
        this.address = address;
        this.productCode = productCode;
        this.quantity = Integer.parseInt(quantity);
        this.purchaseDate = purchaseDate;
        this.purchaseProduct = purchaseProduct;
        this.expires = getExpires();
        this.totalCost = getTotal();
    }

    public String getExpires() {
        ArrayList<String> tmp = new ArrayList<>(Arrays.asList(purchaseDate.split("[\\/]")));
        String d = tmp.get(2) + "-" + tmp.get(1) + "-" + tmp.get(0);
        LocalDate boughtDate = LocalDate.parse(d);
        LocalDate exp = boughtDate.plusMonths((long) purchaseProduct.warranty);
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String res = dateFormatter1.format(exp);
        ArrayList<String> nmc = new ArrayList<>(Arrays.asList(res.split("[\\/]")));
        return nmc.get(2) + "/" + nmc.get(1) + "/" + nmc.get(0);
    }

    public int getTotal() {
        return purchaseProduct.price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %s", code, name, address, productCode, totalCost, expires);
    }
}

public class J07049 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt();
        HashMap<String, Product> hashProduct = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String code = sc.nextLine();
            hashProduct.put(code, new Product(code, sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        n = sc.nextInt();
        sc.nextLine();
        ArrayList<Customer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine(), address = sc.nextLine(), productCode = sc.nextLine(), quantity = sc.nextLine(),
                    purchaseDate = sc.nextLine();
            arr.add(new Customer(i + 1, name, address, productCode, quantity, purchaseDate,
                    hashProduct.get(productCode)));
        }
        arr.sort((x, y) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (!x.expires.equals(y.expires)) {
                Date d1, d2;
                try {
                    d1 = sdf.parse(x.expires);
                    d2 = sdf.parse(y.expires);
                    return d1.compareTo(d2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return x.code.compareTo(y.code);
        });
        for (Customer x : arr) {
            System.out.println(x);
        }
    }
}
