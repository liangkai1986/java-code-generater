package ${BasePackageName}${ControllerPackageName};

import ${BasePackageName}${EntityPackageName}.${ClassName};
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;

import java.util.List;

import cn.smartwatercloud.smartwater.common.controller.BaseController;
import cn.smartwatercloud.smartwater.common.controller.ResponseCode;
import cn.smartwatercloud.smartwater.common.entity.ResponseData;
import cn.smartwatercloud.smartwater.common.entity.TableData;

import com.github.pagehelper.PageInfo;

import lombok.AllArgsConstructor;

import org.apache.commons.lang.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import tk.mybatis.mapper.entity.Example;



/**
 * Author ${Author}
 * Date ${Date}
 */

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
@RequestMapping(value = "/${EntityName}")
public class ${ClassName}Controller extends BaseController<${ClassName}, ${ClassName}>{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ${ClassName}Service ${EntityName}Service;

    /***
    * 分页查询
    * @param query
    * @return
    */
    @PostMapping("/page")
    @Override
    protected ResponseData<TableData<${ClassName}>> queryRecord(@RequestBody ${ClassName} query){
        logger.debug("分页查询${ClassName}数据列表");
        Example example = new Example(${ClassName}.class);
        Example.Criteria criteria = example.createCriteria();
        //TODO 此处需要自己添加实际的查询条件
        //=============================Start=================================
        if (!StringUtils.isEmpty("实体类的查询参数")) {
            criteria.andLike("查询参数名称", "%" + "实体类的查询参数" + "%");
        }
        //=============================End===================================
        PageInfo<${ClassName}> pageInfo = ${EntityName}Service.selectByExampleList(example, query.getPageNum(), query.getPageSize());
        return getTableData(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), pageInfo);
    }

    /***
    * 添加实体对象
    * @param record
    * @return
    */
    @PostMapping("/add")
    @Override
    protected ResponseData<${ClassName}> addRecord(@RequestBody ${ClassName} record) {
        logger.debug("添加${ClassName}数据");
        try {
            //TODO 将实体对象赋值主键
            //record.setID(uidGenerator.getUIDString());
            ${EntityName}Service.insertSelective(record);
        } catch (Exception e) {
            logger.error("添加${ClassName}数据失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    /***
    * 删除实体对象
    * @param record
    * @return
    */
    @PostMapping("/delete")
    @Override
    protected ResponseData<${ClassName}> deleteRecord(@RequestBody List<${ClassName}> record) {
        logger.debug("删除${ClassName}");
        try {
            ${EntityName}Service.deleteBatchByPrimaryKey(record);
        } catch (Exception e) {
            logger.error("删除${ClassName}失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    /***
    * 更新实体对象
    * @param record
    * @return
    */
    @PostMapping("/update")
    @Override
    protected ResponseData<${ClassName}> updateRecord(@RequestBody ${ClassName} record){
        logger.debug("更新${ClassName}");
        try {
            ${EntityName}Service.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.error("更新${ClassName}失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

}
