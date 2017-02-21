package com.yisutech.erp.cms.app.converter;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yisutech.erp.cms.framework.utils.FwConstant;
import com.yisutech.erp.cms.framework.utils.ThreadLocalUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * Created by guangzhong.wgz on 17/2/17.
 */
public class FastJsonAndJsonpHttpMessageConverter extends FastJsonHttpMessageConverter {

    /**
     * @param obj
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    public void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        try {
            String callback = (String) ThreadLocalUtil.get(FwConstant.CALLBACK_FUNCTION);
            String uri = (String) ThreadLocalUtil.get(FwConstant.REQUEST_URI);
            if (StringUtils.isNotBlank(callback) && StringUtils.isNotBlank(uri) && uri.endsWith(".jsonp")) {
                JSONPObject tpObj = new JSONPObject();
                tpObj.setFunction(callback.toString());
                tpObj.getParameters().add(obj);
                obj = tpObj;
            }
            super.writeInternal(obj, outputMessage);
        } finally {
            ThreadLocalUtil.remove();
        }
    }
}
