import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\vikas pal\\OneDrive\\Documents\\GitHub\\Test_Automation\\Test_Automation_v1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Stan Smith");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        System.out.println("Searching Shoes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Scroll to the Element
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'unisex adult Stan Smith Sneaker, White/White/Silver Metallic, 7 Big Kid US')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        element.click();
        System.out.println("Selecting the Shoes");

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());
//        //switch to parent window
//        driver.switchTo().window(newTb.get(0));
//        System.out.println("Page title of parent window: " + driver.getTitle());


//        driver.findElement(By.xpath("//a[contains(text(),' See All Buying Options ')]")).click();
//        System.out.println("Clicking on all buying option button");

//        List<WebElement> addtoCartButton = driver.findElements(By.xpath("//input[@name=\"submit.addToCart\"]"));
//        if (addtoCartButton.size() == 1) {
//            System.out.println("Add to cart button is not found");
//        } else{
//                driver.findElement(By.xpath("//input[@name=\"submit.addToCart\"]")).click();
//                  System.out.println("Adding it to cart");
//                driver.findElement(By.xpath("//span[contains(text(),' View Cart ')]")).click();
//                  System.out.println("Going in the Cart");
//            }


// do whatever you want in the new tab and if you want to switch back then:
//            driver.switchTo().window(parent);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("add-to-cart-button")).click();
        System.out.println("Adding it to cart");
        driver.findElement(By.xpath("(//a[contains(.,'Go to Cart')])[2]"));
        System.out.println("Going in the Cart");
        Thread.sleep(5000);
        Select quantity = new Select(driver.findElement(By.xpath("//select[@data-a-touch-header=\"Quantity\"]")));
        quantity.selectByVisibleText("2");
        System.out.println("Selecting the Quantity");
        System.out.println("Test Passed");

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//       switch to parent window
        driver.switchTo().window(newTb.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dress");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        System.out.println("Searching Dress");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Scroll to the Element
        driver.findElement(By.xpath("//span[contains(.,'Puff Sleeve V Neck Bodycon Casual Midi Dress')]/parent::a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Selecting the Dress");

        //the below code is not working I need to check why
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        System.out.println("Adding it to cart");
        driver.findElement(By.xpath("//span[contains(.,'Cart')]//parent::div/parent::a")).click();
        System.out.println("Going inside the Cart");
        driver.quit();




        //Completing the project here and Will be doing the next project Test_Automation_v2




    }
}