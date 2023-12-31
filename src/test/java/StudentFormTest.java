import manager.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest implements HelperStudent {

    @BeforeMethod
    public void precondition(){

        hideElement("document.querySelector('#adplus-anchor').setAttribute('style','display: none;')");
        selectForms();
        selectPracticeForm();
        System.out.println(wd.findElements(By.id("item-0")).size());
    }

    @Test
    public void studentFormPositive(){

        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);


        StudentDTO studentDTO = StudentDTO.builder()
                .firstName("Sarah")
                .lastName("Connor")
                .email("sarah@mail.com")
                .gender(Gender.FEMALE)
                .phone("1234567890")
                .birthday("05 05 2000")
                .subjects("Maths,Physics")
                .hobbies(hobbies)
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();

        fillForm(studentDTO);
        submit();

    }


}
