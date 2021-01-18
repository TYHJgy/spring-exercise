package com.example.spring.exercise.thread;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTestThread {
    /*
     *创建线程
     * */
    @Test
    void CreateThread() throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread.start();
        myThread.join();
        myThread2.run();
    }

}

class MyThread extends Thread
{
    @SneakyThrows
    @Override
    public void run() {
        int ticket = 30;
        while(true){
            if(ticket>0){
                System.out.println(getName()+"当前售出第"+ticket+"张票");
                //sleep(10);
                ticket--;
            }else{
                break;
            }
        }
    }
}
