package us.potatoboy.timeoutout.mixin;

import net.minecraft.server.network.ServerLoginPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import us.potatoboy.timeoutout.TimeOutOut;

@Mixin(ServerLoginPacketListenerImpl.class)
public final class ServerLoginPacketListenerImplMixin {
    @ModifyConstant(method = "tick", constant = {
            @Constant(intValue = 600)
    })
    private int getLoginTimeoutTicks(int ticks) {
        return (int) Math.min(TimeOutOut.getConfig().loginTimeoutTicks, Integer.MAX_VALUE);
    }
}
