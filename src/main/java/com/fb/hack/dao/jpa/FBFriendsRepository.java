package com.fb.hack.dao.jpa;

import com.fb.hack.entity.FBFriends;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created with IntelliJ IDEA.
 * User: liji
 * Date: 17/4/22
 * Time: 上午11:42
 * To change this template use File | Settings | File Templates.
 */
public interface FBFriendsRepository extends PagingAndSortingRepository<FBFriends, Long> {
}
