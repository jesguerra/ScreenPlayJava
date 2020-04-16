import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Main {


    public void tester(){
        System.out.println("Welcome to Jungle");
        String tester1 = "example";
        String tester2 = "example";
        assertThat(tester1,equalTo(tester2));
    }

    @org.junit.Test
    public void executeTest(){
        tester();
    }
}
