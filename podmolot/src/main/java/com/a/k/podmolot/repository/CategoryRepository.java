package com.a.k.podmolot.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.a.k.podmolot.entity.Category;
import com.a.k.podmolot.entity.UserRole;

@Repository("categoryRepository")
public interface CategoryRepository extends CrudRepository<Category, Long>
{

    @Query(""  
            + " SELECT *            \n" 
            + " FROM podmolot.category           \n"
            + " WHERE parent_category_id is null \n")
    List<Category> getParrent();
    
    @Query(""
            + " SELECT * FROM podmolot.category\r\n"  
            + " WHERE parent_category_id = :parentCategoryId;")
    List<Category> getChildren(@Param("parentCategoryId") Long parentCategoryId);
    
    @Query(""
            // + "USE podmolot;\r\n"
            + " WITH recursive RecursiveQuery (id, parent_category_id, name)\r\n" 
            + " AS"
            + " (SELECT id, parent_category_id, name\r\n" 
            + " FROM category cat\r\n"
            + " WHERE cat.id = :parentCategoryId\r\n" 
            + " UNION ALL\r\n"
            + " SELECT cat.id, cat.parent_category_id, cat.name\r\n" 
            + " FROM category cat\r\n"
            + " JOIN  RecursiveQuery rec ON cat.parent_category_id = rec.id)\r\n" 
            + " SELECT id, name\r\n"
            + " FROM RecursiveQuery\r\n" 
            + " WHERE parent_category_id is not null")
    List<Category> getSubChildren(@Param("parentCategoryId") Long parentCategoryId);
    

    @Query(""
            + " SELECT c.*                                       \n"
            + " FROM category AS c                               \n"
            + " WHERE c.id IN (                                  \n"
            + "                 SELECT  c.parent_category_id     \n"
            + "                 FROM category AS c               \n"
            + "                 JOIN user_category AS uc         \n"
            + "                 ON uc.category_id = c.id         \n"
            + "                 AND uc.user_id = :userId         \n"
            + "                 AND c.parent_category_id is not null"
            + "                )")
    List<Category> getUserParrentCategory(@Param("userId") long userId);
    
    @Query(""
            + " SELECT c.*             \n"
            + " FROM category AS c     \n"
            + " WHERE c.id = :categoryId")
    Category getCategoryById(@Param("categoryId") long categoryId);
    
    /*
     * @Query("" // + "USE podmolot;\r\n" +
     * " WITH recursive RecursiveQuery (id, parent_category_id, name)\r\n" +
     * "AS\r\n" + "(\r\n" + " SELECT id, parent_category_id, name\r\n" +
     * " FROM category cat\r\n" + " WHERE cat.id = :parentCategoryId\r\n" +
     * " UNION ALL\r\n" + " SELECT cat.id, cat.parent_category_id, cat.name\r\n" +
     * " FROM category cat\r\n" +
     * " JOIN  RecursiveQuery rec ON cat.parent_category_id = rec.id\r\n" + ")\r\n"
     * + "SELECT name\r\n" + "FROM RecursiveQuery\r\n" +
     * "WHERE parent_category_id is not null") List<Category>
     * getChildren(@Param("parentCategoryId") Long parentCategoryId);
     */
}
