package com.gerenciador.senha_segura.controller;


import com.gerenciador.senha_segura.service.PasswordService;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(value = "/validade-password")
    public ResponseEntity<FailureResponse> validadePassword(@RequestBody BodyRequest request){

        var failures = passwordService.validatePass(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

}
