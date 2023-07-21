package com.c2psi.bm.models;

import com.c2psi.bm.enumerations.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Operation {
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    Instant opDate;

    @Column(nullable = false)
    String opObject;
    String opDescription;

    @Column(nullable = false)
    OperationType opType;
}
