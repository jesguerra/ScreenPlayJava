package Model.Authentication;

public class Content {
    private String idClient;
    private String email;
    private Boolean emailVerified;
    private String name;
    private String lastName;
    private String idCard;
    private String nickname;
    private String phoneNumber;
    private Model.Authentication.Tokens tokens;
    private String previousSuccessfulLogin;
    private String checkpoint;
    private String productSelected;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Model.Authentication.Tokens getTokens() {
        return tokens;
    }

    public void setTokens(Model.Authentication.Tokens tokens) {
        this.tokens = tokens;
    }

    public String getPreviousSuccessfulLogin() {
        return previousSuccessfulLogin;
    }

    public void setPreviousSuccessfulLogin(String previousSuccessfulLogin) {
        this.previousSuccessfulLogin = previousSuccessfulLogin;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(String productSelected) {
        this.productSelected = productSelected;
    }
}
