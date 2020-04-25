package Model.Authentication;
import Model.LoginUser;

public class LoginUserBuilder implements IBuilder {

    private String username;
    private String password;

    public LoginUserBuilder withUserName(String userName) {
        this.username = userName;
        return this;
    }
    public LoginUserBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    @Override
    public LoginUser build() {

        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(this.username);
        loginUser.setPassword(this.password);
        return loginUser;
    }
}