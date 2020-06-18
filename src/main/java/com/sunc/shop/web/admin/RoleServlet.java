package com.sunc.shop.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunc.shop.model.Address;
import com.sunc.shop.model.Role;
import com.sunc.shop.model.User;
import com.sunc.shop.service.AddressService;
import com.sunc.shop.service.RoleService;
import com.sunc.shop.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @auther sunc
 * @date 2020/6/11 22:12
 */
@WebServlet("/admin/role/*")
public class RoleServlet extends BaseServlet {

    private RoleService service = new RoleService();

    /**
     *  查询所有角色
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Role> list = service.findAllRole();

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
    }

    /**
     *  查询某个角色
     *  供更新用
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String rid = request.getParameter("rid");
        Role role = service.findRole(rid);

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),role);
    }

    /**
     *  删除某个角色
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String rid = request.getParameter("rid");
        service.deleteRole(rid);
    }

    /**
     *  更新某个角色
     */
    public void updateOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Role role = new Role();
        try {
            BeanUtils.populate(role,request.getParameterMap());
            service.updateRole(role);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    /**
     *  增加某个角色
     */
    public void addOne(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        service.addRole(name,description);
    }

}
