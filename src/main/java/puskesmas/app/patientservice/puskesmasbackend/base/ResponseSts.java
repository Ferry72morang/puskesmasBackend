package puskesmas.app.patientservice.puskesmasbackend.base;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.apachecommons.CommonsLog;

@Data
@CommonsLog
@Accessors(chain = true)
public class ResponseSts<T> {
    private boolean success;
    private T data;
    private String message;
    private ErrorDto error;

    public static <T> ResponseSts<T> onFail(String message) {
        return onFail(message, null);
    }

    public static <T> ResponseSts<T> onFail(String message, ResponseSts<T> response) {
        if (response == null)
            response = new ResponseSts<>();
        response.setSuccess(false).setMessage(message);
        return response;
    }

    private static <T> ResponseSts<T> onSuccess(ResponseSts<T> response) {
        if (response == null)
            response = new ResponseSts<>();
        response.setSuccess(true);
        return response;
    }

    public static <T> ResponseSts<T> onSuccess(T data) {
        return onSuccess(data, null);
    }

    public static <T> ResponseSts<T> onSuccess(T data, ResponseSts<T> response) {
        return onSuccess(response).setData(data);
    }

}
