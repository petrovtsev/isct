package ru.isct.service;

import org.springframework.stereotype.Service;

/**
 * Created by ppetrovt on 19.01.2018.
 */
@Service
public class CbrService {

    private final static String URI = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=dd/MM/yyyy&date_req2=dd/MM/yyyy&VAL_NM_RQ=R01239";

    public Integer getRate(){
        return 69;
    }
}
