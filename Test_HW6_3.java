import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Test_HW6_3 {

    private static HW6_3 hw6_3 = null;
    private int[] x1;


    private boolean result_hw6_3;

    public Test_HW6_3(int[] x1, boolean result) {
        this.x1 = x1;
        this.result_hw6_3 = result;
    }


    @Parameterized.Parameters
    public static Collection test() {
        return Arrays.asList(new Object[][]{
                        {new int[]{ 1, 1, 1, 4, 4, 1, 4, 4}, true},
                        {new int[]{1, 1, 1, 1, 1, 1 }, false},
                        {new int[]{4, 4, 4, 4}, false},
                        {new int[]{1, 4, 4, 1, 1, 4, 3 }, false}
                }
        );
    }


    @Test
    public void arrayTest_HW6_3() {
        Assert.assertEquals(hw6_3.check_Array(x1), result_hw6_3);
    }
    @Before
    public void init() {
        System.out.println("init lesson6_3");
        hw6_3 = new HW6_3();
    }

    @After
    public void tearDown() throws Exception {
        hw6_3 = null;
    }
}
