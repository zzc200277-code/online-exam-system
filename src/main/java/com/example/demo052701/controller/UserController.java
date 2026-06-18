package com.example.demo052701.controller;

import com.example.demo052701.entity.User;
import com.example.demo052701.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    private static final int PAGE_SIZE = 5;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping({"/login", "/toLogin"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("msg", "用户名或密码错误");
            model.addAttribute("activeTab", "login");
            return "login";
        }
        session.setAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping({"/register", "/toReg"})
    public String register(User user,
                           @RequestParam(required = false) String confirmPassword,
                           Model model) {
        if (confirmPassword != null && !confirmPassword.equals(user.getPassword())) {
            model.addAttribute("msg", "两次输入的密码不一致");
            model.addAttribute("activeTab", "register");
            return "login";
        }
        if (!userService.register(user)) {
            model.addAttribute("msg", "注册失败：用户名已存在或信息不完整");
            model.addAttribute("activeTab", "register");
            return "login";
        }
        model.addAttribute("msg", "注册成功，请登录");
        model.addAttribute("activeTab", "login");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/getUserById")
    public String getUserById(Integer id, Model model) {
        if (id == null) {
            model.addAttribute("msg", "用户 ID 不能为空");
            return "chaxun";
        }
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("msg", "没有查到对应考生");
        } else {
            model.addAttribute("user", user);
        }
        return "chaxun";
    }

    @GetMapping("/getUserByMail")
    public String getUserByMail(String mail, Model model) {
        User user = userService.findByMail(mail);
        if (user == null) {
            model.addAttribute("msg", "没有查到对应考生");
        } else {
            model.addAttribute("user", user);
        }
        return "chaxun2";
    }

    @GetMapping("/getUserByStatus")
    public String getUserByStatus(@RequestParam(defaultValue = "1") int status,
                                  @RequestParam(defaultValue = "1") int page,
                                  Model model) {
        List<User> allUsers = userService.findByStatus(status);
        int total = allUsers.size();
        int totalPages = Math.max(1, (int) Math.ceil((double) total / PAGE_SIZE));
        int currentPage = Math.min(Math.max(page, 1), totalPages);
        int start = (currentPage - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, total);
        List<User> pageUsers = start < total ? allUsers.subList(start, end) : Collections.emptyList();

        model.addAttribute("users", pageUsers);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("status", status);
        if (pageUsers.isEmpty()) {
            model.addAttribute("msg", "未找到考生");
        }
        return "chaxun2";
    }

    @GetMapping("/updatepassword")
    public String updatePasswordPage() {
        return "updatepassword";
    }

    @PostMapping("/updatepassword")
    public String updatePassword(String username,
                                 String oldpassword,
                                 String newpassword,
                                 RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(oldpassword)) {
            redirectAttributes.addFlashAttribute("msg", "用户名或原密码错误");
            return "redirect:/updatepassword";
        }
        int updated = userService.updatePassword(username, newpassword);
        redirectAttributes.addFlashAttribute("msg", updated == 1 ? "修改密码成功" : "修改密码失败");
        return "redirect:/updatepassword";
    }
}
