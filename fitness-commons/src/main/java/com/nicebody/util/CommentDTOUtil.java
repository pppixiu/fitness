package com.nicebody.util;

import com.nicebody.dto.CommentDTO;
import com.nicebody.enums.CommentTypeEnum;

/**
 * @ClassName CommentDTOUtil
 * @Author sensu
 * @Date 2019/9/23 10:48
 **/
public class CommentDTOUtil {

    /**
     * 返回对于博客评论查询的DTO
     *
     * @param refId
     * @return
     */
    public static CommentDTO blog(Integer refId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setTypeCode(CommentTypeEnum.BLOG.getCode());
        //设置从最高级别评论查起
        commentDTO.setParentId(0);
        commentDTO.setRefId(refId);
        return commentDTO;
    }

    /**
     * 返回对于教练评论查询的DTO
     *
     * @param refId
     * @return
     */
    public static CommentDTO coach(Integer refId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setTypeCode(CommentTypeEnum.COACH.getCode());
        //设置从最高级别评论查起
        commentDTO.setParentId(0);
        commentDTO.setRefId(refId);
        return commentDTO;
    }
}
