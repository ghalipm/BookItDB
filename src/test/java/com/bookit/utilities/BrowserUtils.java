package com.bookit.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.bookit.utilities.WaitUtils.waitUntilClickable;

public class BrowserUtils {

    private static String parentWindow;

    public static void sleep(double seconds){
        try {
            Thread.sleep((long) (seconds * 1000));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement getElement(String xpath, String value){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(String.format(xpath,value))));
    }

    public static WebElement getElement(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xpath)));
    }

    public static List<WebElement> getElements(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public static void clickElement(WebElement element){
        waitUntilClickable(element).click();
    }

    public static void clickAndSend(String xpath,String value) {
        WebElement element = getElement(xpath);
        clickElement(element);
        BrowserUtils.sleep(0.5);
        element.sendKeys(value);
    }

    public static void clickElement(String xpath){
        waitUntilClickable(getElement(xpath)).click();
    }

    public static void clickElement(String xpath, String value){
        waitUntilClickable(getElement(xpath,value)).click();
    }

    public static String getChildWindowTitle() {
        switchToChildWindow();
        return Driver.get().getTitle();
    }

    public static String getChildWindowURL() {
        switchToChildWindow();
        return Driver.get().getCurrentUrl();
    }

    public static void scrollTo(String xpath,String value){
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);",
                getElement(xpath,value));
    }

    public static void scrollTo(String xpath){
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);",
                getElement(xpath));
    }

    public static void scrollTo(WebElement element){
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);",
                element);
    }

    public static void scrollAndClick(String xpath,String value){
        scrollTo(xpath,value);
        clickElement(xpath,value);
    }

    public static void setParentWindow(){
        parentWindow = Driver.get().getWindowHandle();
    }

    public static void switchToChildWindow(){
        setParentWindow();
        Set<String> windows = Driver.get().getWindowHandles();
        for (String each : windows){
            if (!each.equals(parentWindow)){
                Driver.get().switchTo().window(each);
            }
        }
    }

    public static void switchToParentWindow(){
        Driver.get().switchTo().window(parentWindow);
    }

    public static boolean elementDisplayed(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
    }

    public static boolean elementDisplayed(String xpath,String value){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(xpath,value)))).isDisplayed();
    }

    public static boolean elementSelected(String xpath){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isSelected();
    }

    public static boolean elementSelected(String xpath,String value){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        return wait.until(ExpectedConditions.elementToBeSelected(By.xpath(String.format(xpath,value))));
    }

    public static List<String> getTextOfElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        for (WebElement eachElement : elements) {
            texts.add(eachElement.getText().trim());
        }
        return texts;
    }

    public static void hoverOver(WebElement element) {
        Actions act = new Actions(Driver.get());
        act.moveToElement(element).perform();
    }

    public static void turnOnImplicitWait() {
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void turnOffImplicitWait() {
        Driver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
    }

    public static String getCurrentPageTitle() {
        return Driver.get().getTitle();
    }

    public static String getCurrentPageURL() {
        return Driver.get().getCurrentUrl();
    }

    public static void closeCurrentPage() {
        Driver.get().close();
    }

    public static void navigateBack() {
        Driver.get().navigate().back();
    }
}