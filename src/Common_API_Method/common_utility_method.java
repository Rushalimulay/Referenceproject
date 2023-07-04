package Common_API_Method;

import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class common_utility_method {

	public static void EvidenceCreator(String Filename, String RequestBody, String ResponseBody, int StatusCode)
			throws IOException {

		File NewTextFile = new File("C:\\Users\\shail\\Documents\\selenium\book1");
		System.out.println("New blank text file of name :" + NewTextFile.getName());

		FileWriter dataWrite = new FileWriter(NewTextFile);

		dataWrite.write("Request Body is : " + RequestBody + "\n\n");
		dataWrite.write("StatusCode is : " + StatusCode + "\n\n");
		dataWrite.write("Response Body is : " + ResponseBody);

		dataWrite.close();
		System.out.println("Request body and Response body written in textfile : " + NewTextFile.getName());
	}

	public static ArrayList<String> ReadDataExcel(String Sheetname, String TestCasename) throws IOException {
		ArrayList<String> ArrayData = new ArrayList<String>();
		// create the object of the file input Stream to locate the excel file
		FileInputStream Fis = new FileInputStream("C:\\Users\\shail\\Documents\\selenium\\book1.xlsx");
		// open the excel file by creating the object of XSSFWorkBook
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		// open the desire sheet
		int CountOfSheet = WorkBook.getNumberOfSheets();
		for (int i = 0; i < CountOfSheet; i++) {
			String SheetName = WorkBook.getSheetName(i);
			System.out.println(SheetName);
			// access the desired sheet
			if (SheetName.equalsIgnoreCase(Sheetname))
				
			{
				// use XSSFSheet to save the sheet in to variable
				XSSFSheet Sheet = WorkBook.getSheetAt(i);
				// create iterator to iterate throw rows and find out in which column the test
				// case name are found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();
				// create the iterator to iterate throw throw the cells of first row to find out
				// which cell contains testcase name
				Iterator<Cell> Cellsoffirstrow = FirstRow.cellIterator();
				int k = 0;
				int tc_column = 0;
				while (Cellsoffirstrow.hasNext()) {
					Cell cellvalue = Cellsoffirstrow.next();
					if (cellvalue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						tc_column = k;
						System.out.println("Expected column for testcase name : " + k);
						break;
					}
					k++;
				}
				// verify the row were the desired testCase is found and fetch the entire row
				while (Rows.hasNext()) {
					Row datarow = Rows.next();
					String TCname = datarow.getCell(tc_column).getStringCellValue();
					if (TCname.equalsIgnoreCase(TestCasename)) {
						Iterator<Cell> Cellvalues = datarow.cellIterator();
						while (Cellvalues.hasNext()) {
							String data = Cellvalues.next().getStringCellValue();
							ArrayData.add(data);
							
						}
						break;
						

					}

				}
			}

		}
		return ArrayData;
	}
}
