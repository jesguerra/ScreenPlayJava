import Model.Authentication.Content;
import Model.LoginUser;
import Questions.GetAuthenticationToken;
import Questions.ResponseCode;
import Task.PostRequest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.runner.RunWith;
import Questions.GetAuthenticationEmail;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import Task.ValidateEmail;


@RunWith(SerenityRunner.class)
public class SerenityInitialTest2 {

    public static String Url = "https://api-internal-sandbox.lulobank.com/stage";
    public static String Path = "/authentication";

    @org.junit.Test
    public void encryption() {

        Actor johnathan = Actor.named("Johnathan el tester")
                .describedAs("Es el que ejecuta la prueba")
                .whoCan(net.serenitybdd.screenplay.rest.abilities.CallAnApi.at(Url));

        //Create Login Object
        LoginUser loginUser = new LoginUser();
        loginUser.setPassword("654321");
        loginUser.setUsername("tae_mslew@mailinator.com");

        //Create Object PostRequest
        PostRequest postRequest = new PostRequest(Path, loginUser);

        //Actor Attempts to Post Request
        johnathan.attemptsTo(
                postRequest);

        //Validate Code Response
        johnathan.should(
                seeThat("validate that response is :",
                        new ResponseCode(), equalTo(200))
        );

        //Validate that Content.Email
        johnathan.should(
                seeThatResponse("validate Contain Email",
                        response -> response.body("content.email", equalTo("tae_mslew@mailinator.com"))));
        //Validate that Content.Name
        johnathan.should(
                seeThatResponse("validate Contain Name",
                        response -> response.body("content.name", equalTo("TAE NOM ZNKSZ"))));

        //Validate Lambda Expression
        johnathan.should(
                seeThatResponse("Validate other thing",
                        validateResponse -> validateResponse.statusCode(200))
        );

        //Validate through GetAuthentication Question
        johnathan.should(
                seeThat(new GetAuthenticationEmail(), is("tae_mslew@mailinator.com")));

        //Obtaind Content Email through last Response
        String authenticationResponse = SerenityRest.lastResponse().path("content.email");

        //Validate that Email is not Null
        johnathan.attemptsTo(
                Ensure.that(authenticationResponse).not().isEmpty());

        //Validate that Email start with T
        johnathan.attemptsTo(
                Ensure.that(authenticationResponse).startsWith("t"));

        //Map Content Authentication through GetAuthenticationToken Question
        Content contentAuthentication = new GetAuthenticationToken().answeredBy(johnathan).getContent();

        //Obtain Email
        String contentEmail = new GetAuthenticationToken().answeredBy(johnathan).getContent().getEmail();

        //Obtain Token
        String Token = new Questions.GetAuthenticationToken().answeredBy(johnathan).getAccessToken();


        //Remeber and Recall Functions
        String cualquiercosa = null;
        johnathan.remember(cualquiercosa, new GetAuthenticationEmail());

        String emailCualquiera = johnathan.recall(cualquiercosa);

        System.out.println("Print anywhere Email : " + emailCualquiera);

        ValidateEmail validateEmail = new ValidateEmail(johnathan.recall(emailCualquiera));

        johnathan.attemptsTo(
                validateEmail
        );
    }
}