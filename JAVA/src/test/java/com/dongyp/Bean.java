package com.dongyp;

import lombok.Data;
import lombok.NonNull;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/2/1
 */
@Data
public class Bean {
    @NonNull
    private String code;
    private String name;
}
