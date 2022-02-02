package es.iespuertodelacruz.cc.institutorestclient.model.networking;

public enum HttpStatus {

    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not found"),
    NOT_ALLOWED(405, "Method not allowed");

    private int code;
    private String description;

    HttpStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int asCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
