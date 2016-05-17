package ayamitsu.ink.client;

import ayamitsu.ink.AbstractProxy;
import ayamitsu.ink.InkMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by ayamitsu0321 on 2016/05/17.
 */
public class ClientProxy extends AbstractProxy {

    public void preInit() {
        ModelLoader.setCustomModelResourceLocation(InkMod.bucketInk, 0, new ModelResourceLocation(new ResourceLocation(InkMod.MODID, "bucket_ink"), "inventory"));
    }

}
