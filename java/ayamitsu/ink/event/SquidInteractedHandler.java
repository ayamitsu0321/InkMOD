package ayamitsu.ink.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import static net.minecraftforge.fml.common.eventhandler.Event.Result.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by ayamitsu0321 on 2016/05/17.
 */
public class SquidInteractedHandler {

    private Item resultItem;
    private boolean isInteracted = false;

    public SquidInteractedHandler(Item result) {
        this.resultItem = result;
    }

    @SubscribeEvent
    public void onSquidInteracted(PlayerInteractEvent.EntityInteract event) {
        this.isInteracted = false;
        Entity entity = event.getTarget();
        EntityPlayer player = event.getEntityPlayer();

        if (entity instanceof EntitySquid) {
            ItemStack is = player.inventory.getCurrentItem();

            if (is.getItem() == Items.BUCKET) {
                this.isInteracted = true;
            }
        }
    }

    @SubscribeEvent
    public void onFilledBucket(FillBucketEvent event) {
        if (this.isInteracted) {
            event.setFilledBucket(new ItemStack(this.resultItem));
            event.setResult(ALLOW);
        }

        this.isInteracted = false;
    }

}
