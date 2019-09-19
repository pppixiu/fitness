package com.nicebody.service;

import com.nicebody.dto.UserCenterExecution;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.UserBlog;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserCenterService
 * @Author sensu
 * @Date 2019/9/19 18:52
 **/
@Service
public interface UserCenterService {
    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @return
     */
    public List<UserBlog> getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, UserBlog userBlogCondition);

    /**
     * 查询对应user的课程信息并分页
     * @param pageIndex
     * @param pageSize
     * @param userId
     * @return
     */
    public List<Course> getCourseList(int pageIndex, int pageSize, int userId);

}
