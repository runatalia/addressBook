package com.phoneBook.IOData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadingIntoDatabase {

    protected File file;

    @Autowired
    protected ExcelReader reader;

    public void entryFromExcelToTable() {
    } //перенос информации из Excel в базу данных 

    protected List<List<Object>> getSheetIteratorExcel(List<Map<Integer, List<Object>>> sheepsData) { //итерируемся по всем листам 
        List<List<Object>> allData = new ArrayList();
        Iterator iteratorSheeps = sheepsData.iterator();   //получаем все данные со всех листов в один лист для дальнейшей выгрузки в базу данных
        while (iteratorSheeps.hasNext()) {
            Map<Integer, List<Object>> mapSheep = (Map<Integer, List<Object>>) iteratorSheeps.next();
            for (Map.Entry<Integer, List<Object>> detourSheep : mapSheep.entrySet()) {
                System.out.print(detourSheep.getValue());
                allData.add(detourSheep.getValue());
            }
        }
        return allData;
    }

}
