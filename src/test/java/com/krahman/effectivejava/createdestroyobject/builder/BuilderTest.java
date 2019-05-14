package com.krahman.effectivejava.createdestroyobject.builder;

import org.junit.Test;

public class BuilderTest {

    @Test
    public void should_build_bike(){
        Bike bike = new Bike.Builder("A")
                .Style(Bike.Style.COMMUTE)
                .Geared(true)
                .yearOfManufacturing(1990)
                .build();
    }
}
