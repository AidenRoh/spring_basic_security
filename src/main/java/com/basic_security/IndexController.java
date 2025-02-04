package com.basic_security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final SessionInfoService sessionInfoService;

    @GetMapping("sessionInfo")
    public String sesionInfo() {
        sessionInfoService.sessionInfo();
        return "sessionInfo";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dined")
    public String dined() {
        return "dined";
    }

    @PostMapping("/csrf")
    public String csrf() {
        return "csrf applied";
    }

    @GetMapping("/csrfToken")
    public String csrfToken(HttpServletRequest request) {
        CsrfToken token1 = (CsrfToken) request.getAttribute("_csrf");
        CsrfToken token2 = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        String unpackingToken1 = token1.getToken();
        String unpackingToken2 = token2.getToken();
        return unpackingToken1 + ":" + unpackingToken2;
    }
}
