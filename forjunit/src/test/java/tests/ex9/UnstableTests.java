package tests.ex9;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class UnstableTests {

    @Rule
    public RunTwiceRule runTwiceRule = new RunTwiceRule();

    @Rule
    public UnstableRule unstableRule = new UnstableRule(runTwiceRule);

    private static int attempt = 1;

    @Test
    @Unstable(3)
    public void unstableTest() {

        if (attempt == 3) {
            attempt = 1;
            System.out.println("True");
        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }

    @Test
    public void test2() {
        System.out.println("test2");
        Assert.assertEquals("test", 4, 2*2);
    }
}
