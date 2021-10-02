import exceptions.AibAlikException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AbatratorTest {

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, AibAlikException {
        Class personClass = Person.class;
        Constructor c = personClass.getDeclaredConstructor(String.class);
        c.setAccessible(true);

        Object person = c.newInstance("Nawras");


        Method setAgeMethod = personClass.getMethod("setAge", int.class);
        setAgeMethod.invoke(person, 3);

        Method setProfessionMethod = personClass.getMethod("setProfession", String.class);
        setProfessionMethod.invoke(person, "CEO");

        Albatrator.validate(person, new AibAlikException());

        Assertions.assertTrue(true);

    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, AibAlikException {
        Class personClass = Person.class;
        Constructor c = personClass.getDeclaredConstructor(String.class);
        c.setAccessible(true);

        Object person = c.newInstance((Object) null);


        Method setAgeMethod = personClass.getMethod("setAge", int.class);
        setAgeMethod.setAccessible(true);
        setAgeMethod.invoke(person, 3);

        Method setProfessionMethod = personClass.getMethod("setProfession", String.class);
        setProfessionMethod.setAccessible(true);

        setProfessionMethod.invoke(person, "CEO");

        Albatrator.validate(person, new AibAlikException());

        Assertions.assertTrue(true);

    }

    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, AibAlikException {
        Class personClass = Person.class;
        Constructor c = personClass.getDeclaredConstructor(String.class);
        c.setAccessible(true);

        Object person = c.newInstance("M'keissir");


        Method setAgeMethod = personClass.getMethod("setAge", int.class);
        setAgeMethod.setAccessible(true);
        setAgeMethod.invoke(person, 133);

        Method setProfessionMethod = personClass.getMethod("setProfession", String.class);
        setProfessionMethod.setAccessible(true);

        setProfessionMethod.invoke(person, "CEO");

        Albatrator.validate(person, new AibAlikException());

        Assertions.assertTrue(true);

    }

}
