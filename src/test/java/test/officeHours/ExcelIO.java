package test.officeHours;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelIO {

    @Test
    public void readExcellFile() {
        try {
            FileInputStream file08 = new FileInputStream("VytrackTestUsers.xlsx");

            //.xlsx
            //XSSWorkbook - to create an object of .x;sx file
            //HSSWorkbook - to create an object pf .xls file
            //Workbook - is an interface ,that is implemented by XSSWorkbook and HSSWorkbook
            //coz this we used Workbook because maybe you dont know which one is that file

            Workbook workbook = WorkbookFactory.create(file08);//that workbook use for creating Excel file

            //object of sheet used to represent excel file page(bakar de lo parakany aw excela ba nmuna la pary yaka yan du
            //datway ba naw bakar byny(name) nawaka la zheraway paragrafaka danwsre datuany ba index bnusy ka la  0 dast pedaka
            Sheet sheet = workbook.getSheet("QA1-short");//we used name here

            //read first row
            Row row = sheet.getRow(0);

            //read first cell
            Cell cell = row.getCell(0);

            System.out.println(cell);  //you gonna have

            int clumnNumber = row.getPhysicalNumberOfCells();//how many cells
            for (int i = 0; i < clumnNumber; i++) {
                System.out.println(row.getCell(i) + " "); //for printing all elements in row 1
            }

            //to get number of rows
            int rowNum = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowNum; i++) {
                System.out.print(sheet.getRow(i).getCell(0) + " ");//that one gonne return every first element in all rows
                System.out.print(sheet.getRow(i).getCell(1) + " ");
                System.out.print(sheet.getRow(i).getCell(2));
                System.out.println();
            }

            System.out.println("=============================================");
//here we created 2D array to store data from Excel file

            String[][] dataTable = new String[rowNum][clumnNumber];

            for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {//this is for intire table
                for (int columnIndex = 0; columnIndex < clumnNumber; columnIndex++) {
                    System.out.print(sheet.getRow(rowIndex).getCell(columnIndex) + " ");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //input = read
    //output =write

    @Test
    public void writeIntoExcelFile() {

//close excil file during writing.otherwise file will crash
        try (FileInputStream file07 = new FileInputStream("VytrackTestUsers.xlsx");
             ) {
            Workbook workbook=WorkbookFactory.create(file07);
            Sheet sheet=workbook.getSheet("QA1-short");
            Row row=sheet.getRow(1);

            FileOutputStream file06 = new FileOutputStream("VytrackTestUsers.xlsx");//that one for writing
            //write to the second row and 6th column
           row.getCell(5).setCellValue("Passed");
           workbook.write(file06);//to write update to the file
            file06.close();//we closed because if we dont it gonna crash

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

