package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {

WebDriver wd = new ChromeDriver();


@BeforeSuite
default void init(){
    wd.manage().window().maximize();
    wd.get("https://demoqa.com/");
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

}

    @AfterSuite
    default void tearDown(){
//        wd.quit();
    }

}
