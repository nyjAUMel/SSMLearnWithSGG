package com.atguigu.restful.crud.exception;

import com.atguigu.restful.crud.common.R;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 18:09
 */
public class BizException extends RuntimeException {
    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }
}
