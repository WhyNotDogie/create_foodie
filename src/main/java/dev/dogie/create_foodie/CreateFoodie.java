package dev.dogie.create_foodie;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFoodie implements ModInitializer {
	public static final String ID = "create_foodie";
	public static final String NAME = "Create: Foodie";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

	public static final ItemEntry<Item> BREADED_CHICKEN_CUTS = REGISTRATE.item("breaded_chicken_cuts", Item::new)
		.properties(p -> p.food(new FoodProperties.Builder().nutrition(1)
			.saturationMod(0.3F)
			.effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
			.build()))
		.lang("Breaded Chicken Cuts")
		.register();

	public static final ItemEntry<Item> CHICKEN_NUGGETS = REGISTRATE.item("chicken_nuggets", Item::new)
		.properties(p -> p.food(new FoodProperties.Builder().nutrition(8)
			.saturationMod(0.5F)
			.build()))
		.lang("Chicken Nuggets")
		.register();

	public static final ItemEntry<Item> BREADCRUMBS = REGISTRATE.item("breadcrumbs", Item::new)
		.lang("Breadcrumbs")
		.register();

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);

		REGISTRATE.register();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
