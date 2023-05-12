package pojos;

import io.cucumber.java.sl.In;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetPojo {

    private String date;
    private String description;
    private String startTime;
    private String stopTime;
    private List<Integer> studentIds;

    public MeetPojo() {
    }

    public MeetPojo(String date, String description, String startTime, String stopTime, List<Integer> studentIds) {
        this.date = date;
        this.description = description;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.studentIds = studentIds;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
       this.studentIds = studentIds;
    }

    @Override
    public String toString() {
        return "MeetPojo{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", studentIds=" + studentIds +
                '}';
    }
}
