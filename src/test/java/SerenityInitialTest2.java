import Model.Authentication.Content;
import Model.LoginUser;
import Questions.GetAuthenticationEmail;
import Questions.GetAuthenticationToken;
import Questions.ResponseCode;
import Task.PostRequest;
import Task.ValidateEmail;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Shared;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;


@RunWith(SerenityRunner.class)
public class SerenityInitialTest2 {

    public static String Url = "https://api-internal-sandbox.lulobank.com/stage";
    public static String Path = "/authentication";

    @Shared
    GetAuthenticationToken getAuthenticationToken;

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
        PostRequest postRequest1 = new PostRequest(Path, loginUser);

        List<Model.LoginUser> list = Arrays.asList(loginUser);
        String list1 = list.get(0).getUsername();

        List<String> list2 = list.stream()
                .map(s -> loginUser.getUsername())
                .collect(java.util.stream.Collectors.toList());

        //Actor Attempts to Post Request

        johnathan.attemptsTo(
                PostRequest.toAuthenticate());


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

        //obtain Content Email through last Response
        String authenticationResponse = SerenityRest.lastResponse().path("content.email");

        //Validate that Email is not Null
        johnathan.attemptsTo(
                Ensure.that(authenticationResponse).not().isEmpty());

        //Validate that Email start with T
        johnathan.attemptsTo(
                Ensure.that(authenticationResponse).startsWith("t"));

        //Map Content Authentication through GetAuthenticationToken Question
        Content contentAuthentication = new GetAuthenticationToken().answeredBy(johnathan).getContent();

        List<Content> obtainContentInfo = Arrays.asList(contentAuthentication);
        Content[] mycontent = {contentAuthentication};
        System.out.println("El contenido de Content" + obtainContentInfo.get(0).getLastName());

        assertThat("Validate Object property IDCLIEN",contentAuthentication,
                hasProperty("idClient",equalTo("1df8542a-b3ae-4e5b-a79d-97b624f74c23")));

        assertThat(contentAuthentication, hasProperty(
                "idClient",equalTo("0df8542a-b3ae-4e5b-a79d-97b624f74c23")));

        //Obtain Email
        String contentEmail = new GetAuthenticationToken().answeredBy(johnathan).getContent().getEmail();

        //Obtain Token
        String Token = new Questions.GetAuthenticationToken().answeredBy(johnathan).getAccessToken();

        //remember and Recall Functions
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