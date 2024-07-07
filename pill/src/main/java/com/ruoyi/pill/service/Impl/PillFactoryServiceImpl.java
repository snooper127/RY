package com.ruoyi.pill.service.Impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.pill.mapper.PillDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pill.mapper.PillFactoryMapper;
import com.ruoyi.pill.domain.PillFactory;
import com.ruoyi.pill.service.IPillFactoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 保存所有厂商的信息Service业务层处理
 * 
 * @author Snp
 * @date 2023-10-23
 */
@Service
public class PillFactoryServiceImpl implements IPillFactoryService 
{
    @Autowired
    private PillFactoryMapper pillFactoryMapper;

    @Autowired
    private PillDrugMapper pillDrugMapper;

    /**
     * 查询保存所有厂商的信息
     * 
     * @param factoryId 保存所有厂商的信息主键
     * @return 保存所有厂商的信息
     */
    @Override
    public PillFactory selectPillFactoryByFactoryId(Long factoryId)
    {
        return pillFactoryMapper.selectPillFactoryByFactoryId(factoryId);
    }

    /**
     * 根据药品ID查询厂商的信息
     *
     * @param drugId 药品ID
     * @return 保存所有厂商的信息
     */
    @Override
    public PillFactory selectPillFactoryByDrugId(Long drugId) {
        PillFactory pillFactory = pillFactoryMapper.selectPillFactoryByDrugId(drugId);
        return pillFactory;
    }

    /**
     * 查询保存所有厂商的信息列表
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 保存所有厂商的信息
     */
    @Override
    public List<PillFactory> selectPillFactoryList(PillFactory pillFactory)
    {
        return pillFactoryMapper.selectPillFactoryList(pillFactory);
    }

    /**
     * 新增保存所有厂商的信息
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 结果
     */
    @Override
    public int insertPillFactory(PillFactory pillFactory)
    {
        pillFactory.setCreateTime(DateUtils.getNowDate());
        return pillFactoryMapper.insertPillFactory(pillFactory);
    }

    /**
     * 修改保存所有厂商的信息
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 结果
     */
    @Override
    public int updatePillFactory(PillFactory pillFactory)
    {
        pillFactory.setUpdateTime(DateUtils.getNowDate());
        return pillFactoryMapper.updatePillFactory(pillFactory);
    }

    /**
     * 批量删除保存所有厂商的信息
     * 
     * @param factoryIds 需要删除的保存所有厂商的信息主键
     * @return 结果
     */
    @Override
    public int deletePillFactoryByFactoryIds(String factoryIds)
    {
        return pillFactoryMapper.deletePillFactoryByFactoryIds(Convert.toStrArray(factoryIds));
    }

    /**
     * 删除保存所有厂商的信息信息
     * 
     * @param factoryId 保存所有厂商的信息主键
     * @return 结果
     */
    @Override
    public int deletePillFactoryByFactoryId(Long factoryId)
    {
        return pillFactoryMapper.deletePillFactoryByFactoryId(factoryId);
    }
}
