package com.demo;

import com.demo.annotations.Actor;
import com.demo.annotations.JsonSerializationException;
import com.demo.annotations.ModelToJsonConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModelToJsonConverterUnitTest {
    @Test
    public void givenModelNotSerialziableThenExceptionThrown() throws JsonSerializationException {
        Object object = new Object();
        ModelToJsonConverter modelToJsonConverter = new ModelToJsonConverter();
        assertThrows(JsonSerializationException.class,()->{
            modelToJsonConverter.convertToJson(object);
        });
    }
    @Test
    public void givenModelSerializedThenReturned() throws JsonSerializationException {
        Actor actor = new Actor("will", "smith","50");
        ModelToJsonConverter modelToJsonConverter = new ModelToJsonConverter();
        String jsonString = modelToJsonConverter.convertToJson(actor);
        assertEquals("{\"firstName\":\"Will\",\"lastName\":\"Smith\",\"moviesActed\":\"50\"}",jsonString);
    }
}
