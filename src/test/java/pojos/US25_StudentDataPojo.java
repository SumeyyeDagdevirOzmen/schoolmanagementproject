package pojos;

public class US25_StudentDataPojo {

    private String username;
    private String name;
    private String surname;
    private String birthDay;
    private String birthPlace;
    private String phoneNumber;
    private String gender;

    private String motherName;
    private String fatherName;
    private String email;

    private String advisorTeacherId;
    private String ssn;
    private String password;
    private Boolean active;

    public US25_StudentDataPojo() {
    }

    public US25_StudentDataPojo(Boolean active) {
        this.active = active;
    }

    public US25_StudentDataPojo(String username, String name, String surname, String birthDay, String birthPlace, String phoneNumber, String gender, String motherName, String fatherName, String email, String advisorTeacherId, String ssn, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.email = email;
        this.advisorTeacherId = advisorTeacherId;
        this.ssn = ssn;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }



    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdvisorTeacherId() {
        return advisorTeacherId;
    }

    public void setAdvisorTeacherId(String advisorTeacherId) {
        this.advisorTeacherId = advisorTeacherId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "US25_StudentDataPojo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", motherName='" + motherName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", email='" + email + '\'' +
                ", advisorTeacherId='" + advisorTeacherId + '\'' +
                ", ssn='" + ssn + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}