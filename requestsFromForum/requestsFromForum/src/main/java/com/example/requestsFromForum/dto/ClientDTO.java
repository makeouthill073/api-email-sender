package com.example.requestsFromForum.dto;

import javax.validation.constraints.*;

public class ClientDTO {

    @NotEmpty(message = "Поле не должно быть пустой!")
    @NotBlank
    private String firstName;

    @NotEmpty(message = "Поле не должно быть пустой!")
    @NotBlank
    private String lastName;

    @Size(min = 11, max = 12, message = "Напишите корректный номер! ")
    @NotEmpty(message = "Поле не должно быть пустой!")
    private String phoneNumber;

    @NotEmpty(message = "Поле не должно быть пустой!")
    @NotBlank
    private String organization;

    @NotEmpty(message = "Поле не должно быть пустой!")
    @Email
    @NotBlank
    private String mail;

    private String mstroy = "empty";

    private String mbusiness = "empty";

    private String mlogic = "empty";

    public ClientDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMstroy() {
        return mstroy;
    }

    public void setMstroy(String mstroy) {
        this.mstroy = mstroy;
    }

    public String getMbusiness() {
        return mbusiness;
    }

    public void setMbusiness(String mbusiness) {
        this.mbusiness = mbusiness;
    }

    public String getMlogic() {
        return mlogic;
    }

    public void setMlogic(String mlogic) {
        this.mlogic = mlogic;
    }
}
