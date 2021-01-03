/**
 * 
 */
package com.a.k.podmolot.repository;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.a.k.podmolot.entity.UserRole;

/**
 * <h4>Description</h4> 
 * Repository for {@link UserRole}
 *
 * @author kosta
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long>
{
    @Query(""
            + " SELECT R.*                   \n"
            + " FROM ROLE AS R               \n"
            + "   JOIN USER_ROLE AS UR       \n"
            + "     ON UR.ROLE_ID = R.ID     \n"
            + "     AND UR.USER_ID = :userId \n")
    Set<UserRole> findByUserId(@Param("userId") long userId);

    @Query(""
            + " SELECT *            \n"
            + " FROM ROLE           \n"
            + " WHERE NAME = :name  \n")
    UserRole findByName(@Param("name") String string);
}
