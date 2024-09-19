package com.example.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver = null;
	public static Properties prop;
	public static String properties_path = "C:\\Users\\mahul\\OneDrive\\Desktop\\Practice selenium\\BankingSystemOnline\\src\\main\\java\\com\\example\\qa\\configuration\\configu.properties";
	public static FileInputStream fis;

	public Base() {
		try {
			fis = new FileInputStream(properties_path);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException f) {
			System.out.println("Please check your file locattion");
		} catch (IOException i) {
			System.out.println("Please check the permission for read the file");
		}
	}

	public void setUp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("please check your browser name and check again");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}
}
