package com.devicedatadisplayplatform.module.siteasset.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.siteasset.form.ProjectForm;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;
import com.devicedatadisplayplatform.module.siteasset.service.ProjectService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping("/listProject")
    public Result<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return Result.ok(projects);
    }

    @GetMapping("/pageProject")
    public Result<IPage<Project>> getProjectPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<Project> page = projectService.getProjectPage(current, size);
        return Result.ok(page);
    }
    
    @GetMapping("/getProject")
    public Result<Project> getProjectById(@RequestParam String projectId) {
        Project project = projectService.getProjectById(projectId);
        return Result.ok(project);
    }

    @PostMapping("/addProject")
    public Result<String> addProject(@RequestBody ProjectForm projectForm) {
        Project project = ConvertUtil.convert(projectForm, Project.class);
        boolean success = projectService.addProject(project);
        if (success) {
            return Result.ok("项目新增成功");
        } else {
            return Result.fail("项目新增失败");
        }
    }

    @PostMapping("/updateProject")
    public Result<String> updateProject(@RequestBody ProjectForm projectForm) {
        Project project = ConvertUtil.convert(projectForm, Project.class);
        boolean success = projectService.updateProject(project);
        if (success) {
            return Result.ok("项目更新成功");
        } else {
            return Result.fail("项目更新失败");
        }
    }

    @GetMapping("/deleteProject")
    public Result<String> deleteProject(@RequestParam String projectId) {
        boolean success = projectService.deleteProject(projectId);
        if (success) {
            return Result.ok("项目删除成功");
        } else {
            return Result.fail("项目删除失败");
        }
    }
}