package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentInfoTestData {
    /*

// [ {
//#        "id": 4,
//#        "midtermExam": 50.0,
//#        "finalExam": 70.0,
//#        "absentee": 3,
//#        "infoNote": "basarili bir ogrenci",
//#        "lessonName": "Api",
//#        "creditScore": 5,
//#        "educationTerm": "SPRING_SEMESTER",
//#        "average": 62.0,
//#        "studentResponse": {
//#            "userId": 4,
//#            "username": "hatice03",
//#            "name": "monica",
//#            "surname": "team03",
//#            "birthDay": "1987-03-30",
//#            "birthPlace": "Paris",
//#            "phoneNumber": "198-287-6547",
//#            "gender": "FEMALE",
//#            "studentNumber": 1003,
//#            "motherName": "mama",
//#            "fatherName": "papa",
//#            "email": "abc@gmail.com",
//#            "active": true
//#        },
//#        "compulsory": true,
//#        "note": "CC"
//#    }
    ]

     */
    public  List<Map<String, Object>> expecteddata(Integer id,Double midtermExam,Double finalExam,Integer absentee,String infoNote,String lessonName,Integer creditScore,String educationTerm,Double average,Map<String, Object> studentResponse,Boolean compulsory,String note) {

        Map<String, Object> dismap = new HashMap<>();
        dismap.put("id",id);
        dismap.put("midtermExam",midtermExam);
        dismap.put("finalExam",finalExam);
        dismap.put("absentee",absentee);
        dismap.put("infoNote",infoNote);
        dismap.put("lessonName",lessonName);
        dismap.put("creditScore",creditScore);
        dismap.put("educationTerm",educationTerm);
        dismap.put("average",average);
        dismap.put("studentResponse", studentResponse);
        dismap.put("compulsory",compulsory);
        dismap.put("note",note);

        List<Map<String, Object>> expectedData = new ArrayList<>();
        expectedData.add(dismap);
        return  expectedData;




        }

    public Map<String ,Object> studentResponse(){
        Map<String, Object> studentResponse = new HashMap<>();
        studentResponse.put("userId",4);
        studentResponse.put("username","hatice03");
        studentResponse.put("name","monica");
        studentResponse.put("surname","team03");
        studentResponse.put("birthDay","1987-03-30");
        studentResponse.put("birthPlace","Paris");
        studentResponse.put("phoneNumber","198-287-6547");
        studentResponse.put("gender","FEMALE");
        studentResponse.put("studentNumber",1003);
        studentResponse.put("motherName","mama");
        studentResponse.put("fatherName","papa");
        studentResponse.put("email","abc@gmail.com");
        studentResponse.put("active",true);

        return studentResponse;

    }

    }

