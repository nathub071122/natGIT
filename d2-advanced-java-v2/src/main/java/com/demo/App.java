package com.demo;

import com.demo.annotations.Actor;
import com.demo.annotations.ModelToJsonConverter;

public class App 
{
    public static void main( String[] args )
    {
        Actor actor = new Actor("will", "smith","50");
        ModelToJsonConverter modelToJsonConverter = new ModelToJsonConverter();
        System.out.println(actor);
        String jsonString = modelToJsonConverter.convertToJson(actor);
        System.out.println(jsonString);
    }
}
