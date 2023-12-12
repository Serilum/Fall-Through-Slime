package com.natamus.fallthroughslime.forge.events;

import com.natamus.fallthroughslime.events.SlimeEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeSlimeEvent {
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent e) {
		Player player = e.player;
		Level level = player.getCommandSenderWorld();
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}

		SlimeEvent.onPlayerTick((ServerLevel)level, (ServerPlayer)player);
	}
}
