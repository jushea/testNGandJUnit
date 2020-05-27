package ex6;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Fixture will run for group");
        File path = null;

        path = new File("C:\\ISSart\\myFile");
        if(path.mkdir())
            System.out.println("Directory is created. " + path.getAbsolutePath());
        else
            System.out.println("Directory is not created.");
    }

    @AfterMethod
    public void tearDownMethod() {
        File path = new File("C:\\ISSart\\myFile");

        for (File myFile: new File(path.toString()).listFiles())
            if (myFile.isFile()) {
                myFile.delete();
                System.out.println("deleted " + myFile.toString());
            }
        if (path.list().length < 1)
            path.delete();
    }
}
