package com.example.androidviikkotehtavat;

import java.io.IOException;
import java.util.ArrayList;

public class BottleDispenser {

    private static BottleDispenser machine = new BottleDispenser();
    private double money;

    private ArrayList<Bottle> inventory = new ArrayList<>();

    private BottleDispenser() {

        money = 0;
        Bottle bottle1 = new Bottle("Pepsi Max", 1.8, 0.5, 1);
        inventory.add(bottle1);
        Bottle bottle2 = new Bottle("Pepsi Max", 2.2, 1.5, 2);
        inventory.add(bottle2);
        Bottle bottle3 = new Bottle("Coca-Cola Zero", 2.0, 0.5, 3);
        inventory.add(bottle3);
        Bottle bottle4 = new Bottle("Coca-Cola Zero", 2.5, 1.5, 4);
        inventory.add(bottle4);
        Bottle bottle5 = new Bottle("Fanta Zero", 1.95, 0.5, 5);
        inventory.add(bottle5);

    }
    public static BottleDispenser getInstance(){return machine;}

    public double getMoney() {
        return money;
    }

    public double addMoney(int current) {
        money += current;
        return money;
    }


    public int buyBottle(int code)  {
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getCode() == code){
               if(inventory.get(i).getPrice() <= money) {
                   money -= inventory.get(i).getPrice();
                   inventory.remove(i);
                   return 3;
               }else{
                   return 1;
               }
            }

            }
        return 2;
    }


    public double returnMoney() {

        if(money>0) {
            double moneyback = money;
            money = 0;
            return moneyback;
        }
        return 0;
    }

}
