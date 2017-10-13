package Report.Oz.Erman.Model.Response;

public class Transaction {
    private MerchantTransaction merchant;

    public Transaction() {
        super();
    }

    public MerchantTransaction getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantTransaction merchant) {
        this.merchant = merchant;
    }

}
