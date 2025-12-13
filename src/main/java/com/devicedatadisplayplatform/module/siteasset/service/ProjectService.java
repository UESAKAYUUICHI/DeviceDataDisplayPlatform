package com.devicedatadisplayplatform.module.siteasset.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;

import java.util.List;

public interface ProjectService {

    /*
    *  获取所有项目
    * */
    List<Project> getAllProjects();

    /*
     *  分页查询项目
     * */
    IPage<Project> getProjectPage(int current, int size);
    
    /*
     *  根据ID获取项目
     * */
    Project getProjectById(String projectId);

    /*
     *  新增项目
     * */
    boolean addProject(Project project);

    /*
     *  更新项目
     * */
    boolean updateProject(Project project);

    /*
     *  删除项目
     * */
    Boolean deleteProject(String projectId);
}