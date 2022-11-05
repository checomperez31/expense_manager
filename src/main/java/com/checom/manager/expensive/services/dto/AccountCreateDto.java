package com.checom.manager.expensive.services.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountCreateDto implements Serializable {
    private String id;

    private String name;
}
