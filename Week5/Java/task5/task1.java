package org.example.assignment.corejava.Task5;

public class task1  extends Thread{
    public void run() {
        System.out.println("Hello Java!");
        //System.out.println(10/0);
    }
}
class test{
    public static void main(String[] args){
        task1 t1=new task1();
        t1.run();
    }
}
