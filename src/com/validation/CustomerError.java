package com.validation;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class CustomerError {

    boolean hasError;
    private String emailError;
    private String mobileNumberError;
    private String fullNameError;
    private String addressError;

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getMobileNumberError() {
        return mobileNumberError;
    }

    public void setMobileNumberError(String mobileNumberError) {
        this.mobileNumberError = mobileNumberError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }
}
