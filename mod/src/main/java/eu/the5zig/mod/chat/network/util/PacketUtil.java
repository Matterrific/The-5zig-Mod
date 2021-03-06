/*
 * Original: Copyright (c) 2015-2019 5zig [MIT]
 * Current: Copyright (c) 2019 5zig Reborn [GPLv3+]
 *
 * This file is part of The 5zig Mod
 * The 5zig Mod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The 5zig Mod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with The 5zig Mod.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.the5zig.mod.chat.network.util;

import eu.the5zig.mod.The5zigMod;
import eu.the5zig.mod.chat.network.packets.Packet;

/**
 * Created by 5zig.
 * All rights reserved © 2015
 */
public class PacketUtil {

	public static void ensureMainThread(Packet packet) {
		if (!The5zigMod.getVars().isMainThread()) {
			The5zigMod.getScheduler().postToMainThread(new PacketHandleTask(packet));
			throw CancelPacketHandleException.INSTANCE;
		}
	}

}
