package com.bookit.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitUtils {

    public static WebElement waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickable(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean waitUntilTextToBe(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        return wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public static void waitUntilUrlToBe(String url) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitUntilURLContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.urlContains(title));
    }

    public static void waitUntilTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUntilTitleIs(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilVisibilityOfAllElements(List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean waitUntilTextToBePresent(WebElement element,String text) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        return wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
}
