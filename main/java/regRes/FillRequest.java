package regRes;

public class FillRequest extends Request {

    private String username;
    private int generations;

    /**
     * creates new request with number of generations and the username of the
     * user associated with the request
     * @param username
     * @param generations
     */
    public FillRequest(String username, int generations){
        this.username = username;
        this.generations = generations;
    }
}
