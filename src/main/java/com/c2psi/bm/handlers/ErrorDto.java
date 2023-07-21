package com.c2psi.bm.handlers;

import com.c2psi.bm.enumerations.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCode errorCode;
    private String message;
    private List<String> errorList = new ArrayList<>();
}
