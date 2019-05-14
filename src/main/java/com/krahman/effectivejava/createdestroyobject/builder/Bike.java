package com.krahman.effectivejava.createdestroyobject.builder;

public class Bike {

    enum Style{
        SPORTS, COMMUTE
    }

    private String model;
    private Style style;
    private boolean geared;
    private int yearOfManufacturing;


    public static class Builder{
        //Mandatory parameters
        private String model;

        //Optional Parameters
        private Style style;
        private boolean geared;
        private int yearOfManufacturing;


        public Builder(String model){
            this.model = model;
        }

        public Builder Style(Style style){
            this.style = style;
            return this;
        }

        public Builder Geared(boolean geared){
            this.geared = geared;
            return this;
        }

        public Builder yearOfManufacturing(int yearOfManufacturing){
            this.yearOfManufacturing = yearOfManufacturing;
            return this;
        }

        public Bike build(){
            return new Bike(this);
        }
    }

    private Bike(Builder builder){
        this.model = builder.model;
        this.geared = builder.geared;
        this.style = builder.style;
        this.yearOfManufacturing = builder.yearOfManufacturing;
    }
}
