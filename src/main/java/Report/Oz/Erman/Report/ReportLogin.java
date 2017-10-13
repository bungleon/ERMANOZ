package Report.Oz.Erman.Report;

import Report.Oz.Erman.Model.Response.MerchantResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class ReportLogin {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Optional<MerchantResponse> login(String loginUrl, MultiValueMap<String, String> requestMap) {
        RestTemplate restTemplate = new RestTemplate();
        MerchantResponse response=null;
        try{
            response = restTemplate.postForObject(loginUrl, requestMap, MerchantResponse.class);
        }catch (Exception e) {
            logger.error("Exception occured while waiting server respond", e);
        }
        return Optional.ofNullable(response);
    }
}

