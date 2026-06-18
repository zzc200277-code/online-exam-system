package com.example.demo052701.mapper;

import com.example.demo052701.entity.ExamRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamMapper {

    @Select("""
            select id,
                   user_id as userId,
                   exam_name as examName,
                   subject,
                   score,
                   total_score as totalScore,
                   status,
                   submit_time as submitTime,
                   remark
            from exam_record
            order by submit_time desc, id desc
            """)
    List<ExamRecord> findAll();

    @Select("""
            select id,
                   user_id as userId,
                   exam_name as examName,
                   subject,
                   score,
                   total_score as totalScore,
                   status,
                   submit_time as submitTime,
                   remark
            from exam_record
            where user_id = #{userId}
            order by submit_time desc, id desc
            """)
    List<ExamRecord> findByUserId(Integer userId);
}
