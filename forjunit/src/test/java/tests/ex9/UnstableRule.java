package tests.ex9;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class UnstableRule extends TestWatcher {

    private int count;
    private RunTwiceRule runTwiceRule;

    public UnstableRule(RunTwiceRule runTwiceRule) {
        this.runTwiceRule = runTwiceRule;
    }

    protected void starting(Description description) {
        if (description.getAnnotation(Unstable.class) != null) {
            count = description.getAnnotation(Unstable.class).value();

        }
    }

}
