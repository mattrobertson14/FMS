package regRes;

public class Response {
    private String message = null;

    /**
     * @return String message (success/failure)
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
