package com.albert.learn.jdbc.controller;

import com.albert.learn.jdbc.model.UserModel;
import com.albert.learn.jdbc.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<UserModel> queryByArray(@RequestParam("userName") String userName) {
        return learnService.queryByArray(userName);
    }

    @GetMapping("/query-map")
    public List<UserModel> queryByMap(@RequestParam("id") String id) {
        return learnService.queryByMap(id);
    }

    @GetMapping("/query-list")
    public List<Map<String, Object>> queryForList(@RequestParam("userName") String userName) {
        return learnService.queryForList(userName);
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

    @PostMapping("/add-array")
    public String addByArray(@RequestBody UserModel model) {
        int i = learnService.addByArray(model);
        if (i > 0) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @PostMapping("/add-map")
    public String addByMap(@RequestBody UserModel model) {
        int i = learnService.addByMap(model);
        if (i > 0) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @GetMapping("/delete-name")
    public String updateByMap(@RequestParam String name) {
        int i = learnService.deleteByName(name);
        if (i > 0) {
            return String.valueOf(i);
        } else {
            return "FAIL";
        }
    }
}
