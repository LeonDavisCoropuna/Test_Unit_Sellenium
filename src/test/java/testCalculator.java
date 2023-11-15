import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

public class testCalculator {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://www.calculator.net/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
    }

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void tearDown() {

        driver.findElement(By.id("cpar1")).clear();
        driver.findElement(By.id("cpar2")).clear();
    }

    @Test
    public void test() {

        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("50");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        assertEquals("5", result);
    }

    @Test
    public void testError() {

        driver.findElement(By.id("cpar1")).sendKeys("20");
        driver.findElement(By.id("cpar2")).sendKeys("100");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        assertEquals("-2", result);
    }

    @Test
    public void test2() {

        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("100");

        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();

        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        assertEquals("10", result);
    }

    
}
