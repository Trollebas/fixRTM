package com.anatawa12.fixRtm.asm.config

import net.minecraftforge.fml.common.Loader

object MainConfig {
    private val configFile = Loader.instance().configDir.resolve("fix-rtm.cfg")
            .apply { appendText("") }
    private val cfg = KVSConfig().apply { configFile.reader().useLines { loadFile( it ) } }

    @JvmField
    val multiThreadModelConstructEnabled = cfg.enableDisableProp(
            "multi thread model construct",
            "constructs models using a thread with a number of logical cores",
            true)

    @JvmField
    val dummyModelPackEnabled = cfg.enableDisableProp(
            "dummy model pack",
            "use dummy ModelPack generated by fixRTM for not loaded models",
            true)

    @JvmField
    val changeTestTrainTextureEnabled = cfg.enableDisableProp(
            "change test train texture",
            "change texture for test train to make easy to identify test train and electric train",
            true)

    @JvmField
    val addAllowAllPermissionEnabled = cfg.enableDisableProp(
            "add allow all permission",
            "adds a permission meaning all permissions are approved",
            true)

    @JvmField
    val markerDistanceMoreRealPosition = cfg.enableDisableProp(
            "marker distances more real position",
            "make marker distances signs more real position",
            true)

    val cachedPolygonModel = cfg.enableDisableProp(
            "cached polygon model",
            "caches obj, mqo model.",
            true)

    init {
        configFile.writer().use { cfg.writeTo(it) }
    }
}
