package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;//Kita Import Iterator, Linkedlist, No Exception, Queue

public class QueueA<E> {
    private Queue<E> antrian;
    public QueueA() {
        antrian = new LinkedList<E>();//Deklarasi kan LinkedList
    }
    public void enqueue(E object) {
        antrian.add(object);//Deklarasi untuk menginput list
    }
    public E dequeue() throws NoSuchElementException {
        return antrian.remove();//Deklarasikan untuk menghapus list
    }
    public boolean isEmpty() {
        return antrian.isEmpty();//Deklarasi Kondisi untuk list kosong
    }
    public void printQueue() {
        Iterator<E> iterator = antrian.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println(value + " ");//Deklarasikan keadaan untuk mencetak hasil
        }
    }
}

