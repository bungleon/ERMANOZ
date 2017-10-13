package Report.Oz.Erman.Service;

import Report.Oz.Erman.Model.Request.ClientRequest;
import Report.Oz.Erman.Model.Response.ClientResponse;

import java.util.Optional;

public interface ClientService {
    Optional<ClientResponse> getClientDetails(ClientRequest request, String authorizationToken);
}
