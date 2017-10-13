package Report.Oz.Erman.Service;

import Report.Oz.Erman.Model.Request.MerchantRequest;
import Report.Oz.Erman.Model.Response.MerchantResponse;

import java.util.Optional;

public interface LoginService {

    Optional<MerchantResponse> login(MerchantRequest login);
}
