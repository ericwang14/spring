package com.apress.pss.terrormovies.controller;

import com.apress.pss.terrormovies.model.Movie;
import com.apress.pss.terrormovies.model.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public String createMovie(@RequestBody String movie) {
        System.out.println("Adding movie!! "+movie);
        return "created";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public String createMovie() {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        System.out.println("returned movie!");

        return "User " + user.getLastName() + " is accessing movie x";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @Secured("ROLE_ADMIN")
    public ModelAndView getAllMovies() {
        ModelAndView mv = new ModelAndView("movies");
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Die hard", 25000000d));
        movies.add(new Movie("Lethatl Weapon", 30000000d));
        mv.addObject("movies", movies);
        return mv; }
}
