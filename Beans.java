/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapp;


/**
 *
 * @author Baylasan
 */
public class Beans {
   private int amount;

    public Beans() {
       amount=1000;
    }
   
    public int getAmount() {
        return amount;
    
    }
    public void setAmount(int amount) {
        this.amount=amount;
    }
    public void fillcoffeebeans(){                          
        setAmount(1000);
    }
    
   
    public String getInfo() {
        return "Beans{" + "amount=" + amount +'}';
    }

            
   
}
