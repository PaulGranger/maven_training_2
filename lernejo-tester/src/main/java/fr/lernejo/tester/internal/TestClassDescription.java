package main.java.fr.lernejo.tester.internal;

import main.java.fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClassDescription {
    private final Class<?> myClass;

    public TestClassDescription(Class<?> myClass) {
        this.myClass = myClass;
    }

    public List<Method> listTestMethods() {
        return Arrays.stream(myClass.getDeclaredMethods())
        .filter(m -> Modifier.isPublic(m.getModifiers()))
        .filter(m -> m.getReturnType().equals(Void.TYPE))
        .filter(m -> m.getParameterCount() == 0)
        .filter(m -> m.isAnnotationPresent(TestMethod.class))
        .collect(Collectors.toList());
    }
}
