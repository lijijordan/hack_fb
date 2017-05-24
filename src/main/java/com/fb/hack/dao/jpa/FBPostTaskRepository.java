package com.fb.hack.dao.jpa;

import com.fb.hack.entity.FBPostTask;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public interface FBPostTaskRepository extends PagingAndSortingRepository<FBPostTask, Long> {


    /**
     * Find all by mac address list.
     *
     * @param macAddress the mac address
     * @return the list
     */
    List<FBPostTask> findAllByMacAddress(String macAddress);

}
