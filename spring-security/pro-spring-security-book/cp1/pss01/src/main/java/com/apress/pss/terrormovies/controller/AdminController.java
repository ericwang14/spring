package com.apress.pss.terrormovies.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
@RequestMapping("/admin")
public interface AdminController {

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    @ResponseBody
    public String createMovie(@RequestBody String movie);

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    @ResponseBody
    public String createMovie();

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView getAllMovies();
}
