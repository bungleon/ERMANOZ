package Report.Oz.Erman.Report;


import Report.Oz.Erman.Model.Response.MerchantResponse;
import Report.Oz.Erman.Model.Response.TransactionGetResponse;
import Report.Oz.Erman.Model.Response.TransactionListResponse;
import Report.Oz.Erman.Model.Response.TransactionReportResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TransactionReport {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Optional<TransactionReportResponse> prepareReport(String loginUrl, MultiValueMap<String, String> requestMap){
        RestTemplate restTemplate = new RestTemplate();
        TransactionReportResponse response=null;
        try{
            response = restTemplate.postForObject(loginUrl, requestMap, TransactionReportResponse.class);
        }catch (Exception e){
            logger.error("Exception occured while waiting server respond",e);
        }
        return Optional.ofNullable(response);
    }
    public Optional<TransactionListResponse> prepareList(String loginUrl, MultiValueMap<String, String> requestMap){
        RestTemplate restTemplate = new RestTemplate();
        TransactionListResponse response=null;
        try{
            response = restTemplate.postForObject(loginUrl, requestMap, TransactionListResponse.class);
        }catch (Exception e){
            logger.error("Exception occured while waiting server respond",e);
        }
        return Optional.ofNullable(response);
    }
    public Optional<TransactionGetResponse> getTransaction(String loginUrl, MultiValueMap<String, String> requestMap){
        RestTemplate restTemplate = new RestTemplate();
        TransactionGetResponse response=null;
        try{
            response = restTemplate.postForObject(loginUrl, requestMap, TransactionGetResponse.class);
        }catch (Exception e){
            logger.error("Exception occured while waiting server respond",e);
        }
        return Optional.ofNullable(response);
    }

}
