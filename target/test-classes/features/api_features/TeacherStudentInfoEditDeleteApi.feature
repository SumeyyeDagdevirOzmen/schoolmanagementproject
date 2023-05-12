@Us18StudentInfo @teacher @apiRegression
Feature: TeacherNotEditDelete
# //        List<Integer> getid= response.jsonPath().getList("findAll{it.studentResponse.userId==42}.id");
#//        System.out.println("getid = " + getid);
#//        getId=getid.get(0);
#//        {
#//            "id": 464,
#//                "midtermExam": 30.0,
#//                "finalExam": 70.0,
#//                "absentee": 3,
#//                "infoNote": "basarili bir ogrenci",
#//                "lessonName": "JAVA",
#//                "creditScore": 8,
#//                "educationTerm": "SPRING_SEMESTER",
#//                "average": 54.0,
#//                "studentResponse": {
#//            "userId": 42,
#//                    "username": "Amine03",
#//                    "name": "Amine",
#//                    "surname": "Amine",
#//                    "birthDay": "1987-01-15",
#//                    "birthPlace": "Paris",
#//                    "phoneNumber": "346-546-7777",
#//                    "gender": "FEMALE",
#//                    "studentNumber": 1040,
#//                    "motherName": "mama",
#//                    "fatherName": "papa",
#//                    "email": "amine123@gmail.com",
#//                    "active": true
#//        },
#//            "compulsory": false,
#//
# "note": "DD"

  @Us18poststudent
  Scenario: TC01_Notes_must_be_visible
    Given   userhatice set the url for Post
    Then    HTTP Status code should be 200

  @18getStudent
  Scenario: TC02_Student_Info_Get_The_uRl
    Given userhatice get the url
    When  userhatice send get request for Student info
    Then  userhatice gets the student info and assert

    
  @18Putstudent
  Scenario: TC02_StudentInfo_must_update
    Given   userhatice set the url for update
    When    userhatice send Update request for Student info
    Then    htcHTTP Status eror code should be 200

  @18DeleteStudent
  Scenario: TC09_deletebutton_must be active
    Given   I send DELETE Request to the Url
    Then    Response body is  message
