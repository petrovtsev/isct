package ru.isct.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by ppetrovt on 19.01.2018.
 */
@Service
public class CbrService {

    private final static String URI = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=dd/MM/yyyy&date_req2=dd/MM/yyyy&VAL_NM_RQ=R01239";

    public Integer getRate() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(URI);
        CloseableHttpResponse response = client.execute(get);
        return 69;
    }
}
