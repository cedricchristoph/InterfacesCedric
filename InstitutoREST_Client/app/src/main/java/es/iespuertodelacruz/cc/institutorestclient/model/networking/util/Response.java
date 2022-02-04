package es.iespuertodelacruz.cc.institutorestclient.model.networking.util;

public class Response {


    public static Response send(boolean isError, String message, Object body) {
        return new Response(isError, message, body);
    }

    public static Response send(boolean isError, String message) {
        return new Response(isError, message);
    }


    private boolean isError;
    private String message;
    private Object body;

    public Response() {
    }

    public Response(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
    }

    public Response(boolean isError, String message, Object body) {
        this.isError = isError;
        this.message = message;
        this.body = body;
    }


    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
