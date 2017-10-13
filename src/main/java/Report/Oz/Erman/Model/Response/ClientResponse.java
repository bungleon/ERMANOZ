package Report.Oz.Erman.Model.Response;

public class ClientResponse {
    private String status;
    private CustomerInfo customerInfo;

    public ClientResponse() {
        super();
    }
    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }
    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
    public void serStatus(String status){
        this.status=status;
    }
    public String getStatus() {
        return  status;
    }
}
