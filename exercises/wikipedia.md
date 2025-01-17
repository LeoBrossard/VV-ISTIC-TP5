# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

```
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
```
