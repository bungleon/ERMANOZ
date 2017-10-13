package Report.Oz.Erman.Model.Response;

public class Merchant {
    private Integer id;
    private String name;
    private Boolean allowPartialRefund;
    private Boolean allowPartialCapture;

    public Merchant() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAllowPartialRefund() {
        return allowPartialRefund;
    }

    public void setAllowPartialRefund(Boolean allowPartialRefund) {
        this.allowPartialRefund = allowPartialRefund;
    }

    public Boolean getAllowPartialCapture() {
        return allowPartialCapture;
    }

    public void setAllowPartialCapture(Boolean allowPartialCapture) {
        this.allowPartialCapture = allowPartialCapture;
    }
}
