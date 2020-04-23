package Task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Shared;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRequest implements Task {

    @Shared
    PostRequest postRequest;

    private String path;
    private Object userInfo;

    public PostRequest(String requestPath, Object requestUserInfo) {
        path = requestPath;
        userInfo = requestUserInfo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to(path)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .body(userInfo))
        );
    }
    public static PostRequest toAuthenticate(){
        return instrumented(PostRequest.class);
    }
}
