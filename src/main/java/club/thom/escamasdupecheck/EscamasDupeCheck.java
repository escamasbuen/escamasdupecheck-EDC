package club.thom.escamasdupecheck;

import club.thom.escamasdupecheck.commands.DupeResetCommand;
import club.thom.escamasdupecheck.listeners.GuiEventListener;
import club.thom.escamasdupecheck.listeners.ItemTooltipListener;
import club.thom.escamasdupecheck.packets.ContainerSetItemListener;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = escamasdupecheck.MOD_ID, version = escamasdupecheck.VERSION, certificateFingerprint = escamasdupecheck.SIGNATURE)
public class escamasdupecheck {
    public static final String MOD_ID = "EDC";
    // This is replaced by build.gradle with the real version name
    public static final String VERSION = "@@VERSION@@";
    // Signature to compare to, so you know this is an official release of TEM.
    public static final String SIGNATURE = "32d142d222d0a18c9d19d5b88917c7477af1cd28";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ItemTooltipListener());
        MinecraftForge.EVENT_BUS.register(new GuiEventListener());
        MinecraftForge.EVENT_BUS.register(new ContainerSetItemListener());

        ClientCommandHandler.instance.registerCommand(new DupeResetCommand());
    }
}
