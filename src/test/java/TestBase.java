import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase implements AppManager {

    @BeforeSuite
    public void setup(){
        init();
    }

    @AfterSuite(alwaysRun = true)
    public void stop(){
        tearDown();
    }
}
