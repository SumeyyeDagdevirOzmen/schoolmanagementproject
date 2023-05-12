package pojos;

public class StudentInfoExpectedPojo {

        private Integer absentee;
        private Integer educationTermId;
        private Double finalExam;
        private String infoNote;
        private Integer lessonId;
        private Double midtermExam;
        private Integer studentId;

    public StudentInfoExpectedPojo() {
    }

    public StudentInfoExpectedPojo(Integer absentee, Integer educationTermId, Double finalExam, String infoNote, Integer lessonId, Double midtermExam, Integer studentId) {
        this.absentee = absentee;
        this.educationTermId = educationTermId;
        this.finalExam = finalExam;
        this.infoNote = infoNote;
        this.lessonId = lessonId;
        this.midtermExam = midtermExam;
        this.studentId = studentId;
    }

    public Integer getAbsentee() {
        return absentee;
    }

    public void setAbsentee(Integer absentee) {
        this.absentee = absentee;
    }

    public Integer getEducationTermId() {
        return educationTermId;
    }

    public void setEducationTermId(Integer educationTermId) {
        this.educationTermId = educationTermId;
    }

    public Double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Double finalExam) {
        this.finalExam = finalExam;
    }

    public String getInfoNote() {
        return infoNote;
    }

    public void setInfoNote(String infoNote) {
        this.infoNote = infoNote;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public Double getMidtermExam() {
        return midtermExam;
    }

    public void setMidtermExam(Double midtermExam) {
        this.midtermExam = midtermExam;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentInfoExpectedPojo{" +
                "absentee=" + absentee +
                ", educationTermId=" + educationTermId +
                ", finalExam=" + finalExam +
                ", infoNote='" + infoNote + '\'' +
                ", lessonId=" + lessonId +
                ", midtermExam=" + midtermExam +
                ", studentId=" + studentId +
                '}';
    }
}

