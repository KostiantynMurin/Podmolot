package com.a.k.podmolot.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.Data;

@Data
public class Category implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column("name")
    private String name;

    @MappedCollection(idColumn = "PARENT_CATEGORY_ID")
    private Set<Category> childCategories = new HashSet<>();

    public Category()
    {
        super();
    }

    public Category(Long id, String name)
    {
        super();
        this.id = id;
        this.name = name;

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Set<Category> getChildCategories()
    {
        return childCategories;
    }

    public void addChildCategory(Category childCategory)
    {
        this.childCategories.add(childCategory);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Category other = (Category) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    @Override
    public String toString()
    {
        return String.format("Category [id=%s, name=%s]", id, name);
    }

}
