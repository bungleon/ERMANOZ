package Report.Oz.Erman.Model.Response;

public class TransactionGetResponse {
    private Fx fx;
    private CustomerInfo customerInfo;
    private AcquirerTransaction acquirerTransaction;
    private Merchant merchant;
    private MerchantTransaction merchantTransaction;

    public TransactionGetResponse() {
        super();
    }

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public AcquirerTransaction getAcquirerTransaction() {
        return acquirerTransaction;
    }

    public void setAcquirerTransaction(AcquirerTransaction acquirerTransaction) {
        this.acquirerTransaction = acquirerTransaction;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public MerchantTransaction getCMerchantTransaction() {
        return merchantTransaction;
    }

    public void setMerchantTransaction(MerchantTransaction merchantTransaction) {
        this.merchantTransaction = merchantTransaction;
    }
}
