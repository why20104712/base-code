package com.example.elasticsearch.dao;

import com.example.elasticsearch.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wanghaiyang
 * @date 2018/7/28 20:25
 */
@Repository
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
