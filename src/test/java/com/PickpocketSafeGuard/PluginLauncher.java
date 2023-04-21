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

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PluginLauncher
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PickpocketSafeGuardPlugin.class);
		RuneLite.main(args);
	}
}