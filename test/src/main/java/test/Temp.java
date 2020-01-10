package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Temp {
    public static void main(String[] args) {
    }
}

class FooBar {
    private int n;
    public AtomicReference<String> previous = new AtomicReference<>();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(true){

                String previousString = previous.get();
                if("bar".equals(previousString) || previousString == null) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    previous.set("foo");
                    break;
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while(true){

                if("foo".equals(previous.get())) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    previous.set("bar");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new AtomicReference<String>().get());
    }
}