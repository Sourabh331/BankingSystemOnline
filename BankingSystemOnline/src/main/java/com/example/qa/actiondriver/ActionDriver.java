package com.example.qa.actiondriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {
	
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", ele);

		 }
		 public void sleepThread(long time)
		 {
		  try {
		   Thread.sleep(time);
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  }
		 }

		 public void click(WebDriver driver, WebElement ele) {

		  Actions act = new Actions(driver);
		  act.moveToElement(ele).click().build().perform();

		 }
		 public boolean findElement(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  try {
		   ele.isDisplayed();
		   flag = true;
		  } catch (Exception e) {
		   // System.out.println("Location not found: "+locatorName);
		   flag = false;
		  } finally {
		   if (flag) {
		    System.out.println("Successfully Found element at");

		   } else {
		    System.out.println("Unable to locate element at");
		   }
		  }
		  return flag;
		 }

		 public boolean isDisplayed(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  flag = findElement(driver, ele);
		  if (flag) {
		   flag = ele.isDisplayed();
		   if (flag) {
		    System.out.println("The element is Displayed");
		   } else {
		    System.out.println("The element is not Displayed");
		   }
		  } else {
		   System.out.println("Not displayed ");
		  }
		  return flag;
		 }

		 public boolean isSelected(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  flag = findElement(driver, ele);
		  if (flag) {
		   flag = ele.isSelected();
		   if (flag) {
		    System.out.println("The element is Selected");
		   } else {
		    System.out.println("The element is not Selected");
		   }
		  } else {
		   System.out.println("Not selected ");
		  }
		  return flag;
		 }


		 public boolean isEnabled(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  flag = findElement(driver, ele);
		  if (flag) {
		   flag = ele.isEnabled();
		   if (flag) {
		    System.out.println("The element is Enabled");
		   } else {
		    System.out.println("The element is not Enabled");
		   }
		  } else {
		   System.out.println("Not Enabled ");
		  }
		  return flag;
		 }

		 /**
		  * Type text at location
		  * 
		  * @param locatorName
		  * @param text
		  * @return - true/false
		  */
		 public boolean type(WebElement ele, String text) {
		  boolean flag = false;
		  try {
		   flag = ele.isDisplayed();
		   ele.clear();
		   ele.sendKeys(text);
		   // logger.info("Entered text :"+text);
		   flag = true;
		  } catch (Exception e) {
		   System.out.println("Location Not found");
		   flag = false;
		  } finally {
		   if (flag) {
		    System.out.println("Successfully entered value");
		   } else {
		    System.out.println("Unable to enter value");
		   }

		  }
		  return flag;
		 }

		 public boolean selectBySendkeys(String value,WebElement ele) {
		  boolean flag = false;
		  try {
		   ele.sendKeys(value);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Select value from the DropDown");  
		   } else {
		    System.out.println("Not Selected value from the DropDown");
		    // throw new ElementNotFoundException("", "", "")
		   }
		  }
		 }

		 /**
		  * select value from DropDown by using selectByIndex
		  * 
		  * @param locator : Action to be performed on element (Get it from Object
		  * repository)
		  * 
		  * @param index : Index of value wish to select from dropdown list.
		  * 
		  * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
		  * Listbox etc..)
		  * 
		  */
		 public boolean selectByIndex(WebElement element, int index) {
		  boolean flag = false;
		  try {
		   Select s = new Select(element);
		   s.selectByIndex(index);
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Option selected by Index");
		   } else {
		    System.out.println("Option not selected by Index");
		   }
		  }
		 }

		 /**
		  * select value from DD by using value
		  * 
		  * @param locator : Action to be performed on element (Get it from Object
		  * repository)
		  * 
		  * @param value : Value wish to select from dropdown list.
		  * 
		  * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
		  * Listbox etc..)
		  */

		 public boolean selectByValue(WebElement element,String value) {
		  boolean flag = false;
		  try {
		   Select s = new Select(element);
		   s.selectByValue(value);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Option selected by Value");
		   } else {
		    System.out.println("Option not selected by Value");
		   }
		  }
		 }

		 /**
		  * select value from DropDown by using selectByVisibleText
		  * 
		  * @param locator : Action to be performed on element (Get it from Object
		  * repository)
		  * 
		  * @param visibletext : VisibleText wish to select from dropdown list.
		  * 
		  * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
		  * Listbox etc..)
		  */

		 public boolean selectByVisibleText(String visibletext, WebElement ele) {
		  boolean flag = false;
		  try {
		   Select s = new Select(ele);
		   s.selectByVisibleText(visibletext);
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Option selected by VisibleText");
		   } else {
		    System.out.println("Option not selected by VisibleText");
		   }
		  }
		 }

		 public boolean mouseHoverByJavaScript(WebDriver driver,WebElement ele) {
		  boolean flag = false;
		  try {
		   WebElement mo = ele;
		   String javaScript = "var evObj = document.createEvent('MouseEvents');"
		     + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
		     + "arguments[0].dispatchEvent(evObj);";
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript(javaScript, mo);
		   flag = true;
		   return true;
		  }

		  catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("MouseOver Action is performed");
		   } else {
		    System.out.println("MouseOver Action is not performed");
		   }
		  }
		 }

		 public boolean JSClick(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  try {
		   // WebElement element = driver.findElement(locator);
		   JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("arguments[0].click();", ele);
		   // driver.executeAsyncScript("arguments[0].click();", element);

		   flag = true;

		  }

		  catch (Exception e) {
		   e.printStackTrace();

		  } finally {
		   if (flag) {
		    System.out.println("Click Action is performed");
		   } else if (!flag) {
		    System.out.println("Click Action is not performed");
		   }
		  }
		  return flag;
		 }

		 public boolean switchToFrameByIndex(WebDriver driver,int index) {
		  boolean flag = false;
		  try {
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		   driver.switchTo().frame(index);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Frame with index \"" + index + "\" is selected");
		   } else {
		    System.out.println("Frame with index \"" + index + "\" is not selected");
		   }
		  }
		 }

		 /**
		  * This method switch the to frame using frame ID.
		  * 
		  * @param idValue : Frame ID wish to switch
		  * 
		  */
		 public boolean switchToFrameById(WebDriver driver,String idValue) {
		  boolean flag = false;
		  try {
		   driver.switchTo().frame(idValue);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   e.printStackTrace();
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Frame with Id \"" + idValue + "\" is selected");
		   } else {
		    System.out.println("Frame with Id \"" + idValue + "\" is not selected");
		   }
		  }
		 }

		 /**
		  * This method switch the to frame using frame Name.
		  * 
		  * @param nameValue : Frame Name wish to switch
		  * 
		  */
		 public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		  boolean flag = false;
		  try {
		   driver.switchTo().frame(nameValue);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Frame with Name \"" + nameValue + "\" is selected");
		   } else if (!flag) {
		    System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
		   }
		  }
		 }

		 public boolean switchToDefaultFrame(WebDriver driver) {
		  boolean flag = false;
		  try {
		   driver.switchTo().defaultContent();
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   e.printStackTrace();
		   return false;
		  } finally {
		   if (flag) {
		    // SuccessReport("SelectFrame ","Frame with Name is selected");
		   } else if (!flag) {
		    // failureReport("SelectFrame ","The Frame is not selected");
		   }
		  }
		 }

		 public void mouseOverElement(WebDriver driver,WebElement element) {
		  boolean flag = false;
		  try {
		   new Actions(driver).moveToElement(element).build().perform();
		   flag = true;
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   if (flag) {
		    System.out.println(" MouserOver Action is performed on ");
		   } else {
		    System.out.println("MouseOver action is not performed on");
		   }
		  }
		 }

		 public boolean moveToElement(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  try {
		   // WebElement element = driver.findElement(locator);
		   JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("arguments[0].scrollIntoView(true);", ele);
		   Actions actions = new Actions(driver);
		   // actions.moveToElement(driver.findElement(locator)).build().perform();
		   actions.moveToElement(ele).build().perform();
		   flag = true;
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return flag;
		 }

		 public boolean mouseover(WebDriver driver, WebElement ele) {
		  boolean flag = false;
		  try {
		   new Actions(driver).moveToElement(ele).build().perform();
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   return false;
		  } finally {
		   /*
		    * if (flag) {
		    * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
		    * +"\""); } else {
		    * failureReport("MouseOver","MouseOver action is not performed on \""
		    * +locatorName+"\""); }
		    */
		  }
		 }
		 public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		  boolean flag = false;
		  try {
		   new Actions(driver).dragAndDropBy(source, x, y).build().perform();
		   Thread.sleep(5000);
		   flag = true;
		   return true;

		  } catch (Exception e) {
		  
		   return false;
		   
		  } finally {
		   if (flag) {
		    System.out.println("Draggable Action is performed on \""+source+"\"");   
		   } else if(!flag) {
		    System.out.println("Draggable action is not performed on \""+source+"\"");
		   }
		  }
		 }
		 public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		  boolean flag = false;
		  try {
		   new Actions(driver).dragAndDrop(source, target).perform();
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("DragAndDrop Action is performed");
		   } else if(!flag) {
		    System.out.println("DragAndDrop Action is not performed");
		   }
		  }
		 }

		 public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		  boolean flag = false;
		  try {
		   // new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
		   // .perform();
		   new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
		   Thread.sleep(5000);
		   flag = true;
		   return true;
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Slider Action is performed");
		   } else {
		    System.out.println("Slider Action is not performed");
		   }
		  }
		 }
		 public boolean rightclick(WebDriver driver,WebElement ele) {
		  boolean flag = false;
		  try {
		   Actions clicker = new Actions(driver);
		   clicker.contextClick(ele).perform();
		   flag = true;
		   return true;
		   // driver.findElement(by1).sendKeys(Keys.DOWN);
		  } catch (Exception e) {

		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("RightClick Action is performed");
		   } else {
		    System.out.println("RightClick Action is not performed");
		   }
		  }
		 }
		 public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		  boolean flag = false;
		  try {
		   Set<String> windowList = driver.getWindowHandles();

		   String[] array = windowList.toArray(new String[0]);

		   driver.switchTo().window(array[count-1]);

		   if (driver.getTitle().contains(windowTitle)){
		    flag = true;
		   }else{
		    flag = false;
		   }
		   return flag;
		  } catch (Exception e) {
		   //flag = true;
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Navigated to the window with title");
		   } else {
		    System.out.println("The Window with title is not Selected");
		   }
		  }
		 }
		 public boolean switchToNewWindow(WebDriver driver) {
		  boolean flag = false;
		  try {

		   Set<String> s=driver.getWindowHandles();
		   Object popup[]=s.toArray();
		   driver.switchTo().window(popup[1].toString());
		   flag = true;
		   return flag;
		  } catch (Exception e) {
		   flag = false;
		   return flag;
		  } finally {
		   if (flag) {
		    System.out.println("Window is Navigated with title");    
		   } else {
		    System.out.println("The Window with title: is not Selected");
		   }
		  }
		 }

		 public boolean switchToOldWindow(WebDriver driver) {
		  boolean flag = false;
		  try {

		   Set<String> s=driver.getWindowHandles();
		   Object popup[]=s.toArray();
		   driver.switchTo().window(popup[0].toString());
		   flag = true;
		   return flag;
		  } catch (Exception e) {
		   flag = false;
		   return flag;
		  } finally {
		   if (flag) {
		    System.out.println("Focus navigated to the window with title");   
		   } else {
		    System.out.println("The Window with title: is not Selected");
		   }
		  }
		 }
		 public int getColumncount(WebElement row) {
		  List<WebElement> columns = row.findElements(By.tagName("td"));
		  int a = columns.size();
		  System.out.println(columns.size());
		  for (WebElement column : columns) {
		   System.out.print(column.getText());
		   System.out.print("|");
		  }
		  return a;
		 }
		 public int getRowCount(WebElement table) {
		  List<WebElement> rows = table.findElements(By.tagName("tr"));
		  int a = rows.size() - 1;
		  return a;
		 }

		 public boolean launchUrl(WebDriver driver,String url) {
		  boolean flag = false;
		  try {
		   driver.navigate().to(url);
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Successfully launched \""+url+"\"");    
		   } else {
		    System.out.println("Failed to launch \""+url+"\"");
		   }
		  }
		 }
		 public boolean isAlertPresent(WebDriver driver) 
		 { 
		  try 
		  { 
		   driver.switchTo().alert(); 
		   return true; 
		  } // try 
		  catch (NoAlertPresentException Ex) 
		  { 
		   return false; 
		  } // catch 
		 }
		 public String getTitle(WebDriver driver) {
		  boolean flag = false;

		  String text = driver.getTitle();
		  if (flag) {
		   System.out.println("Title of the page is: \""+text+"\"");
		  }
		  return text;
		 }
		 public String getCurrentURL(WebDriver driver) {
		  boolean flag = false;

		  String text = driver.getCurrentUrl();
		  if (flag) {
		   System.out.println("Current URL is: \""+text+"\"");
		  }
		  return text;
		 }
		 public boolean click1(WebElement locator, String locatorName) {
		  boolean flag = false;
		  try {
		   locator.click();
		   flag = true;
		   return true;
		  } catch (Exception e) {
		   return false;
		  } finally {
		   if (flag) {
		    System.out.println("Able to click on \""+locatorName+"\"");
		   } else {
		    System.out.println("Click Unable to click on \""+locatorName+"\"");
		   }
		  }

		 }
		 public void implicitWait(WebDriver driver, int timeOut) {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		 }
		 public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		  wait.until(ExpectedConditions.visibilityOf(element));
		 }
		 public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
		 }
		 public String getCurrentTime() {
		  String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		  return currentDate;
		 }

}
