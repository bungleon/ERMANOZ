package Test.Oz.Erman.Transaction;


import Report.Oz.Erman.Model.Request.TransactionGetRequest;
import Report.Oz.Erman.Model.Request.TransactionListRequest;
import Report.Oz.Erman.Model.Request.TransactionReportRequest;
import Report.Oz.Erman.Model.Response.TransactionGetResponse;
import Report.Oz.Erman.Model.Response.TransactionListResponse;
import Report.Oz.Erman.Model.Response.TransactionReportResponse;
import Report.Oz.Erman.Report.TransactionReport;
import Report.Oz.Erman.Service.Implementation.TransactionServiceImplementation;
import Report.Oz.Erman.Service.TransactionService;
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
public class TransactionTest {

    private TransactionService transactionService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    private void initMocks(){
        HttpSession httpSession=mock(HttpSession.class);
        transactionService=new TransactionServiceImplementation(new TransactionReport());
    }
    @Test
    public void testTansactionReportSuccess()  {
        initMocks();

        TransactionReportRequest request=new TransactionReportRequest("2015-07-01","2015-10-01",1,1);
        Optional<TransactionReportResponse> response = transactionService.prepareReport(request,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertNotNull(response);
    }
    @Test
    public void testTansactionReportFailed()  {
        initMocks();

        TransactionReportRequest request=new TransactionReportRequest("1015-07-01","1015-10-01",-1,-1);
        Optional<TransactionReportResponse> response = transactionService.prepareReport(request,"eyJ0eXAiQiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertEquals(response,Optional.empty());
    }


    @Test
    public void testTransactionListSuccess() {
        initMocks();

        TransactionListRequest request=new TransactionListRequest("2015-07-01","2015-10-01","APPROVED","DIRECT",1,1,"CREDITCARD","","Reference No","1-1568845-56",1);
        Optional<TransactionListResponse> response = transactionService.prepareList(request,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertNotNull(response);
    }

    @Test
    public void testTransactionListFailed() {
        initMocks();

        TransactionListRequest request=new TransactionListRequest("205-","201501","APVED","DECT",1,1,"CREDITCARD","","Reference No","1-1568845-56",1);
        Optional<TransactionListResponse> response = transactionService.prepareList(request,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertNull(response.get().getPerPage());
        Assert.assertNull(response.get().getData());
        Assert.assertNull(response.get().getTo());
    }

    @Test
    public void testTransactionGetSuccess() {
        initMocks();

        TransactionGetRequest request=new TransactionGetRequest("1-1444392550-1");
        Optional<TransactionGetResponse> response = transactionService.getTransaction(request,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJhZG1pbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertNotNull(response);
    }

    @Test
    public void testTransactionGetFailed() {
        initMocks();

        TransactionGetRequest request=new TransactionGetRequest("1-10-1");
        Optional<TransactionGetResponse> response = transactionService.getTransaction(request,"CI6NTpbiIsIm1lcmNoYW50SWQiOjMsInN1Yk1lcmNoYW50SWRzIjpbMyw3NCw5MywxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OF0sInRpbWVzdGFtcCI6MTUwNzgzNTgyOX0.57WbUld-b164-ufCH4TLCmYqng5hRUcgQUCJU-j4Ry4");
        Assert.assertNotNull(response);
        Assert.assertNull(response.get().getFx());
        Assert.assertNull(response.get().getAcquirerTransaction());
        Assert.assertNull(response.get().getCMerchantTransaction());
        Assert.assertNull(response.get().getCustomerInfo());
        Assert.assertNull(response.get().getMerchant());
    }
}
