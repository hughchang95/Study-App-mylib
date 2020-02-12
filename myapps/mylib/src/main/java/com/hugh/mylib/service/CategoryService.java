package com.hugh.mylib.service;

import com.hugh.mylib.dao.CategoryDAO;
import com.hugh.mylib.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return categoryDAO.findAll(sort);
    }

    public Category get(int id){
        Category category=categoryDAO.findById(id).orElse(null);
        return category;
    }
}
