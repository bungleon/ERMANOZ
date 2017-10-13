package Report.Oz.Erman.Controller;
import Report.Oz.Erman.Service.LoginService;
import Report.Oz.Erman.Model.Response.MerchantResponse;
import Report.Oz.Erman.Model.Request.MerchantRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Optional;


@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<MerchantResponse> login(MerchantRequest request
    ) throws ServletException {
        Optional<MerchantResponse> response = loginService.login(request);

        if(response.equals(Optional.empty())) {
            return  new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            return  new ResponseEntity(response,HttpStatus.OK);
        }
    }
}
