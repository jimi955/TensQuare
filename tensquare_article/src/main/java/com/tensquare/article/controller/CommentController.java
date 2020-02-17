package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.ColumnService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ColumnService.CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK.getCode(), "提交成功 ");
    }

    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", commentService.findByArticleid(articleid));
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable("id") String id) {
        commentService.deleteComment(id);
        return new Result(true, StatusCode.OK.getCode(), "删除成功");
    }
}
