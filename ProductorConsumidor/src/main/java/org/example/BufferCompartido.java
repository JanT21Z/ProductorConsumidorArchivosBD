package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BufferCompartido {

    private final BlockingQueue<String> queue;

    public BufferCompartido(int capacidad) {
        this.queue = new ArrayBlockingQueue<>(capacidad);
    }

    public void producir(String item) throws InterruptedException {
        queue.put(item);
        System.out.println("Elemento producido: " + item);
    }

    public String consumir() throws InterruptedException {
        String item = queue.take();
        System.out.println("Elemento consumido: " + item);
        return item;
    }
}
