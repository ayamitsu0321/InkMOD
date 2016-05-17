package ayamitsu.ink;

import ayamitsu.ink.event.SquidInteractedHandler;
import ayamitsu.ink.item.ItemBucketInk;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = InkMod.MODID,
        name = InkMod.NAME,
        version = InkMod.VERSION
)
public class InkMod {

    public static final String MODID = "ink";
    public static final String NAME = "InkMod";
    public static final String VERSION = "1.0.1";

    @Mod.Instance(MODID)
    public static InkMod instance;

    @SidedProxy(clientSide = "ayamitsu.ink.client.ClientProxy", serverSide = "ayamitsu.ink.server.ServerProxy")
    public static AbstractProxy proxy;

    public static Item bucketInk;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        bucketInk = new ItemBucketInk().setUnlocalizedName(MODID + ".bucketInk").setRegistryName(new ResourceLocation(MODID, "bucket_ink")).setContainerItem(Items.BUCKET);
        GameRegistry.register(bucketInk);

        proxy.preInit();
        MinecraftForge.EVENT_BUS.register(new SquidInteractedHandler(bucketInk));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}