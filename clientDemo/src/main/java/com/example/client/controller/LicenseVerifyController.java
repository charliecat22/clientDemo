package com.example.client.controller;

import com.example.client.util.SpringContextUtil;
import com.example.license.LicenseVerify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 证书验证控制器
 *
 * @author zhouyanhao@yingzhengdt.com
 * @date 2022/12/15  13:52
 * @Copyright (c) 2022, 赢证（上海）数字科技有限公司 All Rights Reserved.
 */
@Api(tags = "证书验证控制器")
@RestController
@RequestMapping("/license")
public class LicenseVerifyController {

    public static List<String> TRADE_MODES = new ArrayList<>();
    private LicenseVerify licenseVerify;

    public LicenseVerifyController(LicenseVerify licenseVerify) {
        this.licenseVerify = licenseVerify;
    }

    @ApiOperation(value = "验证证书")
    @GetMapping(value = "/verify")
    public Boolean getServerInfos() {
        System.out.println(TRADE_MODES);
        boolean result = licenseVerify.verify();
        if (!result) {
            SpringApplication.exit(SpringContextUtil.getApplicationContext());
        }
        return result;
    }
}
