package ru.isct.service;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import ru.isct.data.Guest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppetrovt on 21.01.2018.
 */
@Service
public class SberbankService {

    private final String URI_BANK_API = "https://3dsec.sberbank.ru/payment/rest/register.do";
    private final String URI_SUCCESS = "http://85.143.217.34/success.xhtml?";
    private final String URI_FAIL = "http://85.143.217.34/error.xhtml";
    private final String USERNAME = "isct_2018-api";
    private final String PASSWORD = "isct_2018";
    private final String CURRENCY_RUB = "643";

    public String payment(Guest guest) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URI_BANK_API);
        Integer price = guest.getPrice() * 100;
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("userName", USERNAME));
        params.add(new BasicNameValuePair("password", PASSWORD));
        params.add(new BasicNameValuePair("orderNumber", guest.getId().toString()));
        params.add(new BasicNameValuePair("amount", price.toString()));
        params.add(new BasicNameValuePair("currency", CURRENCY_RUB));
        //TODO change
        String url = URI_SUCCESS + "id=" + guest.getId() + "&key=" + guest.getHash();
//        params.add(new BasicNameValuePair("language", locale));
        params.add(new BasicNameValuePair("returnUrl", url));
        params.add(new BasicNameValuePair("failUrl", URI_FAIL));
        params.add(new BasicNameValuePair("description", guest.getGuestType().getNameEn()));
        httpPost.addHeader("accept", "application/json");
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = client.execute(httpPost);

        String json = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        ResponseSB responseSB = gson.fromJson(json, ResponseSB.class);
        client.close();

        //TODO remove
        System.out.println(responseSB.formUrl);

        if (responseSB.formUrl != null) {
            return responseSB.formUrl;
        } else {
            throw new IOException(responseSB.errorMessage);
        }
    }

    class ResponseSB {

        @Getter
        @Setter
        private String orderId;

        @Getter
        @Setter
        private String formUrl;

        @Getter
        @Setter
        private String errorMessage;

        @Getter
        @Setter
        private String errorCode;
    }
}
