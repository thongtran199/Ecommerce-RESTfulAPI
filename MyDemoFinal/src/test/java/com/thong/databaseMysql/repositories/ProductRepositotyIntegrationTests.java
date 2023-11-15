package com.thong.databaseMysql.repositories;

import com.thong.databaseMysql.TestDataUtil;
import com.thong.databaseMysql.domain.entities.ProductEntity;
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
public class ProductRepositotyIntegrationTests {



    private  ProductRepository underTest;

    @Autowired
    public ProductRepositotyIntegrationTests(ProductRepository productDao)
    {
        this.underTest = productDao;
    }
    @Test
    public void testThatBookCanBeCreatedAndRecalled()
    {
        ProductEntity productEntity = TestDataUtil.getProductEntityA();
        underTest.save(productEntity);
        Optional<ProductEntity> result = underTest.findById(productEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(productEntity);
    }
    @Test
    public void testThatBookCanBeFoundMany()
    {
        ProductEntity productEntityA = TestDataUtil.getProductEntityA();
        ProductEntity productEntityB = TestDataUtil.getProductEntityB();
        ProductEntity productEntityC = TestDataUtil.getProductEntityC();

        underTest.save(productEntityA);
        underTest.save(productEntityB);
        underTest.save(productEntityC);
        Iterable<ProductEntity> result = underTest.findAll();
        assertThat(result).hasSize(3).containsExactly(productEntityA, productEntityB, productEntityC);
    }
    @Test
    public void testThatBookCanBeUpdated()
    {
        ProductEntity productEntity = TestDataUtil.getProductEntityA();
        underTest.save(productEntity);
        productEntity.setProductName("NAME UPDATED");
        productEntity.setQuantity(99);
        underTest.save(productEntity);
        Optional<ProductEntity> result = underTest.findById(productEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(productEntity);
    }

}
