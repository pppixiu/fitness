package com.nicebody.mapper;

import com.nicebody.pojo.Comment;
import com.nicebody.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    /**
     * 根据类别信息(type_code) 以及 评论对象信息(ref_id) 以及 回复信息(parent_id)(0为最上层评论) 查询
     *
     * @return
     */
    List<CommentVO> queryCommentList(@Param("typeCode") Integer typeCode,
                                     @Param("refId") Integer refId,
                                     @Param("parentId") Integer parentId);

    /**
     * 根据父评论id 查询 comment信息
     *
     * @param parentId
     * @return
     */
    List<CommentVO> queryCommentChildList(Integer parentId);

    /**
     * 添加comment信息
     *
     * @param comment
     * @return
     */
    int insertComment(@Param("comment") Comment comment);

    /**
     * 通过commentId查询评论信息
     *
     * @param commentId
     * @return
     */
    CommentVO queryCommentById(Integer commentId);

}
