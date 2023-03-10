package com.example.demo.service.impl;

import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepo;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public Account findAccountByAccountName(String accountName) {
        return accountRepo.findAccountByAccountName(accountName);
    }

    @Override
    public Long findAccountIdByAccountName(String accountName) {
        return accountRepo.findAccountIdByAccountName(accountName);
    }

    @Override
    public Boolean existsByAccountName(String accountName) {
        return accountRepo.existsByAccountName(accountName);
    }

    @Override
    public void addNew(String accountName, String password, String email) {
        accountRepo.addNew(accountName, password, email);
    }

    @Override
    public void editAccount(String email, String password, Long accountId) {
        accountRepo.editAccount(email, password, accountId);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepo.getAllAccount();
    }

    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepo.findAccountByEmail(email);
    }

    @Override
    public Boolean findAccountByResetPasswordToken(String token) {
        Account account = accountRepo.findAccountByResetPasswordToken(token);
        return account != null;
    }

    @Override
    public void saveNewPassword(String password, String token) {
        accountRepo.saveNewPassword(password, token);
    }

    @Override
    public void addResetPasswordToken(String accountName) throws UnsupportedEncodingException, MessagingException {

        String token = jwtTokenUtil.generateJwtToken(accountName);
        System.out.println("token reset password: " + token);

        if (token != null && jwtTokenUtil.validateJwtToken(token)) {

            System.out.println("token chưa hết hạn");

            accountRepo.addResetPassToken(token, accountName);
            Account account = accountRepo.findAccountByResetPasswordToken(token);

            System.out.println("Email: " + account.getEmail());
            System.out.println("accountName: " + account.getAccountName());
            System.out.println("Token: " + token);
            try {
                this.sendEmailForResetPassword(account.getAccountName(), token, account.getEmail());
            } catch (MessagingException e) {
                throw new MessagingException("Something went wrong in sending email");
            }

        }
    }


    @Override
    public void sendEmailForResetPassword(String accountName, String token, String email) throws UnsupportedEncodingException, MessagingException {
        String subject = "Yêu cầu cấp lại mật khẩu";
        String fromEmail = "a0421I1.codegym@gmail.com";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/verify-reset-password?token=" + token;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(fromEmail, "Cattle Management Support");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p>Xin chào " + accountName + ",</p>"
                + "<p> Bạn vừa yêu cầu cấp lại mật khẩu.</p>"
                + "<p> Nhấn vào link sau để thay đổi mật khẩu của bạn:</p>"
                + "<p><b><a href='" + confirmUrl + "'>Đổi mật khẩu (nhấn vào đây)!</a><b></p>"
                + "<br>"
                + "<p> Bỏ qua email này nếu bạn nhớ mật khẩu của bạn hoặc bạn không yêu cầu cấp lại mật khẩu. </p>"
                + "<p>Cattle Management Support</p>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }


}