package com.nicebody.service.impl;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.CoachSearch;
import com.nicebody.service.CoachSearchRepository;
import com.nicebody.service.CoachService;
import com.nicebody.util.OrderByUtil;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CoachServiceImplTest
 * @Author Hassan
 * %@Date 2019/9/17 09:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoachServiceImplTest {
    @Autowired
    private CoachService coachService;

    @Autowired
    private CoachSearchRepository coachSearchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /** 多条件查找教练信息测试*/
    @Test
    public void getCoachListTest(){
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setTagId(4);
        coachInfo.setCoachName("王");
        String value = OrderByUtil.coachConvent2String(OrderByEnum.PRICE.getCode());
        List<CoachInfo> coachInfoList = coachService.getCoachList(0,2,coachInfo,value);
        Assert.assertEquals(1, coachInfoList.size());
    }

    /** 测试根据Id查找关注教练，以及教练个人信息*/
    @Test
    public void getCoachInfoTest(){
        CoachInfo coachInfo = new CoachInfo();
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(0,2,0,1);
        List<CoachInfo> coachInfoList1 = coachService.getCoachInfo(0,2,1,0);
        Assert.assertEquals(1,coachInfoList.size());
        Assert.assertEquals(2,coachInfoList1.size());
    }

    /** 测试查找教练图片*/
    @Test
    public void getImageListTest(){
        CoachImage coachImage = new CoachImage();
        List<CoachImage> coachImages = coachService.getImageList(0,2,1);
        Assert.assertEquals(2,coachImages.size());
    }

    /** 测试教练点赞修改*/
    @Test
    public void modifyCoachLikeCountTest(){
        int i = coachService.modifyCoachLikeCount(1,-1);
        System.out.println(i);
    }

    /** 查询关联信息*/
    @Test
    public void getCoachLikeCountTest(){
        System.out.println(coachService.getCoachLikeCount(3,2));
        System.out.println(coachService.getCoachLikeCount(9,10));
    }

    /** 添加关联信息*/
    @Test
    public void insCoachLikeCountTest(){
        System.out.println(coachService.insCoachLikeCount(9,10));
    }

    /** 删除关联信息*/
    @Test
    public void delCoachLikeCountTest(){
        System.out.println(coachService.delCoachLikeCount(9,10));
        System.out.println(coachService.delCoachLikeCount(9,10));
    }

    /** 创建索引*/
    @Test
    public void createIndex(){
        elasticsearchTemplate.createIndex(CoachSearch.class);
    }

    /** 删除索引*/
    @Test
    public void deleteIndex(){
        elasticsearchTemplate.deleteIndex(CoachSearch.class);
    }

    /** 增加数据操作*/
    @Test
    public void insert(){
        List<CoachSearch> list = new ArrayList<>();
        list.add(new CoachSearch(1, "王佳帅", "腹部", "不服现实碰一碰", 2, "http://pxwqui3qb.bkt.clouddn.com/a26855e74b5442038eb96da6022f991d.jpg", 80.0));
        list.add(new CoachSearch(2, "黄山奇", "腹部", "你看我扎不扎你就完了", 256, "http://pxwqui3qb.bkt.clouddn.com/805d9e0c634540fba58a4853f8ca97e9.jpg", 80.0));
        list.add(new CoachSearch(3, "曹钲", "腿部", "不要哔哔赖赖", 564, "http://pxwqui3qb.bkt.clouddn.com/8062e0da26754029ac1ec73dc5862c11.jpg", 40.0));
        list.add(new CoachSearch(4, "曹雪", "腹部", "不服现实碰一碰", 627, "http://pxwqui3qb.bkt.clouddn.com/81283255be7046fc9f777c6ef354f686.jpg", 90.0));
        list.add(new CoachSearch(5, "王欢欢", "胸部", "你看我扎不扎你就完了", 986, "http://pxwqui3qb.bkt.clouddn.com/27119cacdbab43f3a67a56a7ef1db77b.jpg", 70.0));
        list.add(new CoachSearch(6, "赵德地", "胸部", "不要哔哔赖赖", 856, "http://pxwqui3qb.bkt.clouddn.com/f9a2164a0c9f4a0c9f03776b01522cd7.jpg", 50.0));
        list.add(new CoachSearch(7, "刘飒", "背部", "不服现实碰一碰", 680, "http://pxwqui3qb.bkt.clouddn.com/693caa047b1f4a29a59a37cf4ada853b.jpg", 56.0));
        list.add(new CoachSearch(8, "王维权", "背部", "你看我扎不扎你就完了", 565, "http://pxwqui3qb.bkt.clouddn.com/1271f246477e42978d1c16fac434c418.jpg", 25.0));
        list.add(new CoachSearch(9, "宋光荣", "背部", "不要哔哔赖赖", 211, "http://pxwqui3qb.bkt.clouddn.com/616f3ab100f640608348744a5d28947f.jpg", 45.0));
        list.add(new CoachSearch(10, "尚书将", "肩部", "不服现实碰一碰", 546, "http://pxwqui3qb.bkt.clouddn.com/e8362a2dc4324f4bb9c0466998b7d5b4.jpg", 23.0));
        list.add(new CoachSearch(11, "李飒大", "肩部", "你看我扎不扎你就完了", 743, "http://pxwqui3qb.bkt.clouddn.com/789737a7f2b44272a347c112f5742b31.jpg", 85.0));
        list.add(new CoachSearch(12, "孙松", "肩部", "不要哔哔赖赖", 647, "http://pxwqui3qb.bkt.clouddn.com/7462ad9b2b10451c9dc4ce7b96465a68.jpg", 52.0));
        list.add(new CoachSearch(13, "王丹丹", "腹部", "不服现实碰一碰", 212, "http://pxwqui3qb.bkt.clouddn.com/dbe8c5192bdc42a597a503a6e815f649.jpg", 87.0));
        list.add(new CoachSearch(14, "孙飞虎", "腹部", "你看我扎不扎你就完了", 236, "http://pxwqui3qb.bkt.clouddn.com/e57126d97fef445d8c6e84ad7d52890e.jpg", 85.0));
        list.add(new CoachSearch(15, "黄葛根", "臀部", "不要哔哔赖赖", 359, "http://pxwqui3qb.bkt.clouddn.com/41008888466b4227bffc41df1d1fa068.jpg", 95.0));
        list.add(new CoachSearch(16, "蔡静安", "臀部", "不服现实碰一碰", 232, "http://pxwqui3qb.bkt.clouddn.com/ba8d7d5c98d74ca282781e92e4405e13.jpg", 2.0));
        list.add(new CoachSearch(17, "阿思翠", "腿部", "你看我扎不扎你就完了", 539, "http://pxwqui3qb.bkt.clouddn.com/847c05df7ff9450d9da74703afc67110.jpg", 14.0));
        list.add(new CoachSearch(18, "金卡卡", "肱二头肌", "不要哔哔赖赖", 252, "http://pxwqui3qb.bkt.clouddn.com/99ac9b2ef9a4409ebfbe9c7f8df22163.jpg", 56.0));
        list.add(new CoachSearch(19, "埃德加", "肱三头肌", "不要哔哔赖赖", 259, "http://pxwqui3qb.bkt.clouddn.com/e72cf1879c4d42178ca899cc3c0c5e82.jpg", 85.0));
        list.add(new CoachSearch(20, "金东健", "肱三头肌", "不要哔哔赖赖", 333, "http://pxwqui3qb.bkt.clouddn.com/51653f2c64d7443baae85cbf52a8327b.jpg", 41.0));

        // 接收对象集合，实现批量新增
        coachSearchRepository.saveAll(list);
    }

    /**
     * 查询指定索引下的全部信息
     */
    @Test
    public void getAll(){
        Iterable<CoachSearch> list = this.coachSearchRepository.findAll();
        //按照价格升序查询
        //Iterable<CoachSearch> list1 = this.coachSearchRepository.findAll(Sort.by("price").ascending());
        //按照价格降序查询
        //Iterable<CoachSearch> list2 = this.coachSearchRepository.findAll(Sort.by("price").descending());

        for (CoachSearch coachSearch:list){
            System.out.println(coachSearch);
        }
    }

    /**
     * @Description:定义修改方法
     */
    @Test
    public void update(){
        CoachSearch coachSearch = new CoachSearch(1, "王佳帅", "腹部", "不服现实碰一碰", 2, "http://pxwqui3qb.bkt.clouddn.com/a26855e74b5442038eb96da6022f991d.jpg", 80.0);
        coachSearchRepository.save(coachSearch);
    }

    /**
     * @Description:按照价格区间查询
     */
    @Test
    public void queryByPriceBetween(){
        List<CoachSearch> list = this.coachSearchRepository.findByPriceBetween(20.00, 35.00);
        for (CoachSearch coachSearch : list) {
            System.out.println("coach = " + coachSearch);
        }
    }

    /**
     * @Description:matchQuery底层采用的是词条匹配查询
     */
    @Test
    public void testMatchQuery(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", "王"));
        // 搜索，获取结果
        Page<CoachSearch> coachs = this.coachSearchRepository.search(queryBuilder.build());
        // 总条数
        long coachname = coachs.getTotalElements();
        System.out.println("coachName = " + coachname);
        for (CoachSearch coachSearch : coachs) {
            System.out.println(coachSearch);
        }
    }
}
