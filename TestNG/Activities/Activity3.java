package suiteExample;
import org.testng.annotations.Test;

public class DemoOne {
    @Test
    public void firstTestCase() {
        System.out.println("I'm in first test case from demoOne Class");
    }

    @Test
    public void secondTestCase() {
        System.out.println("I'm in second test case from demoOne Class");
    }
}

public class DemoTwo {
    @Test
    public void TestCase() {
        System.out.println("I'm in the test case from DemoTwo Class");
    }
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="ExampleSuite" >
    <test name="SuiteTests" >
        <classes>
            <class name="suiteExample.DemoOne"/>
            <class name="suiteExample.DemoTwo"/>
        </classes>
    </test>
</suite>