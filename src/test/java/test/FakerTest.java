package test;

import com.google.gson.Gson;
import io.restassured.response.Response;
import model.texts.Data;
import model.texts.TextsResponseModel;
import utils.Constants;
import network.Network;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.UUID;

public class FakerTest {

    private Response response1;
    private Gson gson ;
    private String url ;
    private String result;
    TextsResponseModel apiTests;
    public FakerTest() {
        gson = new Gson();
    }

    @Test
    public void characterControlforTexts() {
        //Texts endpointindeki content alanında, character fieldına atılan istek kadar karakter dönüp dönmediğinin kontrülü
        url = Constants.TEXTS_CHAR_URL + Constants.CHARACTER_SIZE;
        response1 = Network.getInstance().getList(url);
        result = response1.jsonPath().prettyPrint();
        apiTests = gson.fromJson(result, TextsResponseModel.class);
        if (response1.statusCode() == Constants.STATUS_CODE_200) {
            Constants.messageText("Statü kodu 200, başarılı.");
            for (Data data : apiTests.getData()) {
                AssertJUnit.assertEquals(Constants.CHARACTER_SIZE, data.getContent().length());
            }
        }
    }

    @Test
    public void quantityControlforTexts() {
        //Texts endpointinde, quantity kadar veri dönüp dönmediğinin kontrolü.
        url = Constants.QUANTITY_URL + Constants.QUANTITY;
        response1 = Network.getInstance().getList(url);
        result = response1.jsonPath().prettyPrint();
        apiTests = gson.fromJson(result, TextsResponseModel.class);
        result = response1.jsonPath().prettyPrint();
        if (response1.statusCode() == Constants.STATUS_CODE_200) {
            Constants.messageText("Statü kodu 200, başarılı.");
            AssertJUnit.assertEquals(Constants.QUANTITY, apiTests.getTotal());
        }
    }

    @Test
    public void fieldTestforTexts() {
        //Texts endpointindeki datalarda, title, author, genre ve content alanlarının gelip gelmediğinin kontrolü.
        url = Constants.QUANTITY_URL + Constants.QUANTITY;
        response1 = Network.getInstance().getList(url);
        result = response1.jsonPath().prettyPrint();
        apiTests = gson.fromJson(result, TextsResponseModel.class);
        if (response1.statusCode() == Constants.STATUS_CODE_200) {
            Constants.messageText("Statü kodu 200, başarılı." + "\n");
            for (Data data : apiTests.getData()) {

                if (!data.getTitle().isEmpty()) {
                    System.out.println("Title alanı geldi.");
                } else {
                    System.out.println("Hata! Title alanı gelmedi.");
                }
                if (!data.getAuthor().isEmpty()) {
                    System.out.println("Author alanı geldi.");
                } else {
                    System.out.println("Hata! Author alanı gelmedi.");
                }
                if (!data.getGenre().isEmpty()) {
                    System.out.println("Genre alanı geldi.");
                } else {
                    System.out.println("Hata! Genre alanı gelmedi.");
                }
                if (!data.getContent().isEmpty()) {
                    System.out.println("Content alanı geldi." + "\n");
                } else {
                    System.out.println("Hata! Content alanı gelmedi." + "\n");
                }
            }
        }
    }
    @Test
    public void customUrlControl() {
        //Custom url oluşturup data gelip gelmediğini kontrol etme
        url = Constants.CUSTOM_URL;
        response1 = Network.getInstance().getList(url);
        result = response1.jsonPath().prettyPrint();
        if (response1.statusCode() == Constants.STATUS_CODE_200) {
            Constants.messageText("Statü kodu 200, başarılı.");
           if (response1 != null) {
             Constants.messageText("Response başarılı bir şekilde geldi.");
           }
        }
    }

    @Test
    public void getRandomProduct() {
        //Product endpointinden random ürün alma ve kontrol etme
        UUID uuid = UUID.randomUUID();
        url = Constants.PRODUCT_URL + uuid;
        response1 = Network.getInstance().getList(url);
        if (response1.statusCode() == Constants.STATUS_CODE_200) {
            Constants.messageText("Statü kodu 200, başarılı.");
            if (response1 != null) {
                Constants.messageText(response1.prettyPrint());
            }
        }
    }
}
