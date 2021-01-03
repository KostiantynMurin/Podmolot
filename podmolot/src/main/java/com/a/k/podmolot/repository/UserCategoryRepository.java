package com.a.k.podmolot.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.entity.User;
import com.a.k.podmolot.entity.UserRole;

public interface UserCategoryRepository extends CrudRepository<User, Long>
{

    @Query(""
            + " SELECT c.*                   \n"
            + " FROM category AS c               \n"
            + "   JOIN user_category AS uc       \n"
            + "     ON uc.category_id = c.id     \n"
            + "     AND uc.user_id = :userId \n"
            + "     AND c.parent_category_id = :parentCategoryId")
    List<Category> getUserCategoriesByUserId(@Param("userId") long userId, @Param("parentCategoryId") long parentCategoryId);

    
}
