package Questions;
import net.serenitybdd.screenplay.Question;
import Model.Authentication.Authentication;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.rest.SerenityRest;

public class GetAuthenticationToken implements Question {

    @Override
    public Authentication answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Authentication.class);
    }
}
