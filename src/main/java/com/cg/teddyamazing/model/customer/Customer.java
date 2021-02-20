package com.cg.teddyamazing.model.customer;

import org.aspectj.bridge.IMessage;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "please input your first name")
    @Size(min=1,max=20)
    private String firstName;

    @NotEmpty(message = "please input your last name")
    @Size(min=1,max=20)
    private String lastName;

    @Size(min=1,max=50)
    private String address;

    @Size(min=10,max=11,message = "so dien thoai phai co 10 hoac 11 so")
    @NumberFormat()
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(Long id,String firstName,String lastName,String address,String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}




