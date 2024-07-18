package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] selectAllData() throws IOException{
		String path=System.getProperty("user.dir")+"/testData/UserDetails.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		int rowNum=excel.getRowCount("Sheet1");
		int columnNum=excel.getCellCount("Sheet1", 1);
		String[][] res=new String[rowNum][columnNum];
		System.out.println("Rows"+rowNum);
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<columnNum;j++) {
				res[i-1][j]=excel.getCellData("Sheet1", i, j);
			}
		}
		return res;
		
	}
	
	@DataProvider(name="usernames")
	public String[] selectUserName() throws IOException {
		String path=System.getProperty("user.dir")+"/testData/UserDetails.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		int rowNum=excel.getRowCount("Sheet1");
		System.out.println("Row count"+rowNum);
//		int columnNum=excel.getCellCount("Sheet1", 1);
		String[] res=new String[rowNum];
//		System.out.println(excel.getCellData("Sheet1", 0, 2));
		for(int i=1;i<=rowNum;i++) {
				res[i-1]=excel.getCellData("Sheet1", i, 2);
		}
		return res;
	}
}
