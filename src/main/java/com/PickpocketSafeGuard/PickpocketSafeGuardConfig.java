package com.PickpocketSafeGuard;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface PickpocketSafeGuardConfig extends Config
{
	@ConfigItem(
		keyName = "hpThreshold",
		name = "HP Threshold",
		description = "The HP amount that the 'pickpocket' option will no longer show as left click for when at or below. Default is 3 for master farmers."
	)
	default int hpThreshold()
	{
		return 3;
	}
}
