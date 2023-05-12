package testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonProgramTestData {
     /*
    Given
        https://school-management-v1.herokuapp.com/lessonPrograms/save

    {
  "day": "MONDAY",
  "educationTermId": "1",
  "lessonIdList": [
    "7"

  ],
  "startTime": "12:30",
  "stopTime": "18:30"
}





        {
    "object": {
        "lessonProgramId": 4,
        "startTime": "12:30:00",
        "stopTime": "18:30:00",
        "lessonName": [
            {
                "lessonId": 7,
                "lessonName": "Api",
                "creditScore": 5,
                "compulsory": true
            }
        ],
        "day": "MONDAY"
    },
    "message": "Created Lesson Program",
    "httpStatus": "CREATED"
}
     */

    //actual data
    public List<Map<String,Object>>map3(Integer lessonId,String lessonName,Integer creditScore,Boolean compulsory){
        Map<String,Object> map3=new HashMap<>();
        map3.put("lessonId", lessonId);
        map3.put("lessonName", lessonName);
        map3.put("creditScore", creditScore);
        map3.put("compulsory", compulsory);

        List<Map<String, Object>> lessonNamelist = new ArrayList<>();
        lessonNamelist.add(map3);
        return  lessonNamelist;
    }

    public Map<String,Object> map2(String startTime,String stopTime,List<Map<String,Object>>lessonNameList,String day){
      Map<String,Object>  map2 = new HashMap<>();
        map2.put("startTime", startTime);
        map2.put("stopTime", stopTime);
        map2.put("lessonName", lessonNameList);
        map2.put("day", day);

        return map2;
    }

    public Map<String,Object> actualData(Map<String,Object> map2,String message,String httpStatus){
      Map<String,Object>  actualData = new HashMap<>();
        actualData.put("object",map2);
        actualData.put("message", message);
        actualData.put("httpStatus",httpStatus);
        return actualData;
    }
    //expectedData

    public Map<String,Object> expectedData(String day,String educationTermId,List<Integer> lessonIdList,String startTime,String stopTime){
      Map<String,Object>  expectedData = new HashMap<>();
       expectedData.put("day", day);
       expectedData.put("educationTermId", educationTermId);
       expectedData.put("lessonIdList", lessonIdList);
       expectedData.put("startTime", startTime);
       expectedData.put("stopTime", stopTime);

       return expectedData;
   }

   }

