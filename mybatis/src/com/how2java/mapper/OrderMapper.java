package com.how2java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.how2java.pojo.Order;

public interface OrderMapper {
    @Select("select * from order_ od inner join order_product_ op on od.id=op.oid "
            + "inner join product_ p on op.pid=p.id")
    @Results({
        @Result(property="id", column="id"),
        @Result(property="code", column="code"),
        @Result(property="orderItems", javaType=List.class, 
                column="id", many=@Many(select="com.how2java.mapper.OrderItemMapper.getOrderItemsByOrderId"))
    })
    public List<Order> getOrders();
}
