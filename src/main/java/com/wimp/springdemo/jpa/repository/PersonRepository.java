package com.wimp.springdemo.jpa.repository;

import com.wimp.springdemo.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author zy
 * @date 2020/8/28
 * <p>
 *  
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    /**
     * 根据name查找Person
     * @param name 名称
     * @return 结果集
     */
    @Query("select p from Person p where p.name = :name")
    Optional<Person> findByNameCustomQuery(@Param("name") String name);

    /**
     * 根据id查询name
     * @param id id
     * @return 名称
     */
    @Query("select p.name from Person p where p.id = :id")
    String findPersonNameById(@Param("id") Long id);

    /**
     * 根据id更新name
     * @param name name
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("update Person p set p.name = ?1 where p.id = ?2")
    void updatePersonNameById(String name,Long id);

    /**
     * 查询大于当前年龄的人
     * @param age 年龄
     * @return 返回值
     */
    @Query("select p from Person p where p.age > :age")
    List<Person> findByAgeGreaterThan(@Param("age") int age);
}
