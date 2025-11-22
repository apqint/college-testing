package org.example;

import org.testing.Assert;
import org.testing.annotations.AfterClass;
import org.testing.annotations.BeforeClass;
import org.testing.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testing.Driver; 
import pom.FormPom;  



public class AppTest {

    WebDriver driver;

    static public String URL = "https://demoqa.com/automation-practice-form";
    static public String USER_NAME = "Pinzari";
    static public String USER_SURNAME = "Adrian";
    static public String USER_EMAIL = "adrian.pinzari06@gmail.com";
    static public String USER_GENDER = "Male";
    static public String USER_DOB = "14 December, 2006";
    static public String USER_NUMBER = "070111111";
    static public String USER_SUBJECT = "Maths";
    static public String USER_HOBBY = "Sports";
    static public String USER_ADDRESS = "Stefan cel Mare 1";
    static public String USER_STATE = "NCR";
    static public String USER_CITY = "Noida";

    @BeforeClass
    public void setUp() {
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillFormTest() throws InterruptedException {
        driver.get(URL);

        // data for the form

        FormPom form = new FormPom(driver);
        form.setFirstName(USER_NAME);
        form.setLastName(USER_SURNAME);
        form.closeAdvert();
        form.setUserEmail(USER_EMAIL);
        form.scrollToFirstName();
        form.setUserGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.scrollToDOB();
        form.setUserDOB(USER_DOB);
        form.setUserSubject(USER_SUBJECT);
        form.setUserHobby(USER_HOBBY);
        form.setUserAddress(USER_ADDRESS);
        form.setUserState(USER_STATE);
        form.setUserCity(USER_CITY);
        form.clickSubmit();

        // compare

        Thread.sleep(1000);

        String fullName = driver.findElement(By.xpath("//tbody//tr[1]/*[2]")).getText();
        Assert.assertEquals(fullName, (USER_NAME + " " + USER_SURNAME));

        String email = driver.findElement(By.xpath("//tbody//tr[2]/*[2]")).getText();
        Assert.assertEquals(email, USER_EMAIL);

        String gender = driver.findElement(By.xpath("//tbody//tr[3]/*[2]")).getText();
        Assert.assertEquals(gender, USER_GENDER);

        String number = driver.findElement(By.xpath("//tbody//tr[4]/*[2]")).getText();
        Assert.assertEquals(number, USER_NUMBER);

        String dateOfBirth = driver.findElement(By.xpath("//tbody//tr[5]/*[2]")).getText();
        Assert.assertEquals(dateOfBirth, USER_DOB);

        String subject = driver.findElement(By.xpath("//tbody//tr[6]/*[2]")).getText();
        Assert.assertEquals(subject, USER_SUBJECT);

        String hobby = driver.findElement(By.xpath("//tbody//tr[7]/*[2]")).getText();
        Assert.assertEquals(hobby, USER_HOBBY);

        String address = driver.findElement(By.xpath("//tbody//tr[9]/*[2]")).getText();
        Assert.assertEquals(address, USER_ADDRESS);

        String stateCity = driver.findElement(By.xpath("//tbody//tr[10]/*[2]")).getText();
        Assert.assertEquals(stateCity, USER_STATE + " " + USER_CITY);

        System.out.println();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}