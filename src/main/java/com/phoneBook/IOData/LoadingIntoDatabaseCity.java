package com.phoneBook.IOData;

import com.phoneBook.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoadingIntoDatabaseCity extends LoadingIntoDatabase {

    @Autowired
    private EntityManager entityManager;
    
    private String file = "C:/Users/БЭГ/Documents/NetBeansProjects/restAPI/src/main/resources/static/files/Region_city.xlsx"; 
    private List<List<Object>> listCity = new ArrayList<>();

    @Transactional
    @Override
    public void entryFromExcelToTable() { //ввод информации из excel в базу данных
        List<Map<Integer, List<Object>>> sheepsData = new ArrayList();
        List<List<Object>> allData = new ArrayList();  //данные со всех листов excel в одном списке
        try {
            sheepsData = reader.read(file);
        } catch (IOException e) {
            System.out.println("Ошибка при парсинге из Excel");
        }
        allData = getSheetIteratorExcel(sheepsData);  //получаем информацию со всех листов
        for (int i = 0; i < allData.size(); i++) { // заносим в базу данных имя города и регион
            for (int j = 0; j < 2; j++) {
                City city = new City(allData.get(i).get(0).toString(), allData.get(i).get(2).toString());
                entityManager.merge(city);
            }
        }

    }
}
