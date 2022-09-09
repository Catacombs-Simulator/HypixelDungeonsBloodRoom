package me.dungeons.gk.entities.Blood;

public class BloodMobs {

    enum MOBS {
        PUTRID("https://textures.minecraft.net/texture/f4624a9a8c69ca204504abb043d47456cd9b09749a36357462303f276a229d4"),
        REVOKER("http://textures.minecraft.net/texture/ad22772f769045fdc5be819ad68b01a97ac04c60886d2ca7afee39b282f7a383"),
        REAPER("http://textures.minecraft.net/texture/ff184c19e725623d32828a0a4e741e86f135ac63dbc828ff3c8468338f3683b"),
        VADER("http://textures.minecraft.net/texture/a89f6303af85877610912dc04b8b1e89724752f0a7eea05ab6547e228179c06f"),
        TEAR("http://textures.minecraft.net/texture/ad67f97d7f821729beb34a82c3f13592b40439fe5248e72576fde7aa180bf77"),
        FROST("http://textures.minecraft.net/texture/3260325171a7ba8460830c0eea515c757a665e5b16a14207ba1a3182752bee87"),
        CANNIBAL("http://textures.minecraft.net/texture/ad67f97d7f821729beb34a82c3f13592b40439fe5248e72576fde7aa180bf77"),
        SKULL("http://textures.minecraft.net/texture/c919e5b8d56f062a21d224de14af771e2f55d09b59e7b099d09daa57540b79cf"),
        PYSCHO("http://textures.minecraft.net/texture/aa23c8cde2943c84249de8351bc3540be5f8afaaba8b2cb032fc5acad78a269b"),
        OOZE("https://textures.minecraft.net/texture/9171f35b8f508142bd8c65417d0f324153ab9147739ee4d10dea733cc80eaa20"),
        FREAK("http://textures.minecraft.net/texture/7d12b2ade413a6cd7cca3c95e961ba9f0ae7165fa41fc7b5d5f094a01240c609"),
        FLAMER("http://textures.minecraft.net/texture/67237eddaebdbbdaacfa912885560ccdc65da93b4c3d513532868ec23bb5b448"),
        MUTE("http://textures.minecraft.net/texture/5cccd53f5191c29a9dc8f0170fbdc4e59e66476aae33de27b468f1de1b7cf3b2"),
        LEECH("http://textures.minecraft.net/texture/5a79860aca799407c0faa10b1bbcf42998fad4ebcf31d7a214180826b4ac94e1"),
        PARASITE("http://textures.minecraft.net/texture/4774871190c878c9a2c4496c1e10257c6c4ea13807d72c15d7ac6ab3a7a9a8dc"),
        WALKER("http://textures.minecraft.net/texture/8421ba5b8e3573ef97beb5b40e15d15b20f30631c4c5330c3deda3047df0e92")
        ;

        private final String url;

        MOBS(String url) {
            this.url = url;
        }

        public String getURL() {
            return this.url;
        }

    }

    enum BOSSES {
        BONZO,
        SCARF,
        LIVID
        ;

    }


}
