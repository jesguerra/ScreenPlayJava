import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PruebaTester {

    public void validateText(){
        String example1 = "Bruce";
        String example2 = "BruceAlexander";
        System.out.println("empezando validación de Prueba Tester");
        assertThat(example1, equalTo(example2));
    }
}
