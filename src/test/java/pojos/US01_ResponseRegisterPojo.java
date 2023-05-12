package pojos;

public class US01_ResponseRegisterPojo {
    private US01_RegisterPojo object;
    private String message;
    private String httpStatus;

    public US01_ResponseRegisterPojo() {
    }

    public US01_ResponseRegisterPojo(US01_RegisterPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public US01_RegisterPojo getObject() {
        return object;
    }

    public void setObject(US01_RegisterPojo object) {
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
        return "US01_ResponseRegisterPojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
