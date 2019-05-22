package ${BasePackageName}${ServicePackageName};

import ${BasePackageName}${DaoPackageName}.${ClassName}Dao;
import ${BasePackageName}${EntityPackageName}.${ClassName};
${InterfaceImport}
import cn.smartwatercloud.smartwater.common.service.BaseService;
import org.springframework.stereotype.Service;


/**
 * Author ${Author}
 * Date ${Date}
 * Description Service继承BaseService需要实现自己自定义的方法
*/
@Service
public class ${ClassName}Service extends BaseService<${ClassName}>{

}
