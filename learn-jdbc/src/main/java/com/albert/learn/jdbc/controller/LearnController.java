package com.albert.learn.jdbc.controller;

import com.albert.learn.jdbc.model.UserModel;
import com.albert.learn.jdbc.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/query-array")
    public List<UserModel> test() {
        return learnService.queryByArray();
    }

    @GetMapping("/query-map")
    public List<UserModel> test2() {
        return learnService.queryByMap();
    }

    @GetMapping("/update-array")
    public String updateByArray(@RequestParam String id, @RequestParam int age) {
        int i = learnService.updateByArray(id, age);
        if (i > 0) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @GetMapping("/update-map")
    public String updateByMap(@RequestParam String id, @RequestParam int age) {
        int i = learnService.updateByMap(id, age);
        if (i > 0) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
