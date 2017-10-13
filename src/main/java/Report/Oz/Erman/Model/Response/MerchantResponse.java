package Report.Oz.Erman.Model.Response;

public class MerchantResponse {
    private String token;
    private String status;

    public MerchantResponse() {
        super();
    }
    public MerchantResponse(String token) {
        this.token = token;
    }

    public MerchantResponse(String token, String status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
