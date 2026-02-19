package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="logindata")
	public String [][] getData() throws IOException
	{
		String path = ".\\Testdata\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcol=xlutil.getCellCount("sheet1", 1);
		
		String logindata[][] = new String [totalrows][totalcol];
		
		for(int i=1; i<=totalrows;i++)
		{
			for(int j=0; j<totalcol; j++)
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		
		return logindata;
	 }

}
