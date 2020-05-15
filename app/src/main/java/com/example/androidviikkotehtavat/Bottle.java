package com.example.androidviikkotehtavat;

public class Bottle {
    private String name;

    private String manufacturer;

    private double price;

    private double size;

    private double total_energy;

    private int code;



    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        price = 1.80;
        size = 0.5;
        code = 0;
    }

    public Bottle(String name, double price, double size, int code){
        this.name = name;
        this.size = size;
        this.price = price;
        this.code = code;
    }

    public double getSize(){
        return size;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getEnergy(){
        return total_energy;
    }

    public int getCode(){
        return code;
    }

}
