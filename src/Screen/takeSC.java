package Screen;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class takeSC {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver","C:\\edge driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();
		List <WebElement> myliststudents = driver.findElements(By.tagName("option"));
	 
		for(int i = 1 ; i <myliststudents.size();i++) {
			 if (i%2 == 1 )	 
			 {
			myliststudents.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
	
		}
		
		}
		
		driver.findElement(By.xpath("//*[@id=\"selectNow\"]")).click();
		Thread.sleep(1000);
		
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:/HWQA/+screenshot+.png") ;
			FileUtils.copyFile(SrcFile,  DestFile);
	
		}
		
		
	}
