package com.example.testproject.data.dao.impl;

import com.example.testproject.data.dao.ProductDAO;
import com.example.testproject.data.entity.ProductEntity;
import com.example.testproject.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired  //객체 주입(자동으로 연결) 미리 만들어진 레포를 끌어와서 사용
    public ProductDAOImpl(ProductRepository productRepository) {  //생성자
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);  //엔티티값을 넘겨줌
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);  //아이디를 기반으로 프로덕트 아이디를 넘겨줌
        return productEntity;
    }

}
