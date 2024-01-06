
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.reservation;


public class Exception1 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());
        
        if(!checkout.after(checkin)){
            System.out.println("Error in reservation: checkout date must be after checkin date");
        }
        else{
            reservation res = new reservation(number, checkin, checkout);
            System.out.println("Reservation: " + res);
            
            System.out.println("---------------------------------- ");
            System.out.println("Enter the update reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());
             
           String error = res.updateDates(checkin, checkout);
            
           if(error != null){
               System.out.println("Error in reservation: " + error);
           }
           System.out.println("Reservation: " + res);            
            
        }
        sc.close();
    }
}
