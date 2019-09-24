package com.nicebody.controller;

import com.nicebody.enums.CommentTypeEnum;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.Comment;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.CommentService;
import com.nicebody.util.CommentDTOUtil;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.CommentVO;
import com.nicebody.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommentController
 * @Author sensu
 * @Date 2019/9/23 14:26
 **/
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/blogcommentlist")
    @ResponseBody
    public ResultVO getBlogCommentList(Integer refId) {
        List<CommentVO> commentVOList = commentService.getCommentList(CommentDTOUtil.blog(refId));
        if (commentVOList == null) {
            return ResultVOUtil.none(UserCenterInfoEnum.NO_INFO);
        }
        return ResultVOUtil.success(commentVOList);
    }

    @GetMapping("/coachcommentlist")
    @ResponseBody
    public ResultVO getCoachCommentList(Integer refId) {
        List<CommentVO> commentVOList = commentService.getCommentList(CommentDTOUtil.coach(refId));
        if (commentVOList == null) {
            return ResultVOUtil.none(UserCenterInfoEnum.NO_INFO);
        }
        return ResultVOUtil.success(commentVOList);
    }

    @PostMapping("addblogcomment")
    @ResponseBody
    public ResultVO addBlogComment(String content, Integer refId, Integer parentId) {
        CommentVO commentVO;
        if (content != null && content != "" && refId != null) {
            //TODO session中获取userprofile
            UserProfile userProfile = new UserProfile();
            userProfile.setUserId(1);

            Comment comment = new Comment();
            comment.setCommentContent(content);
            comment.setRefId(refId);
            comment.setParentId(parentId);
            comment.setUserProfile(userProfile);
            comment.setTypeCode(CommentTypeEnum.BLOG.getCode());
            commentVO = commentService.addComment(comment);
            if (commentVO == null) {
                return ResultVOUtil.error(4, "添加失败");
            }
        } else {
            return ResultVOUtil.error(4, "添加失败");
        }
        return ResultVOUtil.success(commentVO);
    }

}
