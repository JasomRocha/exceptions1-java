/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
    public reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }
    
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime()-checkin.getTime();
        
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);   
    }
     
    
    public String updateDates(Date checkin, Date checkout){
        Date now = new Date();
            
            if(checkin.before(now) || checkout.before(now)){
                return "Reservation dates for Update must be future dates.";
            }
            if(!checkout.after(checkin)){
                return "checkout date must be after checkin date.";
            }
        
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
         return "Room: " 
               + roomNumber 
               + ", check-in: "
               + sdf.format(checkin)
               + ", check-out: "
               + sdf.format(checkout)
               + ", "
               + duration ()
               + " nights"; 
    }
    
    
}
