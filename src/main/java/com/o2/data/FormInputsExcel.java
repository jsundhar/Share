package com.o2.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class FormInputsExcel {
	public String[][] readData() {

		String[][] data = null;
		try {
			String path = System.getProperty("user.dir")
					+ "/src/main/java/com/o2/data/Exceldata.xls";
			System.out.println("Actual Location of File -> " + path);
			FileInputStream excel = new FileInputStream(new File(path));

			try {
				HSSFWorkbook wb = new HSSFWorkbook(excel);
				Sheet sheet1 = wb.getSheetAt(0);
				data = new String[sheet1.getLastRowNum() + 1][6];
				// System.out.println("Arraysize"+sheet1.getLastRowNum());

				for (Row row : sheet1) {
					for (Cell cell : row) {
						data[row.getRowNum()][cell.getColumnIndex()] = cell
								.toString();
					}
				}

				// Printing the string array
				// for (int i=0;i<data.length;i++) {
				// for (int j=0;j<6;j++) { System.out.println("S::"+data[i][j]);
				// } }

				wb.close();
				excel.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

}
