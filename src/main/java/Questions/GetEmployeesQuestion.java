package Questions;
import net.serenitybdd.screenplay.Question;
import Model.Employees;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

public class GetEmployeesQuestion implements Question {

    @Override
    public Employees answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Employees.class);
    }
}
