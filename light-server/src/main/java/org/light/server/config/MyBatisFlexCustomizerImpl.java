package org.light.server.config;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisFlexCustomizerImpl implements MyBatisFlexCustomizer {
    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        FlexGlobalConfig.KeyConfig keyConfig = FlexGlobalConfig.getDefaultConfig().getKeyConfig();
        keyConfig.setKeyType(KeyType.Generator);
        keyConfig.setBefore(true);
        keyConfig.setValue("snowFlakeId");
        flexGlobalConfig.setKeyConfig(keyConfig);
        //todo cache
        //todo sql audit

    }
}
