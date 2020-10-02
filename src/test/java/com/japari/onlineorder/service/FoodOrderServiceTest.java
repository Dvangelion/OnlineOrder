package com.japari.onlineorder.service;

import com.japari.onlineorder.model.Food;
import com.japari.onlineorder.repository.FoodOrderRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

public class FoodOrderServiceTest {

    @InjectMocks
    private FoodOrderService foodOrderService;

    @Mock
    private FoodOrderRepository foodOrderRepository;

    MockitoSession mockito;

    private Food food;


    @Before
    public void setup(){
        mockito = Mockito.mockitoSession().initMocks(this)
                    .startMocking();
    }

//    @Test
//    public void shouldCreateOrder(){
//        FoodOrder order = FoodOrder.builder()
//                .customer('Ke')
//                .items()

}

