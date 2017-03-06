package com.yisutech.erp.cms.core.servcie.impl;

import com.yisutech.erp.cms.core.servcie.RepositoryService;
import com.yisutech.erp.cms.core.servcie.dataobject.QueryRequest;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guangzhong.wgz on 17/3/5.
 */
@Service
public class RepositoryServiceImpl<T extends Serializable> implements RepositoryService {


    /**
     * 保存内容
     *
     * @param serializable
     * @return
     */
    @Override
    public T save(Serializable serializable) {
        return null;
    }

    /**
     * 更新内容
     *
     * @param serializable
     * @return
     */
    @Override
    public T update(Serializable serializable) {
        return null;
    }

    /**
     * 获取内容
     *
     * @param id 内容ID
     * @return
     */
    @Override
    public T get(Long id) {
        return null;
    }

    /**
     * 查询条件
     *
     * @param queryRequest 查询条件
     * @return
     */
    @Override
    public List<T> query(QueryRequest queryRequest) {
        return null;
    }
}
