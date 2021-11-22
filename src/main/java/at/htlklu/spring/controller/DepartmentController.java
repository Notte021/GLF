package at.htlklu.spring.controller;


import at.htlklu.spring.api.LogUtils;
import at.htlklu.spring.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "mvc/departments")
public class DepartmentController
{
    private static final Logger logger = LogManager.getLogger(DepartmentController.class);
    private static final String className = "DepartmentController";

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping (value = "/show")
    public ModelAndView show()
    {
        logger.info(LogUtils.info(className,"show"));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("DepartmentList.html");

        List<Department> departments = departmentRepository.findByOrderByNameAsc();
        mv.addObject("departments",departments);
        return mv;

    }

}
