package ink.wulian.home.common.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.inject.Singleton;
import javax.json.bind.JsonbConfig;
import java.util.Locale;

@Singleton
public class JsonConfig implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig jsonbConfig) {
        jsonbConfig.withDateFormat("yyyy年MM月dd日 HH:mm", Locale.SIMPLIFIED_CHINESE)
                .withFormatting(true)
                .withNullValues(true);
    }

}
