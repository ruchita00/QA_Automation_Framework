package Reusable_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Generic_function {
	WebDriver driver=null;
	public static XSSFWorkbook workbook;
	public static XSSFWorkbook workbook1;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	public static int s=1;
	public static String Locator_value;
	File file = new File("configuration/config.properties");
	Properties prop = new Properties();

	/*Constructor*/
	public void Generic_function() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
	}

	/* Reading chrome driver path from config.properties file */
	public String getDriverPath() {
		String driverpath= prop.getProperty("Driverpath");
		if(driverpath!=null) return driverpath ;
		else throw new RuntimeException ("Driverpath is not specified in the Config.properties");
	}

	/* Reading URL from config.properties file */
	public String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}

	/* Reading Excel file path  from config.properties   */
	private String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	/* Reading test data from Test_Data.xlsx */
	public String td_reader(String sheetName, int iter) throws IOException {
		File src=new File(getFilepath());
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		for(int j=iter;j< iter+1;j++ ) {
			for(int k=s;k<colCount;k++) {
				cell = sheet.getRow(k).getCell(j);
				CellData = cell.getStringCellValue();
				s++;
				break;
			}
		}
		return CellData;
	}

	/*  Taking Screenshot of failed test cases  */
	public  void takeScreenShot(WebDriver driver,String fileName) throws IOException{
		driver.manage().window().maximize();
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
	}
	/*TO get directory path of screenshots*/
	public  String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}
	/*Object Locator of Excel sheet*/
	public  String OR_reader(String sheetname,String Fieldname) throws IOException  {
		File src=new File(getFilepath());
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		for(int i=1;i<rowCount;i++) {
			cell = sheet.getRow(i).getCell(0);
			CellData = cell.getStringCellValue();
			String string1 = CellData;
			String string2 = Fieldname;	 
			if(string1.equals(string2))
			{		 
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();	 
				break;
			}
			else if(string1.equals(string2))
			{
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();
				break;
			}
			else if(string1.equals(string2))
			{
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();
				break;
			}
			else if(string1.equals(string2))
			{
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();
				break;		 
			}
			else
			{
				continue;
			}
		}
		return path;
	}
	/*Generic Click function*/
	public void click(String objname, WebDriver driver) throws IOException {
		driver.findElement(By.xpath(OR_reader("Object Locator", objname))).click();

	}
}
