package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetTestData {

    public List<Map<String, Object>> students() {

        Map<String, Object> student = new HashMap<>();
        student.put("id", 41);
        student.put("username", "mehmetcan");
        student.put("ssn", "333-22-9999");
        student.put("name", "mehmet");
        student.put("surname", "can");
        student.put("birthDay", "2010-02-01");
        student.put("birthPlace", "almanya");
        student.put("phoneNumber", "111-222-9999");
        student.put("gender", "MALE");
        student.put("motherName", "ayse");
        student.put("fatherName", "ali");
        student.put("studentNumber", 1039);
        student.put("email", "team08@gmail.com");
        student.put("active", true);

        List<Map<String, Object>> students = new ArrayList<>();
        students.add(student);
        return students;
    }

    public Map<String, Object> object(int id, String description, String date, String startTime, String stopTime, List<Map<String,Object>> students) {
        Map<String, Object> object = new HashMap<>();
        object.put("id", id);
        object.put("description", description);
        object.put("date", date);
        object.put("startTime", startTime);
        object.put("stopTime", stopTime);
        object.put("advisorTeacherId", 8);
        object.put("teacherName", "Nihal");
        object.put("teacherSsn", "123-54-3478");
        object.put("students", students);


        return object;
    }
/*
{
    "object": {
        "id": 36,
        "description": "Materyal",
        "date": "2024-11-12",
        "startTime": "17:30:00",
        "stopTime": "18:00:00",
        "advisorTeacherId": 8,
        "teacherName": "Nihal",
        "teacherSsn": "123-54-3478",
        "students": [
            {
                "id": 41,
                "username": "mehmetcan",
                "ssn": "333-22-9999",
                "name": "mehmet",
                "surname": "can",
                "birthDay": "2010-02-01",
                "birthPlace": "almanya",
                "phoneNumber": "111-222-9999",
                "gender": "MALE",
                "motherName": "ayse",
                "fatherName": "ali",
                "studentNumber": 1039,
                "email": "team08@gmail.com",
                "active": true
            }
        ]
    },
    "message": "Meet Saved Successfully",
    "httpStatus": "CREATED"
}
 */

    public Map<String, Object> meetData(Map<String, Object> object,String message,String httpstatus){
        Map<String, Object> meetdata = new HashMap<>();
        meetdata.put("object",object);
        meetdata.put("message",message);
        meetdata.put("httpStatus",httpstatus);
        return  meetdata;
    }

    public Map<String , Object> postOrPutData(String date,String description,String startTime,String stoptime){
        List<Integer> stId = new ArrayList<>();
        stId.add(41);
        Map<String , Object>expectedDataPostput = new HashMap<>();
        expectedDataPostput.put("date", date);
        expectedDataPostput.put("description", description);
        expectedDataPostput.put("startTime", startTime);
        expectedDataPostput.put("stopTime", stoptime);
        expectedDataPostput.put("studentIds", stId);
        return expectedDataPostput;
    }








    public Map<Object,Object> MeetExpectedData(String date,String description,String startTime,String stoptime,Integer studentIds){
        Map<Object , Object>expectedDataPost = new HashMap<>();
        List<Integer> students = new ArrayList<>();
        students.add(studentIds);
        expectedDataPost.put("date", date);
        expectedDataPost.put("description", description);
        expectedDataPost.put("startTime", startTime);
        expectedDataPost.put("stopTime", stoptime);
        return expectedDataPost;
    }


    /*
 { ogrenci
  "advisorTeacherId": 9,
  "birthDay": "2010-02-01",
  "birthPlace": "almanya",
  "email": "team08@gmail.com",
  "fatherName": "ali",
  "gender": "MALE",
  "motherName": "ayse",
  "name": "mehmet",
  "password": "12345678",
  "phoneNumber": "111-222-9999",
  "ssn": "333-22-9999",
  "surname": "can",
  "username": "mehmetcan"


  response ogrenci
  {
    "object": {
        "userId": 41,
        "username": "mehmetcan",
        "name": "mehmet",
        "surname": "can",
        "birthDay": "2010-02-01",
        "birthPlace": "almanya",
        "phoneNumber": "111-222-9999",
        "gender": "MALE",
        "studentNumber": 1039,
        "motherName": "ayse",
        "fatherName": "ali",
        "email": "team08@gmail.com",
        "active": true
    },
    "message": "Student saved Successfully"
}
}

ortmem
{
    "object": {
        "userId": 9,
        "username": "Nihal03",
        "name": "Nihal",
        "surname": "Bksgn",
        "birthDay": "1989-01-01",
        "ssn": "123-54-3478",
        "birthPlace": "istanbul",
        "phoneNumber": "531-789-0123",
        "gender": "FEMALE",
        "email": "nhl@hotmail.com"
    },
    "message": "Teacher successfully found",
    "httpStatus": "OK"
}


     */
}