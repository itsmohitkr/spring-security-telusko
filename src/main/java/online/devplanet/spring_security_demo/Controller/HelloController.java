package online.devplanet.spring_security_demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

     @GetMapping("hello")
     public String hello(HttpServletRequest request) {
            return "Hello";
     }


        // about page
        @GetMapping("about")
        public String about(HttpServletRequest request) {
            return "This is the about page";
        }

        // get csrf token
        @GetMapping("csrf")
        public CsrfToken csrf(HttpServletRequest request) {
            return (CsrfToken) request.getAttribute("_csrf");
        }

}
