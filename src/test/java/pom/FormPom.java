package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPom {

    WebDriver driver;
    JavascriptExecutor js;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//*[@id='dateOfBirthInput']")
    WebElement DOB;

    @FindBy(xpath = "//*[@id='userNumber']")
    WebElement number;

    @FindBy(xpath = "//*[@id='subjectsInput']")
    WebElement subject;

    @FindBy(xpath = "//*[@id='state']")
    WebElement state;

    @FindBy(xpath = "//*[@id='city']")
    WebElement city;

    @FindBy(xpath = "//*[@id='currentAddress']")
    WebElement currentAddress;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement submit;

    public FormPom(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstNameParam) {
        firstName.clear();
        firstName.sendKeys(firstNameParam);
    }

    public void setLastName(String lastNameParam) {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }

    public void setUserEmail(String userEmailParam) {
        email.clear();
        email.sendKeys(userEmailParam);
    }

    public void setUserGender(String genderParam) {
        WebElement gender = driver.findElement(By.xpath("//*[text()='" + genderParam + "']"));
        gender.click();
    }

    public void setUserNumber(String numberParam) {
        number.clear();
        number.sendKeys(numberParam);
    }

    public void setUserDOB(String userDOBParam) {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            DOB.sendKeys(Keys.COMMAND, "a");
        } else {
            DOB.sendKeys(Keys.CONTROL, "a");
        }
        DOB.sendKeys(userDOBParam);
        DOB.sendKeys(Keys.ENTER);
    }

    public void setUserHobby(String hobbyParam) {
        WebElement hobby = driver.findElement(By.xpath("//*[text() ='" + hobbyParam + "']"));
        hobby.click();
    }

    public void setUserSubject(String userSubjectParam) throws InterruptedException {
        subject.sendKeys(userSubjectParam);
        Thread.sleep(500);
        subject.sendKeys(Keys.ENTER);
    }

    public void setUserState(String StateParam) {
        state.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement stateItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='" + StateParam + "']")));
        stateItem.click();
    }

    public void setUserCity(String CityParam) {
        city.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cityItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='" + CityParam + "']")));
        cityItem.click();
    }

    public void setUserAddress(String AddressParam) {
        currentAddress.clear();
        currentAddress.sendKeys(AddressParam);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void closeAdvert() {
        try {
            js.executeScript("var elem = document.evaluate(\"//*[@id='adplus-anchor']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {
        }
        try {
            js.executeScript("var elem = document.evaluate(\"//footer\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                    "elem.parentNode.removeChild(elem);");
        } catch (Exception ignored) {
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToDOB() {
        scrollToElement(DOB);
    }

    public void scrollToFirstName() {
        scrollToElement(firstName);
    }
}