package tests.ex9;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunTwiceRule implements TestRule {


    @Override
    public Statement apply(Statement base, Description desc) {
        return new RunTwiceStatement(base, desc);
    }

    public class RunTwiceStatement extends Statement {
        private final Statement base;
        private Description desc;

        public RunTwiceStatement(Statement base, Description desc) {
            this.base = base;
            this.desc = desc;
        }

        @Override
        public void evaluate() throws Throwable {
            Unstable count = desc.getAnnotation(Unstable.class);
            if (count != null) {
                int i = count.value();

                try {
                    System.out.println("1");
                    base.evaluate();
                } catch (Throwable t) {
                    try {
                        System.out.println("Failed on first attempt: " + desc);
                        base.evaluate();
                    } catch (Throwable t0) {
                        System.out.println("Failed on first attempt: " + desc);
                        base.evaluate();
                    }
                }
            }
        }
    }

}
