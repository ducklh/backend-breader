package com.example.demo.service;

import com.example.demo.model.Account;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface AccountService {

    Account findAccountByAccountName (String accountName);

    Long findAccountIdByAccountName(String accountName);

    Boolean existsByAccountName(String accountName);

    void addNew(String accountName, String password, String email);

    void editAccount(String email, String password, Long accountId);

    List<Account> getAllAccount();

    Account save(Account account);

    Account findAccountByEmail(String email);

    Boolean findAccountByResetPasswordToken(String token);

    void saveNewPassword(String password,String code);

    void addResetPasswordToken(String accountName) throws UnsupportedEncodingException, MessagingException;

    void sendEmailForResetPassword(String accountName, String token, String email) throws UnsupportedEncodingException, MessagingException;
}