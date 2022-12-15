package com.example.license.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * License生成类需要的参数
 * @author zyh
 */
@Data
public class LicenseCreatorParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("证书subject")
    private String subject;

    @ApiModelProperty("密钥别称")
    private String privateAlias;

    @ApiModelProperty("密钥密码（需要妥善保管，不能让使用者知道）")
    private String keyPass;

    @ApiModelProperty("访问秘钥库的密码")
    private String storePass;

    @ApiModelProperty("证书生成路径")
    private String licensePath;

    @ApiModelProperty("密钥库存储路径")
    private String privateKeysStorePath;

    @ApiModelProperty("证书生效时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date issuedTime = new Date();

    @ApiModelProperty("证书失效时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiryTime;

    @ApiModelProperty("用户类型")
    private String consumerType = "user";

    @ApiModelProperty("用户数量")
    private Integer consumerAmount = 1;

    @ApiModelProperty("描述信息")
    private String description = "";

    @ApiModelProperty("额外的校验信息")
    private LicenseCheckModel licenseCheckModel;
}
