package com.phoneBook.IOData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ExcelReader {
    private List<Map<Integer, List<Object>>> sheepsData;

    public List<Map<Integer, List<Object>>> read(String filename) throws IOException {
        sheepsData = new ArrayList();
        Workbook workbook = loadWorkbook(filename);
        Iterator sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()) {  //обход всех листов в файле
            Sheet sheet = (Sheet) sheetIterator.next();
            processSheet(sheet);
            System.out.println();
        }
        return sheepsData;
    }

    private Workbook loadWorkbook(String filename) throws IOException {   //анализирует расширение файла и в зависимости от него определяет формат файла
        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        FileInputStream file = new FileInputStream(new File(filename));
        switch (extension) {
            case "xls":
                // old format
                return new HSSFWorkbook(file);
            case "xlsx":
                // new format
                return new XSSFWorkbook(file);
            default:
                throw new RuntimeException("Unknown Excel file extension: " + extension);
        }
    }

    private void processSheet(Sheet sheet) {  // обрабатывает один лист из Excel
        System.out.println("Sheet: " + sheet.getSheetName());  //возвращает имя листа, которое обычно в Excel пишется внизу
        Map data = new HashMap<Integer, List<Object>>(); // складывать построчно данные из ячеек таблицы. 
        Iterator iterator = sheet.rowIterator();         //Ключ мапы - это номер строки, значение - все ячейки данной таблицы.
        for (int rowIndex = 0; iterator.hasNext(); rowIndex++) { //Обход всех строк листа
            Row row = (Row) iterator.next();
            processRow(data, rowIndex, row);
        }
        sheepsData.add(data);
        System.out.println(data);
    }

    private void processRow(Map<Integer, List<Object>> data, int rowIndex, Row row) { //вызывает в цикле метод processCell() для каждой ячейки
        data.put(rowIndex, new ArrayList<>());
        for (Cell cell : row) {
            processCell(cell, data.get(rowIndex));
        }
    }

    private void processCell(Cell cell, List<Object> dataRow) {
        switch (cell.getCellType()) {
            case STRING:
                dataRow.add(cell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    dataRow.add(cell.getLocalDateTimeCellValue());
                } else {
                    dataRow.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                dataRow.add(cell.getBooleanCellValue());
                break;
            case FORMULA:
                dataRow.add(cell.getCellFormula());
                break;
            default:
                dataRow.add(" ");
        }
    }
}
