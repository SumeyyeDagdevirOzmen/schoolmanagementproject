package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US25_StudentResponsePojo {
    private US25_StudentResponseDataPojo object;
    private String message;

    public US25_StudentResponsePojo() {
    }

    public US25_StudentResponsePojo(US25_StudentResponseDataPojo object, String message) {
        this.object = object;
        this.message = message;
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

    @Override
    public String toString() {
        return "US25_StudentResponsePojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                '}';
    }
}