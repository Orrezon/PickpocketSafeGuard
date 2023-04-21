/**
 * Copyright (c) 2023, Orrezon https://github.com/Orrezon
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms are permitted
 * provided that the above copyright notice and this paragraph are
 * duplicated in all such forms and that any documentation, advertising
 * materials, and other materials related to such distribution and use
 * acknowledge that the software was developed by Orrezon. The name of
 * Orrezon may not be used to endorse or promote products derived from
 * this software without specific prior written permission. THIS SOFTWARE
 * IS PROVIDED `'AS IS″ AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.PickpocketSafeGuard;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;

import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
		name = "Pickpocket Safe Guard"
)
public class PickpocketSafeGuardPlugin extends Plugin
{
	private static final String PICKPOCKET_OPTION = "Pickpocket";

	@Inject
	private Client client;

	@Inject
	private PickpocketSafeGuardConfig config;

	@Override
	protected void startUp() throws Exception {
		log.info("Pickpocket Safe Guard started!");
	}

	@Override
	protected void shutDown() throws Exception {
		log.info("Pickpocket Safe Guard stopped!");
	}

	/**
	 * If the player tries to perform the "Pickpocket" option and their health is at or below the set threshold, consume the action - thus preventing it from resolving.
	 * @param menuOptionClicked The menu option details that was clicked. <see>MenuOptionClicked</see>.
	 */
	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked)
	{
		int currentHealth = client.getBoostedSkillLevel(Skill.HITPOINTS);

		if (currentHealth <= config.hpThreshold() && menuOptionClicked.getMenuEntry().getOption().equals(this.PICKPOCKET_OPTION)) {
			menuOptionClicked.consume();
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Current health at or below the set threshold! Eat some food.", "Pickpocket Safe Guard");
		}
	}

	@Provides
	PickpocketSafeGuardConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(PickpocketSafeGuardConfig.class);
	}
}
