package sampleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class amazonTest {

    WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void getLinks(){

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        Set<String> finalUrls = new HashSet<>();
        for(WebElement link : allLinks){

            if(!link.getText().isEmpty()){
                finalUrls.add(link.getText());
            }
        }

        System.out.println("Total number of links = " + finalUrls.size());
        for(String link : finalUrls){
            if(link.startsWith("C") || link.startsWith("D"))
            System.out.println(link);
        }
    }

    @Test(description = "Using java8 methods")
    public void java8GetLinks(){

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        allLinks.stream()
                .map(s ->s.getText())
                .filter(s -> !s.isEmpty())
                .distinct()
                .sorted()
                .filter(s -> s.startsWith("C") || s.startsWith("D"))
                .forEach(System.out::println);

    }

    @AfterClass
    public void tearDown(){
        if(driver!=null)
        driver.quit();
    }
}
