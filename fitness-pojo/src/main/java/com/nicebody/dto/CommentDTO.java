package com.nicebody.dto;

/**
 * @ClassName CommentDTO
 * @Author sensu
 * @Date 2019/9/23 10:32
 **/
public class CommentDTO {
    /** 评论类型， 1教练 2博客 */
    private Integer typeCode;
    /** 评论主体id */
    private Integer refId;
    /** 上级评论 */
    private Integer parentId;


    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
