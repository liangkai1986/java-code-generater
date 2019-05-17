package ${BasePackageName}${EntityPackageName};

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import cn.smartwatercloud.smartwater.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Author ${Author}
 * Date ${Date}
 */
@Data
@ToString
@Table(name = "${TableName}")
public class ${ClassName} extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    ${Properties}

}