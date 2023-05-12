package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Us03_ResponsePojo {
 private Us03_ContactMessageDataPojo object;
 private String message;
 private String httpStatus;

    public Us03_ResponsePojo() {
    }

    public Us03_ResponsePojo(Us03_ContactMessageDataPojo object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Us03_ContactMessageDataPojo getObject() {
        return object;
    }

    public void setObject(Us03_ContactMessageDataPojo object) {
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
        return "Us03_ResponsePojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}

//{
//    "object": {
//        "name": "faruk1",
//        "email": "fgfg1@gmail.com",
//        "subject": "Eigene Meinung",
//        "message": "Aasdfg",
//        "date": "2023-04-19"
//    },
//    "message": "Contact Message Created Successfully",
//    "httpStatus": "CREATED"
//}