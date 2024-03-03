package com.example.messanger.messanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import com.example.messanger.messanger.User;
//import com.example.messanger.messanger.UserRepository;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        // Отображение страницы входа
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Добавление пустого объекта User в модель для заполнения формы
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Шифрование пароля пользователя перед сохранением
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Сохранение пользователя
        userRepository.save(user);
        return "redirect:/login"; // Перенаправление на страницу входа после регистрации
    }
}