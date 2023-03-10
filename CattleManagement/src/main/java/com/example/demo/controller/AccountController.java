package com.example.demo.controller;

import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.model.Account;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.ResetPasswordRequest;
import com.example.demo.payload.request.VerifyRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.ResponseMessage;
import com.example.demo.service.AccountService;
import com.example.demo.service.impl.AccountDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/public")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateAccount(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getAccountName().trim(), loginRequest.getPassword().trim()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenUtil.createToken(authentication);

        AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();

//        String token = jwtTokenUtil.doGenerateToken(accountDetails);
        return ResponseEntity.ok(
                new JwtResponse(
                        token,
                        accountDetails.getUsername(),
                        authentication.getAuthorities()
                ));
    }


    @PostMapping("/forgot-password")
    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException, MessagingException {
//        String accountName = loginRequest.getAccountName();
        String email = loginRequest.getEmail();
//        System.out.println("accountName in controller: " + accountName);
        System.out.println("email in controller: " + email);

        if (email != null){

                Account account = accountService.findAccountByEmail(email.trim());
                accountService.addResetPasswordToken(account.getAccountName());
                return ResponseEntity.ok(new ResponseMessage("Sent email "));

        }
//        else if (accountName != null){
//
//                Account account = accountService.findAccountByAccountName(accountName);
//                accountService.addResetPasswordToken(accountName);
//                return ResponseEntity.ok(new ResponseMessage("Sent email "));
//
//        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Tài khoản không đúng"));
        }

    }

    @PostMapping("/verify-password")
    public ResponseEntity<?> verifyPassword(@RequestBody VerifyRequest token) {
        Boolean isVerified = accountService.findAccountByResetPasswordToken(token.getToken());
        if (isVerified) {
            return ResponseEntity.ok(new ResponseMessage("accepted"));
        } else {
            return ResponseEntity.ok(new ResponseMessage("error"));
        }
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPasswordRequest resetPassRequest) {
        accountService.saveNewPassword(passwordEncoder.encode(resetPassRequest.getPassword()), resetPassRequest.getToken());
        return ResponseEntity.ok(new ResponseMessage("success"));
    }

}

