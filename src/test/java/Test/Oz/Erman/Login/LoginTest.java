package Test.Oz.Erman.Login;
import Report.Oz.Erman.Model.Request.ClientRequest;
import Report.Oz.Erman.Model.Request.MerchantRequest;
import Report.Oz.Erman.Model.Response.ClientResponse;
import Report.Oz.Erman.Model.Response.MerchantResponse;
import Report.Oz.Erman.Report.ReportLogin;
import Report.Oz.Erman.Service.ClientService;
import Report.Oz.Erman.Service.Implementation.LoginServiceImplementation;
import Report.Oz.Erman.Service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    private LoginService loginService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    private void initMocks(){
        HttpSession httpSession=mock(HttpSession.class);
        loginService=new LoginServiceImplementation(new ReportLogin(),httpSession);
    }
    @Test
    public void testLoginSuccess(){
        initMocks();
        MerchantRequest request=new MerchantRequest("demo@bumin.com.tr","cjaiU8CV");
        Optional<MerchantResponse> response = loginService.login(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.get().getStatus(),"APPROVED");
        Assert.assertNotNull(response.get().getToken());
    }
    @Test
    public void testLoginFailed(){
        initMocks();
        MerchantRequest request=new MerchantRequest("fake@bumin.com.tr","123");
        Optional<MerchantResponse> response = loginService.login(request);
        Assert.assertNotNull(response);
        Assert.assertEquals(response,Optional.empty());
    }
}
