// 声明一个名为com.ruoyi.common.annotation的包（package）。  
package com.ruoyi.common.annotation;

// 导入Java语言中的注解（annotation）相关的类。  
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 导入com.ruoyi.common.enums包下的BusinessType和OperatorType枚举类。  
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.OperatorType;

// 声明一个名为Log的注解。此注解用于自定义操作日志记录。  
/**
 * 自定义操作日志记录注解  
 *
 * @author ruoyi
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })  // 指定此注解可以用于参数（PARAMETER）和方法（METHOD）。  
@Retention(RetentionPolicy.RUNTIME)  // 指定此注解的生命周期为RUNTIME，即运行时有效。  
@Documented  // 表示此注解会被JavaDoc文档生成工具记录。  
public @interface Log  // 声明一个名为Log的公共注解。  
{
    // 定义一个名为title的属性，其默认值为""。此属性用于记录日志的模块名称。  
    /**
     * 模块  
     */
    public String title() default "";

    // 定义一个名为businessType的属性，其默认值为BusinessType枚举类型的OTHER。此属性用于记录操作所属的业务类型。  
    /**
     * 功能  
     */
    public BusinessType businessType() default BusinessType.OTHER;

    // 定义一个名为operatorType的属性，其默认值为OperatorType枚举类型的MANAGE。此属性用于记录操作人类的类别（例如：管理员、普通用户等）。  
    /**
     * 操作人类别  
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    // 定义一个名为isSaveRequestData的属性，其默认值为true。此属性用于确定是否保存请求的参数。  
    /**
     * 是否保存请求的参数  
     */
    public boolean isSaveRequestData() default true;

    // 定义一个名为isSaveResponseData的属性，其默认值为true。此属性用于确定是否保存响应的参数。  
    /**
     * 是否保存响应的参数  
     */
    public boolean isSaveResponseData() default true;

    // 定义一个名为excludeParamNames的属性，其默认值为一个空数组。此属性用于指定需要排除的请求参数名称。  
    /**
     * 排除指定的请求参数  
     */
    public String[] excludeParamNames() default {};
}