package Report.Oz.Erman.Model.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TransactionListRequest {
    private String fromDate;
    private String toDate;
    private String status;
    private String operation;
    private Integer merchantId;
    private Integer acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private Integer page;

    public TransactionListRequest () {

    }
    public TransactionListRequest (String fromDate,String toDate,String status,String operation,Integer merchantId,Integer acquirerId,String paymentMethod,String errorCode,String filterField,String filterValue,Integer page) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.operation = operation;
        this.merchantId = merchantId;
        this.acquirerId = acquirerId;
        this.paymentMethod = paymentMethod;
        this.errorCode = errorCode;
        this.filterField = filterField;
        this.filterValue = filterValue;
        this.page = page;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Integer acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getFilterField() {
        return filterField;
    }

    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
