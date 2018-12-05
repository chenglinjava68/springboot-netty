package com.dxp.springbootnetty.service;

import com.dxp.springbootnetty.service.vo.StudentInfo;

/**
 * @author carzy
 */
public interface StudentService {

    /**
     * 新增学生
     *
     * @param studentInfo netty 客户端传过来的数据
     */
    void add(StudentInfo studentInfo);

}
