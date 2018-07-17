package com.demo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.pages.BaseClass;
import com.demo.pages.HomePage;
import com.demo.pages.LoginPage;



public class TestLogin extends BaseClass {

    LoginPage objLogin;
    HomePage objHomePage;

    // Below Commented Code functionality Added in BaseClass with cross Browser functionality
    
    /*
    @BeforeTest
    public void setup(){
    	
    	System.setProperty("webdriver.gecko.driver","C:\\Selenuim\\geckodriver-v0.20.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
       Reporter.log("Browser Session Started with the specified URL",true);
    }

    */
    
    @Test(priority=0,description="Login Page Test")

    public void test_Home_Page_Appear_Correct(){

    //Create Login Page object
    objLogin = new LoginPage(driver);

    //Verify login page title
    String loginPageTitle = objLogin.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application
    objLogin.loginToGuru99("mgr123", "mgr!23");

    // go the next page
    objHomePage = new HomePage(driver);

    //Verify home page
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    
    // Code Added in BaseClass
    /*
    @AfterTest
    public void tearDown(){
    	
    	driver.quit();
    	Reporter.log("Browser Session Ended",true);
    }
    */
}