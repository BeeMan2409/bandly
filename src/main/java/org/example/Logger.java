package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Logger {
    ArrayList<String> logs = new ArrayList<>();

    public Logger(){}

    void log(String mes){
        System.out.println(mes);
        logs.add(mes);
    }
}
