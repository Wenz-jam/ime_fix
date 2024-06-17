package com.wenzjam;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ime_fix implements ModInitializer {

	@Override
	public void onInitialize() {
		Logger logger = LoggerFactory.getLogger("Ime_fix");
		logger.info("IME fix initialized.");
	}
}