package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
    /**
     * 文章审核
     * @Modifying注解
     * 1、在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。
     * 2、UPDATE或者DELETE操作需要使用事务，此时需要 定义Service层，在Service层的方法上添加事务操作。
     * 3、注意JPQL不支持INSERT操作。　　
     * @param id
     */
//    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true)
    void updateState(String id);

    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup = thumbup + 1 WHERE id = ?", nativeQuery = true)
    void addThumbup(String id);
}
