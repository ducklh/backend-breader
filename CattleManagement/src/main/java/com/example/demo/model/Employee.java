package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "{employeeId.empty}")
    private String employeeId;

    @Column(columnDefinition = "VARCHAR(255)")
    @Size(min = 2, max = 50)
    @NotBlank(message = "{employeeName.empty}")
    private String employeeName;

    @Column(columnDefinition = "VARCHAR(255)")
    @Email(message = "Phải đúng định dạng Email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{employeeBirthday.empty}")
    private LocalDate birthday;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotNull(message = "{employeeGender.empty}")
    private String gender;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "{employeeIdCard.empty}")
    private String idCard;

    @Column(columnDefinition = "VARCHAR(255)")
    private String avatar;

    private Boolean isDelete;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotNull(message = "{employeeAddress.empty}")
    private String address;

    //    mot role
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private Account account;

    //    mot news
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "JsonBackNews")
    private Set<News> news;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "JsonBackCage")
    private Set<Cage> cage;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "JsonBackNewsComment")
    private Set<NewsComment> newsComments;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeContact", cascade = CascadeType.REMOVE)
//    @JsonBackReference(value = "EmployeeToCustomer")
//    private Set<Customer> customers;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    public Set<Cage> getCage() {
        return cage;
    }

    public void setCage(Set<Cage> cage) {
        this.cage = cage;
    }

}
