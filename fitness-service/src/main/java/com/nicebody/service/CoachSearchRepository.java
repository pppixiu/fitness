package com.nicebody.service;

import com.nicebody.pojo.CoachSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CoachSearchRepository extends ElasticsearchRepository<CoachSearch, Long> {

    /**
     * 价格区间查找
     * @param price1
     * @param price2
     * @return
     */
    List<CoachSearch> findByPriceBetween(double price1, double price2);
}
