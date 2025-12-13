package com.devicedatadisplayplatform.module.siteasset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;
import com.devicedatadisplayplatform.module.siteasset.mapper.ProjectMapper;
import com.devicedatadisplayplatform.module.siteasset.service.ProjectService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 项目服务层实现类
 * Time 2025/12/13
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    /*
    *  获取所有项目
    * */
    @Override
    public List<Project> getAllProjects() {
        return projectMapper.selectList(null);
    }

    /*
     *  分页获取项目
     * */
    @Override
    public IPage<Project> getProjectPage(int current, int size) {
        IPage<Project> page = new Page<>(current, size);
        return projectMapper.selectPage(page, null);
    }
    
    /*
     *  根据ID获取项目
     * */
    @Override
    public Project getProjectById(Integer projectId) {
        return projectMapper.selectById(projectId);
    }
    
    /*
     *  新增项目
     * */
    @Override
    public boolean addProject(Project project){
        // 使用 QueryWrapper 查询项目是否已存在
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_name", project.getProjectName());
        if(projectMapper.selectOne(queryWrapper) != null){
            return false;
        }else{
            projectMapper.insert(project);
            return true;
        }
    }

    /*
     *  更新项目
     * */
    @Override
    public boolean updateProject(Project project){
        // 应该返回更新影响的行数是否大于0
        return projectMapper.updateById(project) > 0;
    }

    /*
     *  删除项目
     * */
    @Override
    public Boolean deleteProject(Integer projectId){
        return projectMapper.deleteById(projectId) > 0;
    }
}