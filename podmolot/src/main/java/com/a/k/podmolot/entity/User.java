/**
 * 
 */
package com.a.k.podmolot.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

/**
 * <h4>Description</h4> POJO entity for USER
 *
 * @author kosta
 */
@Data
@Table("USER")
public class User
{
    @Id
    private long id;

    @Column("PASSWORD")
    private String password;

    @Transient
    private String passwordCopy;

    @Column("FIRST_NAME")
    private String firstName;

    @Column("LAST_NAME")
    private String lastName;

    @Column("MIDLE_NAME")
    private String middleName;

    @Column("PHONE_NUMBER")
    private String phoneNumber;

    @Column("MAIL")
    private String email;

    @MappedCollection(idColumn = "user_id")
    private Set<UserCategoryReference> categories = new HashSet<>();
    

    public void setCategories(Set<UserCategoryReference> categories)
    {
        this.categories = categories;
    }

    public Set<UserCategoryReference> getCategories()
    {
        return categories;
    }

    /*
     * public void setCategory(Category category) { this.categories.add(new
     * UserCategoryReference(category.getId())); }
     */

    public void addCategory(Category category)
    {
        //categories.add(category);
        this.categories.add(new UserCategoryReference(category.getId()));
     
    }
    /*
     * //// public void addCategory(Category category) { this.categories.add(new
     * UserCategoryReference(category.getId())); } //// public Set<Long>
     * getCategoriesIds(){ return this.categories.stream()
     * .map(UserCategoryReference::getCategory) .collect(Collectors.toSet()); }
     */

    

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the passwordCopy
     */
    public String getPasswordCopy()
    {
        return passwordCopy;
    }

    /**
     * @param passwordCopy the passwordCopy to set
     */
    public void setPasswordCopy(String passwordCopy)
    {
        this.passwordCopy = passwordCopy;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the midleName
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /**
     * @param midleName the midleName to set
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email, firstName, id, lastName, middleName, password, passwordCopy, phoneNumber);
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
        User other = (User) obj;
        return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
                && Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
                && Objects.equals(password, other.password) && Objects.equals(passwordCopy, other.passwordCopy)
                && Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public String toString()
    {
        return String.format(
                "User [id=%s, password=%s, firstName=%s, lastName=%s, midleName=%s, phoneNumber=%s, email=%s]", id,
                password, firstName, lastName, middleName, phoneNumber, email);
    }
}
