
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Test_HW6_2 {
    private static HW6_2 hw6_2 = null;
    private int[] x1;
    private int[] result_hw6_2;

    public Test_HW6_2(int[] x1, int[] result) {
        this.x1 = x1;
        this.result_hw6_2 = result;
    }

    @Parameterized.Parameters
    public static Collection test() {
        return Arrays.asList(new Object[][]{
                        {new int[]{10,15,5,4,8,6}, new int []{8,0}},
                        {new int[]{3,4,8,4,2,5}, new int []{2,5}},
                        {new int[]{3,6,4,4,2,5}, new int []{2,5}},
                        {new int[]{10,4,14,15,5,6,8}, new int []{14,15,5,6,8}}
                }
        );
    }


    @Test
    public void arrayTest_HW6_2() {
        Assert.assertArrayEquals(hw6_2.check_Array(x1), result_hw6_2);
    }

    @Before
    public void init() {
        System.out.println("init lesson6_2");
        hw6_2 = new HW6_2();
    }

    @After
    public void tearDown() throws Exception {
        hw6_2 = null;
    }
}

