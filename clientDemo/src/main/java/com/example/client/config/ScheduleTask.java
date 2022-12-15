package com.example.client.config;

import com.example.license.LicenseVerify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * 定时任务
 *
 * @author zhouyanhao@yingzhengdt.com
 * @date 2022/12/15  14:31
 * @Copyright (c) 2022, 赢证（上海）数字科技有限公司 All Rights Reserved.
 */
@Configuration
@EnableScheduling
@Slf4j
public class ScheduleTask {
    private final LicenseVerify licenseVerify;

    public ScheduleTask(LicenseVerify licenseVerify) {
        this.licenseVerify = licenseVerify;
    }

    @Scheduled(cron = "0/5 * * * * ?")
    private void licenseVerifyTask() {
        boolean result = licenseVerify.verify();
        log.info("执行定时任务时间: {}，证书验证结果：{}", LocalDateTime.now(), result);
    }
}
