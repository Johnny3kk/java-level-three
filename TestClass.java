import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface BeforeSuite{

}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite{

}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test{
    int value() default 1;
}


public class TestClass {
    TestClass testClass;

    public TestClass(){

    }

    @BeforeSuite
    public void init(){
        testClass = new TestClass();
        System.out.println("BeforeSuite");
    }

    @Test(value=1)
    public void test1(){
        System.out.println("Test1");
    }

    @Test(value=2)
    public void test2(){
        System.out.println("Test2");
    }
    @Test(value=3)
    public void test(){
        System.out.println("Test3");
    }
    @AfterSuite
    public void end_init(){
        testClass = null;
        System.out.println("AfterSuite");
    }
}