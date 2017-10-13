package Report.Oz.Erman.Model.Request;

public class TransactionGetRequest {
    private String transactionId;

    public TransactionGetRequest() {
        super();
    }
    public TransactionGetRequest(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
