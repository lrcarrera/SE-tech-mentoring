package org.jsqldb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                // class DB 
                // class Query - composition pattern
                System.out.println(line); // parse use tokenizer pattern
            }
        } catch (IOException e) {
            System.out.println("IOException reading System.in");
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }

        System.out.println(new App().getGreeting());
    }
}
