package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadOperation1 {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Prathyusha P\\Desktop\\PrathyushaSeleinum\\WebApplicationTesting\\src\\com\\ExcelTestDataFiles\\TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		// reading a Row of a Cell Value
		/*Row r=sheet.getRow(0);
		Cell c=r.getCell(0);
		
		String data=c.getStringCellValue();
		System.out.println(data);*/
		
		/*for(int i=0;i<3;i++)
		{
			Row currentRow = sheet.getRow(i);
			for(int j=0;j<2;j++)
			{
				Cell currentCell = currentRow.getCell(j);
				String cellData = currentCell.getStringCellValue();
				System.out.println(cellData);
			}
		}*/
	//reading mutliple data from excel	
	int RowCount=sheet.getLastRowNum();
	
	for(int i=0;i<=RowCount;i++)
	{
		Row r=sheet.getRow(i);
		
		int CellCount=r.getLastCellNum();
		
		for(int k=0;k<CellCount;k++)
		{
			Cell c=r.getCell(k);
			String data=c.getStringCellValue();
			System.out.print(data+"  ");
		}
		System.out.println();
	}
		

	}

}
