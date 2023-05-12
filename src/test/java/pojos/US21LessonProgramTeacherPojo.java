package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US21LessonProgramTeacherPojo {

    public int userId;
    public String username;
    public String name;
    public String surname;
    public String birthDay;
    public String ssn;
    public String birthPlace;
    public String phoneNumber;
    public String gender;
    public String email;


    public US21LessonProgramTeacherPojo() {
    }

    public US21LessonProgramTeacherPojo(int userId, String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender, String email) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.ssn = ssn;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
    }


}
