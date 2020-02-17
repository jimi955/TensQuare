package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 继承JpaRepository来完成对数据库的操作   Label 数据封装的类型  String 主键的类型
 *
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
