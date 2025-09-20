package com.three.jpaTutorial.jpaTuts.repositories;

import com.three.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findBy(Sort sort);
    List<ProductEntity> findByOrderByPrice();
    List<ProductEntity> findByTitleOrderByPrice(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);



    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

   //Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price); //as title and price combination we have given in the constratint that combination of both is unique..so it will return only one element or null

    //@Query("select e from ProductEntity e where e.title=?1 and e.price=?2")//here we have to give java class and variable name as it is JPQL .
    @Query("select e.title from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
