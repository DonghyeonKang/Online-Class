package thymeleaf.basic;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("text-basic")
    public String textBasic(Model model) {
        // text-basic.html 에 데이터를 넘김 data="Hello Spring!"
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        // text-basic.html 에 데이터를 넘김 data="Hello Spring!"
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }

    @GetMapping("variable")
    public String variable(Model model) {
        User userA = new User("김민제", 10);
        User userB = new User("강동현", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    @GetMapping("/basic-object")
    public String basicObject(HttpSession session) {
        session.setAttribute("username", "민제상");

        return "basic/basic-object";
    }

    @GetMapping("/basic-date")
    public String basicDate(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/basic-date";
    }

    @GetMapping("/link")
    public String basicLink(Model model) {
        model.addAttribute("param1", "no1Param");
        model.addAttribute("param2", "no2Param");
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model){
        model.addAttribute("data", "data");
        return "basic/literal";
    }

    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");
        return "basic/operation";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        model.addAttribute("age", 40);

        return "basic/condition";
    }

    @GetMapping("/block")
    public String block(Model model) {
        User userA = new User("수진", 25);
        User userB = new User("동현", 25);
        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        model.addAttribute(list);
        return "basic/block";
    }



    @Component("HelloBean")
    static class HelloBean {
        public String hello(String data) {
            return "hello" + data;
        }
    }

    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

}
