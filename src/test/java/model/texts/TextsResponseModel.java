package model.texts;

import java.util.List;

public class TextsResponseModel {
    String status;
    int code;
    int total;
    List<Data> data;

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public int getTotal() {
        return total;
    }

    public List<Data> getData() {
        return data;
    }
}
