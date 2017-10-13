package Report.Oz.Erman.Model.Response;

public class Fx {
    private Integer originalAmount;
    private String originalCurrency;
    private Integer convertedAmount;
    private String convertedCurrency;

    public Fx() {
        super();
    }

    public Integer getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Integer originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public Integer getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Integer convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getConvertedCurrency() {
        return convertedCurrency;
    }

    public void setConvertedCurrency(String convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }
}
