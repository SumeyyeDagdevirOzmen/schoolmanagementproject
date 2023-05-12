package pojos;

public class US08_ResponseLesPojo {

    private US08_ResponseLesPojo object;
    private String message;
    private String httpStatus;

    public US08_ResponseLesPojo() {
    }

    public US08_ResponseLesPojo(US08_ResponseLesPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public US08_ResponseLesPojo getObject() {
        return object;
    }

    public void setObject(US08_ResponseLesPojo object) {
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
        return "US08_ResponseLes{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }



    }




















