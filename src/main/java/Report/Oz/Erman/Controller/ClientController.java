package Report.Oz.Erman.Controller;


import Report.Oz.Erman.Model.Request.ClientRequest;
import Report.Oz.Erman.Model.Response.ClientResponse;
import Report.Oz.Erman.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ResponseEntity<ClientResponse> login(@RequestHeader(value = "Authorization", required = false) String authorization, @RequestHeader(value = "transactionId") String transactionId
    ) throws ServletException {
        ClientRequest clientRequest=new ClientRequest(transactionId);
        Optional<ClientResponse> response = clientService.getClientDetails(clientRequest,authorization);
        if(response.equals(Optional.empty())) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            return  new ResponseEntity(response,HttpStatus.OK);
        }

    }
}
