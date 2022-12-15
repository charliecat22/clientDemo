package com.example.license.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义需要校验的License参数
 *
 * @author zifangsky
 * @date 2018/4/23
 * @since 1.0.0
 */
@Data
public class LicenseCheckModel implements Serializable {

    private static final long serialVersionUID = 1;

    @ApiModelProperty("可被允许的IP地址")
    private List<String> ipAddress;

    @ApiModelProperty("可被允许的MAC地址")
    private List<String> macAddress;

    @ApiModelProperty("可被允许的CPU序列号")
    private String cpuSerial;

    @ApiModelProperty("可被允许的主板序列号")
    private String mainBoardSerial;

    @ApiModelProperty("可被允许的交易方式")
    private List<String> tradeModes;

}
