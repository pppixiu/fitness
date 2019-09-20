package com.nicebody.service;

import com.nicebody.dto.UserBlogExecution;
import com.nicebody.dto.UserCoachExecution;
import com.nicebody.dto.UserCourseExecution;
import com.nicebody.pojo.UserBlog;
import org.springframework.stereotype.Service;


/**
 * @ClassName UserCenterService
 * @Author sensu
 * @Date 2019/9/19 18:52
 **/
@Service
public interface UserCenterService {
    /**
     * 通过用户Id查找用户博客
     * 或者通过博客内容模糊查找博客信息
     * 或者查询全部博客
     *
     * @return
     */
    public UserBlogExecution getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, UserBlog userBlogCondition);

    /**
     * 根据userId查询用户购买课程信息
     *
     * @param userId
     * @return
     */
    public UserCourseExecution getCourseList(int userId);

    /**
     * 根据用户id得到关注的教练
     *
     * @param userId
     * @return
     */
    public UserCoachExecution getCoachList(int userId);

}
