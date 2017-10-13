package Report.Oz.Erman.Model.Request;

public class ClientRequest {
    private String transactionId;

    public ClientRequest() {
        super();
    }
    public ClientRequest(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
