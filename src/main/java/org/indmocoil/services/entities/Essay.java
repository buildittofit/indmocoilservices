package org.indmocoil.services.entities;


import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import com.google.cloud.spring.data.datastore.core.mapping.Field;
import com.google.cloud.spring.data.datastore.core.mapping.Unindexed;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "essayId")
public class Essay {

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy="org.hibernate.id.UUIDGenerator")
//    @Field(name = "essayId")
    @Id
    private String essayId;

    @Field(name = "heading")
    private String heading;
    @Field(name = "essaytext")
    @Unindexed
    private String essaytext;
    @Field(name = "headLine")
    private String headLine;
    @Field(name = "inputdtm")
    private Date inputdtm;
    @Field(name = "status")
    private String status;
    @Field(name="subheading")
    private String subheading;

}
