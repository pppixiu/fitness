package com.nicebody.service;

import com.nicebody.dto.CommentDTO;
import com.nicebody.pojo.Comment;
import com.nicebody.vo.CommentVO;

import java.util.List;

/**
 * @ClassName CommonServer
 * @Author sensu
 * @Date 2019/9/23 13:38
 **/
public interface CommentService {

    /**
     * 查询评论
     * @param commentDTO
     * @return
     */
    List<CommentVO> getCommentList(CommentDTO commentDTO);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    CommentVO addComment(Comment comment);
}
