import annotations.*;
import exceptions.AibAlikException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Albatrator {

    public static void validate(Object object) throws IllegalAccessException, AibAlikException{
        Class<?> c = object.getClass();

        List<Field> allFields = new ArrayList();

        allFields = getAllFields(c);

        for(Field field : allFields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Null.class)) {
                String value = (String) field.get(object);
                if(!field.getAnnotation(annotations.Null.class).value() && value==null){
                        throw new AibAlikException();
                }
            }

            if(field.isAnnotationPresent(Min.class)) {
                if(field.getType().equals(String.class)) {
                    String value = (String) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Min.class).value())>(value.length())){
                        throw new AibAlikException();
                    }
                }
                if(field.getType().equals(int.class)) {
                    field.setAccessible(true);
                    Integer value = (Integer) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Min.class).value())>(value)){
                        throw new AibAlikException();
                    }
                }
            }

            if(field.isAnnotationPresent(Max.class)){
                if(field.getType().equals(String.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Max.class).value())<(value.length())){
                        throw new AibAlikException();
                    }
                }
                if(field.getType().equals(int.class)) {
                    field.setAccessible(true);
                    Integer value = (Integer) field.get(object);
                    if(Integer.parseInt(field.getAnnotation(annotations.Max.class).value())<(value)){
                        throw new AibAlikException();
                    }
                }
            }
        }
    }

    private static List<Field> getAllFields(Class<?> c) {
        List<Field> list = new ArrayList<>();

        list.addAll(Arrays.asList(c.getDeclaredFields()));

        while (c.getSuperclass()!=null){
            Class<?> superClass = c.getDeclaringClass();
            list.addAll(Arrays.asList(superClass.getDeclaredFields()));
            c = c.getSuperclass();
        }
        return list;
    }

}
