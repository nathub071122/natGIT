package com.demo.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//PROCESS THE ANNOTATIONS
public class ModelToJsonConverter {
    private void checkIfSerializable(Object object) {
        if(Objects.isNull(object)) {
            throw new JsonSerializationException("Serializing null object.");
        }
        //REFLECT UPON THE OBJECT(ACTOR) AND FIND IF IT HAS METADATA ABOUT SERIALIZATION.
        //BY GETTING THE CLASS DURING RUNTIME TO CHECK IF IT HAS THE METADATA (JsonSerializable)
        Class<?> clazz = object.getClass();
        boolean serializable = clazz.isAnnotationPresent(JsonSerializable.class);
        if(!serializable) {
            throw new JsonSerializationException("Json Serialization not possible on " + clazz.getSimpleName() + " class. For serialization annotate the class with JsonSerializable");
        }
    }
    private void initializeModel(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        //REFLECT THE METHODS
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }
    private String getJsonString(Object object) {
        Class<?> clazz = object.getClass();
        Map<String,String> jsonElementMap = new HashMap<>();
        for(Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)){
               jsonElementMap.put("key","value");
            }
        }
        return null;
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class).key();
        if(value.isEmpty()) {
            return field.getName();
        }
        else
        {
            return value;
        }
    }
}
