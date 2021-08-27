package amymialee.noenchantcap;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class NoEnchantCap implements ModInitializer {
    public static EnchantModConfig config;

    Gson daData2 = new Gson();
    Path configPath = Paths.get("config/no-enchantment-cap.json");
    public Gson daData = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

    EnchantModConfig daDataForReal = new EnchantModConfig(true,false, true, 10, 4, 4, 4, 4,3, 3, 2, 3, 4, 5, 5, 5, 2, 2, 3, 3, 5, 3, 5, 2, 3, 3, 3);
    public void setDaData(Gson daData) {
        this.daData = daData;

    }

    public Gson getDaData() {
        return daData;
    }
    public void saveDaData() {
        try {
            if(configPath.toFile().exists()) {
                config = daData.fromJson(new String(Files.readAllBytes(configPath)), EnchantModConfig.class);
            } else {
                Files.write(configPath, Collections.singleton(daData.toJson(daDataForReal)));
                config = daDataForReal;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onInitialize() {
        saveDaData();
    }
}
