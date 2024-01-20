package utils;



import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
public class ExcelReader {

	
	@DataProvider(name = "reservationData")
    public static Iterator<Object[]> getReservationData() {
        List<Object[]> data = new ArrayList<>();

        try (
        		FileInputStream fis = new FileInputStream("src/test/java/resources/ReservationData.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Sheet1");
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String searchText = row.getCell(0).getStringCellValue();
                Cell cell = row.getCell(1);
                DataFormatter formatter = new DataFormatter();
                String checkInMonth = formatter.formatCellValue(cell);
                Cell cell2 = row.getCell(2);
                String val = formatter.formatCellValue(cell2);
                
                Cell cell3 = row.getCell(3);
                String checkOutMonth = formatter.formatCellValue(cell3);
                Cell cell4 = row.getCell(4);
                String val2 = formatter.formatCellValue(cell4);


                data.add(new Object[]{searchText, checkInMonth, val, checkOutMonth, val2});

             // Date checkInMonth = row.getCell(1).get
                // Date val = row.getCell(2).getDateCellValue();
                 //String checkInDate = row.getCell(1).getStringCellValue();
               // String checkOutDate = row.getCell(2).getStringCellValue();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.iterator();
    }
}
