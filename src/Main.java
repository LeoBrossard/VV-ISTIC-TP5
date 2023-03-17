package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        WebDriver browser;
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

        browser = new FirefoxDriver(firefoxOptions);

        browser.get("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal");

        for(int i = 0; i < 10; i++){
            wikipedia_random_link(browser);
        }

    }


    public static void wikipedia_random_link(WebDriver browser) {

        WebElement element = browser.findElement(By.id("mw-content-text"));
        List<WebElement> elements = element.findElements(By.tagName("a"));

        int random = new Random().nextInt(0, elements.size());
        WebElement memory = null;
        for (WebElement link: elements) {
            if(link.getAttribute("href") != null) {
                if (link.getAttribute("href").contains("/wiki") && !link.getAttribute("href").toLowerCase().contains("accueil")) {
                    if (link.isDisplayed() && random == 0) {
                        memory = link;
                    } else {
                        random--;
                    }
                }
            }
        }
        if(memory != null){
            memory.click();
        }
    }


}
