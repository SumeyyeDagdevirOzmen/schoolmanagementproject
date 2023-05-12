package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class MeetObjectPojo {
    public int id;
    public String description;
    public String date;
    public String startTime;
    public String stopTime;
    public int advisorTeacherId;
    public String teacherName;
    public String teacherSsn;
    public List<MeetStudentPojo> students;

    public MeetObjectPojo() {
    }

    public MeetObjectPojo(int id, String description, String date, String startTime, String stopTime, int advisorTeacherId, String teacherName, String teacherSsn, ArrayList<MeetStudentPojo> students) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.advisorTeacherId = advisorTeacherId;
        this.teacherName = teacherName;
        this.teacherSsn = teacherSsn;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getAdvisorTeacherId() {
        return advisorTeacherId;
    }

    public void setAdvisorTeacherId(int advisorTeacherId) {
        this.advisorTeacherId = advisorTeacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSsn() {
        return teacherSsn;
    }

    public void setTeacherSsn(String teacherSsn) {
        this.teacherSsn = teacherSsn;
    }

    public List<MeetStudentPojo> getStudents() {
        return students;
    }

    public void setStudents(List<MeetStudentPojo> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ObjectPojo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", advisorTeacherId=" + advisorTeacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSsn='" + teacherSsn + '\'' +
                ", students=" + students +
                '}';
    }
}
