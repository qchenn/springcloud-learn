package com.fenda.cloud.dao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountDao {

    /**
     * 扣减账户余额
     */
    void decrease(Long userId,BigDecimal money);
}
