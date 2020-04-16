package Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.rest.SerenityRest;

public class GetAuthenticationEmail implements Question {


    public GetAuthenticationEmail() {
    }

    @Override
    public String answeredBy(Actor actor) {
        String authenticationResponse = SerenityRest.lastResponse().path("content.email");
        return authenticationResponse;
    }
}
