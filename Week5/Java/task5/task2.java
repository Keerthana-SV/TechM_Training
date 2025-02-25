package org.example.assignment.corejava.Task5;

public class task2 {
    public static void main(String[] args){
        OddThread ot=new OddThread();
        EvenThread et=new EvenThread();

        ot.run();
        et.run();
    }
}
class OddThread extends Thread{
    public void run(){
        for(int i=0;i<20;i++){
            if(i%2!=0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
class EvenThread extends Thread{
    public void run(){
        for(int i=0;i<=20;i++){
            if(i%2==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
