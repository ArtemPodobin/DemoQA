package manager;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;

public interface HelperStudent extends HelperBase{

    default void selectForms(){
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }
    default void selectPracticeForm(){click(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]"));


    }

    default void fillForm(StudentDTO studentDTO){
        type(By.id("firstName"), studentDTO.getFirstName());
        type(By.id("lastName"), studentDTO.getLastName());
        type(By.id("userEmail"), studentDTO.getEmail());
        selectGender(studentDTO.getGender());
        type(By.id("userNumber"), studentDTO.getPhone());
        type(By.id("dateOfBirthInput"), studentDTO.getBirthday());
        addSubject(studentDTO.getSubjects());
        selectHobby(studentDTO.getHobbies());
        type(By.id("currentAddress"), studentDTO.getAddress());
        typeState(studentDTO.getState());
        typeCity(studentDTO.getCity());
    }

    default void typeBDay(String birthday){
    }

    default void selectGender(Gender gender){
        String gen;

        if(gender.equals(Gender.MALE)){
            gen = "1";
        } else if (gender.equals(Gender.FEMALE)){
            gen = "2";
        } else {
            gen = "3";
        }
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#gender-radio-" + gen +"').checked=true");
    }

    default void addSubject(String subjects){
        String[] split = subjects.split(",");
        String locator = "subjectsInput";
        click(By.id(locator));
        for(String subject : split){
            wd.findElement(By.id(locator)).sendKeys(subject);
            wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        }
    }

    default void selectHobby(List<Hobby> hobbies){
        for(Hobby hobby : hobbies){
            String hob = null;
            switch (hobby){
                case SPORTS:
                    hob = "1";
                    break;
                case READING:
                    hob = "2";
                    break;
                case MUSIC:
                    hob = "3";
                    break;
            }
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#hobbies-checkbox-" + hob +"').checked=true");//hobbies-checkbox-1
        }
    }

    default void typeState(String state){
        wd.findElement(By.id("react-select-3-input")).sendKeys(state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }
    default void typeCity(String city){
        wd.findElement(By.id("react-select-4-input")).sendKeys(city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    default void submit(){
        hideElement("document.querySelector('footer').setAttribute('style','display: none;')");
        //click(By.id("submit"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#submit').click();");
    }


}
