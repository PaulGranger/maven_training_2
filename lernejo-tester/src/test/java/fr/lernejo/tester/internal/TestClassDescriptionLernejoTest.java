package test.java.fr.lernejo.tester.internal;

import main.java.fr.lernejo.tester.api.TestMethod;
import main.java.fr.lernejo.tester.internal.TestClassDescription;
import test.java.fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestClassDescriptionLernejoTest {

    @TestMethod
    public void test() {
        TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);

        List<Method> methodList = testClassDescription.listTestMethods();

        Set<String> methodsNames = methodList.stream().map(m -> m.getName()).collect(Collectors.toSet());
        if (!methodsNames.equals(Set.of("ok", "ko")))
        {
            throw new IllegalStateException("Not In List");
        }
    }

    public static void main(SomeLernejoTests someLernejoTests) {

    }
}
