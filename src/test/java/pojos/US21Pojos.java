package pojos;

public class US21Pojos {

    private US25_StudentResponseDataPojo object;
    private String message;
    private String httpStatus;


    public US21Pojos() {
    }

    public US21Pojos(US25_StudentResponseDataPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public US25_StudentResponseDataPojo getObject() {
        return object;
    }

    public void setObject(US25_StudentResponseDataPojo object) {
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
        return "US21Pojos{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
