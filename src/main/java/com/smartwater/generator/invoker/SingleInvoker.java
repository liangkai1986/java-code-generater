package com.smartwater.generator.invoker;

import com.smartwater.generator.invoker.base.AbstractBuilder;
import com.smartwater.generator.invoker.base.AbstractInvoker;
import com.smartwater.generator.invoker.base.Invoker;
import com.smartwater.generator.utils.GeneratorUtil;
import com.smartwater.generator.utils.StringUtil;

import java.sql.SQLException;

/**
 * 独立单表的实现 没有关联关系
 * Date   2019/05/17
 */
public class SingleInvoker extends AbstractInvoker {

    @Override
    protected void getTableInfos() throws SQLException {
        tableInfos = connectionUtil.getMetaData(tableName);
    }

    @Override
    protected void initTasks() {
        taskQueue.initSingleTasks(className, tableName, tableInfos);
    }

    public static class Builder extends AbstractBuilder {
        private SingleInvoker invoker = new SingleInvoker();

        public Builder setTableName(String tableName) {
            invoker.setTableName(tableName);
            return this;
        }

        public Builder setClassName(String className) {
            invoker.setClassName(className);
            return this;
        }

        @Override
        public Invoker build() {
            if (!isParamtersValid()) {
                return null;
            }
            return invoker;
        }

        @Override
        public void checkBeforeBuild() throws Exception {
            if (StringUtil.isBlank(invoker.getTableName())) {
                throw new Exception("Expect table's name, but get a blank String.");
            }
            if (StringUtil.isBlank(invoker.getClassName())) {
                invoker.setClassName(GeneratorUtil.generateClassName(invoker.getTableName()));
            }
        }
    }

}
