package api.pojo;

public class LoginErrors {
    private String key;
    private String message;

    public LoginErrors(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
