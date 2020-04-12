import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class HW7 {

    public static void main(String[] args) {
        try {
            start_test("TestClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void start_test(String class_name) throws ClassNotFoundException {
        Class testClass = Class.forName(class_name);
        testClass.getAnnotations();
        Method[] metods = testClass.getDeclaredMethods();
        Method[] sortArray=new Method[metods.length];
        for (Method method:metods) {
            Annotation[] annotation = method.getDeclaredAnnotations();
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (method.getAnnotations().length>1){
                    throw new RuntimeException();
                }
                sortArray[0] = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (method.getAnnotations().length>1){
                    throw new RuntimeException();
                }
                sortArray[metods.length-1] = method;
            } else if (method.getAnnotation(Test.class) != null) {
                sortArray[method.getAnnotation(Test.class).value()]=method;
            }
        }
        TestClass test  = new TestClass();

        for (Method m:sortArray ) {
            try {
                m.invoke(test);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}