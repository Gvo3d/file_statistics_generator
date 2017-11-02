package org.yakimovdenis.webserver.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yakimovdenis.webserver.models.LineStatisticsResultEntity;

import java.util.List;

@Repository
public interface LineStatisticsEntityDao extends PagingAndSortingRepository<LineStatisticsResultEntity,Integer> {
}
