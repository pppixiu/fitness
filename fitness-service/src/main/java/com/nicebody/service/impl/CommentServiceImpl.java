package com.nicebody.service.impl;

import com.nicebody.dto.CommentDTO;
import com.nicebody.enums.CommentEnum;
import com.nicebody.exception.CommentException;
import com.nicebody.mapper.CommentMapper;
import com.nicebody.pojo.Comment;
import com.nicebody.service.CommentService;
import com.nicebody.util.CommentDTOUtil;
import com.nicebody.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentserviceImpl
 * @Author sensu
 * @Date 2019/9/23 13:40
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> getCommentList(CommentDTO commentDTO) {
        List<CommentVO> commentVOList = commentMapper.queryCommentList(commentDTO.getTypeCode(),
                commentDTO.getRefId(), commentDTO.getParentId());
        if (commentVOList == null || commentVOList.size() == 0) {
            return null;
        }
        return commentVOList;
    }

    @Override
    public CommentVO addComment(Comment comment) {
        CommentVO commentVO = null;
        if (verifyComment(comment)) {
            comment.setCreateTime(new Date());
            comment.setUpdateTime(new Date());
            commentMapper.insertComment(comment);
            commentVO = commentMapper.queryCommentById(comment.getCommentId());
            if (commentVO == null) {
                throw new CommentException(CommentEnum.FAIL.getMsg());
            }
        } else {
            throw new CommentException(CommentEnum.FAIL.getMsg());
        }
        return commentVO;
    }

    //验证comment
    public boolean verifyComment(Comment comment) {
        if (comment.getCommentContent() == null || "".equals(comment.getCommentContent())) {
            return false;
        }
        if (comment.getRefId() == null) {
            return false;
        }
        if (comment.getTypeCode() == null) {
            return false;
        }
        if (comment.getUserProfile() == null || comment.getUserProfile().getUserId() == null) {
            return false;
        }
        return true;
    }

}
