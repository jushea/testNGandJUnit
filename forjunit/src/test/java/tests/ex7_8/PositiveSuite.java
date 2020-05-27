package tests.ex7_8;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@Suite.SuiteClasses({CreateFileTest.class})
@RunWith(Categories.class)
@Categories.IncludeCategory(MyCategories.PositiveTests.class)
public class PositiveSuite {
}
