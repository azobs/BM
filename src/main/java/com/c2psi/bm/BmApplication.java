package com.c2psi.bm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //To precise that we have some classes that spring must auditing.
/**
 * A class that spring must auditing is a class wich is annoted with @EntityListeners(AuditingEntityListener.class)
 * and use for some attribute:
 *  @CreatedDate
 *  @LastModifiedDate
 *  @CreatedBy
 *  @LastModifiedBy
 */
@Slf4j
public class BmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmApplication.class, args);
    }

}
