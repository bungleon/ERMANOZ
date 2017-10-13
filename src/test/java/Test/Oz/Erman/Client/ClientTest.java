package Test.Oz.Erman.Client;


import Report.Oz.Erman.Model.Request.ClientRequest;
import Report.Oz.Erman.Model.Request.MerchantRequest;
import Report.Oz.Erman.Model.Response.ClientResponse;
import Report.Oz.Erman.Model.Response.MerchantResponse;
import Report.Oz.Erman.Report.ReportClient;
import Report.Oz.Erman.Report.ReportLogin;
import Report.Oz.Erman.Service.ClientService;
import Report.Oz.Erman.Service.Implementation.ClientServiceImplementation;
import Report.Oz.Erman.Service.Implementation.LoginServiceImplementation;
import Report.Oz.Erman.Service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {
    private ClientService clientService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    private void initMocks(){
        HttpSession httpSession=mock(HttpSession.class);
        clientService=new ClientServiceImplementation(new ReportClient());
    }
    @Test
    public void testClientSuccess(){
        initMocks();
        ClientRequest request=new ClientRequest("1-1444392550-1");
        Optional<ClientResponse> response = clientService.getClientDetails(request,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzOTc2NH0.8Cvmto78Y9CJdrPXYk5QwLKbkX0obalUPy9AMT1x1D4");
        Assert.assertNotNull(response);
    }
    @Test
    public void testClientSFailed(){
        initMocks();
        ClientRequest request=new ClientRequest("12356");
        Optional<ClientResponse> response = clientService.getClientDetails(request,"123");
        Assert.assertNotNull(response);
        Assert.assertEquals(response.get().getStatus(),"DECLINED");
    }
}
