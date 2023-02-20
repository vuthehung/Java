package connectmysql;

import java.sql.*;
import java.util.*;
public class TH2 {
    private static String DB_URL = "jdbc:mysql://localhost:3306/flightsss";
    private static String USER_NAME = "root";
    private static String PASSWORD = "1";
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, userName, password);

        return conn;
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        
        Scanner sc = new Scanner(System.in);
        boolean conti = true;
        int cusID = 0;
        
        do {
            System.out.println("Menu");
            System.out.println("1: Flights search");
            System.out.println("2: Booking flight");
            System.out.println("3: View booking");
            System.out.println("4: Exit");
            System.out.println("Please choose!!!");
            int choose = Integer.parseInt(sc.nextLine());
            switch(choose) {
                case 1:
                    System.out.println("Flights search!!!!!");
                    System.out.println();
                    System.out.printf("Please enter originCity: ");
                    String originCity = sc.nextLine();
                    System.out.printf("Please enter destCity: ");
                    String destCity = sc.nextLine();
                    String query1 = "select f.fid, f.departure_time, m.month, f.day_of_month, w.day_of_week, c.name, f.origin_city, f.dest_city "
                                    + "from flights f " + "join carriers c on f.carrier_id = c.cid "
                                    + "join months m on f.month_id = m.mid " + "join weekdays w on f.day_of_week_id = w.did "
                                    + "where origin_city = ? and dest_city = ?";
       
                    PreparedStatement ps = conn.prepareStatement(query1);
                    ps.setString(1, originCity);
                    ps.setString(2, destCity);
                    
                    ResultSet rs = ps.executeQuery();
                    System.out.println("fid |" + " departure_time |" + 
                                " month |" + " day_of_month |" + " day_of_week |" + "   carrier_name     |" + " origin_city  |" + " dest_city");
                    while(rs.next()) {
                        System.out.println(rs.getInt("f.fid") + "   | " + rs.getString("f.departure_time") + "          | "
                                            + rs.getString("m.month") + "   |  " + rs.getInt("f.day_of_month") + "       | "
                                            + rs.getString("w.day_of_week") + "  | " + rs.getString("c.name") + " |  "
                                            + rs.getString("f.origin_city") + "  | " + rs.getString("f.dest_city")
                                            );
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Booking flight!!!!!");
                    System.out.println();
                    System.out.println("Please enter info!!!");
                    cusID++;
                    System.out.printf("Name: ");
                    String name = sc.nextLine();
                    System.out.printf("Address: ");
                    String address = sc.nextLine();
                    System.out.printf("Phone Number: ");
                    String phone = sc.nextLine();
                    String query2 = "insert into customers values(?, ?, ?, ?)";
                    
                    PreparedStatement ps2 = conn.prepareStatement(query2);
                    ps2.setInt(1, cusID);
                    ps2.setString(2, name);
                    ps2.setString(3, address);
                    ps2.setString(4, phone);
                    
                    ps2.executeUpdate();
                    System.out.println("Successfully updated!");
                    System.out.println("Your cusID: " + cusID);
                    System.out.println();
                    System.out.println("Please enter cusID: ");
                    System.out.printf("Please enter flight_id: ");
                    int fid = Integer.parseInt(sc.nextLine());
                    
                    String query3 = "insert into booking values(?, ?, ?)";
                    PreparedStatement ps3 = conn.prepareStatement(query3);
                    ps3.setInt(1, cusID);
                    ps3.setInt(2, fid);
                    ps3.setString(3, "TRUE");
                    ps3.executeUpdate();
                    System.out.println("Successful booking!");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("View booking!!!!!");
                    System.out.println();
                    
                    String query4 = "select b.cusid, c.name, c.address, f.fid, b.status_book "
                            + "from booking b "
                            + "join customers c on b.cusid = c.cusid "
                            + "join flights f on b.fid = f.fid";
                    PreparedStatement ps4 = conn.prepareStatement(query4);
                    ResultSet rs2 = ps4.executeQuery();
                    System.out.println("cusID | cusName | cusAdress | flightID | status_book");
                    while(rs2.next()) {
                        System.out.println( "  " + rs2.getInt("b.cusid") + "   | " + rs2.getString("c.name")
                                           + "   | " + rs2.getString("c.address") + " |      "
                                           + rs2.getInt("f.fid") + "   |   " + rs2.getString("b.status_book"));
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exit!!!!!");
                    conti = false;
                    break;
            }
        } while(conti);
        conn.close();
    }
}
