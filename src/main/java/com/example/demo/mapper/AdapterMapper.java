package com.example.demo.mapper;

import com.example.demo.entity.Adapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: Binh Nguyen
 * Jun 1, 2022
 */

@Mapper
public interface AdapterMapper {
    List<Adapter> list();
}
