package com.phoneBook.DAO;

import com.phoneBook.IOData.ExcelReader;
import com.phoneBook.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ExcelReader reader;

    @Transactional
    @Override
    public List<City> showAllCity() {
        List<City> list = entityManager.createQuery("from City").getResultList();
        return list;
    }

    @Transactional
    @Override
    public void databaseEntryFromExcel() {
        List<Map<Integer, List<Object>>> sheepsData = new ArrayList();
        List<List<Object>> allData = new ArrayList();  //данные со всех листов excel в одном списке
        try {
            sheepsData = reader.read("C:/Users/БЭГ/Documents/NetBeansProjects/restAPI/src/main/resources/static/files/Region_city.xlsx");
        } catch (IOException e) {
            System.out.println("Ошибка при парсинге из Excel");
        }
        System.out.println("Зашли в databaseEntryFromExcel() ");
        Iterator iteratorSheeps = sheepsData.iterator();   //получаем все данные со всех листов в один лист для дальнейшей выгрузки в базу данных
        while (iteratorSheeps.hasNext()) {
            Map<Integer, List<Object>> mapSheep = (Map<Integer, List<Object>>) iteratorSheeps.next();
            for (Map.Entry<Integer, List<Object>> detourSheep : mapSheep.entrySet()) {
                System.out.print(detourSheep.getValue());
                allData.add(detourSheep.getValue());
            }
        }
        for(int i=0;i<allData.size();i++){
            for(int j=0;j<2;j++){
        City city = new City(allData.get(i).get(0).toString(),allData.get(i).get(2).toString());
        entityManager.merge(city);
            }
        }

    }
}
