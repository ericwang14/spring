package com.apress.pss.terrormovies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
@Controller
@RequestMapping("/custom_login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }
}
