package com.example.dbo;

import com.example.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xyfhy on 16/8/3.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
