import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anton Korolev on 14.05.2018.
 */
public class SecondTest {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\AutoTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");


        WebElement elementYandexMarket = driver.findElement(By.xpath("//*[@id=\"wd-_services\"]/div/ul/li[1]/a[1]"));
        elementYandexMarket.click();

        WebElement elementElectronics = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/noindex/ul/li[1]/a"));
        elementElectronics.click();

        WebElement elementheadphones = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div[2]/div/a[1]"));
        elementheadphones.click();

        driver.findElement(By.xpath("//*[@id='glpricefrom']")).sendKeys("5000");

        WebElement elementBeats = driver.findElement(By.xpath("//*[@id='search-prepack']/div/div/div[2]/div/div[1]/div[4]/fieldset/ul/li[3]/div/a/label/div/span"));
        elementBeats.click();

        WebElement bottomOne = driver.findElement((By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button")));
        bottomOne.click();
        driver.findElement((By.xpath("//span[.='Показывать по 12']"))).click();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        WebDriverWait wait  = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[49]/div[3]/div[2]/a")));

        String currentname = driver.findElement((By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[3]/div[2]/a"))).getText();

        driver.findElement(By.xpath("//*[@id='header-search']")).sendKeys(currentname);

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/noindex/div/div/div[2]/div/div[1]/form/span/span[2]/button")).click();

        String resultname =driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[3]/div[2]/a")).getText();

        if(!currentname.equals(resultname)) {
            throw new Exception("Проверка не пройдена");
        }

        driver.quit();
    }
}
