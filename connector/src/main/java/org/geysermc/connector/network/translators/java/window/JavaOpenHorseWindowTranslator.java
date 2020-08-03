/*
 * Copyright (c) 2019-2020 GeyserMC. http://geysermc.org
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 *  @author GeyserMC
 *  @link https://github.com/GeyserMC/Geyser
 *
 */

package org.geysermc.connector.network.translators.java.window;

import com.github.steveice10.mc.protocol.packet.ingame.server.window.ServerOpenHorseWindowPacket;
import com.nukkitx.protocol.bedrock.data.entity.EntityEventType;
import com.nukkitx.protocol.bedrock.data.inventory.ContainerType;
import com.nukkitx.protocol.bedrock.packet.ContainerOpenPacket;
import com.nukkitx.protocol.bedrock.packet.EntityEventPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import com.nukkitx.protocol.bedrock.packet.UpdateEquipPacket;
import org.geysermc.connector.network.session.GeyserSession;
import org.geysermc.connector.network.translators.PacketTranslator;
import org.geysermc.connector.network.translators.Translator;

@Translator(packet = ServerOpenHorseWindowPacket.class)
public class JavaOpenHorseWindowTranslator extends PacketTranslator<ServerOpenHorseWindowPacket> {

    @Override
    public void translate(ServerOpenHorseWindowPacket packet, GeyserSession session) {
        UpdateEquipPacket horseOpenWindow = new UpdateEquipPacket();
        System.out.println(packet.getEntityId());
        horseOpenWindow.setWindowId((short) 24);
        horseOpenWindow.setWindowType((short) 12);
        horseOpenWindow.setSize(0);
        horseOpenWindow.setUniqueEntityId(-1);
        session.sendUpstreamPacket(horseOpenWindow);

        SetEntityDataPacket horseOpenWindow2 = new SetEntityDataPacket();
        horseOpenWindow2.setRuntimeEntityId(packet.getEntityId());
        session.sendUpstreamPacket(horseOpenWindow2);

        ContainerOpenPacket horseWindow = new ContainerOpenPacket();
        horseWindow.setType(ContainerType.HORSE);
        horseWindow.setUniqueEntityId(packet.getEntityId());
        session.sendUpstreamPacket(horseWindow);

    }
}

