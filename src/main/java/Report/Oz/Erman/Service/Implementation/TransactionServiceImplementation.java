package Report.Oz.Erman.Service.Implementation;

import Report.Oz.Erman.APIURL;
import Report.Oz.Erman.Model.Request.TransactionGetRequest;
import Report.Oz.Erman.Model.Request.TransactionListRequest;
import Report.Oz.Erman.Model.Request.TransactionReportRequest;
import Report.Oz.Erman.Model.Response.TransactionGetResponse;
import Report.Oz.Erman.Model.Response.TransactionListResponse;
import Report.Oz.Erman.Model.Response.TransactionReportResponse;
import Report.Oz.Erman.Report.TransactionReport;
import Report.Oz.Erman.Service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Service("TransactionService")
public class TransactionServiceImplementation implements TransactionService,Serializable {


    private final TransactionReport reportTransaction;

    @Value("${baseUrl}")
    private String baseUrl;

    public TransactionServiceImplementation(TransactionReport reportTransaction) {
        this.reportTransaction = reportTransaction;
    }

    @Override
    public Optional<TransactionReportResponse> prepareReport(TransactionReportRequest request,String authorization) {
        String reportUrl = APIURL.TRANSACTIONREPORT.getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        MultiValueMap<String, String> requestMap = setTransactionList(request.getToDate(), request.getFromDate(),request.getMerchant(),request.getAcquirer());
        Optional<TransactionReportResponse> response = reportTransaction.prepareReport(reportUrl,requestMap);
        if (response.isPresent()&& "APPROVED".equals(response.get().getStatus())){

            return response;
        }
        else {
            return Optional.empty();
        }
    }
    @Override
    public Optional<TransactionListResponse> prepareList(TransactionListRequest request,String authorization) {
        String reportUrl = APIURL.TRANSACTIONLIST.getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        MultiValueMap<String, String> requestMap = setTransactionList(request);
        Optional<TransactionListResponse> response=reportTransaction.prepareList(reportUrl,requestMap);
        if (response.isPresent()){

            return response;
        }
        else {
            return Optional.empty();
        }
    }
    @Override
    public Optional<TransactionGetResponse> getTransaction(TransactionGetRequest request, String authorization) {
        String reportUrl = APIURL.TRANSACTION.getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        MultiValueMap<String, String> requestMap = setTransactionGet(request);
        Optional<TransactionGetResponse> response=reportTransaction.getTransaction(reportUrl,requestMap);
        if (response.isPresent()){

            return response;
        }
        else {
            return Optional.empty();
        }
    }

    private MultiValueMap<String, String> setTransactionList(String fromDate, String toDate,Integer merchant,Integer acquirer) {

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("fromDate", fromDate);
        requestMap.add("toDate", toDate);
        requestMap.add("merchant", merchant.toString());
        requestMap.add("acquirer", acquirer.toString());
        return requestMap;
    }
    private MultiValueMap<String, String> setTransactionList(TransactionListRequest request) {

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("fromDate", request.getFromDate().toString());
        requestMap.add("toDate", request.getToDate().toString());
        requestMap.add("status", request.getStatus() );
        requestMap.add("operation", request.getOperation());
        requestMap.add("merchantId", request.getMerchantId().toString());
        requestMap.add("acquirerId", request.getAcquirerId().toString());
        requestMap.add("paymentMethod", request.getPaymentMethod());
        requestMap.add("errorCode", request.getErrorCode());
        requestMap.add("filterField", request.getFilterField());
        requestMap.add("filterValue", request.getFilterValue());
        requestMap.add("page", request.getPage().toString());

        return requestMap;
    }
    private MultiValueMap<String, String> setTransactionGet(TransactionGetRequest request) {

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("transactionId", request.getTransactionId());
        return requestMap;
    }
}
