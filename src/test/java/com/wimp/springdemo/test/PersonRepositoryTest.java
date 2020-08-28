package com.wimp.springdemo.test;

import com.wimp.springdemo.SpringDemoApplication;
import com.wimp.springdemo.jpa.entity.Person;
import com.wimp.springdemo.jpa.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author zy
 * @date 2020/8/28
 * <p>
 *  JPA 测试类
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    private Long id;

    /**
     * 保存person到数据库
     */
    @Before
    public void setUp() {
        assertNotNull(personRepository);
        Person person = new Person("SnailClimb", 23);
        Person savedPerson = personRepository.saveAndFlush(person);// 更新 person 对象的姓名
//        savedPerson.setName("UpdatedName");
//        personRepository.save(savedPerson);

        id = savedPerson.getId();
    }

    /**
     * 使用 JPA 自带的方法查找 person
     */
    @Test
    public void should_get_person() {
        Optional<Person> personOptional = personRepository.findById(id);
        assertTrue(personOptional.isPresent());
        assertEquals("SnailClimb", personOptional.get().getName());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());

        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());
        // 清空数据库
        personRepository.deleteAll();
    }

    /**
     * 自定义 query sql 查询语句查找 person
     */

    @Test
    public void should_get_person_use_custom_query() {
        // 查找所有字段
        Optional<Person> personOptional = personRepository.findByNameCustomQuery("SnailClimb");
        assertTrue(personOptional.isPresent());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());
        // 查找部分字段
        String personName = personRepository.findPersonNameById(id);
        assertEquals("SnailClimb", personName);
        System.out.println(id);
        // 更新
        personRepository.updatePersonNameById("UpdatedName", id);
        Optional<Person> updatedName = personRepository.findByNameCustomQuery("UpdatedName");
        assertTrue(updatedName.isPresent());
        // 清空数据库
        personRepository.deleteAll();
    }
}
