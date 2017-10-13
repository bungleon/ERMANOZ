package Report.Oz.Erman;

public enum APIURL {

    LOGIN("https://sandbox-reporting.rpdpymnt.com/api/v3/merchant/user/login"),
    TRANSACTIONREPORT("https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report"),
    TRANSACTIONLIST("https://sandbox-reporting.rpdpymnt.com/api/v3/transaction/list"),
    TRANSACTION("https://sandbox-reporting.rpdpymnt.com/api/v3/transaction"),
    CLIENT("https://sandbox-reporting.rpdpymnt.com/api/v3/client");

    private String url;

    APIURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
