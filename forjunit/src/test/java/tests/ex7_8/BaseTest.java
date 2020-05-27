package tests.ex7_8;

import org.junit.Rule;
import org.junit.rules.ExternalResource;

import java.io.File;

public class BaseTest {

    @Rule
    public ExternalResource driverRule = new ExternalResource(){
        @Override
        protected void before() {
            System.out.println("Before");
            File path = null;

            path = new File("C:\\ISSart\\myFile");
            if(path.mkdir())
                System.out.println("Directory is created. " + path.getAbsolutePath());
            else
                System.out.println("Directory is not created.");
        };

        @Override
        protected void after() {
            System.out.println("After");
            File path = new File("C:\\ISSart\\myFile");
            for (File myFile: new File(path.toString()).listFiles())
                if (myFile.isFile()) {
                    myFile.delete();
                    System.out.println("deleted " + myFile.toString());
                }
            if (path.list().length < 1)
                path.delete();
        };
    };
}
