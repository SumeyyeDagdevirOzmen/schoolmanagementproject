package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherCreateTestData {
/*
{
  "birthDay": "1982-05-01",
  "birthPlace": "istanbul",
  "email": "slugkzfdas@hotmail.com",
  "gender": "MALE",
  "isAdvisorTeacher": true,
  "lessonsIdList": [
    1
  ],
  "name": "haksss",
  "password": "Team03team",
  "phoneNumber": "56-456-1478",
  "ssn": "532-85-1479",
  "surname": "Bksgn",
  "username": "Hakan123"
}
 */

    public Map<String,Object>teacherExpectedData(String birthDay, String birthPlace, String email,String gender, Boolean isAdvisorTeacher, List<Integer>lessonsIdList,String name,String password,String phoneNumber,String ssn, String surname,String username){

        Map<String,Object>expected=new HashMap<>();
        expected.put("birthDay",birthDay);
        expected.put("birthPlace",birthPlace);
        expected.put("email",email);
        expected.put("gender",gender);
        expected.put("isAdvisorTeacher",isAdvisorTeacher);
        expected.put("lessonsIdList",lessonsIdList);
        expected.put("name",name);
        expected.put("password",password);
        expected.put("phoneNumber",phoneNumber);
        expected.put("ssn",ssn);
        expected.put("surname",surname);
        expected.put("username",username);
        return expected;
    }

    public Map<String,Object> teacherResponseObject (Integer userId,String username, String name,String surname,String birthDay,String ssn, String birthPlace,String phoneNumber,String gender,String email){
        HashMap<String,Object>objectHashMap = new HashMap<>();
        objectHashMap.put("userId",userId);
        objectHashMap.put("username",username);
        objectHashMap.put("name",name);
        objectHashMap.put("surname",surname);
        objectHashMap.put("birthDay",birthDay);
        objectHashMap.put("ssn",ssn);
        objectHashMap.put("birthPlace",birthPlace);
        objectHashMap.put("phoneNumber",phoneNumber);
        objectHashMap.put("gender",gender);
        objectHashMap.put("email",email);
        return objectHashMap;
    }

    public Map<String,Object>teacherActualData(Map<String, Object> teacherResponseObject,String message,String httpStatus){
        HashMap<String,Object>responseMap=new HashMap<>();
        responseMap.put("teacherResponseObject",teacherResponseObject);
        responseMap.put("message",message);
        responseMap.put("httpStatus",httpStatus);
        return responseMap;
    }


}
