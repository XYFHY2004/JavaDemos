package com.example.dbo;

import com.example.entities.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by xyfhy on 16/8/2.
 */

//DAO 操作
//@Repository
//public interface ProductDetailRepository extends CrudRepository<ProductDetail, String> {
////    Page<ProductDetail> findAll(Pageable pageable);
//}

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, Long> {


}

