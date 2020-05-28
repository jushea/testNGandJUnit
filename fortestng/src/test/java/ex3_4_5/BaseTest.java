package ex3_4_5;

import org.testng.annotations.*;

import java.io.File;


public class BaseTest {
    @BeforeGroups(groups = "positive")
    public void startUp() {
        System.out.println("Fixture will run for group");
        File path = null;

        path = new File("C:\\ISSart\\myFile");
        if(path.mkdir())
            System.out.println("Directory is created. " + path.getAbsolutePath());
        else
            System.out.println("Directory is not created.");

    }

    @AfterGroups(groups = "positive")
    public void tearDown() {
        File path = new File("C:\\ISSart\\myFile");
//        File file = new File("C:\\ISSart\\myFile\\program.txt");
        for (File myFile: new File(path.toString()).listFiles())
            if (myFile.isFile()) {
                myFile.delete();
                System.out.println("deleted " + myFile.toString());
            }
        if (path.list().length < 1)
            path.delete();
    }
}
