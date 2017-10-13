package Report.Oz.Erman.Model.Response;

public class AcquirerTransaction {
    private String acquirer;
    private String code;
    public AcquirerTransaction(){
        super();
    }
    public void setAcquirer(String acquirer){
        this.acquirer=acquirer;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
