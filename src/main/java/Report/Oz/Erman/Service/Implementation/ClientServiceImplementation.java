package Report.Oz.Erman.Service.Implementation;

import Report.Oz.Erman.APIURL;
import Report.Oz.Erman.Model.Request.ClientRequest;
import Report.Oz.Erman.Model.Response.ClientResponse;
import Report.Oz.Erman.Report.ReportClient;
import Report.Oz.Erman.Service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.Optional;

@Service("ClientService")
public class ClientServiceImplementation implements ClientService,Serializable {


    private final ReportClient reportClient;

    @Value("${baseUrl}")
    private String baseUrl;

    public ClientServiceImplementation(ReportClient reportClient) {
        this.reportClient = reportClient;
    }


    @Override
    public Optional<ClientResponse> getClientDetails(ClientRequest request, String authorization){

        String loginUrl = APIURL.CLIENT.getUrl();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        MultiValueMap<String, String> requestMap = setTransactionId(request.getTransactionId());
        Optional<ClientResponse> response = reportClient.clientValue(loginUrl, requestMap);
        if (response.isPresent()){

            return response;
        }
        else {
            return Optional.empty();
        }
    }
    private MultiValueMap<String, String> setTransactionId(String transactionId) {


        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("transactionId", transactionId);


        return requestMap;
    }
}
