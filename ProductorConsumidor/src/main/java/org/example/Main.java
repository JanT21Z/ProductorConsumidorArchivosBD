package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        BufferCompartido buffer = new BufferCompartido(10);


        Thread productor1 = new Thread(new Productor(buffer, "input1.txt", "Productor 1"));
        Thread productor2 = new Thread(new Productor(buffer, "input2.txt", "Productor 2"));
        Thread productor3 = new Thread(new Productor(buffer, "input3.txt", "Productor 3"));


        productor1.start();
        productor2.start();
        productor3.start();

        Thread consumidor1 = null;
        Thread consumidor2 = null;

        try{
            consumidor1 =new Thread(new Consumidor(buffer, "Consumidor 1"));
            consumidor2 =new Thread(new Consumidor(buffer, "Consumidor 2"));

        }catch (IOException e){
            e.printStackTrace();
        }

        if (consumidor1 != null){
            consumidor1.start();
        }
        if (consumidor2 != null){
            consumidor2.start();
        }

        try {
            productor1.join();
            productor2.join();
            productor3.join();

            if (consumidor1 != null){
                consumidor1.join();
            }
            if (consumidor2 != null){
                consumidor2.join();
            }

        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
}

