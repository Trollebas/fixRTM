package com.anatawa12.fixRtm.network

import com.anatawa12.fixRtm.DummyModelPackManager
import io.netty.buffer.ByteBuf
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

class SentAllModels() : IMessage {

    override fun fromBytes(buf: ByteBuf) {
    }

    override fun toBytes(buf: ByteBuf) {
    }

    companion object : IMessageHandler<SentAllModels, Nothing?> {
        override fun onMessage(message: SentAllModels, ctx: MessageContext): Nothing? {
            DummyModelPackManager.gotAllModels = true
            return null
        }
    }
}
