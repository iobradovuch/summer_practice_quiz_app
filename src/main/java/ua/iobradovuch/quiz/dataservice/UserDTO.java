package ua.iobradovuch.quiz.dataservice;

import jakarta.validation.constraints.NotEmpty;
import ua.iobradovuch.quiz.service.FieldMatch;

@FieldMatch.List( { @FieldMatch(first = "password", second = "secondPassword" , message = "Passwords must match!") } )
public class UserDTO {
    @NotEmpty
    private String userName;
    @NotEmpty(message = "Required")
    private String password;
    @NotEmpty(message = "Required")
    private String secondPassword;
    public UserDTO(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public UserDTO(@NotEmpty String userName, @NotEmpty(message = "Required") String password, @NotEmpty(message = "Required") String secondPassword) {
        this.userName = userName;
        this.password = password;
        this.secondPassword = secondPassword;
    }
}
