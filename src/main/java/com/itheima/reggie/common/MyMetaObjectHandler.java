package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 元数据处理器
 * 公共字段自动填充-Mybatis-plus提供的
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 执行插入语句的时候，添加了注解 @TableField(fill = FieldFill.INSERT)的公共字段就会执行insertFill()函数
    // 对公共字段自动进行赋值
    @Override
    public void insertFill(MetaObject metaObject) {
        long id=Thread.currentThread().getId();
        log.info("线程id为{}",id);

        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long id=Thread.currentThread().getId();
        log.info("线程id为{}",id);

        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
