package Report.Oz.Erman.Model.Request;

import java.util.Date;

public class TransactionReportRequest {
    private String fromDate;
    private String toDate;
    private Integer merchant;
    private Integer acquirer;

    public TransactionReportRequest(String fromDate,String toDate,Integer merchant,Integer acquirer) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.merchant = merchant;
        this.acquirer = acquirer;
    }
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Integer acquirer) {
        this.acquirer = acquirer;
    }

}
