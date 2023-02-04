package com.phoneBook.controller;

import com.phoneBook.DAO.CityDAO;
import com.phoneBook.IOData.ExcelReader;
import com.phoneBook.entity.City;
import com.phoneBook.entity.Organization;
import com.phoneBook.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import com.phoneBook.service.ServicePhoneBook;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/")
public class RestControllerPhoneBook {

    @Autowired
    private ServicePhoneBook service;

    @Value("${upload.path}")
    private String upLoadPath;

    @GetMapping("persons")
    public String showAllPersonForAll(@Valid @ModelAttribute("person1") Person person1, BindingResult bindingResult, Model model) {
        List<Person> allPersons = service.showAllPerson();
        Collections.sort(allPersons);
        model.addAttribute("persons", allPersons);
        if (!model.containsAttribute("person")) {  //Thymeleaf пытается обратится к атрибуту "person" не видит его и выводит ошибку 500
            Person person = new Person();                       //поэтому добавлен дефолтный person со значениями 
            person.setCity(new City());                         //по умолчанию. В случае,если id есть,то person будет передан из сессии getPerson()
            person.setOrganization(new Organization());
            model.addAttribute("person", person);
        }
        Map<String, List<City>> mapCity = service.showAllCity().stream().collect(Collectors.groupingBy(x -> x.getRegion()));
        model.addAttribute("mapCityRegion", mapCity.keySet());
      
        return "showAllPersonsView";
    }

    @GetMapping("persons/{id}")
    public String getPerson(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Person person = service.getPerson(id);                //в случае, если не добавлены город и организация,то создать объекты с дефолтными значениями
        if (person.getCity() == null) {
            person.setCity(new City());
        }
        if (person.getOrganization() == null) {
            person.setOrganization(new Organization());
        }
        System.out.println(person.getPhoto());
        redirectAttributes.addFlashAttribute("person", person);
        return "redirect:/api/persons";

    }

//    @GetMapping("organizations/{id}")
//    public String getOrganization(@PathVariable int id, RedirectAttributes redirectAttributes) {
//        Organization organization = service.getOrganization(id);
//        redirectAttributes.addFlashAttribute("organization", organization);
//        System.out.println(id);
//        return "redirect:/api/persons";
//    }
     @PostMapping(value ="person", headers = {"Content-type=application/json"})  // доавление данных - доделать
     @ResponseBody
    public String addPerson(@RequestBody  Person person) {
        System.out.println(person.toString());
        
        
        return "redirect:/api/persons";
    }
//    @PostMapping("persons")  // доавление данных - доделать
//    public String addPerson(@RequestBody MultipartFile file, Person person) throws IOException {
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
//        if (file != null) {
//            File uploadDir = new File(upLoadPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();  //в случае,если не существует папки для загрузки файлов,то создать ее
//            }
//            String uuidFile = UUID.randomUUID().toString(); //создавать уникальные значения файлам
//            String resultFileName = uuidFile + "." + file.getOriginalFilename();
//            file.transferTo(new File(upLoadPath + "/" + resultFileName));
//            //  person.setPhoto(resultFileName);
//        }
//        return "здесь будет редирект";
//    }
//    @GetMapping("addPerson")
//    public String addNewEmployee() {
//      //  service.saveEmployee(person);
//        return "addPerson";
//    }

    @PostMapping("persons/delete")
    public String deletePerson(@RequestParam Integer id) {
        service.deletePerson(id);
        return "redirect:/api/persons";
    }

//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        employeeService.saveEmployee(employee);
//        return employee;
//    }
//
}
