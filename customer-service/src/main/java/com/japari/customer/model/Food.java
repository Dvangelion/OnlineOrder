package com.japari.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_FOOD")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class Food extends BaseEntity implements Serializable {
    private String name;

    public void setPrice(Money price){
        this.price = price;
    }

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
                     parameters = {@Parameter(name = "currencyCode", value = "CNY")})

    private Money price;
}
