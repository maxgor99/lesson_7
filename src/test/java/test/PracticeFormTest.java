package test;


import org.junit.jupiter.api.Test;
import pages.PracticeForm;


public class PracticeFormTest extends BaseTest {
    PracticeForm practiceForm = new PracticeForm();


    @Test
    void successPracticeFormTest() {
        practiceForm.openPage().
                setFirstName("Max").
                lastNameInput("Gor").
                userEmailInput("maxgor@gmail.com").
                userNumberInput("1122334455").
                userCurrentAdressInput("text text text").
                genderWrapper("Male").
                setDateOfBirth("01", "October", "1989").
                subjectInput("English").
                hobbiesWrapper("Sports").
                hobbiesWrapper("Music").uploadPicture("frost.jpeg").
                selectState("NCR").
                selectCity("Delhi").
                pressSubmit();


        practiceForm.checkResult("Student Name", "Max Gor")
                .checkResult("Student Email", "maxgor@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1122334455")
                .checkResult("Date of Birth", "01 October,1989")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "frost.jpeg")
                .checkResult("Address", "text text text")
                .checkResult("State and City", "NCR Delhi");


    }


    @Test
    void checkRequiredFieldsTest() {
        practiceForm.openPage().
                setFirstName("Max").
                lastNameInput("Gor").
                userNumberInput("1122334455").
                genderWrapper("Male").
                setDateOfBirth("01", "October", "1989").
                pressSubmit();

        practiceForm.checkResult("Student Name", "Max Gor")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1122334455")
                .checkResult("Date of Birth", "01 October,1989");


    }

    @Test
    void negativePracticeFormTest() {
        practiceForm.openPage().
                setFirstName("Max").
                lastNameInput("Gor").
                userEmailInput("maxgor@gmail.com").
                userNumberInput("aabbcceedd").
                userCurrentAdressInput("text text text").
                genderWrapper("Male").
                setDateOfBirth("01", "October", "1989").
                subjectInput("English").
                hobbiesWrapper("Sports").
                hobbiesWrapper("Music").uploadPicture("frost.jpeg").
                selectState("NCR").
                selectCity("Delhi").
                pressSubmit();


        practiceForm.formResult();


    }

}

