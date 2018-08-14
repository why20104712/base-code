package com.example.elasticsearch.controller;

import com.example.elasticsearch.bean.Article;
import com.example.elasticsearch.bean.Author;
import com.example.elasticsearch.bean.Tutorial;
import com.example.elasticsearch.dao.ArticleSearchRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;

/**
 * @author wanghaiyang
 * @date 2018/7/28 20:25
 */
@RestController
public class TestController {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    /**
     * 保存数据到elasticsearch
     * @author wanghaiyang
     * @date 2018/7/28 20:26
     */
    @RequestMapping("/add")
    public void testSaveArticleIndex() {
        Author author = new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        articleSearchRepository.save(article);
    }


    /**
     * 在es中检索数据
     * @author wanghaiyang
     * @date 2018/7/28 20:25
     */
    @RequestMapping("/query")
    public void testSearch() {
        //搜索关键字
        String queryString = "springboot";
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
