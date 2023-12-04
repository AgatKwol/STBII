
package pl.akademiaqa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateSpaceTest {

private static final String TOKEN = "pk_44666415_BQ3MDY22FN79DULVOS49C7RI9UT3LO73";
private static final String BASE_URL = "https://api.clickup.com/api/v2";



@Test
    void createSpaceTest(){

     JSONObject space = new JSONObject();
     space.put("name", "JAVA SPACE");

    final var response = given() //oznaczenie var można wykorzystać zamiast podawania typu dla zmiennej lokalnej w sytuacji,
            // gdy zmienna ta jest od razu inicjalizowana.
            .header("Authorisation", TOKEN)
            .contentType(ContentType.JSON)
            .body(space.toString())
            .when()
            .post(BASE_URL + "/team/9005016801/space")
            .then()
            .extract()
            .response();

    Assertions.assertThat(response.statusCode()).isEqualTo(200);
    Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("JAVA SPACE");

    }
}
