package ru.isct.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by ppetrovt on 09.01.2018.
 */
@Getter
@Setter
public class GuestType {

    private Integer id;

    private String nameEn;

    private String nameRu;

    private Integer price;

    private Integer priceRu;

    private Boolean member;

    private List<Price> priceList;

    public GuestType() {
    }

    //TODO remove
    public GuestType(Integer id, String nameEn, Integer price, Integer priceRu, Boolean member) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameRu = nameEn;
        this.price = price;
        this.priceRu = priceRu;
        this.member = member;
    }

//    public void getPrice (){
//        for (Price price : priceList) {
//            if (price.getStartDate().before(new Date()) && price.getEndDate().after(new Date())) {
//                System.out.println("OK");
//            }
//        }
//    }

}
