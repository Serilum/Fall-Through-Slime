package com.natamus.fallthroughslime.forge.events;

import com.natamus.fallthroughslime.events.SlimeEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeSlimeEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeSlimeEvent.class);

		PlayerTickEvent.Pre.BUS.addListener(ForgeSlimeEvent::onPlayerTick);
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Pre e) {
		Player player = e.player();
		Level level = player.level();
		if (level.isClientSide()) {
			return;
		}

		SlimeEvent.onPlayerTick((ServerLevel)level, (ServerPlayer)player);
	}
}
