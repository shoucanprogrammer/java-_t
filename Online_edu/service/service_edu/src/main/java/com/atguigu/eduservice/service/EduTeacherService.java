  package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

  /**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-11-14
 */
public interface EduTeacherService extends IService<EduTeacher> {

      //添加课程分类
      void saveSubject(MultipartFile multipartFile);
  }
