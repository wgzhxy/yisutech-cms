package com.yishtech.erp.cms.biz.sling.impl;

import com.yishtech.erp.cms.biz.sling.HttpClientService;
import com.yishtech.erp.cms.biz.sling.SlingAttachmentService;
import com.yisutech.erp.cms.framework.http.SlingResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by guangzhong.wgz on 17/2/20.
 */
@Service
public class SlingAttachmentServiceImpl implements SlingAttachmentService {

    @Resource
    private HttpClientService httpClientService;


}
