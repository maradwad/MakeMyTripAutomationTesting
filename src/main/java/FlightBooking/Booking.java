package FlightBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Booking {
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		
//		EdgeOptions option=new EdgeOptions();
//		option.addArguments("--remote-allow-origins=*");
//		driver=new EdgeDriver(option);
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		String file=System.getProperty("user.dir")+"\\config.properties";
		FileInputStream fi=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fi);

		//driver switch to iframe
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement frame=driver.findElement(By.xpath("//iframe[@id=\"webklipper-publisher-widget-container-notification-frame\"]"));
		driver.switchTo().frame(frame);
		WebElement closeframe=driver.findElement(By.xpath("//div[@id=\"webklipper-publisher-widget-container-notification-container\"]/a"));
		closeframe.click();
		driver.switchTo().defaultContent();
		
		//select city for the flight search
		WebElement fromlabel= driver.findElement(By.xpath("//div[@class=\"flt_fsw_inputBox searchCity inactiveWidget \"]/label"));
		fromlabel.click();
		WebElement fromCity=driver.findElement(By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input"));
		fromCity.sendKeys("Chennai");
		Thread.sleep(3000);
		List<WebElement> list1=driver.findElements(By.xpath("//p[@class=\"searchedResult font14 blackText appendBottom5\"]"));
		for(WebElement element:list1)
		{
			String city=element.getText();
			if(city.contains("Chennai"))
			{
				element.click();
				break;
			}
		}
		
		WebElement toLabel=driver.findElement(By.xpath("//div[@class=\"flt_fsw_inputBox searchToCity inactiveWidget \"]/label"));
		toLabel.click();
		WebElement toCity=driver.findElement(By.xpath("//div[@class=\"react-autosuggest__container react-autosuggest__container--open\"]/input"));
		toCity.sendKeys("Delhi");
		Thread.sleep(3000);
		List<WebElement> list2=driver.findElements(By.xpath("//p[@class='searchedResult font14 blackText appendBottom5']"));
		for(WebElement element:list2)
		{
			String city=element.getText();
			if(city.contains("Delhi"))
			{
				element.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		// Select the departure date	
		WebElement departre=driver.findElement(By.xpath("//input[@id=\"departure\"]"));
		Thread.sleep(3000);
		WebElement datepicker=driver.findElement(By.xpath("//div[@aria-label='"+getFridaydate()+"']"));
	
		datepicker.click();
		

		//Choose fare type
		WebElement fareType=driver.findElement(By.xpath("//div[@class=\"fareCardItem \"][2]"));
		fareType.click();
		
		//click on search button
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.xpath("//p[@class=\"makeFlex vrtlCenter \"]/a"));
		search.click();
		
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,200)");
		
		// Sort flights by cheapest first
		WebElement sort=driver.findElement(By.xpath("//span[@class=\" appendLeft10 up sort-arrow\"]"));
		sort.click();
		js.executeScript("window.scrollBy(0,200)");
		
		//Click on viewall to display all result
		WebElement viewAll=driver.findElement(By.xpath("//*[@id=\"flightCard-5000\"]/div/button"));
		
        // Get the details and cost of the second cheapest flight
		List<WebElement> flight=driver.findElements(By.xpath("//div[@class=\"group-list collapse show\"]"));
		flight.get(1).getText();
		
	}
	
	public static String getFridaydate()
	{
		Date date=new Date();
        LocalDate currentDate = LocalDate.now();
		int todayDay=date.getDay(); 
		int daydiff=5-todayDay;
		if(daydiff<=0)
		{
			daydiff+=7;
		}	
        currentDate=currentDate.plusDays(daydiff);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("E MMM dd yyyy");
        String selectDate=currentDate.format(formatter);
        //System.out.println(selectDate);
        return selectDate;
//        Calendar cal=new Calendar();
        
	}
}

