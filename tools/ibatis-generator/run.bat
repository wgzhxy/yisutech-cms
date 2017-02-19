@echo off
echo -------------------------------------------------------------------------
echo Ibatis code generator
echo VERSION : mybatis-generator-core-1.3.1
echo CONFIG_FILE = generatorConfig.xml
echo -------------------------------------------------------------------------

java -cp "lib/mybatis-generator-core-1.3.1.jar;jdbcdriver/*" org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
@PAUSE
