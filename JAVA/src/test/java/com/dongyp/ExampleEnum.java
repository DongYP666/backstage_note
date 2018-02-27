package com.dongyp;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2018/2/5
 */
public enum ExampleEnum {
    WAIT(0),
    AUDITING(1),
    AUDITED(2);

    private int Status;

    public int getStatus() {
        return Status;
    }

    ExampleEnum(int status) {
        Status = status;
    }
}
