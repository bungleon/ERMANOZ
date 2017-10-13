package Report.Oz.Erman.Service;

import Report.Oz.Erman.Model.Request.TransactionGetRequest;
import Report.Oz.Erman.Model.Request.TransactionListRequest;
import Report.Oz.Erman.Model.Request.TransactionReportRequest;
import Report.Oz.Erman.Model.Response.TransactionGetResponse;
import Report.Oz.Erman.Model.Response.TransactionListResponse;
import Report.Oz.Erman.Model.Response.TransactionReportResponse;

import java.util.Optional;

public interface TransactionService {
    Optional<TransactionReportResponse> prepareReport(TransactionReportRequest request,String authorization);

    Optional<TransactionListResponse> prepareList(TransactionListRequest request,String authorization);

    Optional<TransactionGetResponse> getTransaction(TransactionGetRequest request, String authorization);
}
