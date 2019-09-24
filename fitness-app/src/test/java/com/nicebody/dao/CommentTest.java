package com.nicebody.dao;

import com.nicebody.dto.CommentDTO;
import com.nicebody.enums.CommentTypeEnum;
import com.nicebody.mapper.CommentMapper;
import com.nicebody.pojo.Comment;
import com.nicebody.pojo.UserProfile;
import com.nicebody.util.CommentDTOUtil;
import com.nicebody.vo.CommentVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentTest
 * @Author sensu
 * @Date 2019/9/23 10:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void queryCommentList(){
        // 查询id为6的blog的评论信息
        CommentDTO commentDTO = CommentDTOUtil.blog(6);
        List<CommentVO> commentList = commentMapper.queryCommentList(commentDTO.getTypeCode(),
                commentDTO.getRefId(), commentDTO.getParentId());

        Assert.assertEquals(2, commentList.size());
    }

    @Test
    public void insertComment(){
        Comment comment = new Comment();
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(1);
        comment.setUserProfile(userProfile);
        comment.setCommentContent("插入测试");
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        comment.setRefId(6);
        comment.setTypeCode(CommentTypeEnum.BLOG.getCode());
        comment.setParentId(1);

        int count = commentMapper.insertComment(comment);
        Assert.assertEquals(1, count);
    }

    @Test
    public void queryCommentById(){
        CommentVO commentVO = commentMapper.queryCommentById(1);
        int i = commentVO.getCommentId();
        Assert.assertEquals(1, i);
    }
}

