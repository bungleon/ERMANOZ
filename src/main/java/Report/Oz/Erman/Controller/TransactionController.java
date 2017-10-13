package Report.Oz.Erman.Controller;

import Report.Oz.Erman.Service.TransactionService;
import Report.Oz.Erman.Model.Request.TransactionGetRequest;
import Report.Oz.Erman.Model.Request.TransactionListRequest;
import Report.Oz.Erman.Model.Request.TransactionReportRequest;
import Report.Oz.Erman.Model.Response.TransactionGetResponse;
import Report.Oz.Erman.Model.Response.TransactionListResponse;
import Report.Oz.Erman.Model.Response.TransactionReportResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletException;
import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<TransactionReportResponse> reportTransaction(@RequestHeader(value="Authorization", required = false)String authorization, TransactionReportRequest request
    ) throws ServletException {
        if (StringUtils.isEmpty(authorization)) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        Optional<TransactionReportResponse> response = transactionService.prepareReport(request,authorization);

        if(response.equals(Optional.empty())) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            return  new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<TransactionListResponse> listTransaction(@RequestHeader(value="Authorization", required = false)String authorization, TransactionListRequest request
    ) throws ServletException {
        if (StringUtils.isEmpty(authorization)) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        Optional<TransactionListResponse> response = transactionService.prepareList(request,authorization);
        if(response.equals(Optional.empty())) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            return  new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity<TransactionGetResponse> getTransaction(@RequestHeader(value="Authorization", required = false)String authorization, TransactionGetRequest request
    ) throws ServletException {
        if (StringUtils.isEmpty(authorization)) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        Optional<TransactionGetResponse> response = transactionService.getTransaction(request,authorization);
        if(response.equals(Optional.empty())) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            return  new ResponseEntity(response,HttpStatus.OK);
        }
    }
}
