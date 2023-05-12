package pojos;

public class US06_ResponsePojo {

    private String httpStatus;
    private String message;
    private US06_ObjectPojo object;

    public US06_ResponsePojo() {
    }

    public US06_ResponsePojo(String httpStatus, String message, US06_ObjectPojo object) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.object = object;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public US06_ObjectPojo getObject() {
        return object;
    }

    public void setObject(US06_ObjectPojo object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "US06_ResponsePojo{" +
                "httpStatus='" + httpStatus + '\'' +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
