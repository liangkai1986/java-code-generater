<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${BasePackageName}${DaoPackageName}.${ClassName}Dao">

    <resultMap id="${EntityName}ResultMap" type="${BasePackageName}${EntityPackageName}.${ClassName}">
        ${ResultMap}
        ${Association}
        ${Collection}
    </resultMap>

</mapper>