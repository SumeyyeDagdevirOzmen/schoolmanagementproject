package pojos;

public class US09_ResponseLesson {
    private US09_LessonObject object;
    private String message;
    private String httpStatus;

    public US09_ResponseLesson() {
    }

    public US09_ResponseLesson(US09_LessonObject object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public US09_LessonObject getObject() {
        return object;
    }

    public void setObject(US09_LessonObject object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "US09_ResponseLesson{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
