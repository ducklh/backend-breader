package com.example.demo.repository;

import com.example.demo.model.News;
import com.example.demo.model.NewsComment;
import com.example.demo.model.dto.UserCommentDTO;
import com.example.demo.model.dto.CommentNewsDTO;
import com.example.demo.model.dto.statisticalTypeNewsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface NewsRepo extends JpaRepository<News, String> {
    @Query(value = "select * from news " + " where is_delete = '0' " + " order by created_date desc " , nativeQuery = true)
    Page<News> findAllSortDate(Pageable pageable);
    //    @Override
    @Query(value = "SELECT news.news_id, news.content, news.created_date, news.detail_description, news.highlight, news.image, news.is_delete, news.news_name, news.total_view, news.type, employee.employee_name FROM news inner join employee on news.employee_id = employee.employee_id " + " where news.is_delete = 0 " + " order by created_date desc " , nativeQuery = true)
    Page<News> findAll(Pageable pageable);
    //    @Query(value = "SELECT news.content, news.created_date, news.detail_description, news.highlight, news.image, news.is_delete, news.news_name,employee.employee_name FROM news inner join employee on news.employee_id = employee.employee_id " + " where news.news_id = username and news.is_delete = 0 " , nativeQuery = true)
//    News findNewsByNewsId(String newsId);
    @Query(value = "SELECT * FROM news " + " where news.is_delete = 0 and news.news_name like %:name% " + " order by created_date desc " , nativeQuery = true)
    Page<News> findAllByNewsNameContainingDate(String name,Pageable pageable);

    @Query(value = "SELECT * FROM news " + " where news.is_delete = 0 and news.news_name like %:name% " + " order by created_date asc " , nativeQuery = true)
    Page<News> findAllByNewsNameContainingDateEsc(String name,Pageable pageable);

    @Query(value = "SELECT * FROM news " + " where news.is_delete = 0 and news.news_name like %:name% " + " order by total_view desc " , nativeQuery = true)
    Page<News> findAllByNewsNameContainingViews(String name,Pageable pageable);

    Page<News> findAllByNewsNameContaining(String name, Pageable pageable);
    Page<News> findAllByHighlight(String name, Pageable pageable);
    News findNewsByNewsId(Long newsId);
    @Query(value = "select * from news "+ " order by total_view desc " , nativeQuery = true)
    Page<News> findAllSortTotalView(Pageable pageable);

    @Query(value = "SELECT `type`, sum(total_view) as totalViews FROM news group by `type`"
            ,countQuery="SELECT `type`, sum(total_view) as totalViews FROM news group by `type`", nativeQuery = true)
    Page<statisticalTypeNewsDTO> statisticalTotalViewsByType(Pageable pageable);

    @Query(value = "SELECT news_comment.comment_id as commentId, news_comment.content, news_comment.news_id as newsId, news_comment.employee_id as employeeId, news_comment.is_delete as isDelete, employee.employee_name as employeeName, employee.avatar as avatar  FROM news_comment inner join employee  on news_comment.employee_id = employee.employee_id " + " where news_comment.is_delete = 0 and news_comment.news_id = :idNews " , nativeQuery = true)
    Page<CommentNewsDTO> findNewsByNewsCmt(String idNews, Pageable pageable);

    @Query(value = "SELECT employee.employee_name as employeeName, employee.employee_id as employeeId, employee.avatar FROM employee inner join `account` on `account`.account_id = employee.account_id " + "where `account`.account_name = :nameAccount" , nativeQuery = true)
    UserCommentDTO findUser(String nameAccount);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO news_comment(content,is_delete,employee_id,news_id)" +
            " values(?1,?2,?3,?4)",nativeQuery=true)
    void createCustomer(String content, Boolean isDelete, String employeeId, String newsId);

}