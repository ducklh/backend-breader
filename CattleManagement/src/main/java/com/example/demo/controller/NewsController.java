package com.example.demo.controller;

import com.example.demo.model.Cage;
import com.example.demo.model.Employee;
import com.example.demo.model.News;
import com.example.demo.model.NewsComment;
import com.example.demo.model.dto.*;
import com.example.demo.service.CommentService;
import com.example.demo.service.NewsService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/public/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping()
    public ResponseEntity<Page<News>> findAllNews(@PageableDefault(size = 6 ) Pageable pageable,
                                                  @RequestParam(value = "search", defaultValue = "")  String search,
                                                  @RequestParam(value = "type", defaultValue = "")  String type){

        Page<News> news;
        if ("".equals(search)) {
            news = newsService.findAll(pageable);
        } else{
            switch (type){
                case "asc":
                    news = newsService.findAllByNewsNameContainingDateAsc(search, pageable);
                    break;
                case "date":
                    news = newsService.findAllByNewsNameContainingDate(search, pageable);
                    break;
                case "views":
                    news = newsService.findAllByNewsNameContainingTotalViews(search, pageable);
                    break;
                default:
                    news = newsService.findAllByNewsNameContaining(search, pageable);
            }
//            System.out.println(search);
//            news = newsService.findAllByNewsNameContaining(search, pageable);
        }

        if (news.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/hl")
    public ResponseEntity<Page<News>> findAllNewsHightLight(@PageableDefault(size = 3 ) Pageable pageable){
        Page<News> news;
        news = newsService.findAllByHighlight("1", pageable);

        if (news.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/view")
    public ResponseEntity<Page<News>> findAllNewsTotalView(@PageableDefault(size = 3 ) Pageable pageable){
        Page<News> news;
        news = newsService.findAllByTotalView(pageable);

        if (news.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<News> showDetailNews(@PathVariable String id){
        News news;
        Long idFind = Long.parseLong(id, 10)  ;      // returns 0L
        news = newsService.findNewsByNewsId(idFind);
        if (news==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        news.setTotalView(news.getTotalView()+1);
        newsService.save(news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/statistical")
    public ResponseEntity<Page<statisticalTypeNewsDTO>> statistical(@PageableDefault(size = 5 ) Pageable pageable){
        Page<statisticalTypeNewsDTO> news;
        news = newsService.statisticalTotalViewsByType(pageable);
//        System.out.println(news.toString());
//        if (news.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/comment")
    public ResponseEntity<Page<CommentNewsDTO>> statistical(@PageableDefault(size = 6 ) Pageable pageable,
                                                            @RequestParam(value = "id", defaultValue = "")  String idNews) {
        Page<CommentNewsDTO> comments;
        comments = newsService.findNewsByNewsComments(idNews, pageable);
//        System.out.println(news.toString());
        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/inforUser")
    public ResponseEntity<UserCommentDTO> findUser(@RequestParam(value = "id", defaultValue = "")  String nameAccount) {
        UserCommentDTO comments;
        comments = newsService.findUser(nameAccount);
        if (comments == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(value ="/comment/create")
    public ResponseEntity<?> createComment(@Valid @RequestBody CommentCreateDTO commentCreateDTO, BindingResult bindingResult) {
        NewsComment comment = new NewsComment();
        System.out.println(commentCreateDTO);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newsService.createComment(commentCreateDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    @GetMapping(value = "comment/delete/{id}")
    public ResponseEntity<NewsComment> deleteComment(@PathVariable Long id){
        System.out.println(id);
        NewsComment newsComment;
        newsComment = commentService.findNewsCommentByCommentId(id);
        if (newsComment==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        newsComment.setDelete(true);
        commentService.save(newsComment);
        return new ResponseEntity<>(newsComment, HttpStatus.OK);
    }

    @PatchMapping(value = "comment/edit")
    public ResponseEntity<?> editComment(@Valid @RequestBody CommentEditDTO commentEditDTO, BindingResult bindingResult) {
        NewsComment newsComment = commentService.findNewsCommentByCommentId(commentEditDTO.getCommentId());
        System.out.println(commentEditDTO);
        BeanUtils.copyProperties(commentEditDTO, newsComment);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeService.findEmpById(commentEditDTO.getEmployeeId());
        newsComment.setEmployee(employee);
        News news = newsService.findNewsByNewsId(Long.parseLong(commentEditDTO.getNewsId(), 10));
        newsComment.setNews(news);
        commentService.save(newsComment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}