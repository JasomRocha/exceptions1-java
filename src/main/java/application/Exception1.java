
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.reservation;
import model.exceptions.DomainException;


public class Exception1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{  
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());
        
       
        
        reservation res = new reservation(number, checkin, checkout);
        System.out.println("Reservation: " + res);
            
        System.out.println("---------------------------------- ");
        System.out.println("Enter the update reservation: ");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkout = sdf.parse(sc.next());
             
        res.updateDates(checkin, checkout);
        System.out.println("Reservation: " + res);            
        }
        catch(ParseException e){
            System.out.println("Invalid date Format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        
        sc.close();
    }
}
