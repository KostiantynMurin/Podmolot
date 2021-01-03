/**
 * 
 */
package com.a.k.podmolot.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.a.k.podmolot.entity.User;

/**
 * <h4>Description</h4> Repository for {@link User}
 *
 * @author kosta
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
    @Transactional
    @Query("SELECT * FROM USER WHERE MAIL = :email")
    User findByEmail(@Param("email") String email);
    
    @Query("SELECT * FROM USER WHERE ID = :id")
    User findById(@Param("id") long id);
    
    @Query("SELECT ID FROM USER WHERE MAIL = :email")
    long findIdByEmail(@Param("email") String email);
    
    @Query(""
            + " UPDATE user SET first_name = :firstName ,   \n"
            + "                 last_name = :lastName ,     \n"
            + "                 phone_number = :phoneNumber \n"
            + " WHERE mail = :email                         \n")
    User updateUser(@Param("email") String email, 
                         @Param("firstName") String firstName, 
                         @Param("lastName") String lastName, 
                         @Param("phoneNumber") String phoneNumber);
}
