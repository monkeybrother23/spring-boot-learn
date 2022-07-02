package com.albert.lean.learn.swagger.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Albert
 */
@Api(tags = "测试Api")
@RestController
@RequestMapping("/index")
public class IndexController {
    @Operation(description = "demo接口")
    @GetMapping("/demo")
    public String demo(@Parameter(description = "测试id") @RequestParam String id,
                       @Parameter(description = "测试name") @RequestParam String name) {
        return "swagger";
    }
}
