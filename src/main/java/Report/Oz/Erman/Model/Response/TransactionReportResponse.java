package Report.Oz.Erman.Model.Response;


import java.util.List;

public class TransactionReportResponse {
    private String status;

    private List<TransactionReport> response;

    public TransactionReportResponse() {
        super();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionReport> getTransactionReportList() {
        return response;
    }

    public void setResponse(List<TransactionReport> transactionReportList) {
        this.response = transactionReportList;
    }
}
