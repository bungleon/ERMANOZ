package Report.Oz.Erman.Model.Response;


import java.util.Date;

public class Data {
    private CustomerInfo customerInfo;
    private Date updatedAt;
    private Date createdAt;
    private Fx fx;
    private Acquirer acquirer;
    private Transaction transaction;
    private Boolean refundable;
    private Merchant merchant;
    private Ipn ipn;

    public Data() {
        super();
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Ipn getIpn() {
        return ipn;
    }

    public void setIpn(Ipn ipn) {
        this.ipn = ipn;
    }
}
