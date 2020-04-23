package Questions;
import net.serenitybdd.screenplay.Question;
import Model.Authentication.Authentication;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import Questions.GetAuthenticationToken;

public class GetAuthenticationToken implements Question {

    @Shared
    GetAuthenticationToken getAuthenticationToken;

    @Override
    public Authentication answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Authentication.class);
    }
}
