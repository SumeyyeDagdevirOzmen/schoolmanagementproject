package testdata;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class CreateStudentTestData {

     Map<String, Object> studentBody = new HashMap<>();
     String birthDay=""+ Faker.instance().number().numberBetween(1990,2022)+"-"+"02"+"-"+Faker.instance().number().numberBetween(10,28);
     String birthPlace=Faker.instance().address().cityName();
     String email=Faker.instance().name().firstName()+"@gmail.com";
     String fatherName=Faker.instance().name().firstName();
     String gender="MALE";
     String motherName=Faker.instance().name().firstName();
     String name=Faker.instance().name().firstName();
     String password="pass2345";
     String phoneNumber=Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(1000,9999);
     String ssn=Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(10,99)+"-"+Faker.instance().number().numberBetween(1000,9999);
     String surname=Faker.instance().name().lastName();
     String username=Faker.instance().hobbit().character();
    public Map<String,Object> expectedStudentBodyPozitive(){ //pozitif

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public  Map<String,Object> expectedStudentBodyEmptyAdvTeacher(){

        studentBody.put("advisorTeacherId", null);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyUsername(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username","");
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyName(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name","");
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptySurName(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname","");
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyBirthDay(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay","");
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyBirthPlace(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace","");
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }
    public Map<String,Object> expectedStudentBodyEmptySsn(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn","");
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace","");
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyPhoneNumber(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber","");
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyGender(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender","");
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyMotherName(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName","");
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyFatherName(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName","");
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmptyEmail(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email","");
        studentBody.put("password",password);

        return studentBody;
    }


    public Map<String,Object> expectedStudentBodySsnFormat1(){  //xx-xxx-xxxxx

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",Faker.instance().number().numberBetween(10,99)+"-"+Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(10000,99999));
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodySsnFormat2(){  //xxx-xxx-xxxxx

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(100,999)+"-"+Faker.instance().number().numberBetween(10000,99999));
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodySsnFormat3(){  //x-xxxx-xxxxx

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",Faker.instance().number().numberBetween(0,9)+"-"+Faker.instance().number().numberBetween(1000,9999)+"-"+Faker.instance().number().numberBetween(10000,99999));
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password",password);

        return studentBody;
    }
    public Map<String,Object> expectedStudentBodyEmptyPassword(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password","");

        return studentBody;
    }


    public Map<String,Object> expectedStudentBodySevenCharacterPassword(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password","234527");

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEightSpaceCharacterPassword(){

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",email);
        studentBody.put("password","        ");

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmailFormat0(){ //abc..

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",Faker.instance().name().firstName());
        studentBody.put("password",password);

        return studentBody;
    }

    public Map<String,Object> expectedStudentBodyEmailFormat1(){ //abc..@

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",Faker.instance().name().firstName()+"@");
        studentBody.put("password",password);

        return studentBody;
    }


    public Map<String,Object> expectedStudentBodyEmailFormat2(){ //abc..@gmail

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",Faker.instance().name().firstName()+"@gmail");
        studentBody.put("password",password);

        return studentBody;
    }

    public  Map<String,Object> expectedStudentBodyEmailFormat3(){ //name.gmail@com

        studentBody.put("advisorTeacherId", 2);
        studentBody.put("username",username);
        studentBody.put("ssn",ssn);
        studentBody.put("name",name);
        studentBody.put("surname",surname);
        studentBody.put("birthDay",birthDay);
        studentBody.put("birthPlace",birthPlace);
        studentBody.put("phoneNumber",phoneNumber);
        studentBody.put("gender",gender);
        studentBody.put("motherName",motherName);
        studentBody.put("fatherName",fatherName);
        studentBody.put("email",Faker.instance().name().firstName()+".gmail@com");
        studentBody.put("password",password);

        return studentBody;
    }

}
