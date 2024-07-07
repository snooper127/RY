package com.ruoyi.pill.mapper;

import java.util.List;
import com.ruoyi.pill.domain.PillFactory;

/**
 * 保存所有厂商的信息Mapper接口
 * 
 * @author Snp
 * @date 2023-10-23
 */
public interface PillFactoryMapper 
{
    /**
     * 查询保存所有厂商的信息
     * 
     * @param factoryId 保存所有厂商的信息主键
     * @return 保存所有厂商的信息
     */
    public PillFactory selectPillFactoryByFactoryId(Long factoryId);

    /**
     * 查询保存所有厂商的信息
     *
     * @param drugId 保存所有药品的信息主键
     * @return 保存所有药品的信息
     */
    public PillFactory selectPillFactoryByDrugId(Long drugId);


    /**
     * 查询保存所有厂商的信息列表
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 保存所有厂商的信息集合
     */
    public List<PillFactory> selectPillFactoryList(PillFactory pillFactory);

    /**
     * 新增保存所有厂商的信息
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 结果
     */
    public int insertPillFactory(PillFactory pillFactory);

    /**
     * 修改保存所有厂商的信息
     * 
     * @param pillFactory 保存所有厂商的信息
     * @return 结果
     */
    public int updatePillFactory(PillFactory pillFactory);

    /**
     * 删除保存所有厂商的信息
     * 
     * @param factoryId 保存所有厂商的信息主键
     * @return 结果
     */
    public int deletePillFactoryByFactoryId(Long factoryId);

    /**
     * 批量删除保存所有厂商的信息
     * 
     * @param factoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePillFactoryByFactoryIds(String[] factoryIds);
}
