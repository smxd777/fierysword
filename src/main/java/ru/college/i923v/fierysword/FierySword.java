package ru.college.i923v.fierysword;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FierySword implements ModInitializer {

	public static final String MOD_ID = "fiery-sword";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Инициализация мода Fiery Sword");

		ModItems.initialize();

		UseItemCallback.EVENT.register((player, world, hand) -> {
			ItemStack stack = player.getItemInHand(hand);

			if (!stack.is(ModItems.FIERY_SWORD)) {
				return InteractionResultHolder.pass(stack);
			}

			if (!world.isClientSide()) {
				player.displayClientMessage(
						Component.literal("Огненный меч пылает в руке!"),
						true
				);
			}

			return InteractionResultHolder.success(stack);
		});
	}
}