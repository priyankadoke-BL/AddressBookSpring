package com.bridgelabz.addressbookspring.dto;

import lombok.Data;
import org.hibernate.sql.OracleJoinFragment;

public @Data class ResponseDTO {
    String message;
    Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
