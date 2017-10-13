package Report.Oz.Erman.Service.Implementation;

import Report.Oz.Erman.APIURL;
import Report.Oz.Erman.Model.Request.MerchantRequest;
import Report.Oz.Erman.Model.Response.MerchantResponse;
import Report.Oz.Erman.Report.ReportLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import Report.Oz.Erman.Service.LoginService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Optional;

@Service("LoginService")
public class LoginServiceImplementation implements LoginService, Serializable {

    private final ReportLogin reportLogin;

    //@Autowired
    private final HttpSession httpSession;


    @Value("${email}")
    private String sampleUserEmail;

    @Value("${password}")
    private String sampleUserPassword;

    public LoginServiceImplementation(ReportLogin reportLogin, HttpSession httpSession) {
        this.reportLogin = reportLogin;
        this.httpSession = httpSession;
    }

    @Override
    public Optional<MerchantResponse> login(MerchantRequest login) {

        String loginUrl= APIURL.LOGIN.getUrl();
        MultiValueMap<String, String> requestMap = setUserCredentials(login.getEmail(), login.getPassword());
        Optional<MerchantResponse> response = reportLogin.login(loginUrl, requestMap);
        if (response.isPresent() && "APPROVED".equals(response.get().getStatus())) {
            httpSession.setAttribute("Authorization",response.get().getToken());
            return response;
        } else {
            return Optional.empty();
        }
    }


    private MultiValueMap<String, String> setUserCredentials(String email, String password) {


        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("email", email);
        requestMap.add("password", password);

        return requestMap;
    }
}
