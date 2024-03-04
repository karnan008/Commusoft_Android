package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MainPack.BaseClassForWebAndMobile;
import New_ui_Testclass.Commusoft_WebAndMobile;

public class ExcelReader extends BaseClassForWebAndMobile{
	
	
	
	public ExcelReader(WebDriver sdriver) 
	{
		this.driverWeb=sdriver;
	}
	
	public void OfficeStaff() throws IOException 
	{
		
		String filePath = "./TestData/MobileDatasheet.xlsx";
        String sheetName = "Sheet1";

        
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            // Assuming your data starts from the second row (index 1)
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Row Count: "+rowCount);
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);

                // Check if the row is not null before accessing its cells
                if (row != null) {
                    // Assuming your data is in the first and second columns (index 0 and 1)
                	Cell urlCell = row.getCell(0);
                	Cell idCell = row.getCell(1);//0
                    Cell usernameCell = row.getCell(2);//1
                    Cell passwordCell = row.getCell(3);//2

                    if (urlCell != null && idCell != null && usernameCell != null && passwordCell != null) {
                    	
                    	String url = urlCell.getStringCellValue();
                    	int id = (int) idCell.getNumericCellValue();
                    	String idString = String.valueOf(id);
                    	String userName = usernameCell.getStringCellValue();
                    	String password = passwordCell.getStringCellValue();
                        System.out.println("url: "+url+" id: "+idString+" username: "+userName+ " paswword: "+password);
                        
                        
                        driverWeb.get(url);
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
                        WebElement UserID = driverWeb.findElement(By.xpath("//input[@id='logintype_clientid']"));
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
                        WebElement UserName = driverWeb.findElement(By.xpath("//input[@id='logintype_username']"));
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
                        WebElement UserPassword = driverWeb.findElement(By.xpath("//input[@id='logintype_password']"));
                        

                        // Enter the credentials and submit the form
                       
                        Webclick("//input[@id='logintype_clientid']");
                        UserID.sendKeys(idString);
                        
                        UserName.sendKeys(userName);
                        
                        UserPassword.sendKeys(password);
                        UserPassword.submit();
                        
                        break;

                    } else {
                        System.out.println("One or more cells in the row are null.");
                    }
                } else {
                    System.out.println("Row is null.");
                }
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
       
		
	}
	
		
	

	public void Owner() throws IOException 
	{
		String filePath = "./TestData/MobileDatasheet.xlsx";
        String sheetName = "Sheet1";

        
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            // Assuming your data starts from the second row (index 1)
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Row Count: "+rowCount);
            for (int i = 2; i < rowCount; i++) {
                Row row = sheet.getRow(i);

                // Check if the row is not null before accessing its cells
                if (row != null) {
                    // Assuming your data is in the first and second columns (index 0 and 1)
                	Cell urlCell = row.getCell(0);
                	Cell idCell = row.getCell(1);//0
                    Cell usernameCell = row.getCell(2);//1
                    Cell passwordCell = row.getCell(3);//2

                    if (urlCell != null && idCell != null && usernameCell != null && passwordCell != null) {
                    	
                    	String url = urlCell.getStringCellValue();
                    	int id = (int) idCell.getNumericCellValue();
                        String idString = String.valueOf(id);
                        String userName = usernameCell.getStringCellValue();
                        String password = passwordCell.getStringCellValue();
                        System.out.println("url: "+url+" id: "+idString+" username: "+userName+ " paswword: "+password);
                        
                        
                        driverWeb.get(url);
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_clientid']");
                        WebElement UserID = driverWeb.findElement(By.xpath("//input[@id='logintype_clientid']"));
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_username']");
                        WebElement UserName = driverWeb.findElement(By.xpath("//input[@id='logintype_username']"));
                        ExplicitWait_PresenceOfEle2("//input[@id='logintype_password']");
                        WebElement UserPassword = driverWeb.findElement(By.xpath("//input[@id='logintype_password']"));
                        

                        // Enter the credentials and submit the form
                        
                        Webclick("//input[@id='logintype_clientid']");
                        UserID.sendKeys(idString);
                        
                        UserName.sendKeys(userName);
                       
                        UserPassword.sendKeys(password);
                        UserPassword.submit();
                        
                        break;

                    } else {
                        System.out.println("One or more cells in the row are null.");
                    }
                } else {
                    System.out.println("Row is null.");
                }
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
