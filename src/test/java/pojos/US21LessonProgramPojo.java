package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US21LessonProgramPojo {

    public int lessonProgramId;
    public String startTime;
    public String stopTime;
    public ArrayList<US21LessonNamePojo> lessonName;
    public ArrayList<US21LessonProgramTeacherPojo> teachers;
    public String day;


    public US21LessonProgramPojo() {
    }

    public US21LessonProgramPojo(int lessonProgramId, String startTime, String stopTime, ArrayList<US21LessonNamePojo> lessonName, ArrayList<US21LessonProgramTeacherPojo> teachers, String day) {
        this.lessonProgramId = lessonProgramId;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.lessonName = lessonName;
        this.teachers = teachers;
        this.day = day;
    }


    public int getLessonProgramId() {
        return lessonProgramId;
    }

    public void setLessonProgramId(int lessonProgramId) {
        this.lessonProgramId = lessonProgramId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public ArrayList<US21LessonNamePojo> getLessonName() {
        return lessonName;
    }

    public void setLessonName(ArrayList<US21LessonNamePojo> lessonName) {
        this.lessonName = lessonName;
    }

    public ArrayList<US21LessonProgramTeacherPojo> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<US21LessonProgramTeacherPojo> teachers) {
        this.teachers = teachers;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "US21LessonProgram{" +
                "lessonProgramId=" + lessonProgramId +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", lessonName=" + lessonName +
                ", teachers=" + teachers +
                ", day='" + day + '\'' +
                '}';
    }
}


