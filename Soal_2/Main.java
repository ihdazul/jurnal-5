package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        QueueA<String> queue = new QueueA<>();//Dengan elemen String
        Scanner in = new Scanner(System.in);
        int opsi = 0;
        while(opsi != 4){
            System.out.println("1. Masukkan Data");//Menu
            System.out.println("2. Menghapus Data");
            System.out.println("3. Print list");
            System.out.println("4. Keluar");
            opsi = in.nextInt();
            if(opsi == 1){
                System.out.println("Silahkan Masukkan Data");
                String toDo = in.next();
                queue.enqueue(toDo);//Menggunakan metode FIFO(First In First Out)
                System.out.println();
            }
            else if(opsi == 2){
                queue.dequeue();
                System.out.println("Berhasil Menghapus Tugas Pertama");
                System.out.println();
            }
            else if(opsi == 3){
                queue.printQueue();
                System.out.println();//Print List
            }
        }
    }
}

