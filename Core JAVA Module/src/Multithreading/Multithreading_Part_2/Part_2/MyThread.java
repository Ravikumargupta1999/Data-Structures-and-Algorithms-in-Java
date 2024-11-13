package Multithreading.Multithreading_Part_2.Part_2;

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.println("Child Thread");
    }
}

class ThreadDemo {
    public static void main(String[] args) {
        MyThread obj = new MyThread();
        obj.start();
        for (int i = 0; i < 10; i++)
            System.out.println("Main Thread");
    }
}