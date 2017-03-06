package com.yisutech.erp.cms.core.servcie;

import com.yisutech.erp.cms.core.servcie.dataobject.QueryRequest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guangzhong.wgz on 17/3/5.
 */
public interface RepositoryService<T extends Serializable> {

    /**
     * 保存内容
     *
     * @param t
     * @return
     */
    public T save(T t);

    /**
     * 更新内容
     *
     * @param t
     * @return
     */
    public T update(T t);

    /**
     * 获取内容
     *
     * @param id 内容ID
     * @return
     */
    public T get(Long id);

    /**
     * 查询条件
     *
     * @param queryRequest 查询条件
     * @return
     */
    public List<T> query(QueryRequest queryRequest);
}
