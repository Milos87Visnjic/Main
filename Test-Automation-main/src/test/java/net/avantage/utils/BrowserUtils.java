package net.avantage.utils;

import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * Performs a pause
     * <p>
     * param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     * <p>
     * param element
     * param timeToWaitInSec
     * return
     */
    public static void waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * <p>
     * param element
     * param timeout
     * return
     */
    public static void waitForClickablility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param seconds
     */
    public static void waitForPageToLoad(int seconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element is displayed on page
     * <p>
     * param element
     * throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }


    /**
     * Clicks on an element using JavaScript
     * <p>
     * param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     * <p>
     * param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     * <p>
     * param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).build().perform();
    }

    /**
     * This methods enables to check if the list is ascending order.
     * @param listOfElements
     */
    public static void checkTheListInAscendingOrder(List<WebElement> listOfElements) {
        List<String> rankinList = BrowserUtils.getElementsText(listOfElements);
        boolean isSorted = Ordering.natural().isOrdered(rankinList);
        try {
            if (isSorted) {
                Assert.assertTrue(true);
                System.out.println("The list is in ascending order");
                System.out.println(rankinList);
            }else {
                System.out.println("the list is NOT in ascending order");
                System.out.println(rankinList);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * return a list of string from a list of elements
     * <p>
     * param list of webelements
     * return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.get().getWindowHandle();
        for (String handle : Driver.get().getWindowHandles()) {
            Driver.get().switchTo().window(handle);
            if (Driver.get().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.get().switchTo().window(origin);
    }
    /**
     * Waits for provided element of list to be clickable
     * @param elements
     * @param seconds
     */
    public static void waitForClickablilityListOfElements(List<WebElement> elements, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(elements.get(1)));
    }

}