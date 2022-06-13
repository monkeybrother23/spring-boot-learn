package com.albert.learn.jdbc.controller;

import com.albert.learn.jdbc.model.UserModel;
import com.albert.learn.jdbc.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Albert
 * @date 2022/6/13
 */
@RequestMapping("/learn")
@RestController
public class LearnController {
    private LearnService learnService;

    @Autowired
    public void setLearnService(LearnService learnService) {
        this.learnService = learnService;
    }

    @GetMapping("/test")
    public List<UserModel> test() {
        return learnService.test();
    }
    @GetMapping("/test2")
    public List<UserModel> test2() {
        return learnService.test2();
    }
}
