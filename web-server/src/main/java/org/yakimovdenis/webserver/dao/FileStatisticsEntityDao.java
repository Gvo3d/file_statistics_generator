package org.yakimovdenis.webserver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yakimovdenis.webserver.models.FileStatisticsEntity;

@Repository
public interface FileStatisticsEntityDao extends PagingAndSortingRepository<FileStatisticsEntity, Integer> {
}
