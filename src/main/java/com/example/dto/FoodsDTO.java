package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getter and setter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FoodsDTO {
    private String itemCode;
    private String itemName;
    private double itemPrice;
    private String imageURL;
}
