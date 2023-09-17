import org.example.APIData;
import org.example.Parameters;
import org.example.TestConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITests {
    private TestConfig config;
    private String photosURI;

    @BeforeMethod
    public void setup() {
        config = new TestConfig();
        photosURI = config.getPhotosURI();
    }

    @Test
    public void testMartialSolCount() {
        given()
                .param(Parameters.sol, APIData.sol)
                .param(Parameters.apiKey, config.getApiKey())
                .param(Parameters.page, APIData.page)
                .when()
                .get(photosURI)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(APIData.statusCode)
                .body(APIData.photosSize, equalTo(APIData.arraySize));
    }

    @Test
    public void testMastPhotosByCuriosity() {
        given()
                .param(Parameters.sol, APIData.sol)
                .param(Parameters.apiKey, config.getApiKey())
                .param(Parameters.camera, APIData.MastCamera)
                .when()
                .get(photosURI)
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(APIData.statusCode)
                .body(APIData.arrayName, not(empty()))
                .and()
                .body(APIData.roverName, everyItem(equalTo(APIData.perspectiveCuriosity)));
    }

}
