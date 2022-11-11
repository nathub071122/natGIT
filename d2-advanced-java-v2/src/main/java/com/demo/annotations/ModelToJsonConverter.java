package com.demo.annotations;

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
}
