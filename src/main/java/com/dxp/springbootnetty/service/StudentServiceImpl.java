package com.dxp.springbootnetty.service;

import com.dxp.springbootnetty.domain.Student;
import com.dxp.springbootnetty.repository.StudentMapper;
import com.dxp.springbootnetty.service.vo.StudentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author carzy.
 * @date 16:51 2018/12/4
 */
@Component
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    /**
     * 注入 student 表操作类 {@link StudentMapper}
     * <p>
     * 若提示 ·Could not autowire· 请关闭idea ’Autowired‘ 自动检测功能
     *
     * @param studentMapper 操作类
     */
    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    @Async
    public void add(StudentInfo studentInfo) {
        this.logger.info("add student: {}", studentInfo);
        Student student = new Student();
        student.setUsername(studentInfo.getUsername());
        student.setPwd(studentInfo.getPwd());
        student.setRemark(studentInfo.getRemark());
        this.studentMapper.insert(student);
    }
}
