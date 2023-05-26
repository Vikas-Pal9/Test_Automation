import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\vikas pal\\OneDrive\\Documents\\GitHub\\Test_Automation\\Test_Automation_v1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Stan Smith");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        System.out.println("Searching Shoes");
        driver.findElement(By.xpath("//span[contains(text(),'Stan Smith (End Plastic Waste) Sneaker, Black/Black/White, 4')]")).click();
        System.out.println("Selecting the Shoes");

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        System.out.println("Page title of new tab: " + driver.getTitle());
//        //switch to parent window
//        driver.switchTo().window(newTb.get(0));
//        System.out.println("Page title of parent window: " + driver.getTitle());


        driver.findElement(By.xpath("//a[contains(text(),' See All Buying Options ')]")).click();
        System.out.println("Clicking on all buying option button");


        driver.findElement(By.xpath("//input[@name=\"submit.addToCart\"]")).click();
        System.out.println("Adding it to cart");
        driver.findElement(By.xpath("//span[contains(text(),' View Cart ')]")).click();
        System.out.println("Going in the Cart");
        Select quantity = new Select(driver.findElement(By.xpath("//select[@name=\"quantity\"]")));
        quantity.selectByVisibleText("2");
        System.out.println("Selecting the Quantity");




    }
}