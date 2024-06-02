/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapp;


import javax.swing.JOptionPane;



/**
 *
 * @author Baylasan
 */

public class Coffee {
    private int waterlevel;
    private Grinder grindlevel;
    private int beans;
    private Beans b = new Beans();
    private Water w = new Water();
    private String coffeetype;
    private int cupscounter;
    private final Log logger;

    private final int MAX_WATER_CAPACITY = 220; // ml
    private final int MAX_BEANS_CAPACITY = 14; // gram
    private final double EspressoCaffiene = 63.6; // mg
    private final double AmericanoCaffiene = 94; // mg
    private final double EspressoCalories = 3; // kcal
    private final double AmericanoCalories = 3; // kcal

    public Coffee(String coffeetype, Grinder grindlevel, Log logger) {
        this.grindlevel = grindlevel;
        this.coffeetype = coffeetype;
        this.logger = logger;
        cupscounter++;
    }

    public Coffee(Log logger) {
        this.logger = logger;
    }

    Coffee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCoffeetype() {
        return coffeetype;
    }

    public void setCoffeetype(String coffeetype) {
        this.coffeetype = coffeetype;
    }

    public Beans getB() {
        return b;
    }

    public void setB(Beans b) {
        this.b = b;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(int waterlevel) {
        if (waterlevel >= 30 && waterlevel <= MAX_WATER_CAPACITY) {
            this.waterlevel = waterlevel;
        } else {
            System.out.println("Out of bound!");
        }
    }

    public Grinder getGrindlevel() {
        return grindlevel;
    }

    public void setGrindlevel(Grinder grindlevel) {
        this.grindlevel = grindlevel;
    }

    public Water getW() {
        return w;
    }

    public void setW(Water w) {
        this.w = w;
    }

    public int getCupscounter() {
        return cupscounter;
    }

    public void setCupscounter(int cupscounter) {
        this.cupscounter = cupscounter;
    }

    // To refill the containers
    public void fillContainers() {
        try {
            Beans b1 = new Beans();
            b1.fillcoffeebeans();
            Water w1 = new Water();
            w1.fillwatercontainer();
            logger.log("Containers refilled: beans and water.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            logger.log("Error refilling containers: " + e.getMessage());
        }
    }

    public void makecoffee(String type, int shots) throws Exception {
        if (type.equalsIgnoreCase("Espresso")) {
            waterlevel = 30 * shots;
            beans = 7 * shots;
            w.setWaterlevel(w.getWaterlevel() - 30 * shots);
            b.setAmount(b.getAmount() - 7 * shots);
            System.out.println("Making Espresso!");
            logger.log("Making Espresso with " + shots + " shots.");
        } else if (type.equalsIgnoreCase("Americano")) {
            if (shots == 1) {
                waterlevel = 170;
                beans = 7;
                w.setWaterlevel(w.getWaterlevel() - 170);
                b.setAmount(b.getAmount() - 7);
            } else {
                waterlevel = 220;
                beans = 14;
                w.setWaterlevel(w.getWaterlevel() - 220);
                b.setAmount(b.getAmount() - 14);
            }
            System.out.println("Making Americano!");
            logger.log("Making Americano with " + shots + " shots.");
        } else {
            throw new Exception("Invalid coffee type!");
        }
    }

    public void calculateCaffeineAndCalories(String coffeeType, int shots) {
        double caffeine;
        double calories;

        if (coffeeType.equalsIgnoreCase("Espresso")) {
            caffeine = EspressoCaffiene * shots;
            calories = EspressoCalories * shots;
        } else if (coffeeType.equalsIgnoreCase("Americano")) {
            caffeine = AmericanoCaffiene * shots;
            calories = AmericanoCalories * shots;
        } else {
            System.out.println("Invalid coffee type!");
            logger.log("Invalid coffee type for caffeine and calories calculation.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Caffeine in " + shots + " shot(s) of " + coffeeType + ": " + caffeine + " mg"
                + "\nCalories in " + shots + " shot(s) of " + coffeeType + ": " + calories + " kcal");
        logger.log("Calculated caffeine and calories for " + shots + " shot(s) of " + coffeeType + ": " + caffeine + " mg, " + calories + " kcal.");
    }

    public void serveCoffee() {
        cupscounter++;
        logger.log("Served coffee. Total cups served: " + cupscounter);

        int CLEANING_INTERVAL = 10;
        if (cupscounter % CLEANING_INTERVAL == 0) {
            System.out.println("Please clean the water tray and waste bin.");
            logger.log("Cleaning required after serving " + cupscounter + " cups.");
        }
    }
}

