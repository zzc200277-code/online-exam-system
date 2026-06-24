package com.example.demo052701.mapper;

import com.example.demo052701.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {

    @Select("select * from score where userid = #{userId} order by id")
    List<Score> findByUserId(Integer userId);
}
