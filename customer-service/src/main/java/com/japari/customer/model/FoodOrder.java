package com.japari.customer.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FoodOrder extends BaseEntity implements Serializable {
    private String customer;
    @ManyToMany
    @JoinTable(name = "T_ORDER_FOOD")
    @OrderBy("id")
    private List<Food> items;
    @Enumerated
    @Column(nullable = false)
    private OrderState state;
}
