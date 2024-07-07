package com.ruoyi.pill.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品库，保存所有药品的信息对象 pill_drug
 * 
 * @author Snp
 * @date 2023-10-23
 */
public class PillDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品ID，自增 */
    private Long drugId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品编码 */
    @Excel(name = "药品编码")
    private String drugCode;

    /** 厂商ID */
    @Excel(name = "厂商ID")
    private Long factoryId;

    /** 药品类型 */
    @Excel(name = "药品类型")
    private String drugType;

    /** 处方类型 */
    @Excel(name = "处方类型")
    private String prescriptionType;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 警告值 */
    @Excel(name = "警告值")
    private Long warnValue;

    /** 附加值 */
    @Excel(name = "附加值")
    private Long conversion;

    /** 药品状态 */
    @Excel(name = "药品状态")
    private String status;

    public void setDrugId(Long drugId) 
    {
        this.drugId = drugId;
    }

    public Long getDrugId() 
    {
        return drugId;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugCode(String drugCode) 
    {
        this.drugCode = drugCode;
    }

    public String getDrugCode() 
    {
        return drugCode;
    }
    public void setFactoryId(Long factoryId) 
    {
        this.factoryId = factoryId;
    }

    public Long getFactoryId() 
    {
        return factoryId;
    }
    public void setDrugType(String drugType) 
    {
        this.drugType = drugType;
    }

    public String getDrugType() 
    {
        return drugType;
    }
    public void setPrescriptionType(String prescriptionType) 
    {
        this.prescriptionType = prescriptionType;
    }

    public String getPrescriptionType() 
    {
        return prescriptionType;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setWarnValue(Long warnValue) 
    {
        this.warnValue = warnValue;
    }

    public Long getWarnValue() 
    {
        return warnValue;
    }
    public void setConversion(Long conversion) 
    {
        this.conversion = conversion;
    }

    public Long getConversion() 
    {
        return conversion;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("drugId", getDrugId())
            .append("drugName", getDrugName())
            .append("drugCode", getDrugCode())
            .append("factoryId", getFactoryId())
            .append("drugType", getDrugType())
            .append("prescriptionType", getPrescriptionType())
            .append("unit", getUnit())
            .append("price", getPrice())
            .append("num", getNum())
            .append("warnValue", getWarnValue())
            .append("conversion", getConversion())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
