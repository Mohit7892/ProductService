package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {

    private long Id;
    private Date createdAt;
    private Date lastUpdatedAt;
}
