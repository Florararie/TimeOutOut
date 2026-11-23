package us.potatoboy.timeoutout.mixin;

import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import us.potatoboy.timeoutout.TimeOutOut;

@Mixin(ServerCommonPacketListenerImpl.class)
public final class ServerCommonPacketListenerImplMixin {
    @ModifyConstant(method = "keepConnectionAlive", constant = {
            @Constant(longValue = 15000L)
    })
    private long getKeepAlivePacketInterval(long interval) {
        return TimeOutOut.getConfig().keepAlivePacketIntervalSeconds * 1000L;
    }
}
