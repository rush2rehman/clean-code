package com.krahman.effectivejava.createdestroyobject.builder;

import java.util.EnumSet;
import java.util.Objects;

public abstract class Computer {

    protected String processor;
    protected String RAM;

    public static abstract class Builder<T extends Builder<T>>{
        private String processor;
        private String RAM;

        public Builder(String processor){

            this.processor = processor;
        }

        public T RAM(String val){
            this.RAM = val;
            return self();
        }


        protected abstract T self();

    }

    protected Computer(Builder<?> builder){
        this.processor = builder.processor;
        this.RAM = builder.RAM;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRAM() {
        return RAM;
    }
}

class GamingComputer extends Computer{

    private enum PORT{
        USB, AUDIO
    }
    private String grphicsCard;
    private EnumSet<PORT> ports;
    public static class Builder extends Computer.Builder<Builder>{

        private String graphicsCard;
        private EnumSet<PORT> ports = EnumSet.noneOf(PORT.class);

        public Builder graphicsCard(String graphicsCard){
            this.graphicsCard = graphicsCard;
            return self();
        }

        public Builder addPort(PORT port){
            ports.add(Objects.requireNonNull(port,"port cannot be null"));
            return self();
        }

        public Builder(String processor){
            super(processor);
        }

        @Override
        protected Builder self() {
            return this;
        }

        public GamingComputer build(){
            GamingComputer gamingComputer = new GamingComputer(this);
            return gamingComputer;
        }

    }

    public GamingComputer(Builder builder){
        super(builder);
        this.grphicsCard = builder.graphicsCard;
        this.ports = builder.ports;
    }

    @Override
    public String toString(){
        return this.processor+" "+this.RAM+" "+this.grphicsCard+" "+this.ports;
    }

    public static void main(String...s){
        GamingComputer gamingComputer = new GamingComputer.Builder("i7")
                .RAM("16GB").graphicsCard("NVD").addPort(PORT.AUDIO).addPort(PORT.USB).build();
        System.out.println(gamingComputer);
    }


}
