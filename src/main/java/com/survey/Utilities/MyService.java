package com.survey.Utilities;

public class MyService {

    private static MyService instance;

    private MyService(){};

    public static MyService getInstance(){
        if(instance==null)
        {
            instance = new MyService();
        }
        return instance;
    }

    public void flush(int value){System.out.println("Flushed with value: "+value);}
}
