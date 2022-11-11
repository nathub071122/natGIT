package com.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
// CREATING A CLASS LEVEL ANNOATION
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Target(TYPE)
//delcare an annotation with @interface
public @interface JsonSerializable {
}
