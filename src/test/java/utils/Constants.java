package utils;

public class Constants {
    public static final String BASE_URL = "https://fakerapi.it";
    public static final String QUANTITY_URL = "/api/v1/texts?_quantity=";
    public static final String TEXTS_CHAR_URL = "/api/v1/texts?_quantity=1&_characters=";
    public static final String CUSTOM_URL = "/api/v1/custom?_quantity=1&name=name&lmd=dateTime&phoneNumber=phone&description=text";
    public static final String PRODUCT_URL = "/api/v1/products?_quantity=1&_taxes=12&_categories_type=";
    public static final int CHARACTER_SIZE = 200;
    public static final int QUANTITY = 2;

    public static final int STATUS_CODE_200 = 200;

    public static void messageText(String message) {
        System.out.println(message);
    }

}
