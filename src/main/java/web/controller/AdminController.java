package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"isVisible", "id"})
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, @RequestParam("role") String newRole){
       String roleName = "ROLE_" + newRole.toUpperCase();
       Role role = roleName.contains("ADMIN") ? roleService.getRoleById(1L) : roleService.getRoleById(2L);
       role.getUsers().add(user);
       user.getRoles().add(role);
       userService.addUser(user);
       return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.listOfUsers());
        return "users";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
        public String showEditForm(@ModelAttribute User user, @RequestParam("id") long id, ModelMap modelMap){
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("isVisible", true);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, ModelMap modelMap){
            userService.editUser((Long) modelMap.getAttribute("id"), user);
            return "redirect:/admin";
    }
}
