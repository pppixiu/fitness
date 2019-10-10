package com.nicebody.controller;

import com.nicebody.enums.CommentTypeEnum;
import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.*;
import com.nicebody.service.*;
import com.nicebody.util.OrderByUtil;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName CoachController
 * @Author Hassan
 * %@Date 2019/9/16 22:06
 */
@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CoachSearchRepository coachSearchRepository;

    /**
     * 多条件查询教练信息
     *
     * @param tagId
     * @param rowIndex
     * @param sortId
     * @param coachName
     * @return
     */
    @GetMapping(value = "/coachList")
    public ResultVO sortCoachList(@RequestParam(name = "tagId", defaultValue = "0") Integer tagId,
                                  @RequestParam(name = "rowIndex", defaultValue = "0") Integer rowIndex,
                                  @RequestParam(name = "sortId", defaultValue = "0") Integer sortId,
                                  @RequestParam(name = "coachName", defaultValue = "empty") String coachName) {
        //存储查找教练信息
        CoachInfo coachCondition = new CoachInfo();
        coachCondition.setTagId(tagId);
        coachCondition.setCoachName(coachName);

        //将转换sortId
        String sortValue = OrderByUtil.coachConvent2String(sortId);

        //判断是否加载全部
        List<CoachInfo> coachSize = coachService.getCoachList(0,9999,coachCondition,sortValue);
         if(rowIndex > coachSize.size() + 8){
            return null;
        }

        List<CoachInfo> coachInfoList = coachService.getCoachList(rowIndex, 8, coachCondition, sortValue);
        List<CoachVO> coachVOList = new ArrayList<>();
        //填值
        for (CoachInfo coachInfo : coachInfoList) {
            CoachVO coachVO = new CoachVO();
            BeanUtils.copyProperties(coachInfo, coachVO);
            coachVOList.add(coachVO);
        }
        //公共方法返回
        return ResultVOUtil.success(coachVOList);
    }

    /**
     * 多条件查询教练个人信息
     *
     * @param rowIndex
     * @param pageSize
     * @param coachId
     * @param userId
     * @return
     */
    @GetMapping(value = "/coachShow")
    public ResultVO getCoachInfo(@RequestParam(name = "rowIndex", defaultValue = "0") Integer rowIndex,
                                 @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
                                 @RequestParam(name = "coachId", defaultValue = "1") Integer coachId,
                                 @RequestParam(name = "userId", defaultValue = "0") Integer userId) {
        Blog userCondition = new Blog();
        userCondition.setUserId(coachId);

        //查找该id的教练\图片\课程\博文信息
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(rowIndex, pageSize, 0, coachId);
        List<CoachInfoVO> coachInfoVOList = new ArrayList<>();

        for (CoachInfo coachInfo : coachInfoList) {
            CoachInfoVO coachInfoVO = new CoachInfoVO();
            BeanUtils.copyProperties(coachInfo, coachInfoVO);
            coachInfoVOList.add(coachInfoVO);
        }
        //公共方法返回
        return ResultVOUtil.success(coachInfoVOList);
    }

    /**
     * 查询全部分类
     * @return
     */
    @GetMapping(value = "/tag")
    public ResultVO getCoachTag() {
        List<Tag> tagList = coachService.getTag();
        return ResultVOUtil.success(tagList);
    }

    /**
     * 查询教练课程
     * @param coachId
     * @return
     */
    @GetMapping(value = "/coachCourse")
    public ResultVO getCoachSourse(@RequestParam(name = "coachId", defaultValue = "1") Integer coachId){
        List<Course> courseList = courseService.getCourseByCoachId(coachId,0,3);
        List<CourseVO> courseInfoVOList = new ArrayList<>();

        for (Course course : courseList) {
            CourseVO courseVO = new CourseVO();
            BeanUtils.copyProperties(course, courseVO);
            courseInfoVOList.add(courseVO);
        }
        //公共方法返回
        return ResultVOUtil.success(courseInfoVOList);
    }

    /**
     * 查询教练展示图片
     * @param coachId
     * @return
     */
    @GetMapping(value = "/coachImage")
    public ResultVO  getCoachImage(@RequestParam(name = "coachId", defaultValue = "1") Integer coachId){
       List<CoachImage> coachImageList = coachService.getImageList(0,3,coachId);
       ResultVO resultVO = new ResultVO();

       resultVO.setData(coachImageList);
       resultVO.setCode(0);
       resultVO.setMsg("成功");
       return resultVO;
    }

    /**
     * 教练点赞
     * @param coachId
     * @return
     */
    @GetMapping(value = "/coachLikeCount")
    public ResultVO modifyCoachLikeCount(@RequestParam(name = "coachId") Integer coachId,
                                         @RequestParam(name = "userId") Integer userId,
                                         @RequestParam(name = "judgeid") Integer judgeid){
        //判断值
        int judge = 0;
        int likeJudge = 0;
        System.out.println(judgeid);

        //先查询关联表里有没有该用户信息，有返回值为coachId,没有为null
        String coachLikeJudge = coachService.getCoachLikeCount(coachId, userId);
        if (judgeid == 0){
            judge = 1;
            if(coachLikeJudge == null){
                likeJudge = 0;
            }else {
                likeJudge = 1;
            }
        }
        if(judgeid == 1){
            if (coachLikeJudge == null) {
                likeJudge = 1;
                //没有该关联，咋向表中添加信息
                int addLikeInfo = coachService.insCoachLikeCount(coachId, userId);
                if (addLikeInfo == 1) {
                    //如果修改成功，则修改点赞数，并返回
                    judge = coachService.modifyCoachLikeCount(coachId, 1);
                }
            } else {
                likeJudge = 0;
                //如果表中有该关联，则删除该表关联，点赞数-1
                int delLikeInfo = coachService.delCoachLikeCount(coachId, userId);
                if (delLikeInfo == 1) {
                    judge = coachService.modifyCoachLikeCount(coachId, -1);
                }
            }
        }

        //判断是否修改成功
        if(judge == 1) {
            CoachInfo coachInfo = new CoachInfo();
            CoachInfoVO coachInfoVO = new CoachInfoVO();
            List<CoachInfo> coachInfoList = coachService.getCoachInfo(0, 1, 0, coachId);
            coachInfo = coachInfoList.get(0);
            BeanUtils.copyProperties(coachInfo, coachInfoVO);
            coachInfoVO.setLikeJudge(likeJudge);
            return ResultVOUtil.success(coachInfoVO);
        }else {
            return null;
        }
    }

    /**
     * 添加教练评价
     * @param content
     * @param coachId
     * @param request
     * @return
     */
    @GetMapping(value = "/addCoachComment")
    @ResponseBody
    public ResultVO addCoachComment(@RequestParam(name = "content") String content,
                                    @RequestParam(name = "coachId") Integer coachId,
                                    HttpServletRequest request ){
        HttpSession session = request.getSession();
        UserProfile userProfile = new UserProfile();
        userProfile = (UserProfile) session.getAttribute("userProfile");

        //先查询关联表里有没有该用户信息，有返回值为coachId,没有为null
        String coachLikeJudge = coachService.getCoachLikeCount(coachId, userProfile.getUserId());
        if(coachLikeJudge == null){
            return ResultVOUtil.success(null);
        }

        CommentVO commentVO;
        if (content != null && content != "" && coachId != null) {

            Comment comment = new Comment();
            comment.setCommentContent(content);
            comment.setRefId(coachId);
            comment.setUserProfile(userProfile);
            comment.setTypeCode(CommentTypeEnum.COACH.getCode());
            commentVO = commentService.addComment(comment);
            if (commentVO == null) {
                return ResultVOUtil.error(4, "添加失败");
            }
        }else {
            return ResultVOUtil.error(4, "添加失败");
        }
        return ResultVOUtil.success(commentVO);
    }

    /**
     * 教练姓名模糊查询
     * @param coachName
     * @return
     */
    @GetMapping(value = "/coachName")
    public List<CoachSearch> coachNameSearch(@RequestParam(name = "coachName", defaultValue = "0") String coachName) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", coachName));
        // 搜索，获取结果
        Page<CoachSearch> coachs = this.coachSearchRepository.search(queryBuilder.build());
        // 总条数
        long coachname = coachs.getTotalElements();
        System.out.println("name = " + coachname);

        List<CoachSearch> coachInfoList = new ArrayList<>();

        for (CoachSearch coachSearch : coachs) {
            coachInfoList.add(coachSearch);
        }
        //公共方法返回
        return coachInfoList;
    }
}
