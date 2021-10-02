import com.sun.istack.internal.NotNull;
import exceptions.AibAlikException;

import annotations.*;
import java.lang.reflect.Field;

public class Albatrator {

    public static void validate(Object object, AibAlikException e) throws IllegalAccessException, AibAlikException {
        Class<?> c = object.getClass();

        for(Field field : c.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Null.class)) {
                String value = (String) field.get(object);
                if(!field.getAnnotation(annotations.Null.class).value() && value==null){
                    throw e;
                }
            }

            if(field.isAnnotationPresent(Min.class)) {
                if(field.getType().equals(String.class)) {
                    String value = (String) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Min.class).value())>(value.length())){
                        throw e;
                    }
                }
                if(field.getType().equals(int.class)) {
                    field.setAccessible(true);
                    Integer value = (Integer) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Min.class).value())>(value)){
                        throw e;
                    }
                }
            }

            if(field.isAnnotationPresent(Max.class)){
                if(field.getType().equals(String.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Max.class).value())<(value.length())){
                        throw e;
                    }
                }
                if(field.getType().equals(int.class)) {
                    field.setAccessible(true);
                    Integer value = (Integer) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Max.class).value())<(value)){
                        throw e;
                    }
                }
            }
        }
    }
}
