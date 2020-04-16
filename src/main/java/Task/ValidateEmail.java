package Task;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

public class ValidateEmail implements Task {

    private String Email;

    public ValidateEmail(String email) {
        Email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.recall(Email);
    }
}
