package Task;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateEmail implements Task {

    private String Email;

    public ValidateEmail(String email) {
        Email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.recall(Email);
    }
    public static ValidateEmail toEmail(){
        return instrumented(ValidateEmail.class);
    }
}
