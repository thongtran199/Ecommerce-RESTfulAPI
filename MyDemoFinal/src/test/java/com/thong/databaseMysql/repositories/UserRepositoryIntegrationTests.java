package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.TestDataUtil;

import com.thong.databaseMysql.domain.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTests {



    private UserRepository underTest;

    @Autowired
    public UserRepositoryIntegrationTests(UserRepository userDao)
    {
        this.underTest = userDao;
    }
    @Test
    public void testThatUserCanBeCreatedAndRecalled()
    {
        UserEntity userEntity = TestDataUtil.getUserEntityA();
        underTest.save(userEntity);
        Optional<UserEntity> result = underTest.findById(userEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntity);
    }
    @Test
    public void testThatAuthorCanBeFoundMany()
    {
        UserEntity userEntityA = TestDataUtil.getUserEntityA();
        UserEntity userEntityB = TestDataUtil.getUserEntityB();
        UserEntity userEntityC = TestDataUtil.getUserEntityC();
        underTest.save(userEntityA);
        underTest.save(userEntityB);
        underTest.save(userEntityC);
        Iterable<UserEntity> result =  underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(userEntityA, userEntityB, userEntityC);
    }
    @Test
    public void testThatAuthorCanBeUpdated()
    {
        UserEntity userEntityA = TestDataUtil.getUserEntityA();
        underTest.save(userEntityA);
        userEntityA.setFullName("Tran Van Thong Updated");
        userEntityA.setAuthorities("ROLE_CALLCENTER");
        underTest.save(userEntityA);
        Optional<UserEntity> result = underTest.findById(userEntityA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntityA);
    }

}
